import java.io.PrintWriter;
import java.util.Scanner;

class Character extends Organism {
	private Item weapon;
	private Item armor;
	private Item otherItem;
	private String name;

	//Constructer for Character objects
	public Character (String name) {
		super(100, 25, '@');
		this.name = name;
	}
	// Method to load
	void hydration(Scanner s) {
		String trash;
		String desc;
		name = s.nextLine();
		health = s.nextInt();
		damage = s.nextInt();
		trash = s.nextLine();
		desc = s.nextLine();    
	}
	// Method to save
	void persist(PrintWriter pw){
		pw.println(name);
		pw.println(health);
		pw.println(damage);
		pw.println(".");
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
