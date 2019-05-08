package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MapFileReader {

	public static String readLocationFile(String filename) {
		String fileContents = "";
		try {
			File file = new File(MapFileReader.class.getClassLoader().getResource(filename).getFile());
			Scanner scanner = new Scanner(file);
			System.out.println(scanner);
			fileContents = new String();
			while (scanner.hasNext()) {
				fileContents += scanner.nextLine() + '\n';
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return fileContents;
	}
}
