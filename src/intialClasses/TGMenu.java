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


/**
 * The menu for generating test.
 * @author Jonah Tash
 *
 */
public class TGMenu extends Frame implements WindowListener, ActionListener, ItemListener{
	private int testCount;
	private TextField testC;
	public boolean Mult;
	public boolean Uin;
	private TextArea ta;
	private TextField correctAnswer;
	private TextField incorrect1;
	private TextField incorrect2;
	private TextField incorrect3, tf6, tf7,outputPath;
	private Panel top;
	private ArrayList<WrittenQuestion> questionList;
	private JFileChooser finder;
	private int tempInt;
	/**
	 * Constructs the layout of the Test Generator GUI. It also constructs the components of the menu and adds them onto the menu's frame.
	 * @param topmenu The parent menu of this sub-menu.
	 */
	public TGMenu(Frame topmenu){
		Mult=true;
		testCount =0;
		setLayout(new BorderLayout());
		Panel top = new Panel();
		top.setLayout(new FlowLayout());
		Panel MC = new Panel();
		add(MC, BorderLayout.WEST);
		MC.setLayout(new GridLayout(6,2));
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
		correctAnswer = new TextField();
		MC.add(correctAnswer);
		MC.add(new Label(""));
		MC.add(new Label("Incorrect Answer:"));
		incorrect1 = new TextField();
		incorrect2 = new TextField();
		incorrect3 = new TextField();
		Panel atype1 = new Panel();
		atype1.setLayout(new  GridLayout(3,2));
		atype1.add(new Label("Incorrect Answer Generation"));
		atype1.add(new Label(""));
		Panel atype2 = new Panel();
		atype2.setLayout(new  GridLayout(3,2));
		atype2.add(new Label("Incorrect Answer Generation"));
		atype2.add(new Label(""));
		Panel atype3 = new Panel();
		atype3.setLayout(new  GridLayout(3,2));
		atype3.add(new Label("Incorrect Answer Generation"));
		atype3.add(new Label(""));
		CheckboxGroup wrong1 = new CheckboxGroup();
		CheckboxGroup wrong2 = new CheckboxGroup();
		CheckboxGroup wrong3 = new CheckboxGroup();
		Checkbox isUserIn1 = new Checkbox("User input",wrong1,true);
		atype1.add(isUserIn1);
		Checkbox isPerm1 = new Checkbox("Permutation of correct answer",wrong1,false);
		atype1.add(isPerm1);
		Checkbox isRandS1 = new Checkbox("Random string",wrong1,false);
		atype1.add(isRandS1);
		Checkbox isRandInt1 = new Checkbox("Random integer",wrong1,false);
		atype1.add(isRandInt1);
		Checkbox isUserIn2 = new Checkbox("User input",wrong2,true);
		atype2.add(isUserIn2);
		Checkbox isPerm2 = new Checkbox("Permutation of correct answer",wrong2,false);
		atype2.add(isPerm2);
		Checkbox isRandS2 = new Checkbox("Random string",wrong2,false);
		atype2.add(isRandS2);
		Checkbox isRandInt2 = new Checkbox("Random integer",wrong2,false);
		atype2.add(isRandInt2);
		Checkbox isUserIn3 = new Checkbox("User input",wrong3,true);
		atype3.add(isUserIn3);
		Checkbox isPerm3 = new Checkbox("Permutation of correct answer",wrong3,false);
		atype3.add(isPerm3);
		Checkbox isRandS3 = new Checkbox("Random string",wrong3,false);
		atype3.add(isRandS3);
		Checkbox isRandInt3= new Checkbox("Random integer",wrong3,false);
		atype3.add(isRandInt3);
		atype1.setVisible(true);
		atype2.setVisible(true);
		atype3.setVisible(true);
		Panel buttons = new Panel();
		add(buttons,BorderLayout.CENTER);
		MC.add(incorrect1);
		MC.add(atype1);
		MC.add(new Label("Incorrect Answer:"));
		MC.add(incorrect2);
		MC.add(atype2);
		MC.add(new Label("Incorrect Answer:"));
		MC.add(incorrect3);
		MC.add(atype3);

		Button enter = new Button("Submit question");
		enter.addActionListener(this);
		MC.add(enter);
		isUserIn1.addMouseListener(new DClick2(incorrect1));
		isPerm1.addMouseListener(new MClick2(incorrect1,correctAnswer));
		isRandS1.addMouseListener(new MClick2(incorrect1,1));
		isRandInt1.addMouseListener(new MClick2(incorrect1,0));
		isUserIn2.addMouseListener(new DClick2(incorrect2));
		isPerm2.addMouseListener(new MClick2(incorrect2,correctAnswer));
		isRandS2.addMouseListener(new MClick2(incorrect2,1));
		isRandInt2.addMouseListener(new MClick2(incorrect2,0));
		isUserIn3.addMouseListener(new DClick2(incorrect3));
		isPerm3.addMouseListener(new MClick2(incorrect3,correctAnswer));
		isRandS3.addMouseListener(new MClick2(incorrect3,1));
		isRandInt3.addMouseListener(new MClick2(incorrect3,0));
		c1.addMouseListener(new MClick(correctAnswer, incorrect1, incorrect2, incorrect3,this,1));
		c2.addMouseListener(new MClick(correctAnswer, incorrect1, incorrect2, incorrect3,this,0));
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
		finder = new JFileChooser();
		finder.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		finder.addActionListener(this);
		Button outputter = new Button("Output Path");
		outputter.addActionListener(this);
		outputPath = new TextField(20);
		top.add(outputPath);
		top.add(outputter);
		top.add(tf6);
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
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
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
				ValueGetter vg = new ValueGetter(this,"Done");
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
				if(ta.getText().equals("")||Mult&&(correctAnswer.getText().equals("")||incorrect1.getText().equals("")||incorrect2.getText().equals("")||incorrect3.getText().equals(""))){
					Dia dia1 = new Dia(this,"Error","Please fill in all fields");
					cont = false;
				}
				for(String s : reserved){
					if(ta.getText().equals(s)||Mult&&(correctAnswer.getText().equals(s)||incorrect1.getText().equals(s)||incorrect2.getText().equals(s)||incorrect3.getText().equals(s))){
						Dia dia1 = new Dia(this,"Error","Reserved string "+s+" used");
						cont = false;
					}
				}
				if(cont){
					testCount++;
					if(Mult){
						ArrayList<String> temp = new ArrayList<String>();
						temp.add(correctAnswer.getText());
						temp.add(incorrect1.getText());
						temp.add(incorrect2.getText());
						temp.add(incorrect3.getText());
						questionList.add(new Question(ta.getText(),temp,testCount));
						ta.setText("");
						correctAnswer.setText("");
						incorrect1.setText("");
						incorrect2.setText("");
						incorrect3.setText("");
					}else{
						ValueGetter vg = new ValueGetter(this,"Please input the point value of this question");
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

	/* (non-Javadoc)
	 * @see java.awt.event.ItemListener#itemStateChanged(java.awt.event.ItemEvent)
	 */
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

