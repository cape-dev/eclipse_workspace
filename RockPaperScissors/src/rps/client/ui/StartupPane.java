package rps.client.ui;

import static javax.swing.BoxLayout.X_AXIS;
import static javax.swing.BoxLayout.Y_AXIS;
import static rps.client.Application.showMessage;
import static rps.network.NetworkUtil.getIPV4Addresses;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import rps.client.GameController;
import rps.client.GameListener;
import rps.client.UIController;
import rps.game.data.Player;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

public class StartupPane {

	private final JPanel connectionPane = new JPanel();

	private final JLabel playerLabel = new JLabel("Player name:");
	private final JTextField playerName = new JTextField("Player X");

	private final JLabel hostLabel = new JLabel("Host:");
	private final JComboBox<String> hostIP = new JComboBox<String>();

	private final JLabel joinLabel = new JLabel("Join:");
	private final JTextField joinAddr = new JTextField();

	private final JLabel aiLabel = new JLabel("AIs:");
	private final JComboBox<GameListener> comboAI = new JComboBox<GameListener>();

	private final JButton startBtn = new JButton("Start");

	private final UIController uiController;
	private final GameController gameController;

	private JRadioButton radioHost;
	private JRadioButton radioJoin;
	private JRadioButton radioAi;
	
	int HORIZSPLIT = JSplitPane.HORIZONTAL_SPLIT;
	int VERTSPLIT = JSplitPane.VERTICAL_SPLIT;

	public StartupPane(Container parent, UIController uiController, GameController gameController,
			Vector<GameListener> ais) {

		JSplitPane splitpane1;
		JSplitPane splitpane2;
		JSplitPane splitpane3;
		
		JPanel boardPanel = new JPanel();
		JPanel topicPanel = new JPanel();
		JPanel playButtonsPanel = new JPanel();
		
//		Dimension minimumSize = new Dimension(100, 100);
//		Dimension maximumSize = new Dimension(100, 100);
//		boardPanel.setMinimumSize(minimumSize);
//		boardPanel.setMaximumSize(maximumSize);
//		topicPanel.setMinimumSize(minimumSize);
//		topicPanel.setMaximumSize(maximumSize);
//		playButtonsPanel.setMinimumSize(minimumSize);
//		playButtonsPanel.setMaximumSize(maximumSize);
		
		Container boardC = new Container();
		Container chatC = new Container ();
		Container topicC = new Container();
		Container playButtonsC = new Container();
		
		boardC = boardPanel;
		chatC = connectionPane;
		topicC = topicPanel;
		playButtonsC = playButtonsPanel;
		
		
		//board erstellen:
				boardPanel.setLayout(new GridLayout(6,7));

				addPlayer2("Player 2", boardPanel);
				addPlayer2("Player 2", boardPanel);
				addPlayer2("Player 2", boardPanel);
				addPlayer2("Player 2", boardPanel);
				addPlayer2("Player 2", boardPanel);
				addPlayer2("Player 2", boardPanel);
				addPlayer2("Player 2", boardPanel);
				addPlayer2("Player 2", boardPanel);
				addPlayer2("Player 2", boardPanel);
				addPlayer2("Player 2", boardPanel);
				addPlayer2("Player 2", boardPanel);
				addPlayer2("Player 2", boardPanel);
				addPlayer2("Player 2", boardPanel);
				addPlayer2("Player 2", boardPanel);

				addFreespace(" " , boardPanel);
				addFreespace(" " , boardPanel);
				addFreespace(" " , boardPanel);
				addFreespace(" " , boardPanel);
				addFreespace(" " , boardPanel);
				addFreespace(" " , boardPanel);
				addFreespace(" " , boardPanel);
				addFreespace(" " , boardPanel);
				addFreespace(" " , boardPanel);
				addFreespace(" " , boardPanel);
				addFreespace(" " , boardPanel);
				addFreespace(" " , boardPanel);
				addFreespace(" " , boardPanel);
				addFreespace(" " , boardPanel);

				addPlayer1("Player 1", boardPanel);
				addPlayer1("Player 1", boardPanel);
				addPlayer1("Player 1", boardPanel);
				addPlayer1("Player 1", boardPanel);
				addPlayer1("Player 1", boardPanel);
				addPlayer1("Player 1", boardPanel);
				addPlayer1("Player 1", boardPanel);
				addPlayer1("Player 1", boardPanel);
				addPlayer1("Player 1", boardPanel);
				addPlayer1("Player 1", boardPanel);
				addPlayer1("Player 1", boardPanel);
				addPlayer1("Player 1", boardPanel);
				addPlayer1("Player 1", boardPanel);
				addPlayer1("Player 1", boardPanel);
				//--------------------------------------
				
				
				JLabel topicLabel = new JLabel("ROCK, PAPER, SCISSORS", SwingConstants.CENTER);
				topicPanel.add(topicLabel);
				
				JButton play = new JButton("Play");
				playButtonsPanel.add(play);
				
				
				
				splitpane1 = new JSplitPane(VERTSPLIT, true, boardC, playButtonsC);
				splitpane1.setDividerSize(1);
				splitpane1.setDividerLocation(280);
				
				splitpane2 = new JSplitPane(HORIZSPLIT, true, chatC, splitpane1);
				splitpane2.setDividerSize(1);
				splitpane2.setDividerLocation(170);
				
				splitpane3 = new JSplitPane(VERTSPLIT, true, topicC, splitpane2);
				splitpane3.setDividerSize(1);
				splitpane3.setDividerLocation(25);
		
		
		this.uiController = uiController;
		this.gameController = gameController;

		comboAI.setModel(new DefaultComboBoxModel<GameListener>(ais));
		hostIP.setModel(new DefaultComboBoxModel<String>(getIPV4Addresses()));

		connectionPane.setLayout(new BoxLayout(connectionPane, Y_AXIS));

		ButtonGroup group = new ButtonGroup();
		radioHost = new JRadioButton();
		radioJoin = new JRadioButton();
		radioAi = new JRadioButton();
		group.add(radioHost);
		group.add(radioJoin);
		group.add(radioAi);
		radioHost.setSelected(true);

		addEntry(connectionPane, null, playerLabel, playerName);
		addEntry(connectionPane, radioHost, hostLabel, hostIP);
		addEntry(connectionPane, radioJoin, joinLabel, joinAddr);
		addEntry(connectionPane, radioAi, aiLabel, comboAI);

		connectionPane.add(startBtn);

		
		parent.add(splitpane3);

		

		bindActions();
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

	private static void addEntry(JPanel container, JComponent c0, JComponent c1, JComponent c2) {
		JPanel p = new JPanel();
		p.setLayout(new BoxLayout(p, X_AXIS));
		if (c0 != null) {
			p.add(c0);
		}
		p.add(c1);
		p.add(c2);
		container.add(p);
	}

	private void bindActions() {
		startBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!isValidPlayerName()) {
					showMessage("bad player name");
					return;
				}
				try {
					uiController.switchToWaitingForOpponentPane();
					if (radioHost.isSelected()) {
						String host = (String) hostIP.getSelectedItem();
						gameController.startHostedGame(getPlayer(), host);
					} else if (radioJoin.isSelected()) {
						String host = joinAddr.getText().trim();
						gameController.startJoinedGame(getPlayer(), host);
					} else {
						GameListener ai = (GameListener) comboAI.getSelectedItem();
						gameController.startAIGame(getPlayer(), ai);
					}
				} catch (IllegalArgumentException ex) {
					// in case of duplicate name
					uiController.switchBackToStartup();
					showMessage(ex.getMessage());
				} catch (Exception ex) {
					showMessage("game could not be started");
					uiController.stopWaitingAndSwitchBackToStartup();
				}
			}
		});
	}

	public void show() {
		connectionPane.setVisible(true);
	}

	public void hide() {
		connectionPane.setVisible(false);
	}

	private boolean isValidPlayerName() {
		return getPlayerName().length() > 0;
	}

	private Player getPlayer() {
		return new Player(getPlayerName());
	}

	private String getPlayerName() {
		return playerName.getText().trim();
	}
}
