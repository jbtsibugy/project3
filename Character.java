class Character {
	private int health;
	private int damage;
	private Item weapon;
	private Item armor;
	private char userChar;
	private String name;

	//Constructer for Character objects
	public Character (String name) {
		this.name = name;
		this.health = 100;
		this.damage = 1;
		this.userChar = '@';
	}

	//Getter method for returning the name
	public String getName(){
		return name;
	}

	//Getter method for returning the user char
	public char getChar(){
		return userChar;
	}

	//Getter method for returning the health
	public int getHealth(){
		return health;
	}

	//Getter method for returning damage
	public int getDamage(){
		return damage;
	}

	//Setter method used to set the health of a Character object
	public void setHealth (int health){
		this.health = health;
	}

	//Setter method used to set the damage of a Character object
	public void setDamage (int damage){
		this.damage = damage;
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
