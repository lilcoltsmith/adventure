package adventure;

import components.Exit;
import locations.*;

public class Map {
		
	public Awakening awakening;
	public North_Field northField;
	public West_Forest westForest;
	public South_Forest southForest;
	public East_Field eastField;
	public Monolith monolith;
	public Monolith_Top monolithTop;
	
	public Map(Game game) {
		createMap(game);
	}
	
	public void createMap(Game game) {
		// initial location
		awakening = new Awakening(game, "Awakening", "Before you is a monolithic shrine to Zork...");
		
		// north field
		northField = new North_Field(game, "North Field", "You are north of the monolith.");
		awakening.exits.add(new Exit(1, northField));
		northField.exits.add(new Exit(2, awakening));
		
		northField = new North_Field(game, "North Field", "You are north of the monolith.");
		awakening.exits.add(new Exit(1, northField));
		northField.exits.add(new Exit(2, awakening));
		northField = new North_Field(game, "North Field", "You are north of the monolith.");
		awakening.exits.add(new Exit(1, northField));
		northField.exits.add(new Exit(2, awakening));
		
		// south forest
		southForest = new South_Forest(game, "SouthForest", "You are south of the monolith");
		awakening.exits.add(new Exit(2, southForest));
		southForest.exits.add(new Exit(1, awakening));
		// east forest
		eastField = new East_Field(game, "East Field", "You are east of the monolith");
		awakening.exits.add(new Exit(3, eastField));
		eastField.exits.add(new Exit(4, awakening));
		// west forest
		westForest = new West_Forest(game, "West Forest", "You are west of the monolith");
		awakening.exits.add(new Exit(4, westForest));
		westForest.exits.add(new Exit(3, awakening));
		// monolith
		monolith = new Monolith(game, "Monolith", "It's very dark and spooky...");
		awakening.exits.add(new Exit(11, monolith));
		monolith.exits.add(new Exit(12, awakening));
		// monolith-top
		monolithTop = new Monolith_Top(game, "Monolith-Top", "You can see for miles around you.\n"
				+ "There is a forest to the south and west.\nThere is a field north and east.");
		awakening.exits.add(new Exit(5, monolithTop));
		monolithTop.exits.add(new Exit(6, awakening));
	}
}
