import java.util.Scanner;

class Dungeon {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter your character's name: ");
		String name = in.next();
		Character user = new Character(name);

		Field.generateField(user);
	}
}
