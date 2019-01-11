package game;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystem;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.nio.file.WatchEvent.Kind;
import java.nio.file.WatchEvent.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import components.Exit;
import items.Potion;
import locations.BasicLocation;
import npc.*;

public class GameMap {
	
	public List<BasicLocation> locations;
	
	public GameMap() {
		createMap();
	}
	
	public void createMap() {
		//readLocationFile("awakening.loc");
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
		awakening.getNPC().getInventory().addItem(new Potion("goblin potion", "health", 5));
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
	
//	private BasicLocation readLocationFile(String filename) {
//		try {
//			InputStream is = GameMap.class.getResourceAsStream(filename);
//			InputStreamReader streamReader = new InputStreamReader(is, StandardCharsets.UTF_8);
//			BufferedReader reader = new BufferedReader(streamReader);
//			String line;
//			while((line = reader.readLine()) != null) {
//				System.out.println(line);
//			}
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		
//		BasicLocation location;
//		return null;
//	}
}
