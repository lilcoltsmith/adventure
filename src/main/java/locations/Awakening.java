package locations;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import adventure.Game;
import components.Location;
import items.Potion;

public class Awakening extends Location {
	
	private Game game;
	private Potion healthPotion;
	
	public Awakening(Game game, String name, String description) {
		super(name, description);
		this.game = game;
		healthPotion = new Potion(game, "health potion", "health", 15);
		this.actionDescriptions.add("Pickup " + healthPotion.name);
		this.actions.add(new ItemHandler());
	}
	
	public class ItemHandler implements ActionListener {
		public void actionPerformed(ActionEvent action) {
			game.player.getInventory().addItem(healthPotion);
			game.createInitialChoices();
		}
	}

}
