package components;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import adventure.Game;

public abstract class Location {
	public Game game;
	public String name;
	public String description;
	public List<String> actionDescriptions;
	public List<ActionListener> actions;
	public NPC npc;
	public List<Exit> exits;
	public List<Item> items;
	
	public Location(Game game, String name) {
		this.game = game;
		this.name = name;
		this.description = new String();
		this.items = new ArrayList<Item>();
		this.actionDescriptions = new ArrayList<String>();
		this.actions = new ArrayList<ActionListener>();
		this.exits = new ArrayList<Exit>();
	}
	
	public Location(Game game, String name, String description) {
		this.game = game;
		this.name = name;
		this.description = description;
		this.items = new ArrayList<Item>();
		this.actionDescriptions = new ArrayList<String>();
		this.actions = new ArrayList<ActionListener>();
		this.exits = new ArrayList<Exit>();
	}
	
	public Location(Game game, String name, String description, List<String> actionDescriptions, List<ActionListener> actions) {
		this.game = game;
		this.name = name;
		this.description = description;
		this.actionDescriptions = actionDescriptions;
		this.actions = actions;
		this.items = new ArrayList<Item>();
		this.exits = new ArrayList<Exit>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public List<String> getActionDescriptions() {
		return actionDescriptions;
	}

	public void setActionDescriptions(List<String> actionDescriptions) {
		this.actionDescriptions = actionDescriptions;
	}
	
	public void removeActionDescription(int index) {
		this.actionDescriptions.remove(index);
	}

	public List<ActionListener> getActions() {
		return actions;
	}

	public void setActions(List<ActionListener> actions) {
		this.actions = actions;
	}
	
	public void removeAction(int index) {
		this.actions.remove(index);
	}
	
	public NPC getNPC() {
		return npc;
	}
	
	public void setNPC(NPC npc) {
		this.npc = npc;
	}
	
	public void removeNPC(NPC npc) {
		this.npc = null;
	}

	public List<Exit> getExits() {
		return exits;
	}

	public void setExits(List<Exit> exits) {
		this.exits = exits;
	}
	
	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}
	
	public void addItem(Item item) {
		this.items.add(item);
	}
	
	public void addItems(List<Item> items) {
		for(Item i : items) {
			this.items.add(i);
			this.actionDescriptions.add("Pickup " + i.name);
			this.actions.add(new PickupHandler(i));
		}
	}
	
	public void removeItem(int index) {
		this.items.remove(index);
	}

	@Override
	public String toString() {
		return "Location [name=" + name + ", description=" + description + ", actionDescriptions=" + actionDescriptions
				+ ", actions=" + actions + ", exits=" + exits + "]";
	}
	
	public class PickupHandler implements ActionListener {
		
		Item item;
		
		public PickupHandler(Item item) {
			this.item = item;
		}
		
		public void actionPerformed(ActionEvent action) {
			List<Item> items = game.player.getLocation().getItems();
			int itemIndex = items.indexOf(item);
			
			game.player.getInventory().addItem(item);
			game.player.getLocation().removeItem(itemIndex);
			game.player.getLocation().removeActionDescription(itemIndex);
			game.player.getLocation().removeAction(itemIndex);
			game.createInitialChoices();
		}
	}

}
