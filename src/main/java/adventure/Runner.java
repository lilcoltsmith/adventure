package adventure;

import java.util.Scanner;

import components.*;

public class Runner {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String input = null;
		System.out.println("New/Load ?");
		input = scanner.nextLine().toLowerCase();
		if(input.equalsIgnoreCase("load")) {
			
		}
		else if (input.equalsIgnoreCase("new")) {
			System.out.println("Enter player name: ");
			input = scanner.nextLine().toLowerCase();
			Player player = new Player(input);
			System.out.println(player.toString());
		}
		
		scanner.close();
	}

}
