package util;

import java.util.ArrayList;
import java.util.Scanner;

public class MapFileReader {

	public static ArrayList<String> getLocationsList(String filename) {
		ArrayList<String> locations = new ArrayList<String>();
		try {
			Scanner scanner = new Scanner(MapFileReader.class.getClassLoader().getResourceAsStream("locations/"+filename));
			while (scanner.hasNext()) {
				locations.add(scanner.nextLine() + ".loc");
			}
			scanner.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return locations;
	}

	public static String readLocationFile(String filename) {
		String fileContents = "";
		try {
			Scanner scanner = new Scanner(MapFileReader.class.getClassLoader().getResourceAsStream("locations/"+filename));
			fileContents = new String();
			while (scanner.hasNext()) {
				fileContents += scanner.nextLine() + '\n';
			}
			scanner.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fileContents;
	}
}
