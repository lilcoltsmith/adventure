package adventure;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class Adventure {
	
	public static Game game;
	public static Map map;
	public static JFrame window;
	
	public static void main(String[] args) {
		
		final JFrame frame = new JFrame("Display Mode");
	    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	    frame.setUndecorated(false);
	    
	    window = new JFrame("ADVENTURE");
	    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.black);
		window.setLayout(null);
		window.setResizable(false);
		window.setVisible(false);

	    JButton btn1 = new JButton("Full-Screen");
	    btn1.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	frame.setVisible(false);
//	            device.setFullScreenWindow(window);
	        	window.setExtendedState(JFrame.MAXIMIZED_BOTH);
	    		window.setUndecorated(true);
	            window.setVisible(true);
	            game = new Game(window);
	        }
	    });
	    JButton btn2 = new JButton("Windowed: 800x600");
	    btn2.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	frame.setVisible(false);
	            window.setSize(800, 600);
	            window.setVisible(true);
	            game = new Game(window);
	        }
	    });
	    
	    JButton btn3 = new JButton("Windowed: 1280x720");
	    btn3.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	frame.setVisible(false);
	            window.setSize(1280, 720);
	            window.setVisible(true);
	            game = new Game(window);
	        }
	    });
	    
	    JButton btn4 = new JButton("Windowed: 1920x1080");
	    btn4.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	frame.setVisible(false);
	            window.setSize(1920, 1080);
	            window.setVisible(true);
	            game = new Game(window);
	        }
	    });

	    JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
	    panel.add(btn1);
	    panel.add(btn2);
	    panel.add(btn3);
	    panel.add(btn4);
	    frame.add(panel);

	    frame.pack();
	    frame.setVisible(true);
		
		//game = new Game(window);
	}
}
