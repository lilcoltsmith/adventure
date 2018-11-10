package game;

import java.util.ArrayList;
import java.util.List;

import components.Exit;
import locations.BasicLocation;
import npc.*;

public class Map {
	
	public List<BasicLocation> locations;
	
	public Map() {
		createMap();
	}
	
	public void createMap() {
		locations = new ArrayList<BasicLocation>();
		
		// Add New Locations
		locations.add(new BasicLocation("Awakening", "Before you is a monolithic shrine to Zork..."));
		locations.add(new BasicLocation("North Field", "You are north of the monolith."));
		locations.add(new BasicLocation("South Forest", "You are south of the monolith"));
		locations.add(new BasicLocation("East Field", "You are east of the monolith"));
		locations.add(new BasicLocation("West Forest", "You are west of the monolith"));
		locations.add(new BasicLocation("Monolith", "It's very dark and spooky..."));
		locations.add(new BasicLocation("Monolith - Top", "You can see for miles around you.\n"
				+ "There is a forest to the south and west.\nThere is a field north and east."));
		
		// Configure Locations
		
		// AWAKENING
		BasicLocation awakening = (BasicLocation) locations.stream()
				.filter(location -> location.name.equals("Awakening")).findFirst().get();
		awakening.setNPC(new Enemy("goblin", 5, 5, 50));
		awakening.exits.add(new Exit(1, (BasicLocation) locations
					.stream()
					.filter(location -> location.name.equals("North Field")).findFirst().get()));
		awakening.exits.add(new Exit(2, (BasicLocation) locations
				.stream()
				.filter(location -> location.name.equals("South Forest")).findFirst().get()));
		awakening.exits.add(new Exit(3, (BasicLocation) locations
				.stream()
				.filter(location -> location.name.equals("East Field")).findFirst().get()));
		awakening.exits.add(new Exit(4, (BasicLocation) locations
				.stream()
				.filter(location -> location.name.equals("West Forest")).findFirst().get()));
		awakening.exits.add(new Exit(5, (BasicLocation) locations
				.stream()
				.filter(location -> location.name.equals("Monolith - Top")).findFirst().get()));
		awakening.exits.add(new Exit(11, (BasicLocation) locations
				.stream()
				.filter(location -> location.name.equals("Monolith")).findFirst().get()));
		
		// NORTH FIELD
		BasicLocation northField = (BasicLocation) locations.stream()
				.filter(location -> location.name.equals("North Field")).findFirst().get();
		northField.exits.add(new Exit(2, (BasicLocation) locations
				.stream()
				.filter(location -> location.name.equals("Awakening")).findFirst().get()));
		
		// SOUTH FOREST
		BasicLocation southForest = (BasicLocation) locations.stream()
				.filter(location -> location.name.equals("South Forest")).findFirst().get();
		southForest.exits.add(new Exit(1, (BasicLocation) locations
				.stream()
				.filter(location -> location.name.equals("Awakening")).findFirst().get()));
		
		// EAST FIELD
		BasicLocation eastField = (BasicLocation) locations.stream()
				.filter(location -> location.name.equals("East Field")).findFirst().get();
		eastField.exits.add(new Exit(4, (BasicLocation) locations
				.stream()
				.filter(location -> location.name.equals("Awakening")).findFirst().get()));
		
		// WEST FOREST
		BasicLocation westForest = (BasicLocation) locations.stream()
				.filter(location -> location.name.equals("West Forest")).findFirst().get();
		westForest.exits.add(new Exit(3, (BasicLocation) locations
				.stream()
				.filter(location -> location.name.equals("Awakening")).findFirst().get()));
		
		// MONOLITH - TOP
		BasicLocation monolithTop = (BasicLocation) locations.stream()
				.filter(location -> location.name.equals("Monolith - Top")).findFirst().get();
		monolithTop.exits.add(new Exit(6, (BasicLocation) locations
				.stream()
				.filter(location -> location.name.equals("Awakening")).findFirst().get()));
		
		// MONOLITH
		BasicLocation monolith = (BasicLocation) locations.stream()
				.filter(location -> location.name.equals("Monolith")).findFirst().get();
		monolith.exits.add(new Exit(12, (BasicLocation) locations
				.stream()
				.filter(location -> location.name.equals("Awakening")).findFirst().get()));
	}
}
