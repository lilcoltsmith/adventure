package components;

import java.util.List;

public class Item {
	private String name;
	private List<String> actions;
	private String info;
	
	public Item() {}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	@Override
	public String toString() {
		return "Item [name=" + name + ", actions=" + actions + ", info=" + info + "]";
	}
	
}
