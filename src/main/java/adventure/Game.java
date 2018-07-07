package adventure;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;

import components.Player;
import components.Exit;
import components.Inventory;
import components.Item;
import components.NPC;
import util.GameHandler;

public class Game {
	// STATIC
	public static int width, height;
	// TITLE SCREEN
	public static int TITLE_X;
	public static int TITLE_Y = 100;
	public static int TITLE_WIDTH = 600;
	public static int TITLE_HEIGHT = 150;
	public static int START_BUTTON_X;
	public static int START_BUTTON_Y;
	public static int START_BUTTON_WIDTH = 200;
	public static int START_BUTTON_HEIGHT = 100;
	
	// player/map
	public Player player;
	public Map map;
	public GameHandler handler;
	// menu state
	public String menuState;
	// pages
	public int navPage = 0;
	public int actionPage = 0;
	public int inventoryPage = 0;
	public int npcPage = 0;
	// window elements
	public JFrame window;
	public Container container;
	public JPanel titleNamePanel, startButtonPanel, mainTextPanel, choicePanel, hudPanel, subChoicePanel;
	public JLabel titleNameLabel, hpLabel, hpLabelNumber, locationLabel, locationLabelName;
	public JProgressBar hpBar;
	public JButton startButton, choice0, choice1, choice2, choice3, subChoice0, subChoice1, subChoice2, subChoice3;
	public JTextArea mainTextArea; //Contains 7 lines of text
	public JScrollPane scroll;
	// fonts
	public Font titleFont = new Font("Times New Roman", Font.PLAIN, 90);
	public Font normalFont = new Font("Times New Roman", Font.PLAIN, 30);
	public Font smallFont = new Font("Times New Roman", Font.PLAIN, 20);
		
	public Game(JFrame window) {
		try {
		    UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName() );
		 } catch (Exception e) {
		            e.printStackTrace();
		 }
		this.window = window;
		width = this.window.getWidth(); height = this.window.getHeight();
		
		// SETTINGS
		TITLE_X = (width/2) - TITLE_WIDTH/2;
		START_BUTTON_X = (width/2)-START_BUTTON_WIDTH/2; START_BUTTON_Y = (height - 200);
		
		this.handler = new GameHandler(this);
		resetGame();
	}
	
	public void resetGame() {
		this.map = new Map(this);
		this.player = new Player(this);
		titleScreen();
	}
	
	public void titleScreen() {
		width = window.getWidth(); height = window.getHeight();
		container = window.getContentPane();
		titleNamePanel = createPanel(TITLE_X, TITLE_Y, TITLE_WIDTH, TITLE_HEIGHT, Color.black);
		titleNameLabel = createLabel("ADVENTURE", Color.white, titleFont);
		startButtonPanel = createPanel(START_BUTTON_X, START_BUTTON_Y, START_BUTTON_WIDTH, START_BUTTON_HEIGHT, 
				Color.black);
		startButton = createButton("START", handler.tsHandler);
		titleNamePanel.add(titleNameLabel);
		startButtonPanel.add(startButton);
		container.add(titleNamePanel);
		container.add(startButtonPanel);
		window.setVisible(true);
	}
	
	public void createGameScreen() {
		player.setLocation(map.awakening);
		titleNamePanel.setVisible(false);
		startButtonPanel.setVisible(false);
		createHud();
		createMainText();
		createChoices();
		createSubChoices();
	}
	
	public void createHud() {
		hudPanel = createPanel((width/2)-300, 15, 600, 50, Color.black);
		hudPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
		hpLabel = createLabel("HP:", Color.white, smallFont);
		hpBar = createProgressBar(true, Color.black, new Color(60, 0, 0));
		hpBar.setPreferredSize(new Dimension(200, 25));
		hpLabelNumber = createLabel(Integer.toString(player.getHealth()), Color.white, smallFont);
		locationLabel = createLabel("Location:", Color.white, smallFont);
		locationLabelName = createLabel(player.getLocationName(), Color.white, smallFont);
		hudPanel.add(hpLabel);
		hudPanel.add(hpBar);
		hudPanel.add(locationLabel);
		hudPanel.add(locationLabelName);		
		container.add(hudPanel);
	}
	
	public void createMainText() {
		mainTextPanel = createPanel((width/2)-((width-200)/2), 100, (width-200), 250, Color.black);
		mainTextArea = createTextArea((width/2)-((width-200)/2), 100, (width-200), 250, 
				player.getLocation().getDescription(), Color.black, Color.white, normalFont);
		scroll = new JScrollPane(mainTextArea);
		scroll.setPreferredSize(new Dimension((width-200), 245));
		scroll.setBorder(BorderFactory.createEmptyBorder());
		scroll.setBackground(Color.black);
		scroll.setForeground(Color.white);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		mainTextPanel.add(scroll);
		container.add(mainTextPanel);
	}
	
	public void createChoices() {
		choicePanel = createPanel((width/2)-((width-200)/2), height - 250, (width-200), 150, Color.black);
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
		subChoicePanel = createPanel((width/2)-((width-200)/2), height - 100, (width-200), 40, Color.black);
		subChoicePanel.setLayout(new GridLayout(1,4));
		
		subChoice0 = createButton("Back", handler.backHandler);
		subChoice1 = createButton("<<", handler.prevHandler);
		subChoice2 = createButton(">>", handler.nextHandler);
		subChoice3 = createButton("Map", handler.mapHandler);
		
		addSubChoices();
		
		container.add(subChoicePanel);
	}
	
	public void createInitialChoices() {
		removeChoiceActionListeners();
		menuState = "main";
		navPage = 0; actionPage = 0; inventoryPage = 0; npcPage = 0;
		choice0.setText("Navigate"); choice0.addActionListener(handler.navHandler);
		choice1.setText("Actions"); choice1.addActionListener(handler.actionHandler);
		choice2.setText("Inventory"); choice2.addActionListener(handler.inventoryHandler);
		if(player.getLocation().getNPC() != null) {
			choice3.setText(player.getLocation().getNPC().getName()); choice3.addActionListener(handler.npcHandler);
		}
		else {
			choice3.setText("--");
		}
	}
	
	public void createNavigation(int page) {	
		List<Exit> exits = player.getLocation().getExits();
		int one = 0+(4*page), two = 1+(4*page), three = 2+(4*page), four = 3+(4*page);
	
		removeChoiceActionListeners();
		menuState = "nav";
		if(exits != null) {
			if(one >=0 && one <= exits.size()-1) {
				choice0.setText(exits.get(one).getDirectionName());
				choice0 = addChoiceAction(choice0);
			}
			else choice0.setText("--");
			if(two >=0 && two <= exits.size()-1) {
				choice1.setText(exits.get(two).getDirectionName());
				choice1 = addChoiceAction(choice1);
			}
			else choice1.setText("--");
			if(three >=0 && three <= exits.size()-1) {
				choice2.setText(exits.get(three).getDirectionName());
				choice2 = addChoiceAction(choice2);
			}
			else choice2.setText("--");
			if(four >=0 && four <= exits.size()-1) {
				choice3.setText(exits.get(four).getDirectionName());
				choice3 = addChoiceAction(choice3);
			}
			else choice3.setText("--");
		}
	}
	
	public JButton addChoiceAction(JButton choice) {
		switch(choice.getText()) {
		case "NORTH":
			choice.addActionListener(handler.nHandler);
			break;
		case "SOUTH":
			choice.addActionListener(handler.sHandler);
			break;
		case "EAST":
			choice.addActionListener(handler.eHandler);
			break;
		case "WEST":
			choice.addActionListener(handler.wHandler);
			break;
		case "IN":
			choice.addActionListener(handler.iHandler);
			break;
		case "OUT":
			choice.addActionListener(handler.oHandler);
			break;
		case "UP":
			choice.addActionListener(handler.uHandler);
			break;
		case "DOWN":
			choice.addActionListener(handler.dHandler);
			break;
		}
		return choice;
	}
	
	public void createActions(int page, String type, int itemIndex) {
		List<String> actionDescriptions;
		List<ActionListener> actions;
		if(type.equals("general")) {
			actionDescriptions = player.getLocation().getActionDescriptions();
			actions = player.getLocation().getActions();
		}
		else if(type.equals("item")){
			List<Item> items = player.getInventory().getInventory();
			actionDescriptions = items.get(itemIndex).getActionDescriptions();
			actions = items.get(itemIndex).getActions();
		}
		else {
			actionDescriptions = player.getLocation().getNPC().getActionDescriptions();
			actions = player.getLocation().getNPC().getActions();
		}
		int one = 0+(4*page), two = 1+(4*page), three = 2+(4*page), four = 3+(4*page);
		
		removeChoiceActionListeners();
		menuState = "action";
		if(actions != null) {
			if(one >=0 && one <= actions.size()-1) {
				choice0.setText(actionDescriptions.get(one)); choice0.addActionListener(actions.get(one));
			}
			else choice0.setText("--");
			if(two >=0 && two <= actions.size()-1) {
				choice1.setText(actionDescriptions.get(two)); choice1.addActionListener(actions.get(two));
			}
			else choice1.setText("--");
			if(three >=0 && three <= actions.size()-1) {
				choice2.setText(actionDescriptions.get(three)); choice2.addActionListener(actions.get(three));
			}
			else choice2.setText("--");
			if(four >=0 && four <= actions.size()-1) {
				choice3.setText(actionDescriptions.get(four)); choice3.addActionListener(actions.get(four));
			}
			else choice3.setText("--");
		}
	}
	
	public void createInventory(int page) {
		Inventory inventory = player.getInventory();
		List<Item> items = inventory.getInventory();
		int one = 0+(4*page), two = 1+(4*page), three = 2+(4*page), four = 3+(4*page);
		
		removeChoiceActionListeners();
		menuState = "inventory";
		if(inventory != null) {
			if(one >=0 && one <= items.size()-1) {
				choice0.setText(items.get(one).getName()); choice0.setActionCommand(Integer.toString(one)); choice0.addActionListener(handler.itemHandler);
			}
			else choice0.setText("--");
			if(two >=0 && two <= items.size()-1) {
				choice1.setText(items.get(two).getName()); choice1.setActionCommand(Integer.toString(two)); choice1.addActionListener(handler.itemHandler);
			}
			else choice1.setText("--");
			if(three >=0 && three <= items.size()-1) {
				choice2.setText(items.get(three).getName()); choice2.setActionCommand(Integer.toString(three)); choice2.addActionListener(handler.itemHandler);
			}
			else choice2.setText("--");
			if(four >=0 && four <= items.size()-1) {
				choice3.setText(items.get(four).getName()); choice3.setActionCommand(Integer.toString(four)); choice3.addActionListener(handler.itemHandler);
			}
			else choice3.setText("--");
		}
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
			choice0.setText("--"); choice0.removeActionListener(l); choice0.setActionCommand(null);
		}
		for(ActionListener l : choice1.getActionListeners()) {
			choice1.setText("--"); choice1.removeActionListener(l); choice1.setActionCommand(null);
		}
		for(ActionListener l : choice2.getActionListeners()) {
			choice2.setText("--"); choice2.removeActionListener(l); choice2.setActionCommand(null);
		}
		for(ActionListener l : choice3.getActionListeners()) {
			choice3.setText("--"); choice3.removeActionListener(l); choice3.setActionCommand(null);
		}
	}
	
	public void removeSubChoiceActionListeners() {
		for(ActionListener l : subChoice0.getActionListeners()) {
			subChoice0.setText("--"); subChoice0.removeActionListener(l); subChoice0.setActionCommand(null);
		}
		for(ActionListener l : subChoice1.getActionListeners()) {
			subChoice1.setText("--"); subChoice1.removeActionListener(l); subChoice1.setActionCommand(null);
		}
		for(ActionListener l : subChoice2.getActionListeners()) {
			subChoice2.setText("--"); subChoice2.removeActionListener(l); subChoice2.setActionCommand(null);
		}
		for(ActionListener l : subChoice3.getActionListeners()) {
			subChoice3.setText("--"); subChoice3.removeActionListener(l); subChoice3.setActionCommand(null);
		}
	}
	
	public void updateHealth(int healthUpdate) {
		int updatedHealth = player.getHealth() + healthUpdate;
		if(updatedHealth <= 0) {
			player.setHealth(0);
			playerDead();
		}
		else if(updatedHealth >= player.getTotalHealth()) {
			player.setHealth(player.getTotalHealth());
		}
		else {
			player.setHealth(updatedHealth);
		}
		hpBar.setString(player.getHealth() + "/" + player.getTotalHealth());
		hpBar.setValue(updatedHealth);
		hpLabelNumber.setText(Integer.toString(player.getHealth()));
	}
	
	public void updateLocation(String direction) {
		List<Exit> exits = player.getLocation().getExits();
		for(int i = 0; i < exits.size(); i++) {
			if(exits.get(i).getDirectionName().equals(direction)) {
				player.setLocation(player.getLocation().getExits().get(i).getLeadsTo());
				locationLabelName.setText(player.getLocationName());
				mainTextArea.setText(player.getLocation().getDescription());
				createInitialChoices();
			}
		}
	}
	
	public void attackEnemy(NPC npc) {
		int playerDamage;
		if(player.getEquipment().getRightHand() == null) {
			playerDamage = new Random().nextInt(5);
		}
		else {
			playerDamage = new Random().nextInt(player.getEquipment().rightHand.getDamage());
		}
		if(npc.health <= playerDamage) {
			kill(npc);
		}
		else {
			npc.health -= playerDamage;
			mainTextArea.setText(npc.name + ": " + npc.health + "/" + npc.totalHealth + "\n");
			mainTextArea.setText(mainTextArea.getText() + "You hit the " + npc.name + " for " + playerDamage 
					+ " damage\n");
			int randomDamage = new Random().nextInt(npc.damage);
			mainTextArea.setText(mainTextArea.getText() + "The " + npc.name + " hits you for " + randomDamage 
					+ " damage\n");
			updateHealth(-randomDamage);
		}
	}
	
	public void kill(NPC npc) {
		String message = "";
		for(Item i : npc.inventory.getInventory()) {
			message += i.name + "\n";
		}
		mainTextArea.setText("You killed the " + npc.name + "! It dropped: \n" + message);
		player.getLocation().addItems(npc.inventory.getInventory());
		player.getLocation().removeNPC(npc);
		createInitialChoices();
	}
	
	public void playerDead() {
		removeSubChoiceActionListeners();
		removeChoiceActionListeners();
		choice0.setText("RESET GAME"); choice0.addActionListener(handler.resetHandler);
		mainTextArea.setText("YOU DIED");
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
	
	public JProgressBar createProgressBar(boolean text, Color background, Color foreground) {
		JProgressBar bar = new JProgressBar(0, player.getTotalHealth());
		bar.setPreferredSize(new Dimension(50, 25));
		bar.setBackground(background);
		bar.setForeground(foreground);
		bar.setFont(smallFont);
		bar.setString(player.getHealth() + "/" + player.getTotalHealth());
		bar.setStringPainted(text);
		bar.setValue(player.getHealth());
		return bar;
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
		textArea.setEditable(false);
		return textArea;
	}
}
