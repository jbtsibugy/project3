/**
 * This class creates a field to play on using 2D array. It creates three
 * room objects that can all be accessed in gameplay. It also allows the
 * user to move his/her character throughout the fields and initiates the
 * interactions with objects in the room. Lastly, it makes all enemies 
 * move on their path during each turn of the game.
 * @author Zachary Brennan
 */
import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;

public class Field {
	Scanner in = new Scanner(System.in);
	private char[][] grid;
	private Room room1;
	private Room room2;
	private Room room3;
	private Character c;

	/**
	 * Constructs new <tt>Field</tt> object which creates the three room 
	 * objects, sets the grid to the first room and then initiates the 
	 * moveChar method.
	 * @param c the users Character.
	 */
	public Field(Character c) {
		room1 = new Room("room1.txt");
		room2 = new Room("room2.txt");
		room3 = new Room("room3.txt");
		grid = room1.getGrid();
		this.c = c;
		moveChar(c);
	}

	/**
	 * This drops the users character into the dungeon in the first room.
	 * It then generates and fills the grids with enemy Trolls. Lastly,
	 * it allows the users character to move throughout the three grids
	 * and access menus when encountering objects in the rooms.
	 * @param c the users Character.
	 */
	public void moveChar(Character c) {
		ArrayList<Enemy> enemies = new ArrayList<Enemy>();
		char user = c.getChar();
		PopulateEnemies.createThem(enemies);
		int x = 7;
		int y = 6;
		int count = 0;
		String move = "";

		grid[2][1] = enemies.get(0).getChar();
		grid[1][3] = enemies.get(1).getChar();
		grid[9][11] = enemies.get(2).getChar();
		grid[8][13] = enemies.get(3).getChar();

		grid = room2.getGrid();
		grid[4][2] = enemies.get(4).getChar();
		grid[4][12] = enemies.get(5).getChar();
		grid[6][3] = enemies.get(6).getChar();
		grid[6][11] = enemies.get(7).getChar();

		grid = room3.getGrid();
		grid[4][2] = enemies.get(8).getChar();
		grid[4][12] = enemies.get(9).getChar();
		grid[6][3] = enemies.get(10).getChar();
		grid[6][11] = enemies.get(11).getChar();

		grid = room1.getGrid();

		do {
			grid[y][x] = user;
			for (int i = 0; i < grid.length; i++) {
				for (int j = 0; j < grid[0].length; j++) {
				}
				System.out.println(grid[i]);
			}

			System.out.println("a = left");
			System.out.println("s = down");
			System.out.println("w = up");
			System.out.println("d = right");
			System.out.println("i = inventory menu");
			System.out.println("q = quit game");
			System.out.print("Enter a command: ");
			move = in.next();
			System.out.println("");

			while (!move.equals("a") && !move.equals("s") && !move.equals("w") && !move.equals("d") && !move.equals("i") && !move.equals("q")) {
				System.out.print("Enter a valid comand: ");
				move = in.next();
			}

			if (move.equals("a") || move.equals("d")) {
				x = moveX(move, y, x);
				if (move.equals("a")) {
					grid[y][x + 1] = '*';
				}
				else if (move.equals("d")) {
					grid[y][x - 1] = '*';
				}
			}
			else if (move.equals("s") || move.equals("w")) {
				y = moveY(move, y, x);
				if (move.equals("s")) {
					grid[y - 1][x] = '*';
				}
				else if (move.equals("w")) {
					grid[y + 1][x] = '*';
				}
			}
			else if (move.equals("q")) {
				return;
			}

			if (move.equals("i")) {
				Menus.characterMenu(c);
			}

			moveEnemies();
			if (grid[y][x] == '$') {
				Menus.floorItemMenu();
			}
			else if (grid[y][x] == '?') {
				Menus.merchant();
			}
			else if (grid[y][x] == '#' && y == 11) {
				grid = room2.getGrid();

				x = 2;
				y = 1;
			}
			else if (grid[y][x] == '#' && y == 1) {
				grid = room1.getGrid();
				x = 12;
				y = 11;
			}
			else if (grid[y][x] == '#' && y == 10) {
				grid = room3.getGrid();
				x = 7;
				y = 9;
			}
			else if (grid[y][x] == '#' && y == 8) {
				grid = room2.getGrid();
				x = 7;
				y = 9;
			}
			else if (grid[y][x] == '&' || grid[y + 1][x] == '&' || grid[y - 1][x] == '&' || grid[y][x + 1] == '&' || grid[y][x - 1] == '&') {
				
				System.out.println("You have entered a battle!");
				boolean win = Battle.winFight(c, enemies.get(count));
				if (win == false) {
					return;
				}
				else {
					count++;
				}

				if (count >= 12) {
					System.out.println(c.getName() + " has defeated all enemies and won the game!");
					return;
				}
				
				if (grid[y + 1][x] == '&') {
					grid[y + 1][x] = '*';
				}
				if (grid[y - 1][x] == '&') {
					grid[y - 1][x] = '*';
				}
				if (grid[y][x + 1] == '&') {
					grid[y][x + 1] = '*';
				}
				if (grid[y][x - 1] == '&') {
					grid[y][x - 1] = '*';
				}	
			
			}
			//moveEnemies();
		} while (!move.equals("q"));
	}

	/**
	 * This is used to determine if the users character can move
	 * horizontally without being stoped by a wall.
	 * @return the integer value that will be used for the horizontal shift.
	 * @param s users input of which direction to move.
	 * @param vert the vertical value for the 2D array.
	 * @param horiz the horizontal value for the 2D arrray.
	 */
	public int moveX(String s, int vert, int horiz) {
		if (s.equals("a")) {
			if (grid[vert][horiz - 1] == '|' || grid[vert][horiz - 1] == '-') {
				System.out.println("You have walked into a wall");
				return horiz;
			}
			horiz--;
		}
		else if (s.equals("d")) {
			if (grid[vert][horiz + 1] == '|' || grid[vert][horiz + 1] == '-') {
				System.out.println("You have walked into a wall");
				return horiz;
			}
			horiz++;
		}
		return horiz;
	}

	/**
	 * This is used to determine if the users character can move
	 * vertically without being stoped by a wall.
	 * @return the integer value that will be used for the vertical shift.
	 * @param s users input of which direction to move.
	 * @param vert the vertical value for the 2D array.
	 * @param horiz the horizontal value for the 2D arrray.
	 */
	public int moveY(String s, int vert, int horiz) {
		if (s.equals("s")) {
			if (grid[vert + 1][horiz] == '-' || grid[vert + 1][horiz] == '|') {
				System.out.println("You have walked into a wall");
				return vert;
			}
			vert++;
		}
		else if (s.equals("w")) {
			if (grid[vert - 1][horiz] == '-' || grid[vert - 1][horiz] == '|') {
				System.out.println("You have walked into a wall");
				return vert;
			}
			vert--;
		}
		return vert;
	}

	/**
	 * Moves enemies on all three grids in constant circular motions.
	 */
	public void moveEnemies() {
		char enemy = '&';
		if (grid[1][1] == '&') {
			grid[1][2] = enemy;
			grid[1][1] = '*';
		}
		else if (grid[2][1] == '&') {
			grid[1][1] = enemy;
			grid[2][1] = '*';
		}
		if (grid[3][1] == '&') {
			grid[2][1] = enemy;
			grid[3][1] = '*';
		}
		else if (grid[3][2] == '&') {
			grid[3][1] = enemy;
			grid[3][2] = '*';
		}
		if (grid[3][3] == '&') {
			grid[3][2] = enemy;
			grid[3][3] = '*';
		}
		else if (grid[2][3] == '&') {
			grid[3][3] = enemy;
			grid[2][3] = '*';
		}
		if (grid[1][3] == '&') {
			grid[2][3] = enemy;
			grid[1][3] = '*';
		}
		else if (grid[1][2] == '&') {
			grid[1][3] = enemy;
			grid[1][2] = '*';
		}

		if (grid[8][11] == '&') {
			grid[8][12] = enemy;
			grid[8][11] = '*';
		}
		else if (grid[9][11] == '&') {
			grid[8][11] = enemy;
			grid[9][11] = '*';
		}
		if (grid[10][11] == '&') {
			grid[9][11] = enemy;
			grid[10][11] = '*';
		}
		else if (grid[10][12] == '&') {
			grid[10][11] = enemy;
			grid[10][12] = '*';
		}
		if (grid[10][13] == '&') {
			grid[10][12] = enemy;
			grid[10][13] = '*';
		}
		else if (grid[9][13] == '&') {
			grid[10][13] = enemy;
			grid[9][13] = '*';
		}
		if (grid[8][13] == '&') {
			grid[9][13] = enemy;
			grid[8][13] = '*';
		}
		else if (grid[8][12] == '&') {
			grid[8][13] = enemy;
			grid[8][12] = '*';
		}
		if (grid[4][2] == '&') {
			grid[4][3] = enemy;
			grid[4][2] = '*';
		}
		else if (grid[4][3] == '&' ) {
			grid[5][3] = enemy;
			grid[4][3] = '*';
		}
		else if (grid[5][3] == '&') {
			grid[5][2] = enemy;
			grid[5][3] = '*';
		}
		else if (grid[5][2] == '&') {
			grid[4][2] = enemy;
			grid[5][2] = '*';
		}
		if (grid[4][12] == '&') {
			grid[4][11] = enemy;
			grid[4][12] = '*';
		}
		else if (grid[4][11] == '&') {
			grid[5][11] = enemy;
			grid[4][11] = '*';
		}
		else if (grid[5][11] == '&') {
			grid[5][12] = enemy;
			grid[5][11] = '*';
		}
		else if (grid[5][12] == '&') {
			grid[4][12] = enemy;
			grid[5][12] = '*';
		}
		if (grid[6][3] == '&') {
			grid[7][3] = enemy;
			grid[6][3] = '*';
		}
		else if (grid[7][3] == '&') {
			grid[7][4] = enemy;
			grid[7][3] = '*';
		}
		else if (grid[7][4] == '&') {
			grid[6][4] = enemy;
			grid[7][4] = '*';
		}
		else if (grid[6][4] == '&') {
			grid[6][3] = enemy;
			grid[6][4] = '*';
		}
		if (grid[6][11] == '&') {
			grid[7][11] = enemy;
			grid[6][11] = '*';
		}
		else if (grid[7][11] == '&') {
			grid[7][10] = enemy;
			grid[7][11] = '*';
		}
		else if (grid[7][10] == '&') {
			grid[6][10] = enemy;
			grid[7][10] = '*';
		}
		else if (grid[6][10] == '&') {
			grid[6][11] = enemy;
			grid[6][10] = '*';
		}
	}
}
