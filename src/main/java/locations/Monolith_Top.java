package locations;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import adventure.Game;
import components.Location;

public class Monolith_Top extends Location {
	
	public Monolith_Top(Game game, String name, String description) {
		super(game, name, description);
	}
	
	public class Action0 implements ActionListener {
		public void actionPerformed(ActionEvent action) {
			game.player.setHealth(0);
		}
	}

}
