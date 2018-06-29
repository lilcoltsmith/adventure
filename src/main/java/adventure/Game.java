package adventure;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Rectangle;
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
		
		titleNamePanel = new JPanel();
		titleNamePanel.setBounds(100, 100, 600, 150);
		titleNamePanel.setBackground(Color.black);
		titleNameLabel = new JLabel("ADVENTURE");
		titleNameLabel.setForeground(Color.white);
		titleNameLabel.setFont(titleFont);
		
		startButtonPanel = new JPanel();
		startButtonPanel.setBounds(300, 400, 200, 100);
		startButtonPanel.setBackground(Color.black);
		
		startButton = new JButton("START");
		startButton.setBackground(Color.black);
		startButton.setForeground(Color.white);
		startButton.setFont(normalFont);
		startButton.setFocusPainted(false);
		startButton.addActionListener(tsHandler);
		
		titleNamePanel.add(titleNameLabel);
		startButtonPanel.add(startButton);
		
		container.add(titleNamePanel);
		container.add(startButtonPanel);
		window.setVisible(true);
		//window.validate();
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
		
		hudPanel = new JPanel();
		hudPanel.setBounds(100, 15, 600, 50);
		hudPanel.setBackground(Color.black);
		hudPanel.setLayout(new GridLayout(1, 4));
		
		hpLabel = new JLabel("HP:");
		hpLabel.setFont(smallFont);
		hpLabel.setForeground(Color.white);
		
		hpLabelNumber = new JLabel(Integer.toString(player.getHealth()));
		hpLabelNumber.setFont(smallFont);
		hpLabelNumber.setForeground(Color.white);
		
		locationLabel = new JLabel("Location:");
		locationLabel.setFont(smallFont);
		locationLabel.setForeground(Color.white);
		
		locationLabelName = new JLabel(player.getLocationName());
		locationLabelName.setFont(smallFont);
		locationLabelName.setForeground(Color.white);
		
		hudPanel.add(hpLabel);
		hudPanel.add(hpLabelNumber);
		hudPanel.add(locationLabel);
		hudPanel.add(locationLabelName);
		
		container.add(hudPanel);
	}
	
	public void createMainText() {
		mainTextPanel = new JPanel();
		mainTextPanel.setBounds(100, 100, 600, 250);
		mainTextPanel.setBackground(Color.black);
		
		mainTextArea = new JTextArea(player.getLocation().getDescription());
		mainTextArea.setBounds(100, 100, 600, 250);
		mainTextArea.setBackground(Color.black);
		mainTextArea.setForeground(Color.white);
		mainTextArea.setFont(normalFont);
		mainTextArea.setLineWrap(true);
		mainTextPanel.add(mainTextArea);
		
		container.add(mainTextPanel);
	}
	
	public void createChoices() {
		choicePanel = new JPanel();
		choicePanel.setBounds(250, 350, 300, 150);
		choicePanel.setBackground(Color.black);
		choicePanel.setLayout(new GridLayout(4,1));
		
		choice0 = createChoice("choice0");
		choice1 = createChoice("choice1");
		choice2 = createChoice("choice2");
		choice3 = createChoice("choice3");

		choicePanel.add(choice0);
		choicePanel.add(choice1);
		choicePanel.add(choice2);
		choicePanel.add(choice3);
		
		container.add(choicePanel);
	}
	
	public JPanel createPanel(Rectangle bounds) {
		JPanel panel = new JPanel();
		return panel;
	}
	
	public JButton createChoice(String text) {
		JButton choice = new JButton(text);
		choice.setBackground(Color.black);
		choice.setForeground(Color.white);
		choice.setFont(normalFont);
		choice.setFocusPainted(false);
		return choice;
	}
	
	public class TitleScreenHandler implements ActionListener {
		public void actionPerformed(ActionEvent action) {
			createGameScreen();
		}
	}

}
