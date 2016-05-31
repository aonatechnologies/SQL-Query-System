package intialClasses;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

/**
 * A specialized Dialog that obtains a value from the user. It can also be converted to display a line of text.
 * @author Jonah Tash
 *
 */
public class ValueGetter extends Dialog implements ActionListener{
	private int value;
	private Button ok;
	private JTextField input;
	private boolean conv;
	private TGMenu myTGM;
	
	/**
	 * This constructs a dialog with the given label on top of the given frame. It also adds an area to receive the user inputed value and a a button to submit it.
	 * 
	 * @param f The parent frame of this ValueGetter.
	 * @param label The label of the dialog window.
	 * 
	 */
	public ValueGetter(Frame f, String label){
		super(f,label);
		value = 69;
		ok = new Button("Ok");
		input = new JTextField();
		ok.setSize(100, 50);
		input.setSize(200,100);
		setSize(300,200);
		add(ok,BorderLayout.SOUTH);
		add(input);
		ok.addActionListener(this);
		conv = false;
	}
	/**
	 * Disables the {@link}TextField that is used to input a value and displays the given String in that {@link}TextField.
	 * @param s A string to be displayed.
	 */
	public void displayText(String s){
		input.setText(s);
		input.setEnabled(false);
		conv = true;
	}
	/**
	 * Used to display the message "Test made!" in the {@link}TextField used to input a value.
	 */
	public void conevert(){
		input.setText("Test made!");
		input.setEnabled(false);
		conv = true;
	}
	/**
	 * @return The value entered in into this ValueGetter after the submit button is pressed.
	 */
	public int getValue(){
		return value;
	}
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {
		if(conv){
			setVisible(false);
		}
		else{
			value = Integer.parseInt(input.getText());
			setVisible(false);

		}
		
	}
}
