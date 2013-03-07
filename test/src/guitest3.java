import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener;  
import java.awt.event.WindowAdapter; 
import java.awt.event.WindowEvent;




public class guitest3 {

	
	private boolean joined = false;
	
	public guitest3(){
		
		
		JFrame frame = new JFrame();
		JWindow window = new JWindow();
		JPanel panel = new JPanel();
		
		JButton button = new JButton("EXIT");
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		});	
		
		JButton button1 = new JButton("set visible");
		button.addActionListener(new test() );
		
		panel.add(button);
		panel.add(button1);
		
		window.add(panel);
		
		window.setSize(200, 200);
		window.setVisible(true);
		
		frame.setLocation(300, 0);
		frame.setVisible(joined);
		
		
		
		
	}
	
	private class test implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent event) {
			joined = true;
			
		}
		
	}
	
	
	public static void main(String[] args) {
		new guitest3();
	}
}
