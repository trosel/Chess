import java.util.ArrayList;


public class Knight extends Piece {
	
	@Override
	public ArrayList<Location> calculatePossibleMoves(int a, int b) {
		ArrayList<Location> theChoices = new ArrayList<Location>();
		int x = a;
		int y = b;

		Location one = new Location();
		one.y = y+2;
		one.x = x-1;
		if (one.y<8 && one.y>=0 && one.x<8 && one.x>=0) {
			if (Game.grid[one.x][one.y] == null) {
				theChoices.add(one);
			} else if (Game.grid[one.x][one.y].owner.equals(this.owner) == false) {
				// else if the move has the opposing player's piece in it
				// add the move as well
				theChoices.add(one);
			}
		}
		
		Location two = new Location();
		two.y = y+2;
		two.x = x+1;
		if (two.y<8 && two.y>=0 && two.x<8 && two.x>=0) {
			if (Game.grid[two.x][two.y] == null) {
				theChoices.add(two);
			} else if (Game.grid[two.x][two.y].owner.equals(this.owner) == false) {
				// else if the move has the opposing player's piece in it
				// add the move as well
				theChoices.add(two);
			}
		}
		Location three = new Location();
		three.y = y+1;
		three.x = x-2;
		if (three.y<8 && three.y>=0 && three.x<8 && three.x>=0) {
			if (Game.grid[three.x][three.y] == null) {
				theChoices.add(three);
			} else if (Game.grid[three.x][three.y].owner.equals(this.owner) == false) {
				// else if the move has the opposing player's piece in it
				// add the move as well
				theChoices.add(three);
			}
		}
		Location four = new Location();
		four.y = y+1;
		four.x = x+2;
		if (four.y<8 && four.y>=0 && four.x<8 && four.x>=0) {
			if (Game.grid[four.x][four.y] == null) {
				theChoices.add(four);
			} else if (Game.grid[four.x][four.y].owner.equals(this.owner) == false) {
				// else if the move has the opposing player's piece in it
				// add the move as well
				theChoices.add(four);
			}
		}
		Location five = new Location();
		five.y = y-1;
		five.x = x+2;
		if (five.y<8 && five.y>=0 && five.x<8 && five.x>=0) {
			if (Game.grid[five.x][five.y] == null) {
				theChoices.add(five);
			} else if (Game.grid[five.x][five.y].owner.equals(this.owner) == false) {
				// else if the move has the opposing player's piece in it
				// add the move as well
				theChoices.add(five);
			}
		}
		Location six = new Location();
		six.y = y-1;
		six.x = x-2;
		if (six.y<8 && six.y>=0 && six.x<8 && six.x>=0) {
			if (Game.grid[six.x][six.y] == null) {
				theChoices.add(six);
			} else if (Game.grid[six.x][six.y].owner.equals(this.owner) == false) {
				// else if the move has the opposing player's piece in it
				// add the move as well
				theChoices.add(six);
			}
		}
		Location seven = new Location();
		seven.y = y-2;
		seven.x = x+1;
		if (seven.y<8 && seven.y>=0 && seven.x<8 && seven.x>=0) {
			if (Game.grid[seven.x][seven.y] == null) {
				theChoices.add(seven);
			} else if (Game.grid[seven.x][seven.y].owner.equals(this.owner) == false) {
				// else if the move has the opposing player's piece in it
				// add the move as well
				theChoices.add(seven);
			}
		}
		Location eight = new Location();
		eight.y = y-2;
		eight.x = x-1;
		if (eight.y<8 && eight.y>=0 && eight.x<8 && eight.x>=0) {
			if (Game.grid[eight.x][eight.y] == null) {
				theChoices.add(eight);
			} else if (Game.grid[eight.x][eight.y].owner.equals(this.owner) == false) {
				// else if the move has the opposing player's piece in it
				// add the move as well
				theChoices.add(eight);
			}
		}
			
		return theChoices;
		
	} // close method
	
	public Knight(int a, int b, String s, String o) {
		super(a,b,"N"+s, "knight"+s, o);
	}
}