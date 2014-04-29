import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;


public class ExitMenu extends Menu {

	/**
	 * Initialize values for Exit Menu.
	 * @param winner String displaying the winner of the game.
	 */
	public ExitMenu(String winner){		
		
		menu.setTitle("Game Over!");
		
		//TextField will display winner information
		Label label = new Label(winner);
		
		
		//Exit Button will close game
		exit = new JButton("Exit Game");
		exit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				play = false;	
				close = true;
				menu.setVisible(false);
			}
		});
		
		//Play Again button will start a new game
		playAgain = new JButton("Play Again");
		playAgain.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				play = true;
				close = false;
				menu.setVisible(false);
			}
		});
		
		//add components to JFrame
		menu.add(label);
		menu.add(playAgain);
		menu.add(exit);
		
	}
	

	
	private JButton exit;
	private JButton playAgain;
	
	
}
	

