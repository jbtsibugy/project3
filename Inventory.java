import java.util.ArrayList;
import java.util.Scanner;

/*This class is used to create an Inventory object. It has several methods used to
 * add and drop items form the inventory as well as equip items an so on.
 *
 * @author Zachary Brennan
 * @version 10/01/19
 */
class Inventory {
	ArrayList<Item> items = new ArrayList<Item>();
	Scanner in = new Scanner(System.in);

	private int maxWeight;
	private Item equippedWeapon;
	private Item equippedArmor;

	//Constructor for Inventory objects with maxWeight as the input parameter
	public Inventory(int maxWeight) {
		this.maxWeight = maxWeight;
		Item w0 = new Item(ItemType.WEAPON, "Baseball Bat", 2, 5, 3);
		items.add(w0);
		Item a0 = new Item(ItemType.ARMOR, "Thick Leather Jacket", 2, 4, 5);
		items.add(a0);
	}

	//This method is used to add an Item object to the items ArrayList and
	//ensure that the item does not make the inventory go over the weight limit
	public boolean add(Item item) {
		int weight = totalWeight() + item.getWeight();
		if (weight  <= maxWeight) {
			items.add(item);
			return true;
		}
		else {
			return false;
		}
	}

	//This method is used to calculate the total weight of the inventory
	public int totalWeight() {
		int weight = 0;
		for (int i = 0; i < items.size(); i++) {
			weight = weight + items.get(i).getWeight();
		}
		return weight;
	}

	//This method is used to print the current items in the inventory to the
	// screen as well as a description of the values being displayed
	public void print() {
		System.out.println("");
		System.out.println("Inventroy:");
		System.out.println("Item Weight Value Strength");
		for (int i = 0; i < items.size(); i++) {
			System.out.println(i + 1 + ": " + items.get(i).toString());
		}
		System.out.println("Total weight: " + totalWeight());
	}

	//This method is used to allow the user to drop an item from there
	//inventory. It first displays all of the items in the inventory to the 
	//screen and then take the users input to determine which item to drop from
	//the inventory
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
		
		System.out.println("");
		System.out.println("Dropped: " + items.get(choice - 1).toString());

		if (choice <= items.size()) {
			items.remove(choice - 1);
		}
	}

	//This method is used to allow the user to equip a weapon from there
	//inventory. It first displays all the items with the ItemType WEAPON to the
	//screen and then takes the users input to determine which item to set equal
	//to the equippedWeapon variable
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

	//This method is used to allow the user to equip armor from there inventory.
	//It first displays all the items with the ItemType ARMOR to the screen and
	//then takes the users input to determine which item to set equal to the
	// equippedArmor variable
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
			System.out.println("Enter a valid number");
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
}
