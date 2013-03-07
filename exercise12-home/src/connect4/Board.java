package connect4;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 
 * This class implements the connect-four board. There are also some function
 * implemented to check the state of the board. You *CAN* use the functions of
 * this class in your solution.
 * 
 */
public class Board {

	private final int ROW_COUNT = 6;
	private final int COLUMN_COUNT = 7;

	// playing field.
	private Player[][] model = new Player[ROW_COUNT][COLUMN_COUNT];

	public Player[][] getModel() {
		return model;
	}

	private Player winner = null;

	// list of allowed moves.
	private Collection<Move> possibleMoves = new ArrayList<Move>();

	/*
	 * if a player wins the game, this array contains the four moves building a
	 * block of four connected cells.
	 */
	private Move winningMoves[] = new Move[4];

	/*
	 * an array of this list contains four moves, which build a block of four
	 * connected cells. If a player can make all the moves of an array he wins.
	 */
	private final Collection<Move[]> winningPaths = findAllPaths();

	/**
	 * Default constructor. It creates an empty playing field and initializes
	 * the list of allowed moves.
	 */
	Board() {

		// create an empty field.
		for (int r = 0; r < ROW_COUNT; r++) {
			for (int c = 0; c < COLUMN_COUNT; c++) {
				model[r][c] = Player.EmptySquare;
			}
		}

		// allowed moves.
		for (int i = 0; i < COLUMN_COUNT; i++)
			possibleMoves.add(new Move(0, i));
	}

	// ========================================================================
	//
	// Public interface
	//
	// *** You can can use the public functions in your solution. ***
	//
	// ========================================================================

	/**
	 * Returns the list of moves, which can be played in the current situation
	 * of the game.
	 * 
	 * @return a collection containing the allowed moves.
	 */
	public Collection<Move> getPossibleMoves() {
		return possibleMoves;
	}

	/**
	 * Returns a boolean value, which shows if the game is over or not. The game
	 * is over when a player wins or when all the squares are taken by a player.
	 * 
	 * @return if the game is over.
	 */
	public boolean isGameOver() {
		return possibleMoves.isEmpty();
	}

	/**
	 * This function changes the state of the playing board. In the new state
	 * the player <b>p</b> has made the move <b>m</b>.
	 * 
	 * @param p
	 *            the player who makes a move.
	 * @param m
	 *            the move
	 * @return if the m is an allowed move or not.
	 */
	public boolean update(Player p, Move m) {

		/* if the move is allowed handle it otherwise return false. */
		if (possibleMoves.contains(m)) {

			// the move is allowed, so assign the player to the square,
			// specified by the move.
			model[m.getRow()][m.getColumn()] = p;

			// distinguish the winner and update the list of valid moves:
			// 1) if the player wins, distinguish him as the winner.
			if (moveWins(m)) {
				winner = p;

				// a player wins, hence the game is over and there is no more a
				// allowed move.
				possibleMoves.clear();
			} else {

				// 2) There is no winner yet. If the column is not full yet, add
				// the square above the last move to the list of allowed moves.
				possibleMoves.remove(m);
				if (m.getRow() < ROW_COUNT - 1)
					possibleMoves.add(new Move(m.getRow() + 1, m.getColumn()));
			}
			return true;

		} else
			return false;
	}

	/**
	 * Use this function to check if a player wins the game.
	 * 
	 * @param player
	 *            the player, who is to be checked.
	 * @return if player wins the game.
	 */
	public boolean isWinner(Player player) {
		return player == winner;
	}

	/**
	 * If a player wins the game, this functions returns an array contains the
	 * four moves building a block of four connected cells. If there is no
	 * winner the array contains four nulls.
	 * 
	 * @return an array of moves.
	 */
	public Move[] getWinningMoves() {
		return winningMoves;
	}

	/**
	 * This function creates a new Board-object with the same state as the
	 * current one.
	 * 
	 * @return a copy of the current Board
	 */
	public Board getCopy() {

		// copy playing-field ---------
		Player[][] newModel = new Player[ROW_COUNT][COLUMN_COUNT];
		for (int r = 0; r < ROW_COUNT; r++) {
			System.arraycopy(model[r], 0, newModel[r], 0, model[0].length);
		}

		// copy allowed moves ---------
		ArrayList<Move> newList = new ArrayList<Move>();
		newList.addAll(possibleMoves);

		// copy winning moves ---------
		Move[] newWinningMoves = new Move[4];
		System.arraycopy(winningMoves, 0, newWinningMoves, 0,
				winningMoves.length);

		return new Board(newModel, newList, winner, newWinningMoves);
	}

	/**
	 * 
	 * returns all the blocks, which are made of four connected cells of the
	 * playing board.
	 * 
	 * @return a list of blocks of four cells.
	 */
	public Collection<Player[]> getBlocks() {

		Collection<Player[]> blocks = new ArrayList<Player[]>();
		Player[] blk;

		for (Move[] path : winningPaths) {

			blk = new Player[4];

			blk[0] = model[path[0].getRow()][path[0].getColumn()];
			blk[1] = model[path[1].getRow()][path[1].getColumn()];
			blk[2] = model[path[2].getRow()][path[2].getColumn()];
			blk[3] = model[path[3].getRow()][path[3].getColumn()];

			blocks.add(blk);
		}

		return blocks;

	}

	// ========================================================================
	//
	// Private interface
	//
	// ========================================================================

	/**
	 * This function checks if a player has built a vertical, horizontal, or a
	 * diagonal block of four connected cells by playing the move m.
	 * 
	 * @param m
	 *            a move
	 * @return if a player has won by playing the move m.
	 */
	private boolean moveWins(Move m) {

		// if a block of four connected cells is built, store it.
		for (Move[] path : getPathsContaining(m)) {
			if (isWinnerPath(path)) {
				winningMoves = path;
				return true;
			}
		}

		return false;
	}

	/**
	 * Checks if the board contains similar stones in the cells specified by the
	 * moves contained in the array <b>a</b>.
	 * 
	 * @param a
	 *            array of moves
	 * @return if the moves contained in <b>a</b> build a block of four
	 *         connected, similar stones.
	 */
	private boolean isWinnerPath(Move a[]) {
		if (model[a[0].getRow()][a[0].getColumn()] == model[a[1].getRow()][a[1]
				.getColumn()]
				&& model[a[1].getRow()][a[1].getColumn()] == model[a[2]
						.getRow()][a[2].getColumn()]
				&& model[a[2].getRow()][a[2].getColumn()] == model[a[3]
						.getRow()][a[3].getColumn()]) {

			winningMoves = a;
			return true;
		}
		return false;
	}

	/**
	 * Returns a list of arrays. The move <b>move</b> is contained in all arrays
	 * of this list. Each array contains four moves, which can build a block of
	 * four connected cells.
	 * 
	 * @param move
	 * @return
	 */
	private Collection<Move[]> getPathsContaining(Move move) {

		Collection<Move[]> blks = new ArrayList<Move[]>();

		for (Move[] path : winningPaths) {
			if (pathIncludesMove(path, move))
				blks.add(path);
		}
		return blks;
	}

	/**
	 * checks if a move is contained in an array of moves.
	 * 
	 * @param path
	 *            an array of moves.
	 * @param move
	 *            a move the be checked if it is contained in the array
	 *            <b>path</b>.
	 * @return true if <b>path</b> contains <b>move</b>.
	 */
	private boolean pathIncludesMove(Move[] path, Move move) {

		for (int i = 0; i < path.length; i++) {
			if (path[i].equals(move)) {
				return true;
			}
		}

		return false;
	}

	/**
	 * Returns a list of all possibilities to win a game. An element of this
	 * list is an array containing four moves, which build a block of four
	 * connected cells.
	 * 
	 * @return a list of arrays of moves.
	 */
	private Collection<Move[]> findAllPaths() {

		Collection<Move[]> paths = new ArrayList<Move[]>();
		Move[] tempPath;

		// horizontal paths -----------
		for (int r = 0; r < 6; r++) {
			for (int c = 0; c < 4; c++) {
				tempPath = new Move[4];

				tempPath[0] = new Move(r, c);
				tempPath[1] = new Move(r, c + 1);
				tempPath[2] = new Move(r, c + 2);
				tempPath[3] = new Move(r, c + 3);

				paths.add(tempPath);
			}
		}

		// vertical paths -------------
		for (int r = 0; r < 3; r++) {
			for (int c = 0; c < 7; c++) {
				tempPath = new Move[4];

				tempPath[0] = new Move(r, c);
				tempPath[1] = new Move(r + 1, c);
				tempPath[2] = new Move(r + 2, c);
				tempPath[3] = new Move(r + 3, c);

				paths.add(tempPath);
			}
		}

		// check diagonals to top-right
		for (int r = 0; r < 3; r++) {
			for (int c = 0; c < 4; c++) {

				tempPath = new Move[4];

				tempPath[0] = new Move(r, c);
				tempPath[1] = new Move(r + 1, c + 1);
				tempPath[2] = new Move(r + 2, c + 2);
				tempPath[3] = new Move(r + 3, c + 3);

				paths.add(tempPath);
			}
		}

		// check diagonals to top-left
		for (int r = 0; r < 2; r++) {
			for (int c = 3; c < 7; c++) {

				tempPath = new Move[4];

				tempPath[0] = new Move(r, c);
				tempPath[1] = new Move(r + 1, c - 1);
				tempPath[2] = new Move(r + 2, c - 2);
				tempPath[3] = new Move(r + 3, c - 3);

				paths.add(tempPath);
			}
		}
		// -------------------------------------------
		return paths;

	}

	/**
	 * This constructor is used for copying a concrete instance of this class.
	 * 
	 * @param model
	 *            The current playing field.
	 * @param pm
	 *            List of allowed moves.
	 * @param winner
	 *            The winner of the game.
	 * 
	 * @param winnerPath
	 *            Four moves, which win the game.
	 */
	private Board(Player[][] model, Collection<Move> pm, Player winner,
			Move[] winnerPath) {

		this.model = model;
		this.possibleMoves = pm;
		this.winner = winner;
		this.winningMoves = winnerPath;
	}

}
