/**
 * This class creates menus to be accessed during play of Dungeon Crawler.
 * These menus allow the user to play the game and interact with the world.
 * It first creates two Inventory objects and then creates two ArrayLists.
 * @author Zachary Brennan
 * @author Benedict Tsibu-Gyan
 */
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Menus {
	public static Inventory inven = new Inventory(50);
	public static Inventory mercInven = new Inventory();
	public static ArrayList<Item> items = new ArrayList<Item>();
	public static ArrayList<Item> mercItems = new ArrayList<Item>();
	static Scanner in = new Scanner(System.in);

	/**
	 * Static method used to display the users inventory items, drop items from 
	 * the inventory, equip weapons and armor, and use other items from the 
	 * characters inventory.
	 * @param c the users character.
	 */
	public static void characterMenu(Character c) {	
		int choice;

		do {
			System.out.println("1: Print inventory");
			System.out.println("2: Drop item");
			System.out.println("3: Equip weapon");
			System.out.println("4: Equip armor");
			System.out.println("5: Use Item ");
			System.out.println("6: Save Game");
			System.out.println("7: Load Game");
			System.out.println("8: Return to dugeon");

			System.out.print("Enter a number: ");
			choice = in.nextInt();

			while (choice < 1 || choice > 8) {
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
				case 5:
					inven.useItem(c);
					break;	
				case 6:
					try {
						FileOutputStream save = new FileOutputStream("savedinfo.txt");
						PrintWriter print = new PrintWriter(save);
						c.persist(print);
						print.close();
					}	catch(FileNotFoundException e){
						System.out.println("File was not found");		
					}
					break;
				case 7:
					try {	
						FileInputStream load = new FileInputStream("savedinfo.txt");
						Scanner filereader = new Scanner(load);
						c.hydration(filereader);
						filereader.close();
					}	catch(FileNotFoundException e){
						System.out.println("File was not found");
					} 
					break;

			}
			System.out.println("");

		} while (choice != 8);
	}

	/**
	 * Static method that prints random item that the user has found and allow 
	 * the user to add the item to their inventory.
	 */
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
			//System.out.println("Item has been added to inventory");
		}
		else {
			System.out.println("Item has been dropped");
		}
	}

	/**
	 * Static method used to trade one of the users items for and item from the
	 * merchant. It displays the item that the merchant will trade and then asks
	 * the user if he/she would like to trade one of their items, with equal or 
	 * greater value. When the user successfully trades, their old item will be 
	 * removed from the ArrayList of items and the new item will be added.
	 */
	public static void merchant() {
		inven.fillArray(items);
	        mercInven.fillMercArray(mercItems);

		System.out.println("Would you like to trade one of your items for: " + mercItems.get(0).toString() + "?");
		System.out.println("You need an item with a value of at least 30!");
		inven.print();

		System.out.println("");
		System.out.print("Would you like to trade one of the items in your inventory (y or n)? ");
		String choice = in.next();

		while (!choice.equals("y") && !choice.equals("n")) {
			System.out.print("Enter a valid choice: ");
			choice = in.next();
		}
		if (choice.equals("y")) {
			System.out.print("Enter a number: ");
			int num = in.nextInt();

			while (num < 1 || num > items.size()) {
				System.out.print("Enter a valid number: ");
				num = in.nextInt();
			}
			if (num >= 1 && num <= items.size()) {
				if (items.get(num - 1).getValue() >= 30) {
					boolean canAdd = inven.add(mercItems.get(0));
					inven.delete(num - 1);
					mercInven.deleteMerc(0);
					items.remove(num - 1);
					mercItems.remove(0);

				}
				else {
					mercInven.deleteMerc(0);
					mercItems.remove(0);
					System.out.println("This items value is less than 30!");
					System.out.println("Cannot trade for this item!");
				}
			}
		}
	}

}
