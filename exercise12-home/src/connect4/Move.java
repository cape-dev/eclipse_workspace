package connect4;


public class Move {

	int row;
	int column;

	Move(int r, int c) {
		row = r;
		column = c;
	}

	public int getColumn() {
		return column;
	}

	public int getRow() {
		return row;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Move) {
			Move m = (Move) obj;
			return m.getColumn() == this.column && m.getRow() == this.row;
		} else
			return false;

	}

	@Override
	public String toString() {
		return "<" + row + "," + column + ">";
	}

}
