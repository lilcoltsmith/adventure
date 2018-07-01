package adventure;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.UIManager;

import components.*;

public class Game {
	
	public Player player;
	public Map map = new Map();
	
	public JFrame window;
	public Container container;
	public int windowX, windowY;
	public JPanel titleNamePanel, startButtonPanel, mainTextPanel, choicePanel, hudPanel, subChoicePanel;
	public JLabel titleNameLabel, hpLabel, hpLabelNumber, locationLabel, locationLabelName;
	public Font titleFont = new Font("Times New Roman", Font.PLAIN, 90);
	public Font normalFont = new Font("Times New Roman", Font.PLAIN, 30);
	public Font smallFont = new Font("Times New Roman", Font.PLAIN, 20);
	public JButton startButton, choice0, choice1, choice2, choice3, subChoice0, subChoice1, subChoice2, subChoice3;
	public JTextArea mainTextArea;
	
	public TitleScreenHandler tsHandler = new TitleScreenHandler();
	public NavigationHandler navHandler = new NavigationHandler();
	public ActionHandler actionHandler = new ActionHandler();
	public BackHandler backHandler = new BackHandler();
	public NorthHandler nHandler = new NorthHandler();
	public SouthHandler sHandler = new SouthHandler();
	public EastHandler eHandler = new EastHandler();
	public WestHandler wHandler = new WestHandler();
	
	public Game() {
		
		try {
		    UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName() );
		 } catch (Exception e) {
		            e.printStackTrace();
		 }
		
		titleScreen();

	}
	
	public void titleScreen() {
		window = new JFrame();
		windowX = 800; windowY = 600;
		window.setSize(windowX, windowY);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.black);
		window.setLayout(null);
		container = window.getContentPane();
		titleNamePanel = createPanel(100, 100, 600, 150, Color.black);
		titleNameLabel = createLabel("ADVENTURE", Color.white, titleFont);
		startButtonPanel = createPanel(300, 400, 200, 100, Color.black);
		startButton = createButton("START", tsHandler);
		titleNamePanel.add(titleNameLabel);
		startButtonPanel.add(startButton);
		container.add(titleNamePanel);
		container.add(startButtonPanel);
		window.setVisible(true);
	}
	
	public void createGameScreen() {
		player = new Player("Colton");
		player.setLocation(map.awakening);
		titleNamePanel.setVisible(false);
		startButtonPanel.setVisible(false);
		createHud();
		createMainText();
		createChoices();
		createSubChoices();
	}
	
	public void createHud() {
		hudPanel = createPanel(100, 15, 600, 50, Color.black);
		hudPanel.setLayout(new GridLayout(1, 4));
		hpLabel = createLabel("HP:", Color.white, smallFont);
		hpLabelNumber = createLabel(Integer.toString(player.getHealth()), Color.white, smallFont);
		locationLabel = createLabel("Location:", Color.white, smallFont);
		locationLabelName = createLabel(player.getLocationName(), Color.white, smallFont);
		hudPanel.add(hpLabel);
		hudPanel.add(hpLabelNumber);
		hudPanel.add(locationLabel);
		hudPanel.add(locationLabelName);		
		container.add(hudPanel);
	}
	
	public void createMainText() {
		mainTextPanel = createPanel(100, 100, 600, 250, Color.black);
		mainTextArea = createTextArea(100, 100, 600, 250, player.getLocation().getDescription(), Color.black, Color.white, normalFont);
		mainTextPanel.add(mainTextArea);
		container.add(mainTextPanel);
	}
	
	public void createChoices() {
		choicePanel = createPanel(100, 350, 600, 150, Color.black);
		choicePanel.setLayout(new GridLayout(4,1));
		
		choice0 = createButton("--", null);
		choice1 = createButton("--", null);
		choice2 = createButton("--", null);
		choice3 = createButton("--", null);
		
		createInitialChoices();
		addChoices();
		
		container.add(choicePanel);
	}
	
	public void createSubChoices() {
		subChoicePanel = createPanel(100, 500, 600, 50, Color.black);
		subChoicePanel.setLayout(new GridLayout(1,4));
		
		subChoice0 = createButton("Back", backHandler);
		subChoice1 = createButton("<<", null);
		subChoice2 = createButton(">>", null);
		subChoice3 = createButton("--", null);
		
		addSubChoices();
		
		container.add(subChoicePanel);
	}
	
	public void createInitialChoices() {
		removeChoiceActionListeners();
		choice0.setText("Navigate"); choice0.addActionListener(navHandler);
		choice1.setText("Actions"); choice1.addActionListener(actionHandler);
		choice2.setText("--");
		choice3.setText("--");
	}
	
	public void createNavigation() {	
		removeChoiceActionListeners();
		choice0.setText("Go North"); choice0.addActionListener(nHandler);
		choice1.setText("Go South"); choice1.addActionListener(sHandler);
		choice2.setText("Go East"); choice2.addActionListener(eHandler);
		choice3.setText("Go West"); choice3.addActionListener(wHandler);
	}
	
	public void createActions() {
		removeChoiceActionListeners();
		choice0.setText("action0"); choice0.addActionListener(null);
		choice1.setText("action1"); choice1.addActionListener(null);
		choice2.setText("action2"); choice2.addActionListener(null);
		choice3.setText("action3"); choice3.addActionListener(null);
	}
	
	public void addChoices() {
		choicePanel.add(choice0);
		choicePanel.add(choice1);
		choicePanel.add(choice2);
		choicePanel.add(choice3);
	}
	
	public void addSubChoices() {
		subChoicePanel.add(subChoice0);
		subChoicePanel.add(subChoice1);
		subChoicePanel.add(subChoice2);
		subChoicePanel.add(subChoice3);
	}
	
	public void removeChoiceActionListeners() {
		for(ActionListener l : choice0.getActionListeners()) {
			choice0.removeActionListener(l);
		}
		for(ActionListener l : choice1.getActionListeners()) {
			choice1.removeActionListener(l);
		}
		for(ActionListener l : choice2.getActionListeners()) {
			choice2.removeActionListener(l);
		}
		for(ActionListener l : choice3.getActionListeners()) {
			choice3.removeActionListener(l);
		}
	}
	
	public JPanel createPanel(int x, int y, int width, int height, Color color) {
		JPanel panel = new JPanel();
		panel.setBounds(x, y, width, height);
		panel.setBackground(color);
		return panel;
	}
	
	public JLabel createLabel(String text, Color foreground, Font font) {
		JLabel label = new JLabel(text);
		label.setForeground(foreground);
		label.setFont(font);
		return label;
	}
	
	public JLabel createLabel(String text, Color background, Color foreground, Font font) {
		JLabel label = new JLabel(text);
		label.setBackground(background);
		label.setForeground(foreground);
		label.setFont(font);
		return label;
	}
	
	public JButton createButton(String text, ActionListener action) {
		JButton button = new JButton(text);
		button.setActionCommand(text);
		button.setBackground(Color.black);
		button.setForeground(Color.white);
		button.setFont(normalFont);
		button.setFocusPainted(false);
		button.addActionListener(action);
		return button;
	}
	
	public JTextArea createTextArea(int x, int y, int width, int height, String text, Color background, Color foreground, Font font) {
		JTextArea textArea = new JTextArea(text);
		textArea.setBounds(x, y, width, height);
		textArea.setBackground(background);
		textArea.setForeground(foreground);
		textArea.setFont(font);
		textArea.setLineWrap(true);
		return textArea;
	}
	
	public class TitleScreenHandler implements ActionListener {
		public void actionPerformed(ActionEvent action) {
			createGameScreen();
		}
	}
	
	public class NavigationHandler implements ActionListener {
		public void actionPerformed(ActionEvent action) {
			createNavigation();
		}
	}
	
	public class ActionHandler implements ActionListener {
		public void actionPerformed(ActionEvent action) {
			createActions();
		}
	}
	
	public class BackHandler implements ActionListener {
		public void actionPerformed(ActionEvent action) {
			createInitialChoices();
		}
	}
	
	public class NorthHandler implements ActionListener {
		public void actionPerformed(ActionEvent action) {
			List<Exit> exits = player.getLocation().getExits();
			for(int i = 0; i < exits.size(); i++) {
				if(exits.get(i).getDirectionName().equals("NORTH")) {
					player.setLocation(player.getLocation().getExits().get(i).getLeadsTo());
					locationLabelName.setText(player.getLocationName());
					mainTextArea.setText(player.getLocation().getDescription());
					createInitialChoices();
				}
			}
		}
	}
	
	public class SouthHandler implements ActionListener {
		public void actionPerformed(ActionEvent action) {
			List<Exit> exits = player.getLocation().getExits();
			for(int i = 0; i < exits.size(); i++) {
				if(exits.get(i).getDirectionName().equals("SOUTH")) {
					player.setLocation(player.getLocation().getExits().get(i).getLeadsTo());
					locationLabelName.setText(player.getLocationName());
					mainTextArea.setText(player.getLocation().getDescription());
					createInitialChoices();
				}
			}
		}
	}
	
	public class EastHandler implements ActionListener {
		public void actionPerformed(ActionEvent action) {
			List<Exit> exits = player.getLocation().getExits();
			for(int i = 0; i < exits.size(); i++) {
				if(exits.get(i).getDirectionName().equals("EAST")) {
					player.setLocation(player.getLocation().getExits().get(i).getLeadsTo());
					locationLabelName.setText(player.getLocationName());
					mainTextArea.setText(player.getLocation().getDescription());
					createInitialChoices();
				}
			}
		}
	}
	
	public class WestHandler implements ActionListener {
		public void actionPerformed(ActionEvent action) {
			List<Exit> exits = player.getLocation().getExits();
			for(int i = 0; i < exits.size(); i++) {
				if(exits.get(i).getDirectionName().equals("WEST")) {
					player.setLocation(player.getLocation().getExits().get(i).getLeadsTo());
					locationLabelName.setText(player.getLocationName());
					mainTextArea.setText(player.getLocation().getDescription());
					createInitialChoices();
				}
			}
		}
	}

}
