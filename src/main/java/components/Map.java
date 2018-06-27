package components;

import java.util.ArrayList;
import java.util.List;

public class Map {
	private int size;
	private List<Location> locations;
	
	public Map(int size) {
		this.size = size;
		this.locations = new ArrayList<Location>();
	}
	
	public void addLocation(Location location, int x, int y) {
		this.locations.add(location);
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public List<Location> getLocations() {
		return locations;
	}

	public void setLocations(List<Location> locations) {
		this.locations = locations;
	}

	@Override
	public String toString() {
		return "Map [size=" + size + ", locations=" + locations + "]";
	}
	
}
