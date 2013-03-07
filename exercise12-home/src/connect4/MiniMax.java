package connect4;


public class MiniMax {

	final int MAX_DEPTH;
	
	/**
	 * finds a move for the player <b>player</b>, when he plays against the
	 * player <b>opponent</b>.
	 * 
	 * @param player
	 *            the current player.
	 * @param opponent
	 *            the player playing against the current player.
	 * @param board
	 *            the current playing board.
	 * @return a move for <b>player</b>
	 */
	public Move findMove(Player player, Player opponent, Board board) {

		// TODO: Implement me.
		
		for (int r = 0; r < 7; r++) {
			for (int c = 0; c < 7; c++) {
				if (board.getModel()[r][c] == Player.EmptySquare)
					return new Move(r, c);
			}
		}

		return null;
	}

	/**
	 * scores a finished game. Since the <b>maxPlayer</b> maximizes, the best
	 * score is achieved if he wins and worse score is achieved if he loses. The
	 * score of a drawn game is zero.
	 * 
	 * @param board
	 *            the playing board.
	 * @return the score.
	 */
	private int scoreFinishedGame(Board board) {
		// TODO: Implement me
		return 0;
	}

	/**
	 * scores a game heuristically. This is used, when the search tree reaches
	 * the maximum depth and the game is still not over.
	 * 
	 * @param board
	 *            the current playing board.
	 * @return the score.
	 */
	private int scoreHeuristically(Board board) {

		// TODO: Implement me
		return 0;
	}

}
