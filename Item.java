/**
 * An <tt>Item</tt> represents an item with stats such as weight, value and strength.
 * Items will be used by the Character to play Dungeon Crawler.
 * @author Zachary Brennan
 */
public class Item {
	private ItemType type;
	private String name;
	private int weight;
	private int value;
	private int strength;

	/**
	 * Constructs new <tt>Item</tt> object and sets all instance variables.
	 * @param type the distinction of the item; WEAPON, ARMOR, OTHER.
	 * @param name the name of the item.
	 * @param weight the weight of the item.
	 * @param value the value of the item.
	 * @param strength the strength of the item.
	 */
	public Item(ItemType type, String name, int weight, int value, int strength) {
		this.type = type;
		this.name = name;
		this.weight = weight;
		this.value = value;
		this.strength = strength;
	}

	/**
	 * Getter method used to return the items weight.
	 * @return the weight of the item.
	 */
	public int getWeight() {
		return this.weight;
	}

	/**
	 * Getter method used to return the items value.
	 * @return the value of the item.
	 */
	public int getValue() {
		return this.value;
	}

	/**
	 * Getter method used to return the items name.
	 * @return the name of the item.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Getter method used to return the items type.
	 * @return the type of the item.
	 */
	public ItemType getType() {
		return this.type;
	}
	
	/**
	 * Getter method used to return the items strength.
	 * @return the strength of the item.
	 */
	public int getStrength() {
		return this.strength;
	}

	/**
	 * Returns a string value of the items name, weight, value and strength.
	 * @return a string of all the items instance variables.
	 */
	public String toString() {
		return this.type.toString() + ", " +  this.name + ", " + this.weight + ", " + this.value + ", " +this.strength;
	}
}
