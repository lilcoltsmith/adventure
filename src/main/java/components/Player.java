package components;

import items.*;

public class Player {
	private String name;
	private int totalHealth;
	private int health;
	private Inventory inventory;
	private Equipment equipment;
	private Location location;
	
	public Player() {
		this.totalHealth = 50;
		this.health = 50;
		this.inventory = new Inventory();
		this.inventory.addItem(new Potion("death potion", "health", -50));
		this.inventory.addItem(new Weapon("straight sword", "rightHand", 15));
		this.inventory.addItem(new Armor("bronze helmet", "head", 15));
		this.inventory.addItem(new Armor("bronze chestplate", "chest", 15));
		this.inventory.addItem(new Armor("bronze platelegs", "legs", 15));
		this.inventory.addItem(new Potion("health potion", "health", 10));
		this.equipment = new Equipment(inventory);
		this.location = null;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTotalHealth() {
		return totalHealth;
	}

	public void setTotalHealth(int totalHealth) {
		this.totalHealth = totalHealth;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	public Equipment getEquipment() {
		return equipment;
	}

	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}

	public Location getLocation() {
		return location;
	}
	
	public String getLocationName() {
		return location.getName();
	}
	
	public void setLocation(Location location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Player [name=" + name + ", totalHealth=" + totalHealth + ", health=" + health + ",\n inventory="
				+ inventory + ",\n location=" + location + "]";
	}
	
}
