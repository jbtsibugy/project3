/**
 * An <tt>Inventory</tt> is an ArrayList of Item objects that the user can
 * access. It has several methods used to add and drop items from the inventory
 * as well as equip items and so on.
 * @author Zachary Brennan
 * @author Benedict Tsibu-Gyan
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Inventory {
	public static ArrayList<Item> items = new ArrayList<Item>();
	public static ArrayList<Item> mercItems = new ArrayList<Item>();
	Scanner in = new Scanner(System.in);

	private int maxWeight;
	private Item equippedWeapon;
	private Item equippedArmor;
	private Item equippedItem;
	
	/**
	 * Constructs new <tt>Inventory</tt> object with default items that the
	 * users character will begin the game with.
	 * @param maxWeight the maximum weight you can have in your inventory.
	 */
	public Inventory(int maxWeight) {
		this.maxWeight = maxWeight;
		Item w0 = new Item(ItemType.WEAPON, "Crossbow", 2, 10, 10);
		items.add(w0);
		Item a0 = new Item(ItemType.ARMOR, "Small Shield", 4, 8, 50);
		items.add(a0);		
	}

	/**
	 * Constructs new <tt>Inventory</tt> object with default items that the
	 * merchant can trade to the users character.
	 */
	public Inventory() {
		Item m1 = new Item(ItemType.ARMOR, "Military Armor", 10, 30, 110);
		mercItems.add(m1);
		Item m2 = new Item(ItemType.WEAPON, "Shotgun", 12, 30, 30);
		mercItems.add(m2);
	}

	/**
	 * Adds an item to the users inventory if the item does not cause the 
	 * inventory to exceed its maximum weight.
	 * @return whether or not the item has been added.
	 * @param item the item that the user is adding to the inventory.
	 */
	public boolean add(Item item) {
		int weight = totalWeight() + item.getWeight();
		if (weight  <= maxWeight) {
			items.add(item);
			System.out.println("Item has been added to inventory");
			return true;
		}
		else {
			System.out.println("Cannot add to inventory! Too heavy!");
			return false;
		}
	}

	/**
	 * Calculates the current total weight of the inventory.
	 * @return the new weight of the inventory.
	 */
	public int totalWeight() {
		int weight = 0;
		for (int i = 0; i < items.size(); i++) {
			weight = weight + items.get(i).getWeight();
		}
		return weight;
	}

	/**
	 * Prints the current items in the inventory to the screen as well as
	 * a description of the values being displayed.
	 */
	public void print() {
		System.out.println("");
		System.out.println("Inventroy:");
		System.out.println("Item Weight Value Strength");
		for (int i = 0; i < items.size(); i++) {
			System.out.println(i + 1 + ": " + items.get(i).toString());
		}
		System.out.println("Total weight: " + totalWeight());
	}

	/**
	 * Allows the user to drop an item from there inventory. It first displays
	 * all of the items in the inventory to the screen and then take the users
	 * input to determine which item to drop from the inventory.
	 */
	public void drop() {
		System.out.println("");
		System.out.println("Drop an item:");
		System.out.println("Item Weight Value Strength");
		for (int i = 0; i < items.size(); i++) {
			System.out.println(i + 1 + ": " +  items.get(i).toString());
		}
		System.out.println(items.size() + 1 +  ": Cancel");

		System.out.print("Enter a number: ");
		int choice = in.nextInt();

		while (choice < 1 || choice > items.size() + 1) {
			System.out.print("Enter a valid number: ");
			choice = in.nextInt();
		}

		if (choice >= 1 && choice <= items.size()) {
			System.out.println("");
			System.out.println("Dropped: " + items.get(choice - 1).toString());

			if (choice <= items.size()) {
				items.remove(choice - 1);
			}
		}
	}

	/**
	 * Removes an item from the items ArrayList.
	 * @param i index of item to be deleted form items ArrayList.
	 */
	public void delete(int i) {
		items.remove(i);
	}

	/**
	 * Removes an item from the mercItems ArrayList.
	 * @param i index of item to be deleted form mercItems ArrayList.
	 */
	public void deleteMerc(int i) {
		mercItems.remove(i);
	}

	/**
	 * Allows the user to equip a weapon from there inventory. It first displays
	 * all the items with the ItemType WEAPON to the screen and then takes the
	 * users input to determine which item to set equal to the equippedWeapon
	 * variable.
	 * @param c the users Character.
	 */
	public void equipWeapon(Character c) {
		ArrayList<Item> weapons = new ArrayList<Item>();
		System.out.println("");
		System.out.println("Equip a weapon:");
		System.out.println("Item Weight Value Strength");
		int count = 0;
		for (int i = 0; i < items.size(); i++) {
			if (items.get(i).getType() == ItemType.WEAPON) {
				weapons.add(items.get(i));
				count++;
				System.out.println(count + ": " + items.get(i).toString());
			}
		}
		System.out.println(count + 1 + ": Cancel");

		System.out.print("Enter a number: ");
		int choice = in.nextInt();

		while (choice < 1 || choice > count + 1) {
			System.out.print("Enter a valid number: ");
			choice = in.nextInt();
		}
		if (choice >= 1 && choice <= count) {
			this.equippedWeapon = weapons.get(choice - 1);
			c.setEquippedWeapon(weapons.get(choice - 1));
			System.out.println("");
			System.out.println("Equipped: " + equippedWeapon.toString());
			//c.setDamage(c.getDamage() + equippedWeapon.getStrength());
			System.out.println(c.getName() + "'s damage value: " + (c.getDamage() + c.getWeaponValue()));
		}
	}

	/**
	 * Allows the user to equip an armor from there inventory. It first displays
	 * all the items with the ItemType ARMOR to the screen and then takes the
	 * users input to determine which item to set equal to the equippedArmor
	 * variable.
	 * @param c the users Character.
	 */
	public void equipArmor(Character c) {
		ArrayList<Item> armors = new ArrayList<Item>();
		System.out.println("");
		System.out.println("Equip armor:");
		System.out.println("Item Weight Value Strength");
		int count = 0;
		for (int i = 0; i < items.size(); i++) {
			if (items.get(i).getType() == ItemType.ARMOR) {
				armors.add(items.get(i));
				count++;
				System.out.println(count + ": " + items.get(i).toString());
			}
		}
		System.out.println(count + 1 + ": Cancel");

		System.out.print("Enter a number: ");
		int choice = in.nextInt();

		while (choice < 1 || choice > count + 1) {
			System.out.print("Enter a valid number: ");
			choice = in.nextInt();
		}
		if (choice >= 1 && choice <= count) {
			this.equippedArmor = armors.get(choice - 1);
			c.setEquippedArmor(armors.get(choice - 1));
			System.out.println("");
			System.out.println("Equipped: " + equippedArmor.toString());
			//c.setHealth(c.getHealth() + equippedArmor.getStrength());
			System.out.println(c.getName() + "'s health: " + (c.getHealth() + c.getArmorValue()));
		}
	}

	/**
	 * Adds items from the items ArrayList to another ArrayList.
	 * @param list new ArrayList that will be filled with items.
	 */
	public void fillArray(ArrayList<Item> list) {
		for (int i = 0; i < items.size(); i++) {
			list.add(items.get(i));
		}
	}

	/**
	 * Adds items from the mercItems ArrayList to another ArrayList.
	 * @param list new ArrayList that will be filled with items.
	 */
	public void fillMercArray(ArrayList<Item> list) {
		for (int i = 0; i < mercItems.size(); i++) {
			list.add(mercItems.get(i));
		}
	}

	/**
	 * Allows the user to use an other item from there inventory. It first 
	 * displays all the items with the ItemType OTHER to the screen and then 
	 * takes the users input to determine which item to atttempt to use.
	 * The "Adrenaline Shot" will increase the Characters damage and the
	 * "Estus Flask" will increase the Characters health.
	 * @param c the users Character.
	 */
	public void useItem(Character c) {

		ArrayList<Item> otheritems = new ArrayList<Item>();
		System.out.println("");
		System.out.println("Equip item:");
		System.out.println("Item Weight Value Strength");
		int count = 0;
		for (int i = 0; i < items.size(); i++) {
			if (items.get(i).getType() == ItemType.OTHER) {
				otheritems.add(items.get(i));
				count++;
				System.out.println(count + ": " + items.get(i).toString());
			}
		}
		System.out.println(count + 1 + ": Cancel");

		System.out.print("Enter a number: ");
		int choice = in.nextInt();

		while (choice < 1 || choice > count + 1) {
			System.out.println("Enter a valid number");
			choice = in.nextInt();
		}
		if (choice >= 1 && choice <= count) {
			this.equippedItem = otheritems.get(choice -1);
			System.out.println("");
			System.out.println("Equipped: " + equippedItem.toString());

			if (otheritems.get(choice - 1).getName().equals("Adrenaline Shot")){
				c.addWeapon(otheritems.get(choice - 1)); 
				System.out.println(c.getName() + "'s health: " + (c.getDamage() + c.getOtherItemValue()));
			}
			else if (otheritems.get(choice - 1).getName().equals("Estus Flask")) {
				c.addArmor(otheritems.get(choice - 1));
				System.out.println(c.getName() + "'s damage value: " + (c.getDamage() + c.getOtherItemValue()));

			}

		}
	}	
}
