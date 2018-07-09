package locations;

import components.Location;
import items.Potion;

public class Awakening extends Location {
		
	public Awakening(String name, String description) {
		super(name, description);
		items.add(new Potion("health potion", "health", 15));
		items.add(new Potion("max health potion", "health", 50));
		for(int i = 0; i < items.size(); i++) {
			this.actionDescriptions.add("Pickup " + items.get(i).name);
			this.actions.add(new PickupHandler(items.get(i)));
		}
	}

}
