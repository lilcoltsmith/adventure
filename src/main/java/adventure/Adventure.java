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
	
	public static JButton createResolutionButton(JFrame frame, JFrame window, int width, int height) {
		JButton btn = new JButton("Windowed: " + width + "x" + height);
	    btn.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	frame.setVisible(false);
	            window.setSize(width, height);
	            window.setVisible(true);
	            game = new Game(window);
	        }
	    });
		return btn;
	}
	
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
	        	window.setExtendedState(JFrame.MAXIMIZED_BOTH);
	    		window.setUndecorated(true);
	            window.setVisible(true);
	            game = new Game(window);
	        }
	    });
	    
	    JButton btn2 = createResolutionButton(frame, window, 800, 600);
	    JButton btn3 = createResolutionButton(frame, window, 1280, 720);
	    JButton btn4 = createResolutionButton(frame, window, 1920, 1080);

	    JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
	    panel.add(btn1);
	    panel.add(btn2);
	    panel.add(btn3);
	    panel.add(btn4);
	    frame.add(panel);

	    frame.pack();
	    frame.setVisible(true);
	}
}
