abstract class Organism {

	int health;
	int damage;
	char Char;
	public Organism(int health, int damage, char Char){
		this.health = health;
		this.damage = damage;
		this.Char = Char;

	} 

	public char getChar(){
		return Char;	 
	}
	public int getHealth(){
		return health;	 
	}

	public int getDamage(){
		return damage;	 
	}

	public void setHealth(int health){
		this.health = health;
	}

	public void setDamage(int damage){
		this.damage = damage;
	}

}
