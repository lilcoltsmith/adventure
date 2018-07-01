package locations;

import adventure.Game;
import components.Location;

public class East_Field extends Location {

	private Game game;
	
	public East_Field(Game game, String name, String description) {
		super(name, description);
		this.game = game;
	}

}
