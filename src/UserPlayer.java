
import java.util.Scanner;

/**
 * Handles all User moves and data.
 */
public class UserPlayer extends Player{
		
	/**
	 * Construct new player object and initialize values.
	 */
	public UserPlayer(){
		input = new Scanner(System.in);
		row = -1;
		col = -1;
	}
	
	/**
	 * Get next move from user, check validity of next move, and update grid - console version.
	 * @param board Game board that the user is firing at.
	 */
	public void playerFire(Board board){
         fireAgain = true;
         while(fireAgain){
        	 
        	 //Get User's Input Coordinates
        	 do {    		 
        		 getUserRow();	 
        	 }while(!(row > 0 && row < (Board.getSize()+1)));		   		 											
        	 row--;		//Subtract 1 from row value because array index starts at 0
        	 nextMove.setRow(row);
        	 do {    		 
        		 getUserColumn();
        	 }while(!(col > 0 && col < (Board.getSize()+1)));		   		 											
        	 col--;		//Subtract 1 from column value because array index starts at 0 
        	 nextMove.setCol(col);
        	 
        	 //if user's next move is a valid move - update the grid and exit loop
        	 if(nextMove.isValidMove(board)){
        		 fireAgain = false;
        		 placeShot(board, nextMove);
        	 } 	 
         }
    }  

    
	   /**
     * Requests and stores a valid row from user input - console version.
     */
    public void getUserRow(){
   	 	System.out.println("Select a row to fire in (1 -> " + Board.getSize() + ") : ");
   	 	row = input.nextInt(); 	 	
    }
    
    
    /**
     * Requests and stores a valid column from user input - console version.
     */
    public void getUserColumn(){
    	 System.out.println("Select a column to fire in ((1 -> " + Board.getSize() + ") : ");
    	 col = input.nextInt();
    }
       
    
	private static Scanner input;
	private int row;
	private int col;
}

