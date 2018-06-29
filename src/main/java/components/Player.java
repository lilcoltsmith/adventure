package components;

import java.util.ArrayList;

import items.*;

public class Player {
	private String name;
	private int totalHealth;
	private int health;
	private Inventory inventory;
	private Location location;
	
	public Player(String name) {
		this.name = name;
		this.totalHealth = 50;
		this.health = 50;
		this.inventory = new Inventory();
		this.inventory.addItem(new Sword("rusty sword", 5));
		this.location = new Location("Awakening", "Before you is a monolithic shrine to Zork...", new ArrayList<String>());
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

	public Location getLocation() {
		return location;
	}
	
	public String getLocationName() {
		return location.getName();
	}

	@Override
	public String toString() {
		return "Player [name=" + name + ", totalHealth=" + totalHealth + ", health=" + health + ",\n inventory="
				+ inventory + ",\n location=" + location + "]";
	}
	
}
