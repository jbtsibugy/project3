import java.util.Scanner;
import java.io.PrintWriter;

class Enemy extends Organism{

	//Constructor method for Enemy objects
	public Enemy(){
		super(100, 15, '&');
	}
	Enemy(Scanner s){
        super(s,'&');
	}
        
	void persist(PrintWriter pw){
        pw.println(health);
	pw.println(damage);
	System.out.println("Here in the Enemy Class!");
	}

}
