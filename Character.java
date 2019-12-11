/**
 * A <tt>Character</tt> represents a character with stats such as health, damage
 * and char that is used to play Dungeon Crawler. This class extends the
 * Organism class.
 * @author Zachar Brennan
 * @author Benedict Tsibu-Gyan
 * @author Jonathan
 */
import java.io.PrintWriter;
import java.util.Scanner;

public class Character extends Organism {
	private Item weapon;
	private Item armor;
	private Item otherItem;
	private String name;

	/**
	 * Constructs new <tt>Character</tt> object with default values for
	 * health, damage and char.
	 * @param name name of the users character
	 */
	public Character (String name) {
		super(100, 5, '@');
		this.name = name;
	}
	
	/**
	 * Loads Characters stats from a previous game.
	 * This is done by using a scanner to read iformation from
	 * a file until it reads the String Enemies.
	 * @param s Scanner used to read in information from the file.
	 */
	void hydration(Scanner s) {
		name = s.nextLine();
		health = s.nextInt();
		damage = s.nextInt();
		s.nextLine();
		String weaponString = s.nextLine();
		weapon = parseItem(weaponString);
		armor = parseItem(s.nextLine());
		//Throw away the "Inventory line"
		s.nextLine();
		// Gather all inventory item
		String temp = s.nextLine();
		while (!temp.equals("Enemies")) {
			Item item = parseItem(temp);
			Menus.inven.items.add(item);
			temp = s.nextLine();
		}

	}
	
	/**
	 * Saves the stats of a character from a previous game.
	 * This is done by writting information to a .txt file that will
	 * later be loaded.
	 * @param pw PrintWriter used to write information to file.
	 */
	void persist(PrintWriter pw){
		this.weapon = Menus.inven.items.get(0);
		this.armor = Menus.inven.items.get(1);
		pw.println(name);
		pw.println(health);
		pw.println(damage);
		pw.println(weapon.toString());
		pw.println(armor.toString());
		pw.println("Inventory");
		for (Item item : Menus.inven.items) {
			pw.println(item.toString());
		}
		pw.println("Enemies");
		/*for (Item item : Menus.inven) {
			pw.println(item.toString());
		}*/
		pw.println(".");
	}

	/**
	 * Takes in one of the Strings WEAPON, ARMOR, or OTHER and converts
	 * it into an Item by taking the information read in from the file.
	 * This will allow you to set your Characters inventory items type
	 * when loading.
	 * @return an Item with an ItemType that you can properly load.
	 * @param itemString WEAPON, ARMOR, or OTHER
	 */
	public Item parseItem(String itemString){
		System.out.println("ItemString: "+itemString);
		ItemType type;
		String[] attr = itemString.split(", ");
		switch(attr[0]){
			case "WEAPON":
				type = ItemType.WEAPON;
				break;
			case "ARMOR":
				type = ItemType.ARMOR;
				break;
			default:
				type = ItemType.OTHER;
				break;
		}
		Item item = new Item(type,attr[1],Integer.parseInt(attr[2]),Integer.parseInt(attr[3]),Integer.parseInt(attr[4]));
		return item;
	}

	/**
	 * Getter method for returning a name.
	 * @return the name of the Character.
	 */
	public String getName(){
		return name;
	}

	/**
	 * Returns the armors strength as long as the armor does not equal null.
	 * @return the strength of the armor.
	 */
	public int getArmorValue() {
		if (armor == null) {
			return 0;
		}
		else {
			return armor.getStrength();
		}
	}

	/**
	 * Returns the weapons strength as long as the weapon does not equal null.
	 * @return the strength of the weapon.
	 */
	public int getWeaponValue() {
		if (weapon == null) {
			return 0;
		}
		else {
			return weapon.getStrength();
		}

	}

	/**
	 * Returns the items value as long as the item does not equal null.
	 * @return the value of this item.
	 */
	public int getOtherItemValue() {
             if (otherItem == null) {
                 return 0;
	     }
	     else {
		     return otherItem.getStrength();
	     }
	}

	/**
	 * Setter method used to set a weapon as the equipped weapon.
	 * @param weapon item that is to be equipped as weapon.
	 */
	public void setEquippedWeapon(Item weapon){
		this.weapon = weapon;
	}

	/**
	 * Setter method used to set an armor as the equipped armor.
	 * @param armor item that is to be equipped as armor.
	 */
	public void setEquippedArmor(Item armor){
		this.armor = armor;
	}

	/**
	 * Adds weapons strength to the Characters damage.
	 * @param weapon item whos strength is to be added to damage.
	 */
	public void addWeapon (Item weapon){
		this.damage = weapon.getStrength() + this.damage;
	}

	/**
	 * Adds armors strength to the Characters health.
	 * @param armor item whos strength is to be added to health.
	 */
	public void addArmor (Item armor){
		this.health = armor.getStrength() + this.health;
	}
}
