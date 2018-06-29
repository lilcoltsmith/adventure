package components;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public abstract class Location {
	public String name;
	public String description;
	public List<ActionListener> actions;
	public List<Exit> exits;
	
	public Location(String name) {
		this.name = name;
		this.description = new String();
		this.actions = new ArrayList<ActionListener>();
		this.exits = new ArrayList<Exit>();
	}
	
	public Location(String name, String description) {
		this.name = name;
		this.description = description;
		this.actions = new ArrayList<ActionListener>();
		this.exits = new ArrayList<Exit>();
	}
	
	public Location(String name, String description, List<ActionListener> actions) {
		this.name = name;
		this.description = description;
		this.actions = actions;
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

	public List<ActionListener> getActions() {
		return actions;
	}

	public void setActions(List<ActionListener> actions) {
		this.actions = actions;
	}

	public List<Exit> getExits() {
		return exits;
	}

	public void setExits(List<Exit> exits) {
		this.exits = exits;
	}

	@Override
	public String toString() {
		return "Location [name=" + name + ", description=" + description + ", actions=" + actions + ", exits=" + exits
				+ "]";
	}
	
	
}
