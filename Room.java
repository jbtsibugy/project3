/*This class creates Room objects. It reads in a .txt file containing the layout of the room
 * and then converts it to a 2D array of chars called grid. It also contains a method used to
 * return the 2D array.
 *
 * @author Zachary Brennan
 * @version 10/25/19
 */
import java.util.Scanner;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;

class Room {
	Scanner roomIn;
	char[][] grid;
	String name;
	private int rows;
	private int cols;

	//Constuctor for Room objects with name as the input parameter
	public Room(String name) {
		this.name = name;
		rows = 13;
		cols = 15;
		try {
			roomIn = new Scanner(new BufferedReader(new FileReader(name)));
		}
		catch (FileNotFoundException e) {
			System.out.println("Cannot find the room file");
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
	}
	
	//Getter method used to return the 2D array grid
	public char[][] getGrid() {
		return grid;
	}
}
