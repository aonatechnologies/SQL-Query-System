package intialClasses;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CM implements ActionListener {
	private Frame menu;
	public CM(Frame men){
		menu=men;
	}
	public void actionPerformed(ActionEvent e) {
		menu.setVisible(false);

	}

}
