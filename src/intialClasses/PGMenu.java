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
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.UnsupportedEncodingException;

import javax.swing.BoxLayout;
import javax.swing.JFileChooser;


public class PGMenu extends Frame implements WindowListener,ActionListener{
	private JFileChooser finder,dotTestFinder;
	private TextField numOfArgs,quizLoc,outputLoc; 
	private String myVersion;
	public PGMenu(Frame topmenu){
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
	    		versionPopUp.setVisible(true);
	    	}
	    	if(((Button)e.getSource()).getLabel().equals("Submit")){
	    		myVersion = input.getText();
	    		((Button)e.getSource()).getParent().setVisible(false);
	    	}
	    	if(((Button)e.getSource()).getLabel().equals("Add Test Case")){
	    		
	    	}
	    }
	}
}
