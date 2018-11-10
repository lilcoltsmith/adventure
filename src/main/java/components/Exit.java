package components;

public class Exit {
	public static final int UNDEFINED = 0;
	public static final int NORTH = 1;
	public static final int SOUTH = 2;
	public static final int EAST  = 3;
	public static final int WEST  = 4;
	public static final int UP    = 5;
	public static final int DOWN  = 6;
	public static final int NORTHEAST = 7;
	public static final int NORTHWEST = 8;
	public static final int SOUTHEAST = 9;
	public static final int SOUTHWEST = 10;
	public static final int IN = 11;
	public static final int OUT = 12;
	
	public static final String[] dirName = { 
		"UNDEFINED",
		"NORTH",
		"SOUTH",
		"EAST",
		"WEST",
		"UP",
		"DOWN",
		"NORTHEAST",
		"NORTHWEST",
		"SOUTHEAST",
		"SOUTHWEST",
		"IN",
		"OUT"
	};

	public static final String[] shortDirName = {
		"NULL",
		"N",
		"S",
		"E",
		"W",
		"U",
		"D",
		"NE",
		"NW",
		"SE",
		"SW",
		"I",
		"O"		
	};
	
	private Location leadsTo;
	private int direction;
	private String directionName;
	private String shortDirectionName;
	
	public Exit() {
		direction = Exit.UNDEFINED;
		leadsTo = null;
		directionName = dirName[UNDEFINED];
		shortDirectionName = shortDirName[UNDEFINED];
	}

	
	public Exit(int direction, Location leadsTo) {
		this.direction = direction;

		// Assign direction names
		if (direction <= dirName.length )
			directionName = dirName[direction];
		if (direction <= shortDirName.length )
			shortDirectionName = shortDirName[direction];

		// Assign location
		this.leadsTo = leadsTo;
	}


	public Location getLeadsTo() {
		return leadsTo;
	}


	public void setLeadsTo(Location leadsTo) {
		this.leadsTo = leadsTo;
	}


	public int getDirection() {
		return direction;
	}


	public void setDirection(int direction) {
		this.direction = direction;
	}


	public String getDirectionName() {
		return directionName;
	}


	public void setDirectionName(String directionName) {
		this.directionName = directionName;
	}


	public String getShortDirectionName() {
		return shortDirectionName;
	}


	public void setShortDirectionName(String shortDirectionName) {
		this.shortDirectionName = shortDirectionName;
	}


	@Override
	public String toString() {
		return "Exit [leadsTo=" + leadsTo + ", direction=" + direction + ", directionName=" + directionName
				+ "]";
	}
	
	
}
