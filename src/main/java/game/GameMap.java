package game;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import components.Exit;
import items.Potion;
import locations.BasicLocation;
import npc.*;
import util.MapFileReader;

public class GameMap {
	
	public List<BasicLocation> locations;
	
	public GameMap() {
		createMap();
	}
	
	public void createMap() {
		String fileContents = null;
		ArrayList<String> locationFiles = MapFileReader.getLocationsList("locations-list.txt");
		ArrayList<String> locationData = new ArrayList<String>();
		for (String file : locationFiles) {
			fileContents = MapFileReader.readLocationFile(file);
			locationData.add(fileContents);
		}
		
		locations = createLocations(locationData);
		connectLocations(locationData);
	}

	private void connectLocations(ArrayList<String> locationData) {
		for(String location : locationData) {
			BasicLocation bl = null;
			Scanner scanner = new Scanner(location);
			if(scanner.nextLine().equals("Name")) {
				String name = scanner.nextLine();
				bl = (BasicLocation) locations.stream().filter(item -> item.name.equals(name)).findFirst().get();
			}
			while(scanner.hasNext()) {
				if (scanner.nextLine().equals("Exits")) {
					int exitCount = Integer.parseInt(scanner.nextLine());
					for(int i = 0; i < exitCount; i++) {
						int exitNum = Integer.parseInt(scanner.nextLine());
						String exitName = scanner.nextLine();
						BasicLocation exitLocation = (BasicLocation) locations.stream().filter(item -> item.name.equals(exitName)).findFirst().get();
						if(exitNum == Exit.OUT) {
							bl.setParent(exitName);
						}
						bl.getExits().add(new Exit(exitNum, exitLocation));
					}
				}	
			}
			scanner.close();
		}
	}

	private ArrayList<BasicLocation> createLocations(ArrayList<String> locationData) {
		ArrayList<BasicLocation> locations = new ArrayList<BasicLocation>();
		for(String location : locationData) {
			BasicLocation newLocation = new BasicLocation();
			Scanner scanner = new Scanner(location);
			if(scanner.nextLine().equals("Name")) {
				newLocation.setName(scanner.nextLine());
			}
			if(scanner.nextLine().equals("Description")) {
				newLocation.setDescription(scanner.nextLine());
			}
			if(scanner.nextLine().equals("NPC")) {
				int npcCount = Integer.parseInt(scanner.nextLine());
				for(int i = 0; i < npcCount; i++) {
					String[] npcData = scanner.nextLine().split(",");
					newLocation.addNPC(new Enemy(npcData[0],
						Integer.parseInt(npcData[1]),
						Integer.parseInt(npcData[2]),
						Integer.parseInt(npcData[3]))
					);
					if(scanner.next().equals("Inventory")) {
						scanner.nextLine();
						int inventoryCount = Integer.parseInt(scanner.nextLine());
						for(int j = 0; j < inventoryCount; j++) {
							String[] inventoryData = scanner.nextLine().split(",");
							switch(inventoryData[0]) {
								case "Potion": 
									newLocation.getNPC(0).getInventory().addItem(
										new Potion(inventoryData[1],
											inventoryData[2],
											Integer.parseInt(inventoryData[3]))
									);
									break;
							}
						}
					}
				}
			}
			scanner.close();
			locations.add(newLocation);
		}
		return locations;
	}
}
