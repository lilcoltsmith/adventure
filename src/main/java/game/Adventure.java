package game;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class Adventure {
	
	public static Map map;
	
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
	
	public static void main(String[] args) {
		
		final JFrame frame = new JFrame("Display Mode");
	    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	    frame.setUndecorated(false);
	    
	    //window = Game.createWindow();

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
