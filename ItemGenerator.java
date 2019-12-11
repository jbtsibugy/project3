/**
 * This class an ArrayList of weapons, armors and other items, then randomly
 * generates one item that could be added to the users inventory.
 * @Zachary Brennan
 */
import java.util.Random;
import java.util.ArrayList;

public class ItemGenerator {
	static Random rng = new Random();
	static ArrayList<Item> list = new ArrayList<Item>();
        // ItemType, name, weight, value, strength
	//Method used to randomly generate a new item
	
	/**
	 * Static method used to create several Item objects and randomly return one.
	 * @return one randomly generated Item object.
	 */
	public static Item generate() {
		
	Item w1 = new Item(ItemType.WEAPON, "Small Pistol", 4, 15, 15);
	list.add(w1);
	Item w2 = new Item(ItemType.WEAPON, "Large Pistol", 6, 20, 20);
	list.add(w2);
	Item w3 = new Item(ItemType.WEAPON, "Shotgun", 12, 30, 30);
	list.add(w3);
	Item w4 = new Item(ItemType.WEAPON, "Assault Rifle", 10, 35, 40);
	list.add(w4);
	Item w5 = new Item(ItemType.WEAPON, "Machine Gun", 14, 35, 50);
	list.add(w5);
	Item w6 = new Item(ItemType.WEAPON, "Combat Knife", 1, 5, 5);
	list.add(w6);
	Item w7 = new Item(ItemType.WEAPON, "Flamethrower", 20, 25, 30);
	list.add(w7);
	Item w8 = new Item(ItemType.WEAPON, "Railgun", 20, 50, 80);
	list.add(w8);
	Item a1 = new Item(ItemType.ARMOR, "Flack Jacket", 6, 16, 60);
	list.add(a1);
	Item a2 = new Item(ItemType.ARMOR, "Heavy Body Armor", 15, 25, 90);
	list.add(a2);
	Item a3 = new Item(ItemType.ARMOR, "Military Armor", 10, 30, 110);
	list.add(a3);
	Item a4 = new Item(ItemType.ARMOR, "Military Armor w/ Helmet", 12, 35, 130);
	list.add(a4);
	Item a6 = new Item(ItemType.ARMOR, "Large Shield", 10, 16, 80);
	list.add(a6);
	Item a7 = new Item(ItemType.ARMOR, "Enhanced Combat Armor", 12, 50, 200);
	list.add(a7);
	Item o7 = new Item(ItemType.OTHER, "Gold", 15, 35, 0);
	list.add(o7);
	Item o8 = new Item(ItemType.OTHER, "Diamonds", 10, 45, 0);
	list.add(o8);
	Item o9 = new Item(ItemType.OTHER, "Estus Flask", 0, 5, 100);
	list.add(o9);
	Item o10 = new Item(ItemType.OTHER, "Adrenaline Shot", 0, 5, 25);	
        list.add(o10);

		int rand = rng.nextInt(list.size());
		return list.get(rand);
	}
}
