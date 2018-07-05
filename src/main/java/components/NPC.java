package components;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public abstract class NPC {
	public String name;
	public int damage;
	public Inventory inventory;
	public List<String> actionDescriptions;
	public List<ActionListener> actions;
	
	public NPC(String name) {
		this.name = name; this.damage = 5; this.inventory = new Inventory();
		this.actionDescriptions = new ArrayList<String>();
		this.actions = new ArrayList<ActionListener>();
	}
	
	public NPC(String name, int damage) {
		this.name = name; this.damage = damage; this.inventory = new Inventory();
		this.actionDescriptions = new ArrayList<String>();
		this.actions = new ArrayList<ActionListener>();
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
