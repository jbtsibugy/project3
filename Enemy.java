import java.util.Scanner; 
import java.io.PrintWriter;

class Enemy extends Organism{

	//Constructor method for Enemy objects
	public Enemy(){
		super(100, 15, '&');
	}
	// Method to load
	void hydration(Scanner s){
		String trash;
		String desc;
		health = s.nextInt();
		damage = s.nextInt();
		trash = s.nextLine();
		desc = s.nextLine();
	}
        // Method to save 
	void persist(PrintWriter pw){
		pw.println(health);
		pw.println(damage);
		pw.println(".");
	}

}
