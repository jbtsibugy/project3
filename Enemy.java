/**
 * An <tt>Enemy</tt> represents a Troll enemy with stats such as health,
 * damage and char that is used to roam the dungeons and battle the 
 * Character. This class extends the Organism class.
 * @Zachary Brennan
 * @Benedict Tsibu-Gyan
 * @Jonathan
 */
import java.util.Scanner; 
import java.io.PrintWriter;

public class Enemy extends Organism{

	/**
	 * Constructs new <tt>Enemy</tt> object with default values for
	 * health, damage and char.
	 */
	public Enemy(){
		super(100, 15, '&');
	}
	
	/**
	 * Loads Enemy stats from a previous game.
	 * This is done by using a scanner to read information from
	 * a file.
	 * @param s Scanner used to read in information from the file.
	 */
	void hydration(Scanner s){
		String trash;
		String desc;
		health = s.nextInt();
		damage = s.nextInt();
		trash = s.nextLine();
		desc = s.nextLine();
	}
	
	/**
	 * Saves the state of an enemy from a previous game.
	 * This is done by writting information to a .txt file that will
	 * later be loaded.
	 * @param pw PrintWriter used to write information to file.
	 */
	void persist(PrintWriter pw){
		pw.println(health);
		pw.println(damage);
		pw.println(".");
	}

}
