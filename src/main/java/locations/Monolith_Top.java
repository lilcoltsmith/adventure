package locations;

import adventure.Game;
import components.Location;

public class Monolith_Top extends Location {

	private Game game;
	
	public Monolith_Top(Game game, String name, String description) {
		super(name, description);
		this.game = game;
	}

}
