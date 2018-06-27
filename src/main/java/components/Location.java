package components;

import java.util.List;

public class Location {
	private String name;
	private String description;
	private List<String> actions;
	private int x;
	private int y;
	
	public Location(String name, String description, List<String> actions, int x, int y) {
		this.name = name; this.description = description; this.x = x; this.y = y;
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

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return "Location [name=" + name + ", description=" + description + ", actions=" + actions + ", x=" + x + ", y="
				+ y + "]";
	};
	
	
}
