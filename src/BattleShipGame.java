import java.util.Random;

/**
 * Constructs Battle Ship game and handles all game options.
 */
public class BattleShipGame {

	/**
	 * Construct game boards and players accordingly.
	 * @param skill The skill level to be applied to Computer Player AI
	 */
	public BattleShipGame(int skill){
		//Randomly determine who goes first (as if coin flip)
		generator = new Random();
		takeTurns = generator.nextBoolean();
		
		//Initialize two boards and apply to GUI
		compBoard = new Board(boardSize);
		userBoard = new Board(boardSize);
        gui = new BattleShipGUI(userBoard, compBoard);
        
        //Create Ship object to generate ships and place them on the map
        shipGenerator = Ship.getInstance();
		shipGenerator.createShips(userBoard);	
		shipGenerator.createShips(compBoard);
		
		//Update BSButton status' with ship locations
		userBoard.syncButtons(gui.getUserButtons());
		
		//Update GUIs with ships
		gui.updateUserGUI();
		gui.updateCompGUI();
		
		//Construct Player Objects
		user = new UserPlayer();				
        comp = new AIPlayer(skill);		 

	}


	/**
	 * Take turns firing until there is a winner.
	 */
	public void playGame(){    
		gui.displayGUI();
		
		while ((user.getHitCount(compBoard) < shipGenerator.hitsRequired()) &&	//while there is no winner!
        		(comp.getHitCount(userBoard) < shipGenerator.hitsRequired())){	//PLAY BATTLESHIP!
			
        	if(takeTurns){	//USER'S TURN
        		gui.setTurn(true);          	
            	while(gui.getTurn()){
            		try {
            		    Thread.sleep(750);	
            		} catch(InterruptedException ex) {
            		    Thread.currentThread().interrupt();
            		}
            		System.out.println("Waiting on User...");
            	}           	
            	userBoard.syncBoard(gui.getUserButtons());
            	gui.updateUserGUI();
            }
        	
            else{			//COMPUTER'S TURN							
            	comp.playerFire(compBoard);				//computer selects shot
            	gui.updateCompGUI();
            }
            //Once a player has gone, switch whose turn it is
            takeTurns = !takeTurns;
        }


	}


	/**
	 * Display end of game results.
	 */
	public String getWinner(){
		if(user.getHitCount(userBoard) < comp.getHitCount(compBoard)){
			return "Computer Wins!!! Computer fired " + comp.getShotsFired(compBoard) + " shots!";
		}
		else{
			return "You Win!!! You fired " + user.getShotsFired(userBoard) + " shots!";
			
		}
	}


	public void closeOldGame(){
		gui.closeGUI();
	}
	
	public Board compBoard;
	public Board userBoard;
	private BattleShipGUI gui;
	private Boolean takeTurns;
	private UserPlayer user;
	private AIPlayer comp;
	private final int boardSize = 8;
	private Random generator;
	private Ship shipGenerator;
}
