import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * Class is responsible for constructing two maps and populating them with appropriate data.
 * Class contains methods for updating GUI with new map data.
 */
public class BattleShipGUI {
	
	/**
	 * Constructor initializes all GUI fields.
	 * @param user Board object containing user's data.
	 * @param comp Board object containing computer's data.
	 */
	public BattleShipGUI(Board user, Board comp){
		myTurn = false;	
		userBoard = user;
		compBoard = comp;
		userButtons = new BSButton[Board.getSize()][Board.getSize()];
		compButtons = new BSButton[Board.getSize()][Board.getSize()];
		b = new Border();
		border = new JLabel[Board.getSize()];
		gameBoard = new JFrame("Battle Ship!");
		gameBoard.setBounds(400,75,400,650);
		gameBoard.setResizable(false);
		gameBoard.setLayout(new GridLayout(17,8));
		gameBoard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
		
		//draw user grid
		for(int r = 0; r < Board.getSize(); r++){
			for(int c = 0; c < Board.getSize(); c++){
				userButtons[r][c] = new BSButton();
				userButtons[r][c].setIcon(new javax.swing.ImageIcon(getClass().getResource("Water.gif")));
				userButtons[r][c].addActionListener(new ActionListener(){	
					public void actionPerformed(ActionEvent e){
						while(((BSButton) e.getSource()).isValidMove()){	//while button clicked is valid move													
							if(((BSButton) e.getSource()).getStatus() == 0){
								((BSButton) e.getSource()).setStatus(2);
							}
							else if(((BSButton) e.getSource()).getStatus() == 1){
								((BSButton) e.getSource()).setStatus(3);							
							}	
							setTurn(false);
						}				
					}
				});				
				gameBoard.add(userButtons[r][c]);
			}
		}

		//draw border
		for(int i = 0; i < Board.getSize(); i++){
			border[i] = new JLabel(b);
			gameBoard.add(border[i]);
		}
		
		//draw computer grid
		for(int r = 0; r < Board.getSize(); r++){
			for(int c = 0; c < Board.getSize(); c++){
				compButtons[r][c] = new BSButton();
				compButtons[r][c].setIcon(new javax.swing.ImageIcon(getClass().getResource("Water.gif")));
				gameBoard.add(compButtons[r][c]);
			}
		}
	}

	
	/**
	 * Check user's map for any new hits or misses and update GUI accordingly.
	 */
	public void updateUserGUI(){
		for(int r = 0; r < Board.getSize(); r++){
			for(int c = 0; c < Board.getSize(); c++){
				if(userBoard.grid[r][c] == 2){
					userButtons[r][c].setIcon(new javax.swing.ImageIcon(getClass().getResource("Miss.gif")));
				}
				else if(userBoard.grid[r][c] == 3){
					userButtons[r][c].setIcon(new javax.swing.ImageIcon(getClass().getResource("Hit.gif")));
				}
			}
		}
		
	}
	
	
	/**
	 * Check computer's map for any new hits or misses and update GUI accordingly.
	 */
	public void updateCompGUI(){
		for(int r = 0; r < Board.getSize(); r++){
			for(int c = 0; c < Board.getSize(); c++){
				if(compBoard.grid[r][c] == 1){
					compButtons[r][c].setIcon(new javax.swing.ImageIcon(getClass().getResource("Ship.gif")));
				}
				else if(compBoard.grid[r][c] == 2){
					compButtons[r][c].setIcon(new javax.swing.ImageIcon(getClass().getResource("Miss.gif")));
				}
				else if(compBoard.grid[r][c] == 3){
					compButtons[r][c].setIcon(new javax.swing.ImageIcon(getClass().getResource("Hit.gif")));
				}
			}
		}
	}
	
	/**
	 * Make GUI visible
	 */
	public void displayGUI(){
		gameBoard.setVisible(true);
	}
	
	/**
	 * Closes GUI.
	 */
	public void closeGUI(){
		gameBoard.setVisible(false);
		gameBoard.getDefaultCloseOperation();
	}
	
	/**
	 * Change turns to turn off action listener.
	 */
	public void setTurn(Boolean n){
		myTurn = n;
	}
	
	public boolean getTurn(){
		return myTurn;
	}
	
	/**
	 * 
	 * @return 2D array of BSButtons.
	 */
	public BSButton[][] getUserButtons(){
		return userButtons;	
	}
	
	
	private boolean myTurn;
	private Border b;
	private Board userBoard;
	private Board compBoard;
	private BSButton[][] userButtons;
	private BSButton[][] compButtons;
	private JLabel[] border;
	private JFrame gameBoard;
}
