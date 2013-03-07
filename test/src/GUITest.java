import java.awt.Container; 
import javax.swing.JFrame; 
import javax.swing.JLabel; 
import javax.swing.JButton; 
import java.awt.GridLayout;  
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener;  
import java.awt.event.WindowAdapter; 
import java.awt.event.WindowEvent;

public class GUITest extends JFrame implements ActionListener { 
private static final long serialVersionUID = -4989264796563153034L;
// The width of the window in pixels 
public static final int WIDTH = 400; 
// The height of the window in pixels 
public static final int HEIGHT = 300; 


private JLabel infoLabel;

 // Constructs a new window with a given title
public GUITest(String title) { 
 super(title); 
 
 
//Now, also define that the [X] terminates the program correctly
addWindowListener(new MyWindowListener());
 
//Retrieve the area where one can add elements 
Container pane = getContentPane(); 
pane.setLayout(new GridLayout(4, 1));


//JLabel label2 = new JLabel("Press the [Exit] or [X] in the top right corner to exit"); 
//pane.add(label2); 
//// Create a new push button that may be used in addition to the [X] 

infoLabel = new JLabel("high");
pane.add(infoLabel);


JButton button2 = new JButton ("change");
// Add the button to the content of the window 



//Now, define what should happen if the button is pressed 
button2.addActionListener(this); 
pane.add(button2); 



JButton button1 = new JButton("nothing");

//button1.addActionListener(new ChangeButtonListener2());
pane.add(button1);



JButton exit = new JButton("Exit");
exit.addActionListener(new ExitButtonListener());
pane.add(exit);


 } 


private class ChangeButtonListener1 implements ActionListener { 
public void actionPerformed(ActionEvent event) { 
	if (infoLabel.getText() == "high")
		infoLabel.setText("low");
	else
		infoLabel.setText("high");
} 
} 


private class ChangeButtonListener2 implements ActionListener { 
public void actionPerformed(ActionEvent event) { 
	infoLabel.setText(String.valueOf(( Integer.parseInt(infoLabel.getText()) - 1)));
} 
} 

class MyWindowListener extends WindowAdapter {
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
}

class ExitButtonListener implements ActionListener {
	public void actionPerformed(ActionEvent event){
		System.exit(0);
	}
}




 // Start test application. Creates a new window and displays it 
public static void main(String args[]) { 
// Construct a new window. It is initially invisible 
 GUITest theWindow = new GUITest("Snake is the best gamer in the world"); 
// Set width and height of the window 
 theWindow.setSize(WIDTH, HEIGHT); 
// Open the window 
 theWindow.setVisible(true); 
 System.out.println("Exiting main..."); 
 }




@Override
public void actionPerformed(ActionEvent e) {
	if (infoLabel.getText() == "high")
		infoLabel.setText("low");
	else
		infoLabel.setText("high");
	
} 
} 