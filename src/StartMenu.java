import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;


public class StartMenu extends Menu{

	/**
	 * Initialize start menu fields.
	 */
	public StartMenu(){
		menu.setTitle("COP4331 Spring '14 - Battle Ship!");
		
		//startGame JButton will begin a new game
		startEasyGame = new JButton("Start Easy Game");
		startEasyGame.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				setSkill(0);
				play = true;
			}
		});
		
		startAdvancedGame = new JButton("Start Advanced Game");
		startAdvancedGame.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				setSkill(1);
				play = true;
			}
		});
		
			
		//exitGame JButton will end the program
		exitGame = new JButton("Exit Game");
		exitGame.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				close = true;
			}
		});
		
		menu.add(startEasyGame);
		menu.add(startAdvancedGame);
		menu.add(exitGame);		
	}
	
	/**
	 * Sets the skill level for computer's AI.
	 * @param skill 
	 */
	public void setSkill(int skill){
		skillSelection = skill;
	}
	
	/**
	 * 
	 * @return The computer's AI skill level.
	 */
	public int getSkill(){
		return skillSelection;
	}
	
	
	private int skillSelection;
	private JButton exitGame;
	private JButton startEasyGame;
	private JButton startAdvancedGame;
	
}
	

