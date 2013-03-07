import javax.swing.*;
import java.awt.*;   
import java.awt.event.*;


public class guitest2 {

	// The width of the window in pixels 
	public static final int WIDTH = 400; 
	// The height of the window in pixels 
	public static final int HEIGHT = 300; 
	
	
	protected JLabel label;
	
	public guitest2() {
		

		
		JFrame frame1 = new JFrame();
		JFrame frame2 = new JFrame();
		
		Container pane1 = frame1.getContentPane();
		Container pane2 = frame2.getContentPane();
		
		pane1.setLayout(new GridLayout(2,2));
		pane2.setLayout(new GridLayout(5,1));
		
		
		
		//unterstes fenster:
		addPane(pane1, pane2);
		addBorderedLabel("test2", pane1);
		addBorderedLabel("test3", pane1);
		addBorderedLabel("test4", pane1);
		
		//oberes fenster:

		label = new JLabel("test5", SwingConstants.CENTER);
		label.addMouseListener(new MouseListener(){
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
		});
		pane2.add(label);
		
		class MouseListener1 implements MouseListener {
			public void mouseEntered(MouseEvent e){
				label.setText("Troll");
			}

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				label.setText("test5");
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		}
		
		
		addLabel("test6", pane2);
		addLabel("test7", pane2);
		addBorderedLabel("test8", pane2);
		addLabel("test9", pane2);
		
		
		
		
		
		frame1.setSize(WIDTH, HEIGHT);
		frame1.setVisible(true);
		frame2.setVisible(false);
		
		
		
	}
	
	
	public void addBorderedLabel(String text, Container pane){
		JLabel label = new JLabel(text, SwingConstants.CENTER);
		label.setBorder(BorderFactory.createLineBorder(Color.black));
		pane.add(label);
	}
	
	public void addLabel(String text, Container pane){
		JLabel label = new JLabel(text, SwingConstants.CENTER);
		pane.add(label);
	}
	
//	public void addButton(String text, Container pane){
//		JButton button = new JButton(text);
//		pane.add(button);
//	}
	
	public void addPane(Container boxer, Container boxed){
		boxer.add(boxed);
	}
	
	
	public static void main(String[] args) {
		guitest2 gui = new guitest2();
	
	}
}
	
	

