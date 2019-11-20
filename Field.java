/*
 * @author Zachary Brennan
 * @version 10/25/19
 */
import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;

class Field {
	//private int rows = 12;
	//private int cols = 15;
	//static char[][] grid = new char[rows][cols];
	static Scanner in = new Scanner(System.in);
	static Scanner roomIn;// = new Scanner(new BufferedReader(new FileReader("room1.txt")));
	static char[][] grid;
	
	//Method used to generate the room in which the game is played.
	//The room grid is made up of a 2 dimentional array
	public static void generateField (Character c) {
	
		int rows = 12;
		int cols = 15;
		try {
			roomIn = new Scanner(new BufferedReader(new FileReader("room1.txt")));
		}
		catch (FileNotFoundException e) {
			System.out.println("Cannot find the file");
		}
		grid = new char[rows][cols];
		while (roomIn.hasNextLine()) {
			for (int i = 0; i < grid.length; i++) {
				String[] line = roomIn.nextLine().trim().split(" ");
				for (int j = 0; j < line.length; j++) {
					grid[i][j] = line[j].charAt(0);
				}
			}
		}

		/*grid = new char[][] {
			{'-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
			{'|', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '$', '|'},
			{'|', '*', '$', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '|'},
			{'|', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '|'},
			{'|', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '|'},
			{'|', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '|'},
			{'|', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '|'},
			{'|', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '|'},
			{'|', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '|'},
			{'|', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '$', '*', '|'},
			{'|', '$', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '|'},
			{'-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
		};*/
		moveChar(c);
	}

	//Mehtod used to move the users char throughout the grid.
	//This method also sets creates Enemy objects and allows the users
	//char to interact with the playing field
	public static void moveChar(Character c) {
		ArrayList<Enemy> enemies = new ArrayList<Enemy>();
		char user = c.getChar();
		Enemy e1 = new Enemy();
		enemies.add(e1);
		Enemy e2 = new Enemy();
		enemies.add(e2);
		Enemy e3 = new Enemy();
		enemies.add(e3);
		Enemy e4 = new Enemy();
		enemies.add(e4);
		int x = 5;
		int y = 5;
		int count = 0;
		String move = "";

		grid[2][1] = e1.getChar();
		grid[1][3] = e2.getChar();
		grid[9][11] = e3.getChar();
		grid[8][13] = e4.getChar();
		do {
			grid[y][x] = user;
			for (int i = 0; i < grid.length; i++) {
				for (int j = 0; j < grid[0].length; j++) {
				}
				System.out.println(grid[i]);
			}

			System.out.println("a = left, s = down, w = up, d = right, i = inventory menu, q = quit game");
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
			else if (grid[y][x] == '&' || grid[y + 1][x] == '&' || grid[y - 1][x] == '&' || grid[y][x + 1] == '&' || grid[y][x - 1] == '&') {
				
				System.out.println("You have entered a battle!");
				boolean win = Battle.winFight(c, enemies.get(count));
				if (win == false) {
					return;
				}
				else {
					count++;
				}

				if (count >= 4) {
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
		} while (!move.equals("q"));
	}

	//Method used to move the users char to the left and right on the grid
	public static int moveX(String s, int vert, int horiz) {
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

	//Method used to move the users char up and down on the grid
	public static int moveY(String s, int vert, int horiz) {
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

	//Method used to move the enemies in circulat motions around the
	//items on the grid
	public static void moveEnemies() {
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
	}
}
