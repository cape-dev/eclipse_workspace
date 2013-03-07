package connect4;

public enum Player {

	PLAYER_1("P1"),
	PLAYER_2("P2"),
	EmptySquare(" "); 

	private String caption;

	Player(String c) {
		caption = c;
	}
	
	
	public String getCaption() {
		return caption;
	}
}
    