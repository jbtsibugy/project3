import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;
class Dungeon {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter your character's name: ");
		String name = in.next();
		Character user = new Character(name);

		System.out.println();
		System.out.println("This is the story of a guy who had a machine gun in a fantasy world for some reason");

		Field.generateField(user);
	}
}
