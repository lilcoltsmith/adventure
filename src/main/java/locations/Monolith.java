package locations;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import adventure.Game;
import components.Location;

public class Monolith extends Location{
	
	private Game game;
	
	public Monolith(Game game, String name, String description) {
		super(name, description);
		this.game = game;
	}
	
	public class Action0 implements ActionListener {
		public void actionPerformed(ActionEvent action) {
			game.player.setHealth(0);
		}
	}
	
}
