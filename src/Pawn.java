import java.util.ArrayList;


public class Pawn extends Piece {
	
	@Override
	public ArrayList<Location> calculatePossibleMoves(int a, int b) {
		ArrayList<Location> theChoices = new ArrayList<Location>();
		int x = a;
		int y = b;
		
		// if it is player one
		if (owner.equals("player1")) {
			// if there is a bad guy diagonal to the pawn
			if (xCurrentPlace+1<8 && yCurrentPlace+1<8) {
				if (Game.grid[xCurrentPlace+1][yCurrentPlace+1] != null) {
					if (Game.grid[xCurrentPlace+1][yCurrentPlace+1].owner.equals(this.owner) == false) {
						Location three = new Location();
						three.y = y+1;
						three.x = x+1;
						theChoices.add(three);
					}
				}
			}
			if (xCurrentPlace-1>=0 && yCurrentPlace+1<8) { 
				if (Game.grid[xCurrentPlace-1][yCurrentPlace+1] != null) {
					if (Game.grid[xCurrentPlace-1][yCurrentPlace+1].owner.equals(this.owner) == false) {
						Location four = new Location();
						four.y = y+1;
						four.x = x-1;
						theChoices.add(four);
					}
				}
			}
			// if it is the pawn's first move
			if (hasMoved == false) {
				for(int i=1; i<3;i++) {
					Location two = new Location();
					two.y = y+i;
					two.x = xCurrentPlace;
					if (two.y<8 && two.y>=0 && two.x<8 && two.x>=0) {
						if (Game.grid[two.x][two.y] == null) {
							theChoices.add(two);
						} else if (Game.grid[two.x][two.y].owner.equals(this.owner) == false) {
							// else if the move is blocked by the opposing player's piece
							break;
						} else {
							// if the move is blocked by a friendly piece
							break;
						}
					}
				}
			// if it is a regular move
			} else {
				Location one = new Location();
				one.y = y+1;
				one.x = xCurrentPlace;
				if (Game.grid[one.x][one.y] == null) {
					theChoices.add(one);
				} else if (Game.grid[one.x][one.y].owner.equals(this.owner) == false) {
					// else if the move has the opposing player's piece in it
					// add the move as well
					theChoices.add(one);
				}
			}
				
		// else if it is player two	
		} else {
			// if there is a bad guy diagonal to the pawn
			if (xCurrentPlace-1>=0 && yCurrentPlace-1>=0) {
				if (Game.grid[xCurrentPlace-1][yCurrentPlace-1] != null) {
					if (Game.grid[xCurrentPlace-1][yCurrentPlace-1].owner.equals(this.owner) == false) {
						Location three = new Location();
						three.y = y-1;
						three.x = x-1;
						theChoices.add(three);
					}
				}
			}
			if (xCurrentPlace+1<8 && yCurrentPlace-1>=0) {
				if (Game.grid[xCurrentPlace+1][yCurrentPlace-1] != null) {
					if (Game.grid[xCurrentPlace+1][yCurrentPlace-1].owner.equals(this.owner) == false) {
						Location four = new Location();
						four.y = y-1;
						four.x = x+1;
						theChoices.add(four);
					}
				}
			}
			// if it is the pawn's first move of the game
			if (hasMoved == false) {
				for(int i=1; i<3;i++) {
					Location two = new Location();
					two.y = y-i;
					two.x = xCurrentPlace;
					if (two.y<8 && two.y>=0 && two.x<8 && two.x>=0) {
						if (Game.grid[two.x][two.y] == null) {
							theChoices.add(two);
						} else if (Game.grid[two.x][two.y].owner.equals(this.owner) == false) {
							// else if the move has the opposing player's piece in it
							// add the move as well
							theChoices.add(two);
							break;
						} else {
							break;
						}
					}
				}
			} else {
			// if it is a regular move
				Location one = new Location();
				one.y = y-1;
				one.x = xCurrentPlace;
				if (Game.grid[one.x][one.y] == null) {
					theChoices.add(one);
				} else if (Game.grid[one.x][one.y].owner.equals(this.owner) == false) {
					// else if the move has the opposing player's piece in it
					// add the move as well
					theChoices.add(one);
				}
			}
		}
			
		return theChoices;
		
	} // close method
	
	public Pawn(int a, int b, String s, String o) {
		super(a,b,"P"+s, "pawn"+s, o);
	}
}
