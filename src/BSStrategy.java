import java.util.Random;

/**
 * Class containing methods for choosing battle ship moves with basic strategy.
 * @author justin
 *
 */
public class BSStrategy {

    /**
     * Generates a random Move.
     * @return Random move.
     */
    public static Move getRandomMove(){
    	Move randMove = new Move(generator.nextInt(Board.getSize()), 
    			generator.nextInt(Board.getSize()));
    	return randMove;
    }
	
	/**
	* Select a move that neighbors current move, return invalid Move if none are available.
	* @param move Coordinates being evaluated.
	* @param board Board being evaluated.
	* @return Returns a move that is directly North, South, East, or West of current Move.
	* @return Move(-1, -1) if there are no moves available North, South, East or West of current Move.
	*/
	public static Move getLocalMove(Move move, Board board){
	  int row = move.getRow();
	    	int col = move.getCol();
	    	Move localMove = new Move(row, col-1);	
	    	System.out.println("Trying localMove " + localMove.toString());
	    	if(localMove.isValidMove(board)){			//if West coordinate is valid - return
	    		System.out.println("returning local W: " + localMove.toString());
	    		return localMove;
	    	}
	    	else{
	    		localMove = new Move(row, col +1);
	        	System.out.println("Trying localMove " + localMove.toString());
	    		if(localMove.isValidMove(board)){		//else if East coordinate is valid - return
	    			System.out.println("Returning local E: " + localMove.toString());
	    			return localMove;
	    		}
	    		else{
	    			localMove = new Move (row-1, col);
	    	    	System.out.println("Trying localMove " + localMove.toString());
	    			if(localMove.isValidMove(board)){	//else if South coordinate is valid - return
	    				System.out.println("Returning local S: " + localMove.toString());
	    				return localMove;
	    			}
	    			else{
	    				localMove = new Move(row+1, col);
	    		    	System.out.println("Trying localMove " + localMove.toString());
	    				if(localMove.isValidMove(board)){//else if North coordinate is valid - return
	    					System.out.println("Returning local N: " + localMove.toString());
	    					return localMove;
	    				}
	    				else{
	    					localMove = new Move(-1, -1);//if no localMoves are valid - return an invalid move
	    					System.out.println("Returning Invalid Local Move: " + localMove.toString());
	    					return localMove;			//if invalid move is returned - there are no valid moves
	    				}								//available
	    			}
	    		}
	    	}  	
	    }
	
	
	/**
     * Continue streak is method used when computer has made multiple successful shots in a row.
     * Computer will traverse this path in search for the next valid move.
     * @param board Game board being fired on.
     * @param prevMove The previous move being used to determine the next move.
     * @param d The direction (UP,DOWN,RIGHT,LEFT) to traverse for next move.
     * @return The next move a long this path. Invalid move is returned if no cases match.
     */
    public static Move continueStreak(Move prevMove, Board board, int d){
    	System.out.println("In continueStreak()");
    	Move sMove;
    	switch (d){
    	case 1:			//Move up 1
    		sMove = new Move((prevMove.getRow()-1), prevMove.getCol());
    		System.out.println("Getting N move: "+ sMove.toString());
    		break;
    	case 2:			//Move down 1
    		sMove = new Move((prevMove.getRow()+1), prevMove.getCol());
    		System.out.println("Getting S move: "+ sMove.toString());

    		break;
    	case 3:			//Move right 1
    		sMove = new Move(prevMove.getRow(), (prevMove.getCol() +1));
    		System.out.println("Getting E move: "+ sMove.toString());

    		break;
    	case 4:			//Move left 1
    		sMove = new Move(prevMove.getRow(), (prevMove.getCol() -1));
    		System.out.println("Getting W move: "+ sMove.toString());
    		break;
		default:
			sMove = new Move(-1, -1);	//if all cases fail, set sMove to an invalid Move
    		System.out.println("Getting invalid move, direction 'd' does not match any cases."); 		
    	}
    	return sMove;
    }
	
    /**
     * Determine which direction to travel based off of the previous 2 moves made.
     * @param prev1 Last move made.
     * @param prev2	Move before last move made.
     * @return Integer value used to determine direction. (1 = North, 2 = South, 3 = East, 4 = West, 0 = No relation)
     */
    public static int getStreakDirection(Move prev1, Move prev2){
    	int direction;
    	if(prev1.isNorth(prev2)){
    		System.out.println("prev1 isNorth of prev2");
    		direction = 1;
    	}
    	else if(prev1.isSouth(prev2)){
    		System.out.println("prev1 isSouth of prev2");
    		direction = 2;
    	}
    	else if(prev1.isEast(prev2)){
    		System.out.println("prev1 isEast of prev2");

    		direction = 3;
    	}
    	else if(prev1.isWest(prev2)){
    		System.out.println("prev1 isWest of prev2");
    		direction = 4;
    	}
    	else{
    		direction = 0;
    	}
    	return direction;
    }
	    
    
    

   
	private static Random generator = new Random();
	
	
}
