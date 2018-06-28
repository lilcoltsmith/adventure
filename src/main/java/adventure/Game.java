package adventure;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

import components.*;

public class Game {
	
	public JFrame window;
	Container container;
	public int windowX, windowY;
	public JPanel titleNamePanel, startButtonPanel;
	public JLabel titleNameLabel, startButtonLabel;
	public Font titleFont = new Font("Times New Roman", Font.PLAIN, 90);
	public Font normalFont = new Font("Times New Roman", Font.PLAIN, 30);
	public JButton startButton;
	
	public Game() {
		
		try {
		    UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName() );
		 } catch (Exception e) {
		            e.printStackTrace();
		 }
		
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
		
		titleNamePanel.add(titleNameLabel);
		startButtonPanel.add(startButton);
		
		container.add(titleNamePanel);
		container.add(startButtonPanel);
		window.setVisible(true);
		window.validate();

	}

	public static void main(String[] args) {
		new Game();
		Scanner scanner = new Scanner(System.in);
		String input = null;
		System.out.println("New/Load ?");
		input = scanner.nextLine().toLowerCase();
		if(input.equalsIgnoreCase("load")) {
			
		}
		else if (input.equalsIgnoreCase("new")) {
			System.out.println("Enter player name: ");
			input = scanner.nextLine().toLowerCase();
			Player player = new Player(input);
			System.out.println(player.toString());
		}
		
		scanner.close();
	}

}
