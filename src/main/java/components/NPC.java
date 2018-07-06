package components;

import java.awt.event.ActionListener;
import java.util.List;

import adventure.Game;

public abstract class NPC {
	public Game game;
	public String name;
	public int damage;
	public int health;
	public int totalHealth;
	public Inventory inventory;
	public List<String> actionDescriptions;
	public List<ActionListener> actions;
	
	public void kill() {
		String message = "";
		message += "You killed the goblin! It dropped: \n";
		List<Item> items = this.inventory.getInventory();
		for(Item item : items) {
			message += item.name + "\n";
		}
		game.mainTextArea.setText(message);
		game.player.getLocation().addItems(this.inventory.getInventory());
		game.player.getLocation().removeNPC(this);
		game.createInitialChoices();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	public List<String> getActionDescriptions() {
		return actionDescriptions;
	}

	public void setActionDescriptions(List<String> actionDescriptions) {
		this.actionDescriptions = actionDescriptions;
	}

	public List<ActionListener> getActions() {
		return actions;
	}

	public void setActions(List<ActionListener> actions) {
		this.actions = actions;
	}

	@Override
	public String toString() {
		return "NPC [name=" + name + ", damage=" + damage + ", inventory=" + inventory + ", actionDescriptions="
				+ actionDescriptions + ", actions=" + actions + "]";
	}
	
}
