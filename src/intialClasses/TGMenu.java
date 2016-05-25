import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JOptionPane;


public class TGMenu extends Frame implements WindowListener, ActionListener{
	private int testCount;
	private TextField testC;
	public boolean Mult;
	public boolean Uin;
	private TextArea ta;
	private TextField tf2;
	private TextField tf3;
	private TextField tf4;
	private TextField tf5;
	private Panel top;
	public TGMenu(Frame topmenu){
		Mult=true;
		testCount =0;
		setLayout(new BorderLayout());
		Panel top = new Panel();
		top.setLayout(new FlowLayout());
		Panel MC = new Panel();
		add(MC, BorderLayout.WEST);
		MC.setLayout(new GridLayout(6,3));
		MC.add(new Label("Question:"));
		ta = new TextArea(2,45);
		MC.add(ta);
		Panel qtyp = new Panel();
		CheckboxGroup qtype = new CheckboxGroup();
		Checkbox c1 =new Checkbox("Multiple Choice", qtype, true);

		qtyp.add(c1);
		Checkbox c2 = new Checkbox("Free Response", qtype, false);

		qtyp.add(c2);
		MC.add(qtyp);
		MC.add(new Label("Correct Answer:"));
		tf2 = new TextField();
		MC.add(tf2);
		MC.add(new Label(""));
		MC.add(new Label("Incorrect Answer:"));
		tf3 = new TextField();
		MC.add(tf3);
		Panel atype = new Panel();
		atype.setLayout(new  GridLayout(3,2));
		atype.add(new Label("Incorrect Answer Generation"));
		atype.add(new Label(""));
		CheckboxGroup at = new CheckboxGroup();
		Checkbox a1 = new Checkbox("User input",at,true);
		atype.add(a1);
		Checkbox a2 = new Checkbox("Permutation of correct answer",at,false);
		atype.add(a2);
		Checkbox a3 = new Checkbox("Random string",at,false);
		atype.add(a3);
		Checkbox a4 = new Checkbox("Random integer",at,false);
		atype.add(a4);
		atype.setVisible(true);
		MC.add(atype);
		MC.add(new Label("Incorrect Answer:"));
		tf4 = new TextField();
		MC.add(tf4);
		MC.add(new Label(""));
		MC.add(new Label("Incorrect Answer:"));
		tf5 = new TextField();
		MC.add(tf5);
		MC.add(new Label(""));
		Button enter = new Button("Submit question");
		enter.addActionListener(this);
		MC.add(enter);
		a1.addMouseListener(new DClick2(tf3,tf4,tf5,this));
		a2.addMouseListener(new MClick2(tf3,tf4,tf5,this));
		a3.addMouseListener(new MClick2(tf3,tf4,tf5,this));
		a4.addMouseListener(new MClick2(tf3,tf4,tf5,this));
		c1.addMouseListener(new DClick(tf2, tf3, tf4, tf5,this));
		c2.addMouseListener(new MClick(tf2, tf3, tf4, tf5,this));
		testC = new TextField();
		testC.setEditable(false);
		testC.setText(testCount+" questions created");
		MC.add(testC);
		MC.setVisible(true);
		
		
		TextField tf6 = new TextField(20);
		top.add(new Label("Number of students "));
		TextField tf7 = new TextField(5);
		top.add(tf7);
		top.add(new Label("||  Test Name"));
		top.add(tf6);
		Button submit = new Button("Finish Test");
		top.add(submit);
		add(top, BorderLayout.NORTH);
		Button back = new Button("Back to Top Menu");
		back.addActionListener(new CM(this));
		back.addActionListener(new OpenTG(topmenu));
		add(back,BorderLayout.SOUTH);
		addWindowListener(this);
		top.setVisible(true);
		setTitle("Test Generator");
		setSize(1200,500);

	}
	public void windowClosing(WindowEvent evt) {
	      System.exit(0);  // Terminate the program
	}
	@Override public void windowOpened(WindowEvent evt) { }
	@Override public void windowClosed(WindowEvent evt) { }
	@Override public void windowIconified(WindowEvent evt) { }
	@Override public void windowDeiconified(WindowEvent evt) { }
	@Override public void windowActivated(WindowEvent evt) { }
	@Override public void windowDeactivated(WindowEvent evt) { }
	@Override
	public void actionPerformed(ActionEvent e) {
		if(ta.getText().equals("")||Mult&&(tf2.getText().equals("")||tf3.getText().equals("")||tf4.getText().equals("")||tf5.getText().equals(""))){
			Dia dia1 = new Dia(this,"Error");
		}else{
			testCount++;
			testC.setText(testCount+" questions created");
			
		}
	}
}
