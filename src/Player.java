import java.util.*; 
import java.awt.*;

/**
 * Controls and manipulates the pieces in their own ArrayList
 * 
 * @author Cale Short
 *
 */
public class Player {
	ArrayList<Piece> pieces;
	Color pieceColor;
	boolean pieceWasKilledThisTurn = false;
	boolean playerChangedTheirMind = false;
	boolean promotionNeeded;
	boolean ableToCastle;
	GameHelper gameHelps = new GameHelper();
	String userIn;
	
	
	/**
	 * Calls the parameter piece's <code>calculatePossibleMoves()</code> method,
	 * if that returned ArrayList is empty, set <code>ableToMove</code> to false, if it is 
	 * not empty, check to see if the parameter piece is a king that can castle, and also 
	 * leave <code>ableToMove</code> as true.
	 * 
	 * @param t				The chosen piece from <code>selectPieceToMove()</code> passes to <code>Game.theActivePiece</code> and
	 * 						<code>Game.theActivePiece</code> passes to this parameter.
	 * @return ableToMove	
	 */
	public boolean canThePieceMove(Piece t) {
		boolean ableToMove = true;
		ableToCastle = false;
		
		if (t.calculatePossibleMoves(t.xCurrentPlace, t.yCurrentPlace).isEmpty()) {
			ableToMove = false;
		}
		//if it is a King
		//check to see if the King can castle
		if (t instanceof King) {
			if (t.hasMoved == false) {
				for (Piece a:pieces) {
					if (a instanceof Rook) {
						if (a.hasMoved == false) {
							//if it is rooka
							if (a.name.equals("rooka")) {
								if (Game.grid[a.xStartingPlace+1][a.yStartingPlace] == null && Game.grid[a.xStartingPlace+2][a.yStartingPlace] == null && Game.grid[a.xStartingPlace+3][a.yStartingPlace] == null) {
									ableToMove = true;
									ableToCastle = true;
									break;
								}
							}
							//if it is rookb
							if (a.name.equals("rookb")) {
								if (Game.grid[a.xStartingPlace-1][a.yStartingPlace] == null && Game.grid[a.xStartingPlace-2][a.yStartingPlace] == null) {
									ableToMove = true;
									ableToCastle = true;
									break;
								}
							}
						}
					}
				}
			}
		}
		
		return ableToMove;
	}
	
	/**
	 * Checks to see if the desired piece exists in the player's ArrayList AND 
	 * if the piece is also alive. If those conditions are met, return <code>theSelectedPiece</code>.
	 * Continue until a piece is able to be returned.
	 * 
	 * @return theSelectedPiece 		Becomes <code>Game.theActivePiece</code>
	 */
	public Piece selectPieceToMove() {
		boolean pieceIsFound = true;
		Piece theSelectedPiece = null;
		
		do {
			userIn = gameHelps.getUserAns("What piece would you like to move?");
			for (Piece p:pieces) {
				// if the piece is in the players array of live pieces
				if (userIn.equals(p.name)) {
					if (p.isAlive == true) {
						theSelectedPiece = p;
						break;
					}
				}
			}
			pieceIsFound = pieces.contains(theSelectedPiece);
		} while(!pieceIsFound);
		
		return theSelectedPiece;

	}
	
	/**
	 * Gets the array of possible moves and prints out the choices for the player,
	 * asks the player to type in one of the choices,
	 * if the players's choice is in the list of possibles, go ahead and move there.
	 * If the player's choice is not in the list, set <code>playerChangedTheirMind</code> to true,
	 * and the player is sent back to choosing a piece.
	 * 
	 * @param thePieceToMove
	 */
	public void movePiece(Piece thePieceToMove) {
		playerChangedTheirMind = false;
		promotionNeeded = false;
		
		ArrayList<Location> possibles = thePieceToMove.calculatePossibleMoves(thePieceToMove.xCurrentPlace, thePieceToMove.yCurrentPlace);
		System.out.println("Type each coordinate of desired move with a comma separating them: ");
		
		// print the available moves
		int i = 1;
		for (Location loc:possibles) {
			System.out.println("[" + i + "]" + loc.x + "," + loc.y);
			i++;
		}
		
		// get the user's choice 
		userIn = gameHelps.getUserAns("Or type 'X' to choose a different piece");
		
		// if the user doesn't type an X
		if (userIn.equals("X") == false && userIn.equals("x") == false) {
			// change the user input into two different integer coordinates
			String[] userLocChoice = userIn.split(",");
			int xCompare = Integer.parseInt(userLocChoice[0]);
			int yCompare = Integer.parseInt(userLocChoice[1]);
			for (Location loc:possibles) {
				if (xCompare == loc.x && yCompare == loc.y) {
					Game.grid[thePieceToMove.xCurrentPlace][thePieceToMove.yCurrentPlace] = null;
					thePieceToMove.xCurrentPlace = loc.x;
					thePieceToMove.yCurrentPlace = loc.y;
					if (Game.grid[xCompare][yCompare] != null) {
						pieceWasKilledThisTurn = true;
					}
					// in case of promotion of pawns
					if (thePieceToMove instanceof Pawn) {
						if (thePieceToMove.yCurrentPlace == 0 || thePieceToMove.yCurrentPlace == 7) {
							promotionNeeded = true;
						}
					}
					thePieceToMove.hasMoved = true;
					playerChangedTheirMind = false;
					break;
				} else {
					playerChangedTheirMind = true;
				}
			}
		// if the user types an X
		} else if (userIn.equals("X") || userIn.equals("x")){
			playerChangedTheirMind = true;
		}	
		
	} // close method
	
	/**
	 * Create the ArrayList of pieces and set the color.
	 * 
	 * @param c			For possible future implementation of <code>awt.Color</code> functionality.
	 */
	public Player(Color c) {
		pieces = new ArrayList<Piece>();
		pieceColor = c;
		
	}
}