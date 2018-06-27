package components;

import java.util.List;

public abstract class Item {
	@SuppressWarnings("unused")
	private String name;
	@SuppressWarnings("unused")
	private List<String> actions;
	@SuppressWarnings("unused")
	private String info;
	
	public abstract String getName();

	public abstract void setName(String name);

	public abstract List<String> getActions();

	public abstract void setActions(List<String> actions);

	public abstract String getInfo();

	public abstract void setInfo(String info);
}
