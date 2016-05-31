package intialClasses;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * An ActionListener used for the purpose of closing a specific menu on ActionEvent.
 * @author Thomas Wrona
 *
 */
public class CM implements ActionListener {
	private Frame menu;
	/**
	 * @param men The menu to be closed on an action event
	 */
	public CM(Frame men){
		menu=men;
	}
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {
		menu.setVisible(false);

	}

}
