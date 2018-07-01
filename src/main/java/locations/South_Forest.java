package locations;

import adventure.Game;
import components.Location;

public class South_Forest extends Location {

	private Game game;
	
	public South_Forest(Game game, String name, String description) {
		super(name, description);
		this.game = game;
	}

}
