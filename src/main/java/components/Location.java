package components;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import game.Game;

public abstract class Location {
	public String name;
	public String description;
	public String parent;
	public List<String> actionDescriptions;
	public List<ActionListener> actions;
	public List<NPC> npcs;
	public List<Exit> exits;
	public List<Item> items;

	public Location() {
		this.name = "???";
		this.description = new String();
		this.parent = new String("root");
		this.items = new ArrayList<Item>();
		this.actionDescriptions = new ArrayList<String>();
		this.actions = new ArrayList<ActionListener>();
		this.exits = new ArrayList<Exit>();
		this.npcs = new ArrayList<NPC>();
	}
	
	public Location(String name) {
		this.name = name;
		this.description = new String();
		this.parent = new String("root");
		this.items = new ArrayList<Item>();
		this.actionDescriptions = new ArrayList<String>();
		this.actions = new ArrayList<ActionListener>();
		this.exits = new ArrayList<Exit>();
		this.npcs = new ArrayList<NPC>();
	}
	
	public Location(String name, String description) {
		this.name = name;
		this.description = description;
		this.parent = new String("root");
		this.items = new ArrayList<Item>();
		this.actionDescriptions = new ArrayList<String>();
		this.actions = new ArrayList<ActionListener>();
		this.exits = new ArrayList<Exit>();
		this.npcs = new ArrayList<NPC>();
	}
	
	public Location(String name, String description, List<String> actionDescriptions, List<ActionListener> actions) {
		this.name = name;
		this.description = description;
		this.parent = new String("root");
		this.actionDescriptions = actionDescriptions;
		this.actions = actions;
		this.items = new ArrayList<Item>();
		this.exits = new ArrayList<Exit>();
		this.npcs = new ArrayList<NPC>();
	}

	public Location(String name, String description, String parent, List<String> actionDescriptions, List<ActionListener> actions) {
		this.name = name;
		this.description = description;
		this.parent = parent;
		this.actionDescriptions = actionDescriptions;
		this.actions = actions;
		this.items = new ArrayList<Item>();
		this.exits = new ArrayList<Exit>();
		this.npcs = new ArrayList<NPC>();
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

	public String getParent() {
		return parent;
	}

	public void setParent(String parent) {
		this.parent = parent;
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
	
	public NPC getNPC(int index) {
		return this.npcs.get(index);
	}
	
	public void setNPC(NPC npc, int index) {
		this.npcs.set(index, npc);
	}

	public void addNPC(NPC npc) {
		this.npcs.add(npc);
	}
	
	public void removeNPC(int index) {
		this.npcs.remove(index);
	}

	public List<NPC> getNPCs() {
		return this.npcs;
	}

	public void setNPCs(List<NPC> npcs) {
		this.npcs = npcs;
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
			List<Item> items = Game.player.getLocation().getItems();
			int itemIndex = items.indexOf(item);
			
			Game.player.getInventory().addItem(item);
			Game.player.getLocation().removeItem(itemIndex);
			Game.player.getLocation().removeActionDescription(itemIndex);
			Game.player.getLocation().removeAction(itemIndex);
			Game.createInitialChoices();
		}
	}

}
