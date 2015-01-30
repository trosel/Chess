
/**
 * @author Cale Short
 *Date: 27/1/2015
 *Project: Console Chess Game
 *Description: 2 players control their chess pieces with text commands in the console.
 */
public class Main {

	public static void main(String[] args) {
		Game theGame = new Game();
		theGame.setUp();
		theGame.playGame();
		theGame.endGame();
	}
}
