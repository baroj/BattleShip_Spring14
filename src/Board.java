/**
 * Board class contains all data regarding player moves and methods to handle the data.
 * Board class is the MODEL of the Model/View/Controller Architecture.
 */
public class Board{

	/**
	 * Constructs an empty game board.
	 * @param size Size of game board.
	 */
	public Board(int size) {
		boardSize = size;
		grid = new int[boardSize][boardSize];		
		for (int r = 0; r < boardSize; r++) {
			for (int c = 0; c < boardSize; c++) {
				grid[r][c] = 0;
			}
		}
	}


	/**
	 * Display board to console for debugging purposes.
	 */
	public void displayBoard() {
		for (int r = 0; r < boardSize; r++) {
			for (int c = 0; c < boardSize; c++) {
				if (grid[r][c] == 2){	//if field is a miss
					System.out.print(" M");
				}
				else if(grid[r][c] == 3){//if field is a hit
					System.out.print(" !");
				}
				else{
					System.out.print(" ~");
				}
			}
			System.out.println("");
		}
	}


	/**
	 * Prints game board to console with ship locations revealed, for debugging purposes.
	 */
	public void displayShips() {
		for (int r = 0; r < boardSize; r++) {
			for (int c = 0; c < boardSize; c++) {
				if(grid[r][c] == 1){
					System.out.println(" S");
				}
				else{
					System.out.println(" ~");
				}
			}
			System.out.println("");
		}
	}

	/**
	 * Updates Board's grid with a new move.
	 * @param move Move coordinates used to update grid.
	 */
	public void updateGrid(Move move){
		if(move.isValidMove(this)){
			if(grid[move.getRow()][move.getCol()] == 1){
				grid[move.getRow()][move.getCol()] = 3;
			}
			else{
				grid[move.getRow()][move.getCol()] = 2;
			}
		}
	}
	
	/**
	 * Update the Board's grid using the buttonStatus values.
	 * @param buttons
	 */
	public void syncBoard(BSButton[][] buttons){
		for(int r = 0; r < boardSize; r++){
			for(int c = 0; c < boardSize; c++){
				grid[r][c] = buttons[r][c].getStatus();
			}
		}	
	}
	
	/**
	 * Update 2D array of buttons' statuses using board's grid values.
	 * @param buttons 2D array of buttons being updated.
	 */
	public void syncButtons(BSButton[][] buttons){
		for(int r = 0; r < boardSize; r++){
			for(int c = 0; c < boardSize; c++){
				buttons[r][c].setStatus(grid[r][c]);
			}
		}	
	}

	/**
	 * Gets value of current board size.
	 * @return The size of current board.
	 */
	public static int getSize(){
		return boardSize;
	}

	
	public int[][] grid;
	private static int boardSize;
}
