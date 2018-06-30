package adventure;

import components.Exit;
import locations.*;

public class Map {

	public Awakening awakening;
	public North_Field northField;
	public West_Forest westForest;
	public South_Forest southForest;
	public East_Field eastField;
	
	public Map() {
		// initial location
		awakening = new Awakening("Awakening", "Before you is a monolithic shrine to Zork...");
		
		// north field
		northField = new North_Field("North Field", "You are north of the monolith.");
		awakening.exits.add(new Exit(1, northField));
		northField.exits.add(new Exit(2, awakening));
		// south forest
		southForest = new South_Forest("SouthForest", "You are south of the monolith");
		awakening.exits.add(new Exit(2, southForest));
		southForest.exits.add(new Exit(1, awakening));
		// east forest
		eastField = new East_Field("East Field", "You are east of the monolith");
		awakening.exits.add(new Exit(3, eastField));
		eastField.exits.add(new Exit(4, awakening));
		// west forest
		westForest = new West_Forest("West Forest", "You are west of the monolith");
		awakening.exits.add(new Exit(4, westForest));
		westForest.exits.add(new Exit(3, awakening));
		
	}
}
