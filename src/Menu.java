import java.awt.FlowLayout;

import javax.swing.JFrame;

/**
 * Contains fields and methods related to all Menu Objects.

 */

public abstract class Menu {

	public Menu(){
		menu = new JFrame();
		menu.setBounds(250, 250, 260, 200);
		menu.setLayout(new FlowLayout(FlowLayout.CENTER));
		menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menu.setResizable(false);
		play = false;
		close = false;
	}
	
	public void displayMenu(){
		menu.setVisible(true);
	}
	
	public void disableMenu(){
		menu.setVisible(false);
	}
	
	public JFrame menu;
	public boolean play;
	public boolean close;
}
