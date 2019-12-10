/*This is the main method of the dungeon crawler project. It displays an overview of the game as well as
 * takes user input for the name of the character. It then calls the Field class to generate the game.
 *
 * @author Zachary Brennan
 * @version 11/26/19
 */ 
import java.util.Scanner;
import java.util.*;
import java.lang.Math;

class Dungeon {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enormous, murdurous Trolls keep attacking your town. They take your");
		System.out.println("people, take them to the dungeons, and feast on them. You have decided");
		System.out.println("to enter one of the dungeons and take all of the Trolls out. The only");
		System.out.println("way to enter a dungeon is to jump down a hidden hole in the ground.");
		System.out.println("You will appear in the center of the first floor of the Troll's");	
		System.out.println("dungeon. You enter the dungeon with only a heavy stick for a weapon,"); 
		System.out.println("and a thick leather jacket for armor. You have no armor or weapons");
		System.out.println("equipped when you first enter the dungeon, so keep this in mind before");
		System.out.println("entering battle with a Troll for the first time. The Trolls are all");
		System.out.println("moving by items of value, and will enter battle with your character"); 
		System.out.println("if you come within one space above, below, to the left, or to the");
		System.out.println("right of one of them. When you enter a space that has an item mark,");
		System.out.println("you will be told what the item is and then asked if you would like to");
		System.out.println("add the item to your inventory. You must add the items to your");
		System.out.println("inventory before you can equip your character with anything. Be");
		System.out.println("careful though, you can only carry 50 pounds of items in your");
		System.out.println("inventory. Keep track of the total weight of your inventory and drop");
		System.out.println("any items that you will not need. There are three levels to this");

		System.out.println("particular dungeon. You can move back and forth between each level by");
		System.out.println("entering a space with a stairway enterence mark. Each level has");
		System.out.println("several items that you can equip to your character as well as multiple");
		System.out.println("enemy Trolls that must be defeated. Search for as many items as");
		System.out.println("possible in order to equip your character with more useful armor and"); 
		System.out.println("weapons. This is the only way to kill all the enemy Trolls and stop");
		System.out.println("your people from being slaughtered.");
		System.out.println();

		System.out.println("Your Character = @");
		System.out.println("Enemy Troll = &");
		System.out.println("Random Item = $");
		System.out.println("Stairway Enterence = #");
		System.out.print("Enter your character's name: ");
		//Timer t = new Timer;
		//t.start();
		java.util.Date date = new java.util.Date();
		//System.out.print(date);
		String name = in.next();
		Character user = new Character(name);

		String date_string = String.valueOf(date);
		//System.out.println(date_string);
		String parsed_date_string = date_string.substring(date_string.indexOf("0"), date_string.indexOf("0") + 7);
		//System.out.print("wwww" + parsed_date_string + "eeeeeeeeeeeeeeeeeeeee ");
		Field game = new Field(user);
		java.util.Date date2 = new java.util.Date();
		String String_date2 = String.valueOf(date2);
		String parsed_date_two = String_date2.substring(String_date2.indexOf("0"), date_string.indexOf("0") + 7);
		int end = Integer.parseInt(parsed_date_two.substring(5,7));
		int start = Integer.parseInt(parsed_date_string.substring(5,7));
		int total_time = end - start;
		if (total_time < 0){
			total_time = total_time * -1;
		}
		System.out.println("total Minutes explored: " + total_time + " mins");
		//int total_time = (int(parsed_date_two.substring(6,8)) - int(parsed_date_two.substring(6,8)));
	}
}
