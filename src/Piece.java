import java.util.ArrayList;


/**
 * Holds all of the attributes and behaviors that are essential to any piece.
 * 
 * @author Cale Short
 *
 */
public abstract class Piece {
	
	int xStartingPlace;
	int yStartingPlace;

	int xCurrentPlace;
	int yCurrentPlace;
	
	boolean hasMoved = false;
	boolean wasPromoted = false;
	boolean isAlive = true;
	protected String display;
	protected String name;
	public String owner;
	
	/**
	 * Each different piece overrides this method with their respective rules of movement.
	 * 
	 * @param a		the x coordinate of the piece's current location
	 * @param b		the y coordinate of the piece's current location
	 * @return		an ArrayList of possible locations that the piece can move to
	 */
	public abstract ArrayList<Location> calculatePossibleMoves(int a, int b);
	
	/**
	 * Each piece calls this constructor in their own constructor, passing in various parameters.
	 * 
	 * @param a				x coordinate of the starting position of the piece on the grid
	 * @param b				y coordinate of the starting position of the piece on the grid
	 * @param d				the String that shows up on the board, representing the piece
	 * @param n				the name of the piece, what the player calls the piece when selecting them
	 * @param ownerName		either "player1" or "player2"
	 */
	public Piece(int a, int b, String d, String n, String ownerName) {
		xStartingPlace = a;
		yStartingPlace = b;
		xCurrentPlace = a;
		yCurrentPlace = b;
		owner = ownerName;
		if (ownerName.equals("player1")) {
			display = "1" + d;
		} else {
			display = d + "2";
		}
		name = n;
	}
}
