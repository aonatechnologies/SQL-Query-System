package intialClasses;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

public class ValueGetter extends Dialog implements ActionListener{
	private int value;
	private Button ok;
	private JTextField input;
	private boolean conv;
	private TGMenu myTGM;
	public ValueGetter(Frame f, String label,TGMenu tgm){
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
		this.myTGM=tgm;
	}
	public void displayText(String s){
		input.setText(s);
		input.setEnabled(false);
		conv = true;
	}
	public void conevert(){
		input.setText("Test made!");
		input.setEnabled(false);
		conv = true;
	}
	public int getValue(){
		return value;
	}
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
