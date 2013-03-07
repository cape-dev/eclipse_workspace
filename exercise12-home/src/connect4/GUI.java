package connect4;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 * This class provides a graphical user interface for playing connect-four
 * against computer.
 * 
 */
public class GUI implements ActionListener {

	// ------------------------------------------
	private Board board = new Board(); // playing field

	// the two connect-four players
	private Player humanPlayer = Player.PLAYER_1;
	private Player computerPlayer = Player.PLAYER_2;

	/* Implementation of MINI-MAX algorithm, used to find the computer's moves. */
	private MiniMax miniMax = new MiniMax();

	// GUI-Elements -----------------------------
	private JFrame frame = null;
	private JPanel panel = null;
	private JMenuBar menuBar = null;

	private Square[][] cells;

	// Paths to icons ---------------------------
	private final String projPath = System.getProperty("user.dir");
	private final String imagesPath = "/src/connect4/images/";

	private String greyIconPath = projPath + imagesPath + "grey.png";
	private String whiteIconPath = projPath + imagesPath + "white.png";
	private String redIconPath = projPath + imagesPath + "red.png";
	private String yellowIconPath = projPath + imagesPath + "yellow.png";
	private String redWinsIconPath = projPath + imagesPath + "redWins.png";
	private String yellowWinsIconPath = projPath + imagesPath
			+ "yellowWins.png";

	// --------------------------------
	private ImageIcon disableCellIcon = new ImageIcon(greyIconPath);
	private ImageIcon enableCellIcon = new ImageIcon(whiteIconPath);
	private ImageIcon redIcon = new ImageIcon(redIconPath);
	private ImageIcon yellowIcon = new ImageIcon(yellowIconPath);
	private ImageIcon redWinsIcon = new ImageIcon(redWinsIconPath);
	private ImageIcon yellowWinsIcon = new ImageIcon(yellowWinsIconPath);

	// --------------------------------
	private final Cursor busyCursor = new Cursor(Cursor.WAIT_CURSOR);
	private final Cursor defaultCursor = new Cursor(Cursor.DEFAULT_CURSOR);

	/**
	 * Starts the GUI.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// Schedule a job for the event-dispatching thread:
		// creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				GUI gui = new GUI();
				gui.showGUI();
			}
		});
	}

	/**
	 * The constructor initializes the GUI-Elements.
	 */
	GUI() {

		initializeMenuBar();
		initializeCells();
		initializePanel();
		initializeFrame();
	}

	/**
	 * This function handles the interaction with the GUI.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() instanceof JMenuItem) {
			// the only possible menu action is resetting the game.
			resetGame();

		} else if (e.getSource() instanceof Square) {
			// a square is clicked.
			setBoardEnabled(false);
			handleSquareSelection((Square) e.getSource());
			setBoardEnabled(true);
		}
	}

	/**
	 * asks the second player for a move and updates the GUI to show the moves
	 * of the players.
	 * 
	 * @param square
	 *            the selected square.
	 */
	private void handleSquareSelection(Square square) {

		Move m = new Move(square.getRow(), square.getColumn());

		board.update(humanPlayer, m);
		updateGUI(humanPlayer, m);

		// the second player plays only if the first player does not win !
		if (!board.isWinner(humanPlayer)) {

			frame.setCursor(busyCursor);
			Move compMove = miniMax.findMove(computerPlayer, humanPlayer,
					board.getCopy());
			board.update(computerPlayer, compMove);
			updateGUI(computerPlayer, compMove);
			frame.setCursor(defaultCursor);
		}
	}

	/**
	 * Updates the GUI to show the effect of players move.
	 * 
	 * @param player
	 *            the player, who makes a move.
	 * @param move
	 *            the move of the player.
	 */
	private void updateGUI(Player player, Move move) {

		// if the player wins the game highlight the block of four squares.
		if (board.isWinner(player)) {

			Move[] path = board.getWinningMoves();
			for (int i = 0; i < 4; i++) {

				(cells[path[i].getRow()][path[i].getColumn()])
						.setIcon(getPlayersIcon(player, true));
			}

		} else {
			// put the player's stone in the square.
			(cells[move.getRow()][move.getColumn()]).setIcon(getPlayersIcon(
					player, false));
		}
		frame.update(frame.getGraphics());
	}

	/**
	 * returns an icon for a player depending on whether he wins or not.
	 * 
	 * @param p
	 *            a player
	 * @param won
	 *            determines if the player wins.
	 * @return an icon for the player <b>p</b>.
	 */
	private Icon getPlayersIcon(Player p, boolean won) {
		if (p == computerPlayer) {
			if (won)
				return redWinsIcon;
			else
				return redIcon;
		} else if (p == humanPlayer) {
			if (won)
				return yellowWinsIcon;
			else
				return yellowIcon;

		}
		return null;
	}

	/**
	 * This function is used for disabling the board after a square is selected
	 * by the user or when the game is over. When the computer has made his move
	 * and if the game is still not over, this function is used for enabling the
	 * board.
	 * 
	 * @param enable
	 */
	private void setBoardEnabled(boolean enable) {

		menuBar.setEnabled(enable);

		for (Move m : board.getPossibleMoves()) {

			cells[m.getRow()][m.getColumn()].setEnabled(enable);
			if (enable)
				cells[m.getRow()][m.getColumn()].setIcon(enableCellIcon);
		}

		frame.update(frame.getGraphics());
	}

	// ==============================================================
	//
	private void showGUI() {

		setBoardEnabled(true);
		frame.setVisible(true);
	}

	// ==============================================================
	//
	private void resetGame() {

		board = new Board();
		initializeCells();

		panel.removeAll();
		for (int r = 5; r > -1; r--)
			for (int c = 0; c < 7; c++)
				panel.add(cells[r][c]);

		setBoardEnabled(true);
		frame.update(frame.getGraphics());
	}

	// ==============================================================
	//
	private void initializeFrame() {
		// Create and set up the window.
		frame = new JFrame("connect4");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setJMenuBar(menuBar);
		frame.setContentPane(panel);

		// Display the window.
		frame.setSize(550, 520);
	}

	// ==============================================================
	//
	private void initializePanel() {

		panel = new JPanel(new GridLayout(6, 7));
		panel.setBackground(Color.BLACK);
		panel.setBorder(BorderFactory.createEmptyBorder());

		for (int r = 5; r > -1; r--)
			for (int c = 0; c < 7; c++)
				panel.add(cells[r][c]);

	}

	// ==============================================================
	//
	/**
	 * Resets the playing board.
	 */
	private void initializeCells() {

		cells = new Square[6][7];

		for (int r = 5; r > -1; r--)
			for (int c = 0; c < 7; c++)
				cells[r][c] = new Square(r, c, disableCellIcon, this);

	}

	// ==============================================================
	//
	private void initializeMenuBar() {
		menuBar = new JMenuBar();
		JMenu menu;
		JMenuItem menuItem;

		menuBar = new JMenuBar();

		menu = new JMenu("Game");
		menuBar.add(menu);

		menuItem = new JMenuItem("Reset");
		menuItem.addActionListener(this);
		menu.add(menuItem);
	}

}
