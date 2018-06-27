package items;

import java.util.List;

import components.Item;

public class Sword extends Item{
	private String name;
	private List<String> actions;
	private int damage;
	private String info;
	
	public Sword() {};
	
	public Sword(String name, int damage) {
		this.name = name; this.damage = damage;
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

	public List<String> getActions() {
		return actions;
	}

	public void setActions(List<String> actions) {
		this.actions = actions;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String toString() {
		return "\n\t[name=" + name + ", damage=" + damage + "]";
	};
}
