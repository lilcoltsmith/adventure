package adventure;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
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
	public static boolean fullscreen = false;
	// TITLE SCREEN
	public static int TITLE_X;
	public static int TITLE_Y = 100;
	public static int TITLE_WIDTH = 600;
	public static int TITLE_HEIGHT = 150;
	public static int START_BUTTON_X;
	public static int START_BUTTON_Y;
	public static int START_BUTTON_WIDTH = 200;
	public static int START_BUTTON_HEIGHT = 100;
	// HUD
	public static int HUD_X;
	public static int HUD_Y = 15;
	public static int HUD_WIDTH = 600;
	public static int HUD_HEIGHT = 50;
	public static FlowLayout HUD_LAYOUT = new FlowLayout(FlowLayout.CENTER, 10, 5);
	// HEALTH BAR
	public static Color HEALTH_COLOR = new Color(60, 0, 0);
	public static Dimension HEALTH_SIZE = new Dimension(200, 25);
	// MAIN TEXT AREA
	public static int MAIN_TEXT_X;
	public static int MAIN_TEXT_Y = 100;
	public static int MAIN_TEXT_WIDTH;
	public static int MAIN_TEXT_HEIGHT = 250;
	public static Dimension MAIN_TEXT_SCROLL_SIZE;
	// CHOICE PANEL
	public static int CHOICE_X;
	public static int CHOICE_Y;
	public static int CHOICE_WIDTH;
	public static int CHOICE_HEIGHT = 150;
	public static int SUB_CHOICE_Y;
	public static int SUB_CHOICE_HEIGHT = 40;
	public static GridLayout CHOICE_PANEL_LAYOUT = new GridLayout(4, 1);
	
	// player/map
	public static Player player;
	public static Map map;
	public static GameHandler handler;
	// menu state
	public static String menuState;
	// pages
	public static int navPage = 0;
	public static int actionPage = 0;
	public static int inventoryPage = 0;
	public static int npcPage = 0;
	// window elements
	public static JFrame window;
	public static Container container;
	public static JPanel titleNamePanel, startButtonPanel, mainTextPanel, choicePanel, hudPanel, subChoicePanel;
	public static JLabel titleNameLabel, hpLabel, hpLabelNumber, locationLabel, locationLabelName;
	public static JProgressBar hpBar;
	public static JButton startButton, playerIconButton, equipmentIconButton, choice0, choice1, choice2, choice3, subChoice0, subChoice1, subChoice2, subChoice3;
	public static JTextArea mainTextArea; //Contains 7 lines of text
	public static JScrollPane scroll;
	// fonts
	public static Font titleFont = new Font("Times New Roman", Font.PLAIN, 90);
	public static Font normalFont = new Font("Times New Roman", Font.PLAIN, 30);
	public static Font smallFont = new Font("Times New Roman", Font.PLAIN, 20);
	// icons
	public static BufferedImage playerIconImage;
	public static ImageIcon playerIcon;
	public static BufferedImage equipmentIconImage;
	public static ImageIcon equipmentIcon;
		
	public Game() {
		try {
		    UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName() );
		 } catch (Exception e) {
		            e.printStackTrace();
		 }
				
		// SETTINGS
		width = window.getSize().width; height = window.getSize().height;
		TITLE_X = (width/2) - TITLE_WIDTH/2;
		START_BUTTON_X = (width/2)-START_BUTTON_WIDTH/2; START_BUTTON_Y = (height - 200);
		HUD_X = (width/2)-HUD_WIDTH/2;
		MAIN_TEXT_X = (width/2)-((width-200)/2); MAIN_TEXT_WIDTH = (width-200);
		MAIN_TEXT_SCROLL_SIZE = new Dimension((width-200), 245);
		CHOICE_X = (width/2)-((width-200)/2); CHOICE_Y = height - 250; CHOICE_WIDTH = (width-200);
		SUB_CHOICE_Y = height - 100;
		
		// LOAD IMAGES
		loadImages();
		
		Game.handler = new GameHandler();
		Game.map = new Map();
		Game.player = new Player();
		titleScreen();
	}
	
	public static void resetGame() {
		container.removeAll();
		if(Game.fullscreen) {
			Game.window = Game.createWindow();
		}
		else {
			Game.window = Game.createWindow(Game.width, Game.height);
		}
		Game.map = new Map();
		Game.player = new Player();
		titleScreen();
	}
	
	public static void titleScreen() {
		
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
	}
	
	public static void createGameScreen() {
		player.setLocation(map.awakening);
		titleNamePanel.setVisible(false);
		startButtonPanel.setVisible(false);
		createHud();
		createMainText();
		createChoices();
		createSubChoices();
	}
	
	public static void createHud() {
		hudPanel = createPanel(HUD_X, HUD_Y, HUD_WIDTH, HUD_HEIGHT, Color.black);
		hudPanel.setLayout(HUD_LAYOUT);
		playerIconButton = createIconButton(playerIcon, handler.inventoryHandler);
		equipmentIconButton = createIconButton(equipmentIcon, handler.eiHandler);
		hpLabel = createLabel("HP:", Color.white, smallFont);
		hpBar = createProgressBar(true, Color.black, HEALTH_COLOR);
		hpBar.setPreferredSize(HEALTH_SIZE);
		hpLabelNumber = createLabel(Integer.toString(player.getHealth()), Color.white, smallFont);
		locationLabel = createLabel("Location:", Color.white, smallFont);
		locationLabelName = createLabel(player.getLocationName(), Color.white, smallFont);
		hudPanel.add(playerIconButton);
		hudPanel.add(hpLabel);
		hudPanel.add(hpBar);
		hudPanel.add(locationLabel);
		hudPanel.add(locationLabelName);
		hudPanel.add(equipmentIconButton);
		container.add(hudPanel);
	}
	
	public static void createMainText() {
		mainTextPanel = createPanel(MAIN_TEXT_X, MAIN_TEXT_Y, MAIN_TEXT_WIDTH, MAIN_TEXT_HEIGHT, Color.black);
		mainTextArea = createTextArea(MAIN_TEXT_X, MAIN_TEXT_Y, MAIN_TEXT_WIDTH, MAIN_TEXT_HEIGHT, 
				player.getLocation().getDescription(), Color.black, Color.white, normalFont);
		scroll = new JScrollPane(mainTextArea);
		scroll.setPreferredSize(MAIN_TEXT_SCROLL_SIZE);
		scroll.setBorder(BorderFactory.createEmptyBorder());
		scroll.setBackground(Color.black);
		scroll.setForeground(Color.white);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		mainTextPanel.add(scroll);
		container.add(mainTextPanel);
	}
	
	public static void createChoices() {
		choicePanel = createPanel(CHOICE_X, CHOICE_Y, CHOICE_WIDTH, CHOICE_HEIGHT, Color.black);
		choicePanel.setLayout(CHOICE_PANEL_LAYOUT);
		
		choice0 = createButton("--", null);
		choice1 = createButton("--", null);
		choice2 = createButton("--", null);
		choice3 = createButton("--", null);
		
		createInitialChoices();
		addChoices();
		
		container.add(choicePanel);
	}
	
	public static void createSubChoices() {
		subChoicePanel = createPanel(CHOICE_X, SUB_CHOICE_Y, CHOICE_WIDTH, SUB_CHOICE_HEIGHT, Color.black);
		subChoicePanel.setLayout(new GridLayout(1,4));
		
		subChoice0 = createButton("Back", handler.backHandler);
		subChoice1 = createButton("<<", handler.prevHandler);
		subChoice2 = createButton(">>", handler.nextHandler);
		subChoice3 = createButton("Map", handler.mapHandler);
		
		addSubChoices();
		
		container.add(subChoicePanel);
	}
	
	public static void createInitialChoices() {
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
	
	public static void createNavigation(int page) {	
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
	
	public static JButton addChoiceAction(JButton choice) {
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
	
	public static void createActions(int page, String type, int itemIndex) {
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
	
	public static void createInventory(int page) {
		Inventory inventory = player.getInventory();
		List<Item> items = inventory.getInventory();
		int one = 0+(4*page), two = 1+(4*page), three = 2+(4*page), four = 3+(4*page);
		
		removeChoiceActionListeners();
		menuState = "inventory";
		if(inventory != null) {
			if(one >=0 && one <= items.size()-1) {
				choice0.setText(items.get(one).getName()); choice0.setActionCommand(Integer.toString(one));
				choice0.addActionListener(handler.itemHandler);
			}
			else choice0.setText("--");
			if(two >=0 && two <= items.size()-1) {
				choice1.setText(items.get(two).getName()); choice1.setActionCommand(Integer.toString(two));
				choice1.addActionListener(handler.itemHandler);
			}
			else choice1.setText("--");
			if(three >=0 && three <= items.size()-1) {
				choice2.setText(items.get(three).getName()); choice2.setActionCommand(Integer.toString(three));
				choice2.addActionListener(handler.itemHandler);
			}
			else choice2.setText("--");
			if(four >=0 && four <= items.size()-1) {
				choice3.setText(items.get(four).getName()); choice3.setActionCommand(Integer.toString(four));
				choice3.addActionListener(handler.itemHandler);
			}
			else choice3.setText("--");
		}
	}
	
	public static void addChoices() {
		choicePanel.add(choice0);
		choicePanel.add(choice1);
		choicePanel.add(choice2);
		choicePanel.add(choice3);
	}
	
	public static void addSubChoices() {
		subChoicePanel.add(subChoice0);
		subChoicePanel.add(subChoice1);
		subChoicePanel.add(subChoice2);
		subChoicePanel.add(subChoice3);
	}
	
	public static void removeChoiceActionListeners() {
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
	
	public static void removeSubChoiceActionListeners() {
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
	
	public static void updateHealth(int healthUpdate) {
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
	
	public static void updateLocation(String direction) {
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
	
	public static void attackEnemy(NPC npc) {
		int playerDamage = new Random().nextInt(player.getDamage());;
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
	
	public static void kill(NPC npc) {
		String message = "";
		for(Item i : npc.inventory.getInventory()) {
			message += i.name + "\n";
		}
		mainTextArea.setText("You killed the " + npc.name + "! It dropped: \n" + message);
		player.getLocation().addItems(npc.inventory.getInventory());
		player.getLocation().removeNPC(npc);
		createInitialChoices();
	}
	
	public static void playerDead() {
		removeSubChoiceActionListeners();
		removeChoiceActionListeners();
		choice0.setText("RESET GAME"); choice0.addActionListener(handler.resetHandler);
		mainTextArea.setText("YOU DIED");
	}
	
	public static JFrame createWindow() {
		JFrame window = new JFrame("ADVENTURE");
	    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.black);
		window.setLayout(null);
		window.setResizable(false);
		window.setExtendedState(JFrame.MAXIMIZED_BOTH);
		window.setUndecorated(true);
        window.setVisible(true);
		return window;
	}
	
	public static JFrame createWindow(int width, int height) {
		JFrame window = new JFrame("ADVENTURE");
	    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.black);
		window.setLayout(null);
		window.setResizable(false);
		window.setSize(width, height);
        window.setVisible(true);
		return window;
	}
	
	public static JPanel createPanel(int x, int y, int width, int height, Color color) {
		JPanel panel = new JPanel();
		panel.setBounds(x, y, width, height);
		panel.setBackground(color);
		return panel;
	}
	
	public static JLabel createLabel(String text, Color foreground, Font font) {
		JLabel label = new JLabel(text);
		label.setForeground(foreground);
		label.setFont(font);
		return label;
	}
	
	public static JProgressBar createProgressBar(boolean text, Color background, Color foreground) {
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
	
	public static JButton createButton(String text, ActionListener action) {
		JButton button = new JButton(text);
		button.setActionCommand(text);
		button.setBackground(Color.black);
		button.setForeground(Color.white);
		button.setFont(normalFont);
		button.setFocusPainted(false);
		button.addActionListener(action);
		return button;
	}
	
	public static JButton createIconButton(ImageIcon icon, ActionListener action) {
		JButton button = new JButton(icon);
		button.setBackground(Color.black);
		button.setForeground(Color.white);
		button.setFont(normalFont);
		button.setFocusPainted(false);
		button.setBorderPainted(false);
		button.addActionListener(action);
		return button;
	}
	
	public static JTextArea createTextArea(int x, int y, int width, int height, String text, Color background, Color foreground, Font font) {
		JTextArea textArea = new JTextArea(text);
		textArea.setBounds(x, y, width, height);
		textArea.setBackground(background);
		textArea.setForeground(foreground);
		textArea.setFont(font);
		textArea.setLineWrap(true);
		textArea.setEditable(false);
		return textArea;
	}
	
	public static void loadImages() {
		try {
			playerIconImage = ImageIO.read(Game.class.getClassLoader().getResourceAsStream("player-50-white.png"));
			playerIconImage = resize(playerIconImage, 25, 25);
			equipmentIconImage = ImageIO.read(Game.class.getClassLoader().getResourceAsStream("body-armor-24-white.png"));
			equipmentIconImage = resize(equipmentIconImage, 25, 25);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		playerIcon = new ImageIcon(playerIconImage);
		equipmentIcon = new ImageIcon(equipmentIconImage);
	}
	
	public static BufferedImage resize(BufferedImage img, int height, int width) {
        Image tmp = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        BufferedImage resized = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = resized.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();
        return resized;
    }
}
