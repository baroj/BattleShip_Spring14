import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.Icon;

/**
 * Class that constructs Rectangle Icon
 * @author justin
 *
 */
public class Border implements Icon {

	@Override
	public int getIconHeight() {
		return 100;
	}

	@Override
	public int getIconWidth() {
		return 200;
	}

	@Override
	public void paintIcon(Component c, Graphics g, int x, int y) {
		  Graphics2D g2 = (Graphics2D) g;
	      //Rectangle2D rect = new Rectangle2D.Double(60, 70, getIconHeight() , getIconWidth());
	      g2.setColor(Color.BLACK);
	      g2.fillRect(0, 0, getIconWidth(), getIconHeight());
	      
	}
	
	
	
}