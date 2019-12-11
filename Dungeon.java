/**
 * This is the main method of the dungeon crawler project.
 * It displays an overview of the game with a small list 
 * of instructions as well as takes user input for the name 
 * of the character. It then calls the Field class to 
 * generate the game and sets a timer to tell the user how
 * many minutes he/she was playing the game.
 * @author Zachary Brennan
 * @author Jonathan
 */ 
import java.util.Scanner;
import java.util.*;
import java.lang.Math;

public class Dungeon {
	/**
	 * Main method of Dungeon Crawler game
	 */
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
		
		//record start time for timer
		java.util.Date date = new java.util.Date();
		String name = in.next();
		Character user = new Character(name);
		//change date to string and parse
		String date_string = String.valueOf(date);
		String parsed_date_string = date_string.substring(date_string.indexOf("0"), date_string.indexOf("0") + 7);
		Field game = new Field(user);
		//record end time of game for timer
		java.util.Date date2 = new java.util.Date();
		String String_date2 = String.valueOf(date2);
		String parsed_date_two = String_date2.substring(String_date2.indexOf("0"), date_string.indexOf("0") + 7);
		int end = Integer.parseInt(parsed_date_two.substring(5,7));
		int start = Integer.parseInt(parsed_date_string.substring(5,7));
		int total_time = end - start;
		if (total_time < 0){
			total_time = total_time * -1;
		}
		//print total time elapsed
		System.out.println("Total Minutes Explored: " + total_time + " mins");
	}
}
