/* 
 * @author Zachary Brennan
 * @version 10/28/19
 */
import java.util.Scanner;

class Menus {
	private static Inventory inven = new Inventory(40);
	static Scanner in = new Scanner(System.in);

	//Method used to display and interact with the users inventory
	//menu. This method is used to display, drop items from, equip
	//weapons, and equip armor from the character's inventory
	public static void characterMenu(Character c) {	
		int choice;

		do {
			System.out.println("1: Print inventory");
			System.out.println("2: Drop item");
			System.out.println("3: Equip weapon");
			System.out.println("4: Equip armor");
			System.out.println("5: Return to dugeon");

			System.out.print("Enter a number: ");
			choice = in.nextInt();

			while (choice < 1 || choice > 5) {
				System.out.print("Enter a valid number: ");
				choice = in.nextInt();
			}

			switch (choice) {
				case 1:
					inven.print();
					break;

				case 2:
					inven.drop();
					break;

				case 3:
					inven.equipWeapon(c);
					break;

				case 4:
					inven.equipArmor(c);
					break;
			}

			System.out.println("");

		} while (choice != 5);
	}

	//Method used to print a randon item that the user has found and
	//allow the user to add the item to their inventory
	public static void floorItemMenu() {
		Item thing = ItemGenerator.generate();

		System.out.println("You have found the: " + thing.toString());
		System.out.println("Would you like to add this item to your inventory (y or n)?");

		String choice = in.next();
		while (!choice.equals("y") && !choice.equals("n")) {
			System.out.print("Enter a valid choice: ");
			choice = in.next();
		}
		if (choice.equals("y")) {
			boolean canAdd = inven.add(thing);
			System.out.println("Item has been added to inventory");
		}
		else {
			System.out.println("Item has been dropped");
		}
	}
}
