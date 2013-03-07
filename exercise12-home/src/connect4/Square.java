package connect4;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * A square of playing board.
 * 
 *
 */
public class Square extends JButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int row = 0;
	private int column = 0;

	/**
	 * 
	 * @param row
	 * @param column
	 * @param icon
	 */
	public Square(int row, int column, ImageIcon icon, ActionListener listener) {

		super();

		setIcon(icon);
		setDisabledIcon(icon);

		this.row = row;
		this.column = column;

		setEnabled(false);
		setBackground(Color.BLACK);
		setBorder(BorderFactory.createEmptyBorder());

		addActionListener(listener);
	}

	@Override
	public void setIcon(Icon icon) {

		super.setIcon(icon);
		setDisabledIcon(icon);
	}

	public int getRow() {
		return row;
	}

	public int getColumn() {
		return column;
	}
}
