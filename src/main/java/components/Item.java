package components;

import java.awt.event.ActionListener;
import java.util.List;

public abstract class Item {
	public String name;
	public List<String> actionDescriptions;
	public List<ActionListener> actions;
	public String type;
	public String info;
	
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public List<String> getActionDescriptions(){
		return this.actionDescriptions;
	}

	public void setActionDescriptions(List<String> actionDescriptions) {
		this.actionDescriptions = actionDescriptions;
	}

	public List<ActionListener> getActions(){
		return this.actions;
	}

	public void setActions(List<ActionListener> actions) {
		this.actions = actions;
	}

	public String getInfo() {
		return this.info;
	}

	public void setInfo(String info) {
		this.info = info;
	}
}
