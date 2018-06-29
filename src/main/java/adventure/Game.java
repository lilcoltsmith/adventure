package adventure;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.UIManager;

import components.*;

public class Game {
	
	public Player player;
	
	public JFrame window;
	public Container container;
	public int windowX, windowY;
	public JPanel titleNamePanel, startButtonPanel, mainTextPanel, choicePanel, hudPanel;
	public JLabel titleNameLabel, hpLabel, hpLabelNumber, locationLabel, locationLabelName;
	public Font titleFont = new Font("Times New Roman", Font.PLAIN, 90);
	public Font normalFont = new Font("Times New Roman", Font.PLAIN, 30);
	public Font smallFont = new Font("Times New Roman", Font.PLAIN, 20);
	public JButton startButton, choice0, choice1, choice2, choice3;
	public JTextArea mainTextArea;
	
	public TitleScreenHandler tsHandler = new TitleScreenHandler();
	
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
		titleNamePanel.setVisible(false);
		startButtonPanel.setVisible(false);
		createHud();
		createMainText();
		createChoices();
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
		choice0 = createButton("choice0", null);
		choice1 = createButton("choice1", null);
		choice2 = createButton("choice2", null);
		choice3 = createButton("choice3", null);
		choicePanel.add(choice0);
		choicePanel.add(choice1);
		choicePanel.add(choice2);
		choicePanel.add(choice3);
		container.add(choicePanel);
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

}
