package locations;

import adventure.Game;
import components.Location;

public class North_Field extends Location {

	private Game game;
	
	public North_Field(Game game, String name, String description) {
		super(name, description);
		this.game = game;
	}
	
}
