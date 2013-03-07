import javax.swing.*;

import java.awt.*;


public class jSplitPaneTest extends JSplitPane {

	
	JLabel CHAT = new JLabel("CHAT", SwingConstants.CENTER);
	
	
	int HORIZSPLIT = JSplitPane.HORIZONTAL_SPLIT;
	int VERTSPLIT = JSplitPane.VERTICAL_SPLIT;
	Dimension dim = new Dimension(500, 400);

	
	public jSplitPaneTest(){
		
		JFrame superFrame = new JFrame();
		JSplitPane splitpane1;
		JSplitPane splitpane2;
		JPanel board = new JPanel();
		JPanel chat = new JPanel();
		JPanel topic = new JPanel();
		
		Container boardC = new Container();
		Container chatC = new Container ();
		Container topicC = new Container();
		
		boardC = board;
		chatC = chat;
		topicC = topic;
		
		
		//board erstellen:
		board.setLayout(new GridLayout(6,7));

		addPlayer2("Player 2", board);
		addPlayer2("Player 2", board);
		addPlayer2("Player 2", board);
		addPlayer2("Player 2", board);
		addPlayer2("Player 2", board);
		addPlayer2("Player 2", board);
		addPlayer2("Player 2", board);
		addPlayer2("Player 2", board);
		addPlayer2("Player 2", board);
		addPlayer2("Player 2", board);
		addPlayer2("Player 2", board);
		addPlayer2("Player 2", board);
		addPlayer2("Player 2", board);
		addPlayer2("Player 2", board);

		addFreespace(" " , board);
		addFreespace(" " , board);
		addFreespace(" " , board);
		addFreespace(" " , board);
		addFreespace(" " , board);
		addFreespace(" " , board);
		addFreespace(" " , board);
		addFreespace(" " , board);
		addFreespace(" " , board);
		addFreespace(" " , board);
		addFreespace(" " , board);
		addFreespace(" " , board);
		addFreespace(" " , board);
		addFreespace(" " , board);

		addPlayer1("Player 1", board);
		addPlayer1("Player 1", board);
		addPlayer1("Player 1", board);
		addPlayer1("Player 1", board);
		addPlayer1("Player 1", board);
		addPlayer1("Player 1", board);
		addPlayer1("Player 1", board);
		addPlayer1("Player 1", board);
		addPlayer1("Player 1", board);
		addPlayer1("Player 1", board);
		addPlayer1("Player 1", board);
		addPlayer1("Player 1", board);
		addPlayer1("Player 1", board);
		addPlayer1("Player 1", board);
		//--------------------------------------
		
		JLabel topicLabel = new JLabel("ROCK, PAPER, SCISSORS", SwingConstants.CENTER);
		topic.add(topicLabel);
		
		
		chat.add(CHAT);
		
		

		
		splitpane1 = new JSplitPane(HORIZSPLIT, true, chatC, boardC){
			private final int location = 100;
			{
			setDividerLocation(location);
			}
			
			@Override
			public int getDividerLocation(){
				return location;
			}
			
			@Override
			public int getLastDividerLocation(){
				return location;
			}
		};
		splitpane1.setOneTouchExpandable(false);
		splitpane1.setDividerSize(1);
		
		splitpane2 = new JSplitPane(VERTSPLIT, true, topicC, splitpane1){
			private final int location = 30;
			{
			setDividerLocation(location);
			}
			
			@Override
			public int getDividerLocation(){
				return location;
			}
			
			@Override
			public int getLastDividerLocation(){
				return location;
			}
		};
		splitpane2.setOneTouchExpandable(false);
		splitpane2.setDividerSize(1);
		
		
		
		
		superFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		superFrame.add(splitpane2);
		superFrame.setSize(500, 400);
		superFrame.setMinimumSize(dim);
		
		superFrame.setVisible(true);
	
	}
	
	public void addPlayer1(String text, JPanel pane){
		JLabel label = new JLabel(text, SwingConstants.CENTER);
		label.setBorder(BorderFactory.createLineBorder(Color.black));
		label.setBackground(Color.blue);
		label.setOpaque(true);
		pane.add(label);
	}
	
	public void addPlayer2(String text, JPanel pane){
		JLabel label = new JLabel(text, SwingConstants.CENTER);
		label.setBorder(BorderFactory.createLineBorder(Color.black));
		label.setBackground(Color.red);
		label.setOpaque(true);
		pane.add(label);
	}
	
	public void addFreespace(String text, JPanel pane){
		JLabel label = new JLabel(text, SwingConstants.CENTER);
		label.setBorder(BorderFactory.createLineBorder(Color.black));
		pane.add(label);
	}
	
	
	
	public static void main(String[] args) {
		new jSplitPaneTest();
	}
}
