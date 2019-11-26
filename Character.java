import java.io.PrintWriter;
import java.util.Scanner;

class Character extends Organism {
	private Item weapon;
	private Item armor;
	private String name;

	//Constructer for Character objects
	public Character (String name) {
		super(100, 1, '@');
		this.name = name;
	}

	Character(Scanner s) {
		super(s,'@');
		String trash;
		String desc;
		name = s.nextLine();
		health = s.nextInt();
		damage = s.nextInt();
		trash = s.nextLine();
		desc = s.nextLine();    
	}
	void persist(PrintWriter pw){
		System.out.println(" Here! in the Character class!");
		pw.println(name);
		pw.println(health);
		pw.println(damage);
		pw.println(".");
	}

	//Getter method for returning the name
	public String getName(){
		return name;
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
