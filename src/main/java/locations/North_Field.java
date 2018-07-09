package locations;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import adventure.Game;
import components.Location;

public class North_Field extends Location {
	
	public North_Field(String name, String description) {
		super(name, description);
	}
	
	public class Action0 implements ActionListener {
		public void actionPerformed(ActionEvent action) {
			Game.player.setHealth(0);
		}
	}
	
}
