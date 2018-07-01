package locations;

import adventure.Game;
import components.Location;

public class West_Forest extends Location {
	
	private Game game;
	
	public West_Forest(Game game, String name, String description) {
		super(name, description);
		this.game = game;
	}

}
