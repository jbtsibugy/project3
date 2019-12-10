/*This class is used to create Item objects. It has method used to return neccesary
 * values and a method used to return a string value of a description of the item.
 *
 * @author Zachary Brennan
 * @version 10/01/19
 */
class Item {
	private ItemType type;
	private String name;
	private int weight;
	private int value;
	private int strength;

	//Constructor for Item objects. This constructor has input parameters
	//type, name, weight, value and strength.
	public Item(ItemType type, String name, int weight, int value, int strength) {
		this.type = type;
		this.name = name;
		this.weight = weight;
		this.value = value;
		this.strength = strength;
	}

	//Getter method used to return the item's weigth
	public int getWeight() {
		return this.weight;
	}

	//Getter method used to return the item's value
	public int getValue() {
		return this.value;
	}

	//Getter method used to return the item's name
	public String getName() {
		return this.name;
	}

	//Getter method used to return the item's type
	public ItemType getType() {
		return this.type;
	}
	
	//Getter method used to return the item's strength
	public int getStrength() {
		return this.strength;
	}

	//Method used to return a string value of the item's name, weight, value,
	//and strength
	public String toString() {
		return this.type.toString() + ", " +  this.name + ", " + this.weight + ", " + this.value + ", " +this.strength;
	}
}
