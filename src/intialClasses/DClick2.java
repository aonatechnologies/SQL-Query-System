package intialClasses;

import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


/**
 * A MouseListener that enables a given TextFiels on a MouseEvent.
 * @author Jonah Tash
 *
 */
public class DClick2 implements MouseListener {
	private TextField t1;
	/**
	 * @param tf1 The TextFiel to be enabled on a MouseEvent.
	 */
	public DClick2(TextField tf1){
		t1=tf1;

	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
	 */
	@Override
	public void mousePressed(MouseEvent arg0) {
		t1.setEditable(true);
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
