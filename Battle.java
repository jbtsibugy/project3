/**
 * This class takes in a Character and an Enemy object and determines who would
 * win the battle.
 * @author Zachary Brennan
 * @author Benedict
 */
import java.util.Scanner;

class Battle {

	/**
	 * Static method used to determine if character has won or lost the battle.
	 * This method takes in a Character and an Enemy as input parameters and
	 * uses them to determine which of the two will still have remaining health
	 * after the battle. 
	 * Will return true if Character still has health when the battle is over.
	 * @return whether or not it is true that the Character won the battle.
	 * @param c Character object used for battle.
	 * @param e Enemy object used for battle.
	 */
	public static boolean winFight (Character c, Enemy e) {
		Scanner in = new Scanner(System.in);
		int curHealth = c.getHealth() + c.getArmorValue();

		do {
			System.out.println(c.getName() + " attacks the Troll for: " + (c.getDamage() + c.getWeaponValue()) + " damage");
			e.setHealth(e.getHealth() - (c.getDamage() + c.getWeaponValue()));
			System.out.println("Troll Health: " + e.getHealth());
			System.out.println();

			if (e.getHealth() <= 0) {
                		System.out.println(c.getName() + " won the battle!");
				System.out.println();
				return true;
			}

			System.out.println("The Troll slashes you with its rusty sword for: " + e.getDamage() + " damage");
			c.setHealth(c.getHealth() - e.getDamage());
			curHealth = curHealth - e.getDamage();
			System.out.println(c.getName() + "'s health: " + curHealth);
			System.out.println();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException ie) {
				System.out.println("Interrupted!");
			}

			if (curHealth <= 0) {
                		System.out.println(c.getName() + " lost the battle and died! Game Over!");
				System.out.println();
				return false;
			}

		} while (curHealth > 0 && e.getHealth() > 0);
		return false;
	}
}
