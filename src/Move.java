//Justin Johnson
//April 12, 2014


/**
 * Class for handling moves. 
 * @author Jonathan and Justin
 *
 */
public class Move {

	/**
	 * Construct move and assign coordinates.
	 * @param r Row
	 * @param c Column
	 */
	public Move(int r, int c){
		row = r;
		col = c;
	}

	/**
	 * Get row.
	 * @return Row.
	 */
	public int getRow(){
		return row;
	}

	/**
	 * Get column.
	 * @return Column.
	 */
	public int getCol(){
		return col;
	}

	/**
	 * Set value of x-coordinate.
	 * @param r New value for row.
	 */
	public void setRow(int r){
		row = r;
	}

	/**
	 * Set value of y-coordinate.
	 * @param c New value for column.
	 */
	public void setCol(int c){
		col = c;
	}

	/**
	 * Convert r and c coordinates to a string with structure : "row, column"
	 */
	public String toString(){
		return (row + 1) + ", " + (col + 1);
	}

	/**
	 * Check to see if this move's coordinates is directly above Move 'other'.
	 * @param other Move being compared with.
	 * @return True if this move's coordinates is directly above Move 'other'.
	 */
	public Boolean isNorth(Move other){
		if((this.getCol() == other.getCol()) && (this.getRow() == (other.getRow()-1))){
			return true;
		}
		else{
			return false;
		}
	}

	/**
	 * Check to see if this move's coordinates is directly below Move 'other'.
	 * @param other Move being compared with.
	 * @return True if this move's coordinates is directly below Move 'other'.
	 */
	public Boolean isSouth(Move other){
		if((this.getCol() == other.getCol()) && (this.getRow() == (other.getRow()+1))){
			return true;
		}
		else{
			return false;
		}
	}

	/**
	 * Check to see if this move's coordinates is directly to right of Move 'other'.
	 * @param other Move being compared with.
	 * @return True if this move's coordinates is directly to right of Move 'other'.
	 */
	public Boolean isEast(Move other){
		if((this.getRow() == other.getRow()) && (this.getCol() == (other.getCol()+1))){
			return true;
		}
		else{
			return false;
		}
	}

	/**
	 * Check to see if this move's coordinates is directly to left of Move 'other'.
	 * @param other Move being compared with.
	 * @return True if this move's coordinates is directly to left of Move 'other'.
	 */
	public Boolean isWest(Move other){
		if((this.getRow() == other.getRow()) && (this.getCol() == (other.getCol()-1))){
			return true;
		}
		else{
			return false;
		}
	}

	/**
	 * Check to see if this coordinate is a ship hit.
	 * @param board The game board being checked for a ship hit.
	 * @return True if move coordinate is a hit.
	 */
	public Boolean isHit(Board board){
		if(board.grid[this.getRow()][this.getCol()] == 3){
			return true;
		}
		else{
			return false;
		}
	}
	
	/**
	 * Check to see if this coordinate is a a miss shot.
	 * @param board The game board being checked for a missed shot..
	 * @return True if move coordinate is a missed shot.
	 */
	public Boolean isMiss(Board board){
		if(board.grid[this.getRow()][this.getCol()] == 2){
			return true;
		}
		else{
			return false;
		}
	}

	/**
	 * Check to see if this Move is a valid move.
	 * @param board Board being checked for validity.
	 * @return True if current coordinate is not already fired upon and is valid coordinate on grid.
	 */
	public Boolean isValidMove(Board board){
		int col = this.getCol();
		int row = this.getRow();
		//if move is outside of the grid size - is not valid
		if((col < 0) || (col > Board.getSize()-1) || (row < 0) || (row > Board.getSize()-1)){	
			System.out.println("Invalid Move Detected\nStay Within Grid!"); 
			return false;															
		}
		//else if coordinate contains miss or hit - computer has already shot here
		else if(this.isMiss(board) || this.isHit(board)){
			System.out.println("Invalid Move Detected\nAlready shot here!"); 
			return false;
		}
		//else coordinate is a valid move
		else{
			System.out.println("Valid Move Detected");
			return true;
		}
		
	}
	

	

	private int row;
	private int col;
}
