/**
 * This class is the super class for the Character and Enemy classes.
 * An <tt>Organism</tt> is some kind of being that has a health value,
 * a damage value, and some kind of char symbol.
 * @author Benedict Tsibu-Gyan
 * @author Zachary Brennan
 */
public abstract class Organism {

	int health;
	int damage;
	char Char;

	/**
	 * Constructs new <tt>Organism</tt> object and sets all instance variables.
	 * @param health the health value of the organism.
	 * @param damage the damage value of the organism.
	 * @param Char the char symbol for the organism.
	 */
	public Organism(int health, int damage, char Char){
		this.health = health;
		this.damage = damage;
		this.Char = Char;

	} 

	/**
	 * Getter method use to return the organisms char value.
	 * @return organisms char symbol.
	 */
	public char getChar(){
		return Char;	 
	}

	/**
	 * Getter method used to return the organisms health value.
	 * @return organisms health value.
	 */
	public int getHealth(){
		return health;	 
	}

	/**
	 * Getter method used to return the organisms damage value.
	 * @return organisms damage value.
	 */
	public int getDamage(){
		return damage;	 
	}

	/**
	 * Setter method used to set the organisms health value.
	 * @param health new health value for organism.
	 */
	public void setHealth(int health){
		this.health = health;
	}

	/**
	 * Setter method used to set the organisms damage value.
	 * @param damage new damage value for organism.
	 */
	public void setDamage(int damage){
		this.damage = damage;
	}

}
