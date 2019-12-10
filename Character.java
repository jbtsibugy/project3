import java.io.PrintWriter;
import java.util.Scanner;

class Character extends Organism {
	private Item weapon;
	private Item armor;
	private Item otherItem;
	private String name;

	//Constructer for Character objects
	public Character (String name) {
		super(100, 5, '@');
		this.name = name;
	}
	// Method to load
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
	// Method to save
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

	//Getter method for returning the name
	public String getName(){
		return name;
	}

	public int getArmorValue() {
		if (armor == null) {
			return 0;
		}
		else {
			return armor.getStrength();
		}
	}

	public int getWeaponValue() {
		if (weapon == null) {
			return 0;
		}
		else {
			return weapon.getStrength();
		}

	}
	public int getOtherItemValue() {
             if (otherItem == null) {
                 return 0;
	     }
	     else {
		     return otherItem.getStrength();
	     }
	}
	//Setter method used to set the equipped weapon
	public void setEquippedWeapon(Item weapon){
		this.weapon = weapon;
	}

	//Setter method used to set the equipped armor
	public void setEquippedArmor(Item armor){
		this.armor = armor;
	}

	//Method used to add the weapon's strength to the character's health
	public void addWeapon (Item weapon){
		this.damage = weapon.getStrength() + this.damage;
	}

	//Method used to add the armor's strength to the character's health
	public void addArmor (Item armor){
		this.health = armor.getStrength() + this.health;
	}
}
