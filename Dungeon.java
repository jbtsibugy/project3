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
		
		System.out.println("Enormous, murdurous Trolls keep attacking your town. They take your");
		System.out.println("people, force them into the dungeons, and feast on them. You have");
		System.out.println("decided to enter one of the dungeons and take all of the Trolls out.");
		System.out.println("The only way to enter a dungeon is to jump down a hidden hole in the");
		System.out.println("ground. You will land in the center of the first floor of the Troll's");	
		System.out.println("dungeon. You enter the dungeon with only a crossbow for a weapon, and"); 
		System.out.println("a small shield for armor. You have no armor or weapons equipped when you");
		System.out.println("first enter the dungeon, so keep this in mind before entering battle");
		System.out.println("with a Troll for the first time. The Trolls are all moving close to");
		System.out.println("items of value, and will enter battle with your character if you come"); 
		System.out.println("within one space above, below, to the left, or to the right of one of");
		System.out.println("them. When you enter a space that has an item mark, you will be told");
		System.out.println("what the item is and then asked if you would like to add the item to");
		System.out.println("your inventory. You must add the items to your inventory before you can");
		System.out.println("equip your character with any new item. Be careful though, you can only");
		System.out.println("carry 50 pounds of items in your inventory. Keep track of the total");
		System.out.println("weight of your inventory and drop any items that you will not need.");
		System.out.println("There are two specail items, the Estus Flask and the Adrenaline Shot.");
		System.out.println("There are three levels to this particular dungeon. You can move back and");
		System.out.println("forth between each level by entering a space with a stairway enterence");
		System.out.println("mark. Each level has several items that you can equip to your character");
		System.out.println("as well as multiple enemy Trolls that must be defeated. The third level");
		System.out.println("contains two merchant Trolls that will trade either a weapon or armor");
		System.out.println("for one of your inventory items with a value of at least 30. Search for");
		System.out.println("as many items as possible in order to equip your character with more");
		System.out.println("useful armor and weapons. This is the only way to kill all the enemy");
		System.out.println("Trolls and stop your people from being slaughtered.");
		System.out.println();

		System.out.println("Your Character = @");
		System.out.println("Enemy Troll = &");
		System.out.println("Random Item = $");
		System.out.println("Stairway Enterence = #");
		System.out.println("Merchant Troll = ?");
		System.out.print("Enter your character's name: ");
		String name = in.next();
		Character user = new Character(name);

		Field game = new Field(user);
	}
}
