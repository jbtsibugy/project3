/*This is the main method of the dungeon crawler project. It displays an overview of the game as well as
 * takes user input for the name of the character. It then calls the Field class to generate the game.
 *
 * @author Zachary Brennan
 * @version 11/26/19
 */ 
import java.util.Scanner;

class Dungeon {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enormous, murdurous Trolls keep attacking your town. They kidnap your");
		System.out.println("people, take them to the dungeons, and feast on them. You have decided");
		System.out.println("to enter one of the dungeons and take all of the Trolls out. The only");
		System.out.println("way to enter a dungeon is to jump down a hidden hole in the ground.");
		System.out.println("You will appear in the center of the first floor of the Troll's");	
		System.out.println("dungeon. You enter the dungeon with only a heavy stick for a weapon,"); 
		System.out.println("and a thick leather jacket for armor. You have no armor or weapons");
		System.out.println("equipped when you first enter the dungeon, so keep this in mind before");
		System.out.println("entering battle with a Troll for the first time. The Trolls are all");
		System.out.println("guarding items of value, and will enter battle with your character"); 
		System.out.println("if you come within one space above, below, to the left, or to the");
		System.out.println("right of one of them. When you enter a space that has an item mark,");
		System.out.println("you will be told what the item is and then asked if you would like to");
		System.out.println("add the item to your inventory. You must add the items to your");
		System.out.println("inventory before you can equip your character with anything. There are");
		System.out.println("three levels to this particular dungeon. You can move back and forth");
		System.out.println("between each level by entering a space with a stairway enterence mark.");
		System.out.println("Each level has several items that you can equip to your character as");
		System.out.println("well as multiple enemy Trolls that must be defeated. Search for as");
		System.out.println("many items as possible in order to equip your character with more"); 
		System.out.println("useful armor and weapons. This is the only way to kill all the enemy");
		System.out.println("Trolls and stop your people from being slaughtered.");
		System.out.println();

		System.out.println("Your Character = @");
		System.out.println("Enemy Troll = &");
		System.out.println("Random Item = $");
		System.out.println("Stairway Enterence = #");
		System.out.print("Enter your character's name: ");
		String name = in.next();
		Character user = new Character(name);

		Field game = new Field(user);
	}
}
