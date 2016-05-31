package intialClasses;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * A specialized ActionListener used to open a TGMenu upon an ActionEvent.
 * @author Thomas Wrona
 *
 */
public class OpenTG implements ActionListener{
	private Frame myMenu;
	/**
	 * @param menu The TGMenu to become visible on an {@link}ActionEvent.
	 */
	public OpenTG(Frame menu){
		myMenu = menu;
	}
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent arg0) {
		myMenu.setVisible(true);
		
	}

}
