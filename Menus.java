/* 
 * @author Zachary Brennan
 * @version 10/28/19
 */
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.PrintWriter;

class Menus {
	private static Inventory inven = new Inventory(40);
	static Scanner in = new Scanner(System.in);

	//Method used to display and interact with the users inventory
	//menu. This method is used to display, drop items from, equip
	//weapons, and equip armor from the character's inventory
	public static void characterMenu(Character c, Enemy e1, Enemy e2, Enemy e3, Enemy e4) {	
		int choice;

		do {
			System.out.println("1: Print inventory");
			System.out.println("2: Drop item");
			System.out.println("3: Equip weapon");
			System.out.println("4: Equip armor");
			System.out.println("5: Return to dugeon");
			System.out.println("6: Save Game");
			System.out.println("7: Load Game");

			System.out.print("Enter a number: ");
			choice = in.nextInt();

			while (choice < 1 || choice > 7) {
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
				case 6:
					try {
						System.out.println("Hellooo from the Menu class");
						FileOutputStream save = new FileOutputStream("savedinfo.txt");
						PrintWriter print = new PrintWriter(save);
						c.persist(print);
						e1.persist(print);
						e2.persist(print);
						e3.persist(print);
						e4.persist(print);
						print.close();
					}	catch(FileNotFoundException e){
						System.out.println("File was not found");		
					}
					break;
				case 7:
					try {	
						System.out.println("I'm loading!");
						FileInputStream load = new FileInputStream("savedinfo.txt");
						Scanner filereader = new Scanner(load);
						c.hydration(filereader);
						e1.hydration(filereader);
						e2.hydration(filereader);
						e3.hydration(filereader);
						e4.hydration(filereader);
					//	Character loadedchar = new Character().hydration(filereader);
					//	Enemy loadedenmy1 = new Enemy(filereader);	 
					//	Enemy loadedenmy2 = new Enemy(filereader);	 
					//	Enemy loadedenmy3 = new Enemy(filereader);	 
					//	Enemy loadedenmy4 = new Enemy(filereader);
						filereader.close();
					}	catch(FileNotFoundException e){
						System.out.println("File was not found");
					} 
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
