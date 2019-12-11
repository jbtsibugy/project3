/**
 * A <tt>Room</tt> represents a new set of chars that will be put into a 2D array
 * and used to create the grid on which the game is played. It reads in a .txt 
 * file containing the layout of the room and then converts it to a 2D array of
 * char symbols.
 * @author Zachary Brennan
 */
import java.util.Scanner;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;

public class Room {
	Scanner roomIn;
	char[][] grid;
	String name;
	private int rows;
	private int cols;

	/**
	 * Constructs new <tt>Room</tt> objects by setting the size of the 2D array
	 * and trying to read the file in using a Scanner, a BufferedReader, and 
	 * a FileReader. Uses try catch block to attempt to read in the files.
	 * @param name name of the room that will be read in.
	 * @throws FileNotFoundException if the readers do  not find a file to read in.
	 */
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

	/**
	 * Returns a 2D array of the current grid.
	 * @return 2D array of char symbols making up the grid.
	 */
	//Getter method used to return the 2D array grid
	public char[][] getGrid() {
		return grid;
	}
}
