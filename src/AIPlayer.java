/**
 * Constructs the computer user and handles computer moves.
 */
public class AIPlayer extends Player{

	/**
	 * Constructor creates computer player and initializes fields.
	 * @param s The skill level being applied to computer player.
	 */
	public AIPlayer(int s){
		skillLevel = s;
	
	}

	/**
	 * Calculates the next computer move based off chosen skill level and artificial intelligence.
	 * @param board The game board being fired on to.
	 */
	public void playerFire(Board board){
		
		//SKILL LEVEL BEGINNER - shot selections are random
		if(skillLevel==0){	
			nextMove = BSStrategy.getRandomMove();
			while(!nextMove.isValidMove(board)){
				nextMove = BSStrategy.getRandomMove();
			}
			placeShot(board, nextMove);
		}
		
		//SKILL LEVEL ADVANCED - computer utilizes battleship strategies
		else{
			
			if(getShotsFired(board) == 0){	//If first shot of game, select shot at random
				System.out.println("First shot of game.");
				nextMove = BSStrategy.getRandomMove();
				while(!nextMove.isValidMove(board)){
					nextMove = BSStrategy.getRandomMove();
				}
				placeShot(board, nextMove);
			}
			
			
			
			else{	//If not first shot of game - utilize battleship strategy
				
				//check previous hits for potential hit streak, choose next move based off previous hits
				switch(onStreak(board)){
					
					case 0:	//prevMove and prevMove2 are not hits
						//System.out.println("Case 0: No previous moves to work with.");
						while(!nextMove.isValidMove(board)){	//while move is not valid - get another move
							nextMove = BSStrategy.getRandomMove();
						}
						//System.out.println("Placing random shot: " + nextMove.toString());
						placeShot(board, nextMove);																				
						break;
						
					case 1: //prevMove is hit, prevMove2 is not a hit
						//System.out.println("prevMove.isHit: " + prevMove.toString());
						nextMove = BSStrategy.getLocalMove(prevMove, board);
						//if local move is a valid move - place it on the grid
						if(nextMove.isValidMove(board)){
							//System.out.println("nextMove.isValid: " + nextMove.toString());
							//System.out.println("Placing next local move: " + nextMove.toString());
							placeShot(board, nextMove);
						}
						else{
							//System.out.println("Local move not valid, return to random move.");
							while(!nextMove.isValidMove(board)){	//while move is not valid - get another move
								nextMove = BSStrategy.getRandomMove();
							}
							//System.out.println("Placing random shot: " + nextMove.toString());
							placeShot(board, nextMove);	
						}
						break;
						
						
					case 2:	//prevMove and prevMove2 are both hits
						//System.out.println("prevMove.isHit: " + prevMove.toString());
						//System.out.println(" && prevMove2.isHit: " + prevMove2.toString());
						nextMove = BSStrategy.continueStreak(prevMove, board, BSStrategy.getStreakDirection(prevMove, prevMove2));
						if(nextMove.isValidMove(board)){
							//System.out.println("nextMove.isValid: " + nextMove.toString());
							//System.out.println("Placing next local move: " + nextMove.toString());
							placeShot(board, nextMove);
						}
						else{
							nextMove = BSStrategy.continueStreak(prevMove2, board, BSStrategy.getStreakDirection(prevMove2, prevMove));
							if(nextMove.isValidMove(board)){
								//System.out.println("nextMove.isValid: " + nextMove.toString());
								//System.out.println("Placing next local move: " + nextMove.toString());
								placeShot(board,nextMove);
							}
							else{
								while(!nextMove.isValidMove(board)){	//while move is not valid - get another move
									nextMove = BSStrategy.getRandomMove();
								}
								//System.out.println("Placing random shot: " + nextMove.toString());
								placeShot(board, nextMove);	
							}
							
						}
						break;
						
					case 3:	//prevMove2 is hit, prevMove1 is not a hit	
						//System.out.println("prevMove2.isHit: " + prevMove2.toString());
						nextMove = BSStrategy.getLocalMove(prevMove2, board);
						//if local move is a valid move - place it on the grid
						if(nextMove.isValidMove(board)){
							//System.out.println("nextMove.isValid: " + nextMove.toString());
							//System.out.println("Placing next local move: " + nextMove.toString());
							placeShot(board,nextMove);
						}
						else{
							//System.out.println("Local move not valid, return to random move.");
							while(!nextMove.isValidMove(board)){	//while move is not valid - get another move
								nextMove = BSStrategy.getRandomMove();
							}
							//System.out.println("Placing random shot: " + nextMove.toString());
							placeShot(board, nextMove);	
						}
				
						break;
					default:
						System.out.println("Error selecting next move.");
				
				}
			}
		}
	}

    /**
     * 
     * @param board Game board being played on.
     * @return Integer value used to represent previous move hits.
     * 			1 = prevMove.isHit(board) && !prevMove2.isHit(board)
     * 			2 = prevMove.isHit(board) && prevMove2.isHit(board)
     * 			3 = prevMove2.isHit(board)
     * 			0 = No previous hits to work with.
     */
    private int onStreak(Board board){
    	if(prevMove.isHit(board) && !prevMove2.isHit(board)){
    		//System.out.println("prevMove.isHit(board) && !prevMove2.isHit(board)");
			return 1;
    	}
    	else if(prevMove.isHit(board) && prevMove2.isHit(board)){
    		//System.out.println("prevMove.isHit(board) && prevMove2.isHit(board)");
    		return 2;
    	}
    	else if(prevMove2.isHit(board)){	
    		//System.out.println("prevMove2.isHit(board) && !prevMove.isHit(board)");
    		return 3;
    	}
    	else{
    		//System.out.println("No previous hits to work with.");
    		return 0;
    	}
    }
    

    
	private int skillLevel;

}
