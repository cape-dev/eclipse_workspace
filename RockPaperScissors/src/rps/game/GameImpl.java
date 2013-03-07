package rps.game;

import java.rmi.RemoteException;

import rps.client.GameListener;
import rps.game.data.AttackResult;
import rps.game.data.Figure;
import rps.game.data.FigureKind;
import rps.game.data.Move;
import rps.game.data.Player;

/**
 * The {@code GameImpl} is an implementation for the {@code Game} interface. It
 * contains the necessary logic to play a game.
 */
public class GameImpl implements Game {

	private GameListener listener1;
	private GameListener listener2;
	private Player player1;
	private Player player2;
	private FigureKind[] assignmentP1;
	private FigureKind[] assignmentP2;
	private Figure[] board = new Figure[42];
	private FigureKind initialChoiceP1;
	private FigureKind initialChoiceP2;
	private Player surrender;
	private FigureKind updatedKindAfterDrawP1;
	private FigureKind updatedKindAfterDrawP2;
	private Move lastMove;
	private Player movingPlayer ;
	private String lastMovingPlayer = "";
	private int fromIndex;
	private int toIndex;

	public GameImpl(GameListener listener1,GameListener listener2) throws RemoteException {
		this.listener1 = listener1;
		this.listener2 = listener2;
		this.player1 = listener1.getPlayer();
		this.player2 = listener2.getPlayer();
	}

	@Override
	public void sendMessage(Player p, String message) throws RemoteException {
		listener1.chatMessage(p, message);
		listener2.chatMessage(p, message);
		// TODO Auto-generated method stub
	}

	@Override
	public void setInitialAssignment(Player p, FigureKind[] assignment)
			throws RemoteException {
		if (p == player1) {
			if (assignmentP1 == null)
				assignmentP1 = assignment;
			else
				throw new IllegalStateException("player1 has already set initialAssignment");
		} else if (p == player2)
			if (assignmentP2 == null)
				assignmentP2 = assignment;
			else
				throw new IllegalStateException("player 2 has already set initialAssignment");
		if (assignmentP1 != null && assignmentP2 != null) {

			// builds initial gaming board from player-assignments
			for (int i = 0; i < 42; i++) {
				if (assignmentP1[i] == null && assignmentP2[i] == null) board[i] = null ;
				else if(assignmentP1[i] != null) board[i] = new Figure(assignmentP1[i], player1);
				else board[i] = new Figure(assignmentP2[i], player2);		
			}	

			listener1.provideInitialChoice();
			listener2.provideInitialChoice();
		}
	}

	@Override
	public void setInitialChoice(Player p, FigureKind kind)
			throws RemoteException {
		if (p == player1)
			initialChoiceP1 = kind;
		else
			initialChoiceP2 = kind;
		if (initialChoiceP1 != null && initialChoiceP2 != null) {

			if (initialChoiceP1.attack(initialChoiceP2) == AttackResult.DRAW) {
				initialChoiceP1 = null;
				initialChoiceP2 = null;
				listener1.provideInitialChoice();
				listener2.provideInitialChoice();
			} else {
				listener1.startGame();
				listener2.startGame();

				if (initialChoiceP1.attack(initialChoiceP2) == AttackResult.WIN)
					listener1.provideNextMove();
				else
					listener2.provideNextMove();
			}
		}
	}

	@Override
	public void move(Player movingPlayer, int fromIndex, int toIndex)throws RemoteException {
		if (lastMovingPlayer.equals(movingPlayer.getNick()))								//checks if one player is trying to move two times in a row
			throw new IllegalStateException(								// throws exception if that occurred
					"Player is not allowed to move twice in a row");
	
		else {
			lastMovingPlayer = movingPlayer.getNick();
			lastMove = new Move(fromIndex, toIndex, board.clone());					// last move is updated	
			this.movingPlayer = movingPlayer;								
			this.fromIndex = fromIndex;
			this.toIndex = toIndex;

			if (board[toIndex] == null) {									// checks if move is an attack or just a move
				board[toIndex] = board[fromIndex];							
				board[fromIndex] = null;
				listener1.figureMoved();
				listener2.figureMoved();
				if(movableFigures(getOpponent(movingPlayer)))
					getListener(getOpponent(movingPlayer)).provideNextMove();
					
				else if(movableFigures(movingPlayer)){
					lastMovingPlayer = "";
					getListener(movingPlayer).provideNextMove();
					
				}
				

			} else {														// if move is an attack this section will be started
				listener1.figureAttacked();
				listener2.figureAttacked();
				board[fromIndex].setDiscovered();
				board[toIndex].setDiscovered();
				if (board[toIndex].getKind() == FigureKind.FLAG) {	// checks if flag was attacked
					uncoverAllFigures();
					getListener(movingPlayer).gameIsWon();
					getListener(getOpponent(movingPlayer)).gameIsLost();
				} else if (board[fromIndex].attack(board[toIndex]) == AttackResult.DRAW) { // checks if attack was a draw

					listener1.provideChoiceAfterFightIsDrawn();
					listener2.provideChoiceAfterFightIsDrawn();

				} else {													// evaluates remaining attackoptions: win, loose, losse against trap

					if (board[fromIndex].attack(board[toIndex]) == AttackResult.WIN) {
						board[toIndex] = board[fromIndex];
						board[fromIndex] = null;
						
						if(movableFigures(getOpponent(movingPlayer)))
							getListener(getOpponent(movingPlayer)).provideNextMove();
						else if(movableFigures(movingPlayer)){
							lastMovingPlayer = "";
							getListener(movingPlayer).provideNextMove();
						}
					} else if (board[fromIndex].attack(board[toIndex]) == AttackResult.LOOSE) {
						board[fromIndex] = null;
						getListener(getOpponent(movingPlayer)).provideNextMove();
					} else if (board[fromIndex].attack(board[toIndex]) == AttackResult.LOOSE_AGAINST_TRAP) {
						board[toIndex] = null;
						board[fromIndex] = null;
						if(movableFigures(getOpponent(movingPlayer)))
							getListener(getOpponent(movingPlayer)).provideNextMove();
						else if(movableFigures(movingPlayer)){
							lastMovingPlayer = "";
							getListener(movingPlayer).provideNextMove();
						}
						else{ 
							uncoverAllFigures();
							listener1.gameIsDrawn();
							listener2.gameIsDrawn();
						}
						
						getListener(getOpponent(movingPlayer)).provideNextMove();
					}
				}

			}
		}

	}

	@Override
	public void setUpdatedKindAfterDraw(Player p, FigureKind kind) throws RemoteException {

		if (p == player1)
			updatedKindAfterDrawP1 = kind;

		else
			updatedKindAfterDrawP2 = kind;

		if (updatedKindAfterDrawP1 != null && updatedKindAfterDrawP2 != null) { //the board will be updated and the new move will be evaluated if both player have updated their figurekind
			if (movingPlayer == player1) {
				board[fromIndex] = new Figure(updatedKindAfterDrawP1, player1);
				board[toIndex] = new Figure(updatedKindAfterDrawP2, player2);
			} else {
				board[fromIndex] = new Figure(updatedKindAfterDrawP2, player2);
				board[toIndex] = new Figure(updatedKindAfterDrawP1, player1);
			}
			lastMove = new Move(fromIndex, toIndex, board.clone());
			listener1.figureAttacked();	
			listener2.figureAttacked();

			if (board[fromIndex].attack(board[toIndex]) == AttackResult.DRAW) { //if the to player once again have chosen the same kind, the players are asked to submit another figure kind update
				listener1.provideChoiceAfterFightIsDrawn();
				listener2.provideChoiceAfterFightIsDrawn();
			} else if (board[fromIndex].attack(board[toIndex]) == AttackResult.WIN) {
				board[toIndex] = board[fromIndex];
				board[fromIndex] = null;
				if(movableFigures(getOpponent(movingPlayer)))
					getListener(getOpponent(movingPlayer)).provideNextMove();
				else if(movableFigures(movingPlayer)){
					lastMovingPlayer = "";
					getListener(movingPlayer).provideNextMove();
				}			
				
				} else if (board[fromIndex].attack(board[toIndex]) == AttackResult.LOOSE) {
				board[fromIndex] = null;
				getListener(getOpponent(movingPlayer)).provideNextMove();
			} 
				
			
	}

	}

	@Override
	public void surrender(Player p) throws RemoteException {
		if (surrender != null)											// checks if one player already surrendered 
			throw new IllegalStateException("The game is already over!"); // throws exception if one player already surrendered
		
		else{

			surrender = p;
			uncoverAllFigures();
			getListener(p).gameIsLost();
			getListener(getOpponent(p)).gameIsWon();

			listener1.chatMessage(p, "I surrender");
			listener2.chatMessage(p, "I surrender");
		}
	}

	@Override
	public Figure[] getField() throws RemoteException {

		return board;
	}

	@Override
	public Move getLastMove() throws RemoteException {

		return lastMove;											
	}

	@Override
	public Player getOpponent(Player p) throws RemoteException {
		if (p == player1)
			return player2;
		else if (p == player2)
			return player1;
		else
			return null;
	}

	/**
	 * Method returns corresponding listener depending on which player is given
	 * 
	 * @param p
	 *      	 Player
	 * @return correct listener
	 */
	public GameListener getListener(Player p) {
		if (p == player1)
			return listener1;
		else if (p == player2)
			return listener2;
		else
			return null;
	}
	
	
	private boolean movableFigures(Player p){
		for (int i=0; i < board.length; i++){
			if(board[i] != null)
			if (board[i].getKind() == FigureKind.ROCK || board[i].getKind() == FigureKind.SCISSORS || board[i].getKind() == FigureKind.PAPER){
				if (board[i].belongsTo(p)){
					if (i == 0 || i == 6 || i == 35 || i == 41){
						//linke obere Ecke
					if ((i == 0 && board[1] != null && board[7] != null && (board[1].getKind() == FigureKind.FLAG || board[1].getKind() == FigureKind.TRAP) && (board[7].getKind() == FigureKind.FLAG || board[7].getKind() == FigureKind.TRAP))==false)
							//rechte obere Ecke
					if ((i == 6 && board[5] != null && board[13] != null && ( board[5].getKind() == FigureKind.FLAG || board[13].getKind() == FigureKind.TRAP) && (board[5].getKind() == FigureKind.FLAG || board[13].getKind() == FigureKind.TRAP))==false)
								//linke untere Ecke
					if ((i == 35 && board[28] != null && board[36] != null && (board[28].getKind() == FigureKind.FLAG || board[36].getKind() == FigureKind.TRAP) && (board[28].getKind() == FigureKind.FLAG || board[36].getKind() == FigureKind.TRAP))==false)
									//rechte untere Ecke
					if ((i == 41 && board[34] != null && board[40] != null && (board[34].getKind() == FigureKind.FLAG || board[40].getKind() == FigureKind.TRAP) && (board[34].getKind() == FigureKind.FLAG || board[40].getKind() == FigureKind.TRAP))==false)
							return true;			
					}
					else return true;
				}
			}
		}
		return false;
		
	}
	
	private void uncoverAllFigures(){
		for (Figure fig : board) {
			if(fig != null)
			fig.setDiscovered();
			}
		
	}
}