import java.awt.Color;
import java.util.ArrayList;


/**
 * Handles the main flow of the chess game.
 * 
 * @author Cale Short
 *
 */
/**
 * @author Training3
 *
 */
public class Game {
	
	public Player player1 = new Player(Color.black);
	public Player player2 = new Player(Color.white);
	int moveCounter = 0;
	GameHelper gameHelp = new GameHelper();
	public static Piece[][] grid = new Piece[8][8];
	boolean keepPlaying = true;
	boolean pieceIsAbleToMove = false;
	String userInput;
	Piece theActivePiece;

	
	/**
	 * Instantiates the pieces for players 1 and 2.
	 * Stores the pieces in their respective ArrayLists.
	 * Prints the starting board.
	 */
	public void setUp() {
		
//	create all of the piece objects for Player 1
		Pawn player1pawnA = new Pawn(0,1,"a","player1");
		Pawn player1pawnB = new Pawn(1,1,"b","player1");
		Pawn player1pawnC = new Pawn(2,1,"c","player1");
		Pawn player1pawnD = new Pawn(3,1,"d","player1");
		Pawn player1pawnE = new Pawn(4,1,"e","player1");
		Pawn player1pawnF = new Pawn(5,1,"f","player1");
		Pawn player1pawnG = new Pawn(6,1,"g","player1");
		Pawn player1pawnH = new Pawn(7,1,"h","player1");
		
		Rook player1rookA = new Rook(0,0,"a","player1"); 
		Rook player1rookB = new Rook(7,0,"b","player1"); 
		
		Bishop player1bishopA = new Bishop(2,0,"a","player1");
		Bishop player1bishopB = new Bishop(5,0,"b","player1");
		
		Knight player1knightA = new Knight(1,0,"a","player1");
		Knight player1knightB = new Knight(6,0,"b","player1");
		
		Queen player1queen = new Queen(3,0,"","player1");
		King player1king = new King(4,0,"player1");
		
//	create all of the piece objects for Player 2
		Pawn player2pawnA = new Pawn(0,6,"a","player2");
		Pawn player2pawnB = new Pawn(1,6,"b","player2");
		Pawn player2pawnC = new Pawn(2,6,"c","player2");
		Pawn player2pawnD = new Pawn(3,6,"d","player2");
		Pawn player2pawnE = new Pawn(4,6,"e","player2");
		Pawn player2pawnF = new Pawn(5,6,"f","player2");
		Pawn player2pawnG = new Pawn(6,6,"g","player2");
		Pawn player2pawnH = new Pawn(7,6,"h","player2");
		
		Rook player2rookA = new Rook(0,7,"a","player2"); 
		Rook player2rookB = new Rook(7,7,"b","player2"); 
		
		Bishop player2bishopA = new Bishop(2,7,"a","player2");
		Bishop player2bishopB = new Bishop(5,7,"b","player2");
		
		Knight player2knightA = new Knight(1,7,"a","player2");
		Knight player2knightB = new Knight(6,7,"b","player2");
		
		Queen player2queen = new Queen(3,7,"","player2");
		King player2king = new King(4,7,"player2");
		
//	put pieces into Player 1 array
		player1.pieces.add(player1pawnA);
		player1.pieces.add(player1pawnB);
		player1.pieces.add(player1pawnC);
		player1.pieces.add(player1pawnD);
		player1.pieces.add(player1pawnE);
		player1.pieces.add(player1pawnF);
		player1.pieces.add(player1pawnG);
		player1.pieces.add(player1pawnH);
		
		player1.pieces.add(player1rookA);
		player1.pieces.add(player1rookB);

		player1.pieces.add(player1bishopA);
		player1.pieces.add(player1bishopB);

		player1.pieces.add(player1knightA);
		player1.pieces.add(player1knightB);

		player1.pieces.add(player1queen);
		player1.pieces.add(player1king);
		
//	put pieces into Player 2 array
		player2.pieces.add(player2pawnA);
		player2.pieces.add(player2pawnB);
		player2.pieces.add(player2pawnC);
		player2.pieces.add(player2pawnD);
		player2.pieces.add(player2pawnE);
		player2.pieces.add(player2pawnF);
		player2.pieces.add(player2pawnG);
		player2.pieces.add(player2pawnH);
		
		player2.pieces.add(player2rookA);
		player2.pieces.add(player2rookB);

		player2.pieces.add(player2bishopA);
		player2.pieces.add(player2bishopB);

		player2.pieces.add(player2knightA);
		player2.pieces.add(player2knightB);

		player2.pieces.add(player2queen);
		player2.pieces.add(player2king);
		
		gameBoardRefresh();
		
	} // close method
		
	/**
	 * Stores each piece in the correct grid location,
	 * depending on if the piece is alive, promoted, et cetera.
	 * Prints the board.
	 */
	public void gameBoardRefresh() {
		
//		loop through player's array of pieces. if the piece has an x that matches i
//		AND a y that matches r
//		AND if the piece is ALIVE
//		put it in the array location
		for (int i = 0; i < 8; i++) {
			for (int r = 0; r < 8; r++) {
				for (Piece p:player1.pieces) {
					if(p.isAlive == true) {
						if (p.wasPromoted == true) {
							// do not assign to a place on the board
						} else if(p.xCurrentPlace == i && p.yCurrentPlace == r) {
							grid[i][r] = p;
						}
					}
				}
			}
		}
//		Fill the game board for Player 2
		for (int i = 0; i < 8; i++) {
			for (int r = 0; r < 8; r++) {
				for (Piece p:player2.pieces) {
					if(p.isAlive == true) {
						if (p.wasPromoted == true) {
							// do not assign to a place on the board
						} else if(p.xCurrentPlace == i && p.yCurrentPlace == r) {
							grid[i][r] = p;
						}
					}
				} 
			} 
		}
		
		// print the game board with the game pieces in the right spots
		
		//print the top border
		System.out.println("                         Y");
		System.out.print("  ");
		for (int i=0;i<8;i++) {
			System.out.print("    " + i);
		}
		//print the side border
		for (int i=0; i < 8; i++) {
			System.out.println("");
			
			if (i == 3) {
				System.out.print("X " + i + " ");
			} else {
				System.out.print("  " + i + " ");
			}
			// print the body of the board
			for (int r=0; r < 8; r++) {
				if (grid[i][r] != null) {
					System.out.print("[" + grid[i][r].display + "]");
					
				} else {
					System.out.print("[   ]");
					
				}
			}
			// print the right side border
			if (i == 3) {
				System.out.print(" " + i + " X");
			} else {
				System.out.print(" " + i);
			}
		}
		//print the bottom border
		System.out.println("");
		System.out.print("  ");
		for (int i=0;i<8;i++) {
			System.out.print("    " + i);
		}
		System.out.println("");
		System.out.println("                          Y");
	} // close method

	/**
	 * Controls the main game loops.
	 * Player 1 has a turn, then player 2, 
	 * then the game asks if the players would like to continue playing.
	 */
	public void playGame() {
		
		while (keepPlaying == true) {
			
			//player 1's turn
			do {
				do {
					System.out.print("\n Player1: ");
					// player types the name of the piece they want
					// store that in the active piece
					theActivePiece = player1.selectPieceToMove();
					// check to see if the active piece is able to move
					pieceIsAbleToMove = player1.canThePieceMove(theActivePiece);			
				} while(pieceIsAbleToMove == false);
				
				if(player1.ableToCastle) {
					castle(theActivePiece);
				} else {
					player1.movePiece(theActivePiece);
					if (player1.promotionNeeded) {
						promotion(theActivePiece);
					}
				}
				alertPlayerOfCheck();
			} while (player1.playerChangedTheirMind);
			if (player1.pieceWasKilledThisTurn) {
				// pass the victim piece's current coords into the method
				// currently, the attacker and the victim have the same coords
				playerKillsAPiece(grid[theActivePiece.xCurrentPlace][theActivePiece.yCurrentPlace]);
				player1.pieceWasKilledThisTurn = false;
			}
			gameBoardRefresh();
			
			
			//player 2's turn
			do {
				do {
					System.out.print("\n Player2: ");
					theActivePiece = player2.selectPieceToMove();
					pieceIsAbleToMove = player2.canThePieceMove(theActivePiece);			
				} while(pieceIsAbleToMove == false);
				
				if(player2.ableToCastle) {
					castle(theActivePiece);
				} else {
					player2.movePiece(theActivePiece);
					if (player2.promotionNeeded) {
						promotion(theActivePiece);
					}
				}
				alertPlayerOfCheck();
			} while (player2.playerChangedTheirMind);
			if (player2.pieceWasKilledThisTurn) {
				playerKillsAPiece(grid[theActivePiece.xCurrentPlace][theActivePiece.yCurrentPlace]);
				player2.pieceWasKilledThisTurn = false;
			}
			gameBoardRefresh();
			
			moveCounter++;
			if (moveCounter == 24) {
				System.out.println("Each player has one last move before stalemate.");
			}
			if (moveCounter == 25) {
				System.out.println("Stalemate!!");
				keepPlaying = false;
			}
			
			// keep playing the game?
			userInput = gameHelp.getUserAns("\nDo you want to keep playing? y/n");
			if (userInput.equals("n") || userInput.equals("N")) {
				keepPlaying = false;
			} else if (userInput.equals("y") || userInput.equals("Y")) {
				keepPlaying = true;
			}
		} // close while
	} // close method
	
	/**
	 * Sets the victim piece's <code>isAlive</code> to false.
	 * If the victim piece is a king, end the game.
	 * 
	 * @param murderedPiece		<code>theActivePiece</code> is used for this because at the time, both the attacker and
	 * 							the victim have the same x and y coordinates. The difference is that the victim is in the
	 * 							correct x and y grid space while the attacker is not yet stored in that space.
	 * 							Once <code>gameBoardRefresh()</code> is called, the victim will be not be stored in the grid location
	 * 							and the attacker will.
	 */
	public void playerKillsAPiece(Piece murderedPiece) {
		//if the victim is player2
		if (grid[murderedPiece.xCurrentPlace][murderedPiece.yCurrentPlace].owner.equals("player2")) {
			for(Piece pc:player2.pieces) {
				// if the opposing piece's coords match the murdered piece's coords
				// change the murdered piece's status to NOT ALIVE
				if(pc.xCurrentPlace == murderedPiece.xCurrentPlace && pc.yCurrentPlace == murderedPiece.yCurrentPlace) {
					pc.isAlive = false;
					//if the king was taken, end the game
					if(pc instanceof King) {
						keepPlaying = false;
					}
				}
			}
		//if the victim is player1
		} else {
			for(Piece pc:player1.pieces) {
				// if the opposing piece's coords match the murdered piece's coords
				// change the murdered piece's status to NOT ALIVE
				if(pc.xCurrentPlace == murderedPiece.xCurrentPlace && pc.yCurrentPlace == murderedPiece.yCurrentPlace) {
					pc.isAlive = false;
					//if the king was taken, end the game
					if(pc instanceof King) {
						keepPlaying = false;
					}
				}
			}
		}
		
	} // close method
	
	/**
	 * Asks the player if they want to castle,
	 * creates an ArrayList of the rooks that are able to castle,
	 * lets the player choose which pawn to castle with,
	 * makes the <code>kingToCastle</code> and chosen rook grid location null,
	 * resets the <code>kingToCastle</code> and chosen rook's x coordinates to their new locations.
	 * 
	 * @param kingToCastle		Check in <code>Player.canThePieceMove(Piece t)</code> if <code>theActivePiece</code> is a king
	 * 							and if it can castle. If yes, then <code>theActivePiece</code> if passed as this parameter.
	 */
	public void castle(Piece kingToCastle) {
		ArrayList<Piece> rooksThatCanCastle = new ArrayList<Piece>();
		//player1
		if (kingToCastle.owner.equals("player1")) {
			userInput = gameHelp.getUserAns("Would you like to castle? y/n");
			if (userInput.equals("y") || userInput.equals("Y")) {
				System.out.print("You can castle with: ");
				for (Piece p:player1.pieces) {
					if (p instanceof Rook) {
						if (p.hasMoved == false) {
							//if it is rooka
							if (p.name.equals("rooka")) {
								if (Game.grid[p.xStartingPlace+1][p.yStartingPlace] == null && Game.grid[p.xStartingPlace+2][p.yStartingPlace] == null && Game.grid[p.xStartingPlace+3][p.yStartingPlace] == null) {
									System.out.print(p.name + " ");
									rooksThatCanCastle.add(p);
								}
							}
							//if it is rookb
							if (p.name.equals("rookb")) {
								if (Game.grid[p.xStartingPlace-1][p.yStartingPlace] == null && Game.grid[p.xStartingPlace-2][p.yStartingPlace] == null) {
									System.out.print(p.name + " ");
									rooksThatCanCastle.add(p);
								}
							}
						}
					}
				}
				userInput = gameHelp.getUserAns("\nType the rook you want to switch with.");
				for(Piece r:rooksThatCanCastle) {
					if (userInput.equals(r.name)) {
						// if they castle with rooka
						if (r.name.equals("rooka")) {
							grid[kingToCastle.xCurrentPlace][kingToCastle.yCurrentPlace] = null;
							grid[r.xCurrentPlace][r.yCurrentPlace] = null;
							kingToCastle.xCurrentPlace -= 3;
							r.xCurrentPlace += 2;

							player1.playerChangedTheirMind = false;
							break;
						}
						// if they castle with rookb
						if (r.name.equals("rookb")) {
							grid[kingToCastle.xCurrentPlace][kingToCastle.yCurrentPlace] = null;
							grid[r.xCurrentPlace][r.yCurrentPlace] = null;
							kingToCastle.xCurrentPlace += 2;
							r.xCurrentPlace -= 2;
							
							player1.playerChangedTheirMind = false;
							break;
						}
					} else {
						player1.playerChangedTheirMind = true;
					}
				}
			} else {
				// if player types something other than "y" 
				// send them back to choosing a piece
				player1.playerChangedTheirMind = true;
			}
		//player2
		} else {
			userInput = gameHelp.getUserAns("Would you like to castle? y/n");
			if (userInput.equals("y") || userInput.equals("Y")) {
				System.out.print("You can castle with: ");
				for (Piece p:player2.pieces) {
					if (p instanceof Rook) {
						if (p.hasMoved == false) {
							//if it is rooka
							if (p.name.equals("rooka")) {
								if (Game.grid[p.xStartingPlace+1][p.yStartingPlace] == null && Game.grid[p.xStartingPlace+2][p.yStartingPlace] == null && Game.grid[p.xStartingPlace+3][p.yStartingPlace] == null) {
									System.out.print(p.name + " ");
									rooksThatCanCastle.add(p);
								}
							}
							//if it is rookb
							if (p.name.equals("rookb")) {
								if (Game.grid[p.xStartingPlace-1][p.yStartingPlace] == null && Game.grid[p.xStartingPlace-2][p.yStartingPlace] == null) {
									System.out.print(p.name + " ");
									rooksThatCanCastle.add(p);
								}
							}
						}
					}
				}
				userInput = gameHelp.getUserAns("\n Type the rook you want to switch with.");
				for(Piece r:rooksThatCanCastle) {
					if (userInput.equals(r.name)) {
						// if they castle with rooka
						if (r.name.equals("rooka")) {
							grid[kingToCastle.xCurrentPlace][kingToCastle.yCurrentPlace] = null;
							grid[r.xCurrentPlace][r.yCurrentPlace] = null;
							kingToCastle.xCurrentPlace -= 3;
							r.xCurrentPlace += 2;

							player1.playerChangedTheirMind = false;
							break;
						}
						// if they castle with rookb
						if (r.name.equals("rookb")) {
							grid[kingToCastle.xCurrentPlace][kingToCastle.yCurrentPlace] = null;
							grid[r.xCurrentPlace][r.yCurrentPlace] = null;
							kingToCastle.xCurrentPlace += 2;
							r.xCurrentPlace -= 2;
							
							player1.playerChangedTheirMind = false;
							break;
						}
					} else {
						player2.playerChangedTheirMind = true;
					}
				}
			} else {
				player2.playerChangedTheirMind = true;
			}
		}
	}
	
	
	/**
	 * Asks the player if they want to promote their pawn,
	 * sets the <code>pawnToPromote</code>'s <code>wasPromoted</code> to true, so that it
	 * will not be printed by the <code>gameBoardRefresh()</code>,
	 * asks what piece they would like to promote to,
	 * creates the respective piece object and places it on the
	 * <code>pawnToPromote</code>'s current x and y coordinates
	 * 
	 * @param pawnToPromote		if the the piece from <code>Player.movePiece()</code> is a Pawn and if it
	 * 							moves into an edge of the board, <code>theActivePiece</code> is passed as 
	 * 							this parameter.
	 */
	public void promotion(Piece pawnToPromote) {
		//player1
		if (pawnToPromote.owner.equals("player1")) {
			userInput = gameHelp.getUserAns("Promote your pawn? y/n ");
			if (userInput.equals("Y") || userInput.equals("y")) {
				pawnToPromote.wasPromoted = true;
				
				userInput = gameHelp.getUserAns("Promote to queen, knight, rook, or bishop? q/k/r/b");
				if (userInput.equals("q")) {
					Queen player1queenNew = new Queen(pawnToPromote.xCurrentPlace, pawnToPromote.yCurrentPlace,"*","player1");
					player1.pieces.add(player1queenNew);
				} else if (userInput.equals("k")) {
					Knight player1knightNew = new Knight(pawnToPromote.xCurrentPlace, pawnToPromote.yCurrentPlace,"*","player1");
					player1.pieces.add(player1knightNew);
				} else if (userInput.equals("r")) {
					Rook player1rookNew = new Rook(pawnToPromote.xCurrentPlace, pawnToPromote.yCurrentPlace,"*", "player1");
					player1.pieces.add(player1rookNew);
				} else if (userInput.equals("b")) {
					Bishop player1bishopNew = new Bishop(pawnToPromote.xCurrentPlace, pawnToPromote.yCurrentPlace,"*","player1");
					player1.pieces.add(player1bishopNew);
				}
				
			} else {
				player1.playerChangedTheirMind = true;
			}
		//player2
		} else {
			userInput = gameHelp.getUserAns("Promote your pawn? y/n ");
			if (userInput.equals("Y") || userInput.equals("y")) {
				pawnToPromote.wasPromoted = true;
				
				userInput = gameHelp.getUserAns("Promote to queen, knight, rook, or bishop? q/k/r/b");
				if (userInput.equals("q")) {
					Queen player2queenNew = new Queen(pawnToPromote.xCurrentPlace, pawnToPromote.yCurrentPlace,"*","player2");
					player2queenNew.wasPromoted = true;
					player1.pieces.add(player2queenNew);
				} else if (userInput.equals("k")) {
					Knight player2knightNew = new Knight(pawnToPromote.xCurrentPlace, pawnToPromote.yCurrentPlace,"*","player2");
					player2knightNew.wasPromoted = true;
					player2.pieces.add(player2knightNew);
				} else if (userInput.equals("r")) {
					Rook player2rookNew = new Rook(pawnToPromote.xCurrentPlace, pawnToPromote.yCurrentPlace,"*", "player2");
					player2rookNew.wasPromoted = true;
					player2.pieces.add(player2rookNew);
				} else if (userInput.equals("b")) {
					Bishop player2bishopNew = new Bishop(pawnToPromote.xCurrentPlace, pawnToPromote.yCurrentPlace,"*","player2");
					player2bishopNew.wasPromoted = true;
					player2.pieces.add(player2bishopNew);
				}
			} else {
				player2.playerChangedTheirMind = true;
			}
		}
	}
	
	
	/**
	 * Cycles through all of the enemies living pieces,
	 * finds out if any of their possible moves contains a King,
	 * alerts the correct player that they are in check.
	 * 
	 */
	public void alertPlayerOfCheck() {
		ArrayList<Location> allLivingPiecesPossibleMoves = new ArrayList<Location>();
		
		if(theActivePiece.owner.equals("player1")) {
			for(Piece p:player2.pieces) {
				if (p.isAlive == true && p.wasPromoted == false) {
					allLivingPiecesPossibleMoves.addAll(p.calculatePossibleMoves(p.xCurrentPlace, p.yCurrentPlace));
				}
			}
		} else {
			for(Piece p:player1.pieces) {
				if (p.isAlive == true && p.wasPromoted == false) {
					allLivingPiecesPossibleMoves.addAll(p.calculatePossibleMoves(p.xCurrentPlace, p.yCurrentPlace));
				}
			}
		}
		
		
		for(Location loc:allLivingPiecesPossibleMoves) {
			if(grid[loc.x][loc.y] instanceof King) {
				if(grid[loc.x][loc.y].owner.equals("player1")) {
					System.out.println("Player 1 is in check!!");
					break;
				} else {
					System.out.println("Player 2 is in check!!");
					break;
				}
				
			}
		}
	}
	
	/**
	 * Prints each player's pieces that are dead or promoted.
	 */
	public void endGame() {
		System.out.println("Player 1's cemetary:");
		for (Piece pies:player1.pieces) {
			if (pies.isAlive == false) {
				System.out.print(pies.display + " ");
			}
		}
		for (Piece pies:player1.pieces) {
			if (pies.wasPromoted == true) {
				System.out.println("Promoted -> " + pies.display);
			}
		}
		System.out.println("\nPlayer 2's cemetary:");
		for (Piece pies:player2.pieces) {
			if (pies.isAlive == false) {
				System.out.print(pies.display + " ");
			}
		}
		for (Piece pies:player2.pieces) {
			if (pies.wasPromoted == true) {
				System.out.println("Promoted -> " + pies.display);
			}
		}
		
		System.out.println("\nThanks for playing!");
	}
	
}
