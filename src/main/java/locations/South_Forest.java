package locations;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import components.Location;
import game.Game;

public class South_Forest extends Location {
	
	public South_Forest(String name, String description) {
		super(name, description);
	}
	
	public class Action0 implements ActionListener {
		public void actionPerformed(ActionEvent action) {
			Game.player.setHealth(0);
		}
	}

}
