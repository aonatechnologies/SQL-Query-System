package intialClasses;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class TGMenu extends Frame implements WindowListener, ActionListener, ItemListener{
	private int testCount;
	private TextField testC;
	public boolean Mult;
	public boolean Uin;
	private TextArea ta;
	private TextField tf2;
	private TextField tf3;
	private TextField tf4;
	private TextField tf5, tf6, tf7,outputPath;
	private Panel top;
	private ArrayList<WrittenQuestion> questionList;
	private JFileChooser finder;
	private int tempInt;
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
		c1.addItemListener(this);
		c2.addItemListener(this);
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
		
		
		tf6 = new TextField(20);
		top.add(new Label("Number of students "));
		tf7 = new TextField(5);
		top.add(tf7);
		top.add(new Label("||  Test Name"));
		top.add(tf6);
		Button submit = new Button("Finish Test");
		submit.addActionListener(this);
		top.add(submit);
		finder = new JFileChooser();
		finder.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		finder.addActionListener(this);
		Button outputter = new Button("Output Path");
		outputter.addActionListener(this);
		outputPath = new TextField(20);
		top.add(outputPath);
		top.add(outputter);
		add(top, BorderLayout.NORTH);
		Button back = new Button("Back to Top Menu");
		back.addActionListener(new CM(this));
		back.addActionListener(new OpenTG(topmenu));
		add(back,BorderLayout.SOUTH);
		addWindowListener(this);
		top.setVisible(true);
		setTitle("Test Generator");
		setSize(1200,500);
		questionList=new ArrayList<WrittenQuestion>();

	}
	public void setTempInt(int i){
		this.tempInt=i;
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
		if(e.getSource() instanceof JFileChooser){
			File f = ((JFileChooser)e.getSource()).getSelectedFile();
			outputPath.setText(f.getPath()+"\\");
			finder.getParent().setVisible(false);
		}
		if(e.getSource() instanceof Checkbox){
			if(((Checkbox)e.getSource()).getLabel().equals("Free Response")){
				Mult=false;
			}else{
				if(((Checkbox)e.getSource()).getLabel().equals("Multiple Choice")){
					Mult=true;
				}
			}
		}
		if(e.getSource() instanceof Button){
			if(((Button)e.getSource()).getLabel().equals("Output Path")){
				Dialog choosePath = new Dialog(this,"Choose the Output Directory");
				choosePath.add(finder);
				choosePath.setLocationRelativeTo(this);
				choosePath.setVisible(true);
				choosePath.pack();
			}
			if(((Button)e.getSource()).getLabel().equals("Finish Test")){
				PrintWriter pw = null;
				try {
					pw = new PrintWriter(outputPath.getText()+tf6.getText()+".test","UTF-8");
				} catch (FileNotFoundException | UnsupportedEncodingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				pw.println(tf6.getText());
				ArrayList<Test> tests = new ArrayList<Test>();
				tests.add(new Test(questionList));
				for(int i = 0; i<Integer.parseInt(tf7.getText());i++){
					Test temp = new Test(questionList);
					temp.randomize();
					tests.add(temp);
				}
				for(Test t : tests){
					pw.println(t);
				}
				pw.close();
				ValueGetter vg = new ValueGetter(this,"Done",null);
				vg.conevert();
				vg.setLocationRelativeTo(this);
				vg.setVisible(true);
				try {
					TestWriter tw = new TestWriter(outputPath.getText()+tf6.getText()+".test",outputPath.getText());
					tw.gimmeTehTests();
				} catch (FileNotFoundException | UnsupportedEncodingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
			if(((Button)e.getSource()).getLabel().equals("Submit question")){
				String[] reserved = {" < : > ","</t>","</q>","</ >"};
				boolean cont = true;
				if(ta.getText().equals("")||Mult&&(tf2.getText().equals("")||tf3.getText().equals("")||tf4.getText().equals("")||tf5.getText().equals(""))){
					Dia dia1 = new Dia(this,"Error","Please fill in all fields");
					cont = false;
				}
				for(String s : reserved){
					if(ta.getText().equals(s)||Mult&&(tf2.getText().equals(s)||tf3.getText().equals(s)||tf4.getText().equals(s)||tf5.getText().equals(s))){
						Dia dia1 = new Dia(this,"Error","Reserved string "+s+" used");
						cont = false;
					}
				}
				if(cont){
					testCount++;
					if(Mult){
						ArrayList<String> temp = new ArrayList<String>();
						temp.add(tf2.getText());
						temp.add(tf3.getText());
						temp.add(tf4.getText());
						temp.add(tf5.getText());
						questionList.add(new Question(ta.getText(),temp,testCount));
						ta.setText("");
						tf2.setText("");
						tf3.setText("");
						tf4.setText("");
						tf5.setText("");
					}else{
						ValueGetter vg = new ValueGetter(this,"Please input the point value of this question",this);
						vg.setModal(true);
						vg.setLocationRelativeTo(this);
						vg.setVisible(true);
						questionList.add(new WrittenQuestion(ta.getText(),vg.getValue(),testCount));
						ta.setText("");
					}
					testC.setText(testCount+" questions created");
				}
			}
		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if(e.getSource() instanceof Checkbox){
			if(((Checkbox)e.getSource()).getLabel().equals("Free Response")){
				Mult=false;
			}else{
				if(((Checkbox)e.getSource()).getLabel().equals("Multiple Choice")){
					Mult=true;
				}
			}
		}
	}
}

