/**
 * Abstract Player class containing common member methods and fields to all Battle Ship players.
 */
public abstract class Player{
	
	/**
	 * Initialize all Player fields.
	 */
	public Player(){
		fireAgain = false;	//can be used to adjust game settings, allowing player to shoot until missing
		prevMove = new Move(0, 0);	
		prevMove2 = new Move(0, 0);
		nextMove = new Move(0, 0);
	}
	
	
	/**
	 * Get next move from player, check validity of next move, and handle move appropriately.
	 * @param board Game board that the user is firing at.
	 */
    public abstract void playerFire(Board board);
       
    /**
     * Sends update to board's grid and increments player's hit counter and shotsFired counter accordingly.
     * @param board Game board shot is being placed on.
     * @param nextMove Coordinates of move being placed on grid.
     */
    public void placeShot(Board board, Move nextMove){
		 board.updateGrid(nextMove);
		 prevMove2 = prevMove;
		 prevMove = nextMove;					
		 fireAgain = false;
    }
    
    /**
     * @return Total number of hits on ships.
     */
    public int getHitCount(Board board){
    	int hits = 0;
    	for(int r = 0; r < Board.getSize(); r++){
    		for(int c = 0; c < Board.getSize(); c++){
    			if(board.grid[r][c] == 3){
    				hits++;
    			}
    		}
    	}
    	return hits;
    }
    
    
    /**
     * 
     * @return Total number of shots fired by player.
     */
    public int getShotsFired(Board board){
    	int shotsFired = 0;
    	for(int r = 0; r < Board.getSize(); r++){
    		for(int c = 0; c < Board.getSize(); c++){
    			if(board.grid[r][c] == 3 || board.grid[r][c] == 2){
    				shotsFired++;
    			}
    		}
    	}
    	return shotsFired;
    }
    
    
    public Move prevMove;
    public Move prevMove2;
    public Move nextMove;
	public boolean fireAgain;		

}

