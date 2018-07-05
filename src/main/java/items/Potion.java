package items;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import adventure.Game;
import components.Item;

public class Potion extends Item {
	public Game game;
	public String type;
	public int restore;
	
	public Potion(Game game, String type, int restore) {
		this.game = game; this.type = type; this.restore = restore;
		this.actionDescriptions = new ArrayList<String>(); this.actions = new ArrayList<ActionListener>();
		this.actionDescriptions.add(type + ": " + Integer.toString(restore));
		this.actions.add(new RestoreHandler(this));
	}
	
	public Potion(Game game, String name, String type, int restore) {
		this.game = game; this.name = name; this.type = type; this.restore = restore;
		this.actionDescriptions = new ArrayList<String>(); this.actions = new ArrayList<ActionListener>();
		this.actionDescriptions.add(type + ": +" + Integer.toString(restore));
		this.actions.add(new RestoreHandler(this));
	}
	
	public class RestoreHandler implements ActionListener {
		Item item;
		
		public RestoreHandler(Item item) {
			this.item = item;
		}
		
		public void actionPerformed(ActionEvent action) {
			game.updateHealth(restore); game.createInitialChoices(); game.player.getInventory().removeItem(item);
		}
	}
}
