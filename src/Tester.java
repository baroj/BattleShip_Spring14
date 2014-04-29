

public class Tester{

    public static void main(String[] arg) {

    	
    	BattleShipGame newGame;
    	ExitMenu exit;
        StartMenu start = new StartMenu();
        
        do{	
    		start.displayMenu();
    	}while(!start.close && !start.play);  
        start.disableMenu();
        
        //Only enter game play if user selects Play on Start Menu
        if(start.play){
          
        //while user chooses to continue playing
        	do{
        		newGame = new BattleShipGame(start.getSkill());
        		newGame.playGame();
        	
        		exit = new ExitMenu(newGame.getWinner());
        	
        		//Once game play has ended - display exit menu
        		do{	       			
        			exit.displayMenu();
        		}while(!exit.close && !exit.play);
        		exit.disableMenu();
        		newGame.closeOldGame();
        
        		//if user selects Play Again in exit menu - new game will start	
        	}while(exit.play);
        
        	
        }
        
        System.exit(0);	//force close any threads left running
    }

}
