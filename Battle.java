class Battle {

	//Method used to determine if character has won or lost the figth.
	//This method takes in a Character and an Enemy as input parameters
	//and uses them to determine which of the two will still have
	//remaining health after the battle
	public static boolean winFight (Character c, Enemy e) throws InterruptedException{
		while (c.getHealth() > 0 && e.getHealth() > 0) {
			System.out.println(c.getName() + " attacks for: " + c.getDamage());
			e.setHealth(e.getHealth() - c.getDamage());
			System.out.println("Enemy Health: " + e.getHealth());
			Thread.sleep(2000);
			System.out.println();

			if (e.getHealth() <= 0) {
                		System.out.println(c.getName() + " won the battle!");
				System.out.println();
				return true;
			}

			System.out.println("Enemy attacks for: " + e.getDamage());
			c.setHealth(c.getHealth() - e.getDamage());
			System.out.println(c.getName() + "'s health: " + c.getHealth());
			Thread.sleep(2000);
			System.out.println();

			if (c.getHealth() <= 0) {
                		System.out.println(c.getName() + " lost the battle and died! Game Over!");
				return false;
			}
		}
		if (c.getHealth() > 0){
                	System.out.println(c.getName() + " won the battle!");
			return true;
		}
		else {
			System.out.println(c.getName() + " lost the battle and died! Game Over!" );
			return false;
		}
	}
}
