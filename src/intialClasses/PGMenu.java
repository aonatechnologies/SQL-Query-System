package intialClasses;


import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.MenuComponent;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JFileChooser;


public class PGMenu extends Frame implements WindowListener,ActionListener{
	private JFileChooser finder,dotTestFinder;
	private TextField numOfArgs,quizLoc,outputLoc; 
	private String myVersion,myArgs;
	private ArrayList<String> myOutputs;
	ArrayList<TextField> inputs;
	TextField exOutput;
	public PGMenu(Frame topmenu){
		myArgs = "";
		myOutputs = new ArrayList<String>();
		setLayout(new FlowLayout());
		addWindowListener(this);
		finder = new JFileChooser();
		finder.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		finder.addActionListener(this);
		dotTestFinder = new JFileChooser();
		dotTestFinder.addActionListener(this);
		numOfArgs = new TextField(20);
		Label argNumLabel = new Label("Number of test case arguements:");
		Button dotTestButton = new Button("Add Test Case");
		dotTestButton.addActionListener(this);
		quizLoc = new TextField(20);
		Button quizLocButton = new Button("Folder of Python Programs");
		quizLocButton.addActionListener(this);
		outputLoc = new TextField(20);
		Button outputButton = new Button("Output Directory");
		outputButton.addActionListener(this);
		Button grade = new Button("Grade");
		grade.addActionListener(this);
		Button selectVersion = new Button("Select Python Version");
		selectVersion.addActionListener(this);
		add(argNumLabel);
		add(numOfArgs);
		add(dotTestButton);
		add(selectVersion);
		add(quizLoc);
		add(quizLocButton);
		add(outputLoc);
		add(outputButton);
		add(grade);
		Button back = new Button("Back to Top Menu");
		back.addActionListener(new CM(this));
		back.addActionListener(new OpenTG(topmenu));
		add(back);
		addWindowListener(this);
		setTitle("Python Grader");
		setSize(700,500);
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
	public void actionPerformed(ActionEvent e) {
		TextField input=new  TextField(20);
		boolean isPython = false;
		if(e.getSource() instanceof JFileChooser){
			if(isPython){
				quizLoc.setText(((JFileChooser)e.getSource()).getSelectedFile().getPath());
				((JFileChooser)e.getSource()).getParent().setVisible(false);
			}else{
				outputLoc.setText(((JFileChooser)e.getSource()).getSelectedFile().getPath());
				((JFileChooser)e.getSource()).getParent().setVisible(false);
			}
		}
		if(e.getSource() instanceof Button){
			if(((Button)e.getSource()).getLabel().equals("Select Python Version")){
	    		System.out.println("reached");
	    		Dialog versionPopUp = new Dialog(this,"Select Version");
	    		versionPopUp.setLayout(new BoxLayout(versionPopUp,BoxLayout.Y_AXIS));
	    		versionPopUp.setModal(true);
	    		TextArea ta = new TextArea();
	    		ta.setText("Please enter the current version of Python on your device in the form MAJORMINOR.\nFor example Python 3.4.1 would be entered as 34");
	    		ta.setEditable(false);
	    		versionPopUp.add(ta);
	    		Button enter = new Button("Submit");
	    		enter.addActionListener(this);
	    		versionPopUp.add(input);
	    		versionPopUp.add(enter);
	    		versionPopUp.pack();
	    		versionPopUp.setLocationRelativeTo(this);
	    		versionPopUp.setVisible(true);
	    	}
			if(((Button)e.getSource()).getLabel().equals("Grade")){
				PrintWriter scoreWriter = null;
				try {
					scoreWriter = new PrintWriter(outputLoc+"\\PythonScores.csv","UTF-8");
				} catch (FileNotFoundException | UnsupportedEncodingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				PrintWriter breakdownWriter = null;
				try {
					breakdownWriter = new PrintWriter(outputLoc+"\\PythonBreakdown.csv","UTF-8");
				} catch (FileNotFoundException | UnsupportedEncodingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				scoreWriter.println("Name, Correct, Total, Percent");
				breakdownWriter.println("Name, Returned, Expected, Passed/Failed");
				double total = myOutputs.size();
				for(File f :new File(quizLoc.getText()).listFiles()){
					int studScore = 0;
					BufferedReader bf = null;
					try {
						bf = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("C:\\+Python"+myVersion+" "+f.getPath()+myArgs.substring(0,myArgs.length()-1)).getInputStream()));
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					String line=null;
					int c = 0;
					try {
						while((line=bf.readLine())!=null){
							if(line.equals(myOutputs.get(c))){
								studScore++;
								breakdownWriter.println(f.getName().substring(0,f.getName().length()-2)+", "+line+", "+myOutputs.get(c)+", Passed");
							}else{
								breakdownWriter.println(f.getName().substring(0,f.getName().length()-2)+", "+line+", "+myOutputs.get(c)+", Failed");
							}
						}
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					scoreWriter.println(f.getName().substring(0,f.getName().length()-2)+", "+studScore+", "+total+", "+studScore/total);
			}
			}
	    	if(((Button)e.getSource()).getLabel().equals("Submit")){
	    		myVersion = input.getText();
	    		((Button)e.getSource()).getParent().setVisible(false);
	    	}
	    	if(((Button)e.getSource()).getLabel().equals("Submit Case")){
	    		((Button)e.getSource()).getParent().setVisible(false);
	    		for(TextField tf : inputs){
	    			myArgs +=tf.getText()+" ";
	    		}
	    		myOutputs.add(exOutput.getText());
	    		((Button)e.getSource()).getParent().setVisible(false);
	    	}
	    	if(((Button)e.getSource()).getLabel().equals("Add Test Case")){
	    		Dialog d = new Dialog(this,"Add a test case");
	    		d.setLayout(new BoxLayout(d,BoxLayout.Y_AXIS));
	    		d.add(new Label("Input(s):"));
	    		inputs= new ArrayList<TextField>();
	    		for (int i = 0; i<Integer.parseInt(numOfArgs.getText());i++){
	    			inputs.add(new TextField(20));
	    		}
	    		for(TextField tf : inputs){
	    			d.add(tf);
	    		}
	    		d.add(new Label("Expected ouput:"));
	    		exOutput = new TextField(20);
	    		d.add(exOutput);
	    		Button b =new Button("Submit Case");
	    		b.addActionListener(this);
	    		d.add(b);
	    		d.setModal(true);
	    		d.pack();
	    		d.setLocationRelativeTo(this);
	    		d.setVisible(true);
	    	}
	    	if(((Button)e.getSource()).getLabel().equals("Folder of Python Programs")){
	    		isPython = true;
	    		Dialog d = new Dialog(this,"Select the folder containing the Python programs");
	    		d.setModal(true);
	    		d.add(finder);
	    		d.pack();
	    		d.setLocationRelativeTo(this);
	    		d.setVisible(true);
	    	}
	    	if(((Button)e.getSource()).getLabel().equals("Output Directory")){
	    		isPython = false;
	    		Dialog d = new Dialog(this,"Select an output directory");
	    		d.setModal(true);
	    		d.add(finder);
	    		d.pack();
	    		d.setLocationRelativeTo(this);
	    		d.setVisible(true);
	    	}
	    }
	}
}
