package game;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import util.MapBuilder;

public class Adventure {
	
	public static GameMap map;
	
	public static JButton createResolutionButton(JFrame frame, int width, int height) {
		JButton btn = new JButton("Windowed: " + width + "x" + height);
	    btn.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	frame.setVisible(false);
	        	Game.window = Game.createWindow(width, height);
	            new Game();
	        }
	    });
		return btn;
	}

	public static JButton createMapBuilderBUtton(JFrame frame) {
		JButton btn = new JButton("Map Builder");
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				MapBuilder.window = Game.createWindow(800, 600);
				new MapBuilder();
			}
		});
		return btn;
	}
	
	public static void main(String[] args) {
		
		final JFrame frame = new JFrame("Display Mode");
	    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	    frame.setUndecorated(false);
	    
	    JButton btn1 = new JButton("Full-Screen");
	    btn1.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	frame.setVisible(false);
	        	Game.fullscreen = true;
	        	Game.window = Game.createWindow();
	            new Game();
	        }
	    });
	    
	    JButton btn2 = createResolutionButton(frame, 800, 600);
	    JButton btn3 = createResolutionButton(frame, 1280, 720);
		JButton btn4 = createResolutionButton(frame, 1920, 1080);
		JButton btn5 = createMapBuilderBUtton(frame);

		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

		JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		panel.add(new JLabel("Select window size for game:"));
		mainPanel.add(panel);

	    JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
	    panel2.add(btn1);
	    panel2.add(btn2);
	    panel2.add(btn3);
		panel2.add(btn4);
		mainPanel.add(panel2);
		
		JPanel panel3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		panel3.add(new JLabel("Utilities"));
		mainPanel.add(panel3);

		JPanel panel4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panel4.add(btn5);
		mainPanel.add(panel4);

		frame.add(mainPanel);
	    frame.pack();
	    frame.setVisible(true);
	}
}
