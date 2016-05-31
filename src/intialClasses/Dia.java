package intialClasses;

import java.awt.Dialog;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;


/**
 * A specialized Dialog used to display a certain message.
 * @author Thomas Wrona
 *
 */
public class Dia extends Dialog implements WindowListener{
	/**
	 * @param f The parent frame of this Dia.
	 * @param s The window label of this Dia.
	 * @param labelText The text to be displayed in this Dia.
	 */
	public Dia(Frame f,String s,String labelText){
		super(f,s);
		add(new Label(labelText));
		pack();
		addWindowListener(this);
		setVisible(true);
	}

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent arg0) {

	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		setVisible(false);
		
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
