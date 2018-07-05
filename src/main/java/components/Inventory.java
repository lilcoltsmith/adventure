package components;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
	private List<Item> inventory;
	
	public Inventory() {
		this.inventory = new ArrayList<Item>();
	}
	
	public void addItem(Item item) {
		this.inventory.add(item);
	}
	
	public void removeItem(Item item) {
		this.inventory.remove(item);
	}

	public List<Item> getInventory() {
		return inventory;
	}

	public void setInventory(List<Item> inventory) {
		this.inventory = inventory;
	}

	@Override
	public String toString() {
		return "[" + inventory + "]";
	};
	
}
