import java.awt.event.*;


public class guitest2Listener extends guitest2 implements MouseListener {
	
	
	public void mouseEntered(MouseEvent e){
		label.setText("Troll");
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		label.setText("test5");
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		label.setText("Troll Number 2");
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		label.setText("Trollolol");
		
	}
}

