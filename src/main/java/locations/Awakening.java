package locations;

import adventure.Game;
import components.Location;
import items.Potion;

public class Awakening extends Location {
		
	public Awakening(Game game, String name, String description) {
		super(game, name, description);
		this.game = game;
		items.add(new Potion(game, "health potion", "health", 15));
		items.add(new Potion(game, "max health potion", "health", 50));
		for(int i = 0; i < items.size(); i++) {
			this.actionDescriptions.add("Pickup " + items.get(i).name);
			this.actions.add(new PickupHandler(items.get(i)));
		}
	}

}
