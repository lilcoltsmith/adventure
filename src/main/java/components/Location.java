package components;

import java.util.ArrayList;
import java.util.List;

public class Location {
	private String name;
	private String description;
	private List<String> actions;
	private List<Exit> exits;
	
	public Location(String name) {
		this.name = name;
		this.description = new String();
		this.actions = new ArrayList<String>();
		this.exits = new ArrayList<Exit>();
	}
	
	public Location(String name, String description, List<String> actions) {
		this.name = name; this.description = description;
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

	public List<String> getActions() {
		return actions;
	}

	public void setActions(List<String> actions) {
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
