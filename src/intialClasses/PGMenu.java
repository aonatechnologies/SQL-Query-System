package intialClasses;


import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.MenuComponent;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.UnsupportedEncodingException;

import javax.swing.JFileChooser;


public class PGMenu extends Frame implements WindowListener,ActionListener{
	private JFileChooser finder,dotTestFinder;
	private TextField question,answer,quizLoc,outputLoc; 
	public PGMenu(Frame topmenu){
		setLayout(new FlowLayout());
		addWindowListener(this);
		finder = new JFileChooser();
		finder.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		finder.addActionListener(this);
		dotTestFinder = new JFileChooser();
		dotTestFinder.addActionListener(this);
		question = new TextField(20);
		answer = new TextField(20);
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
		add(question);
		add(answer);
		add(dotTestButton);
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
		setTitle("Test Grader");
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
	    
	}
}
