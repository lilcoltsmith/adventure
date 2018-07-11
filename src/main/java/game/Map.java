package game;

import components.Exit;
import locations.*;
import npc.*;

public class Map {
		
	public Awakening awakening;
	public North_Field northField;
	public West_Forest westForest;
	public South_Forest southForest;
	public East_Field eastField;
	public Monolith monolith;
	public Monolith_Top monolithTop;
	
	public Map() {
		createMap();
	}
	
	public void createMap() {
		// initial location
		awakening = new Awakening("Awakening", "Before you is a monolithic shrine to Zork...");
		
		//npc
		awakening.setNPC(new Goblin("goblin", 5, 50));
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
		// monolith
		monolith = new Monolith("Monolith", "It's very dark and spooky...");
		awakening.exits.add(new Exit(11, monolith));
		monolith.exits.add(new Exit(12, awakening));
		// monolith-top
		monolithTop = new Monolith_Top("Monolith-Top", "You can see for miles around you.\n"
				+ "There is a forest to the south and west.\nThere is a field north and east.");
		awakening.exits.add(new Exit(5, monolithTop));
		monolithTop.exits.add(new Exit(6, awakening));
	}
}
