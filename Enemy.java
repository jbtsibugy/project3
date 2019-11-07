class Enemy{
	private int health;
	private int damage;
	private char enemyChar;

	//Constructor method for Enemy objects
	public Enemy(){
		this.health = 100;
		this.damage = 15;
		this.enemyChar = '&';
	}

	//Getter method for returning the enemy char
	public char getChar(){
		return enemyChar;
	}

	//Getter method for returning the enemy health
	public int getHealth(){
		return health;
	}

	//Getter method for returning the enemy damage
	public int getDamage(){
		return damage;
	}

	//Setter method used to set the enemy health
	public void setHealth (int health){
		this.health = health;
	}
}
