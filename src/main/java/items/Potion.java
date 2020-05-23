package items;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import components.Item;
import game.Game;

public class Potion extends Item {
	public int restore;
	
	public Potion(String name, String type, int restore) {
		super(name, type);
		this.restore = restore;
		this.actionDescriptions.add(type + ": +" + Integer.toString(restore)); this.actions.add(new RestoreHandler(this));
	}
	
	public class RestoreHandler implements ActionListener {
		Item item;
		
		public RestoreHandler(Item item) {
			this.item = item;
		}
		
		public void actionPerformed(ActionEvent action) {
			Game.updateHealth(restore); Game.player.getInventory().removeItem(item);
			if(Game.player.getHealth() > 0) {
				Game.createInitialChoices();
			}
		}
	}
}
