package intialClasses;
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
import java.io.FilenameFilter;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;


public class TGeMenu extends Frame implements WindowListener,ActionListener{
	private JFileChooser finder,dotTestFinder;
	private String returnText;
	private TextField dotTestLoc,quizLoc,outputLoc; 
	public TGeMenu(Frame topmenu){
		returnText="";
		setLayout(new FlowLayout());
	    finder = new JFileChooser();
		finder.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		finder.addActionListener(this);
		dotTestFinder = new JFileChooser();
		dotTestFinder.addActionListener(this);
		TextField dotTestLoc = new TextField(20);
		Button dotTestButton = new Button(".test Location");
		dotTestButton.addActionListener(this);
		TextField quizLoc = new TextField(20);
		Button quizLocButton = new Button("Folder of Answers");
		quizLocButton.addActionListener(this);
		TextField outputLoc = new TextField(20);
		Button outputButton = new Button("Output Directory");
		outputButton.addActionListener(this);
		add(dotTestLoc);
		add(dotTestButton);
		add(quizLoc);
		add(quizLocButton);
		add(outputLoc);
		add(outputButton);
		
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
	    if(e.getSource() instanceof JFileChooser){
	    	if(((JFileChooser)e.getSource()).getFileSelectionMode()==JFileChooser.DIRECTORIES_ONLY){
	    		File f = ((JFileChooser)e.getSource()).getSelectedFile();
	    		returnText = f.getPath()+"\\";
	    		((JFileChooser)e.getSource()).getParent().setVisible(false);
	    	}else{
	    		File f = ((JFileChooser)e.getSource()).getSelectedFile();
	    		returnText = f.getPath();
	    		((JFileChooser)e.getSource()).getParent().setVisible(false);
	    	}
	    }else{
			if(((Button)e.getSource()).getLabel().equals(".test Location")){
				Dialog selectPath = new Dialog(this,"Select .test Location");
				selectPath.pack();
				selectPath.add(this.dotTestFinder);
				selectPath.setVisible(true);
				dotTestLoc.setText(returnText);
			}
			if(((Button)e.getSource()).getLabel().equals("Folder of Answers")){
				Dialog selectPath = new Dialog(this,"Select the Folder Containing the Students' Answers");
				selectPath.pack();
				selectPath.add(finder);
				selectPath.setVisible(true);
				quizLoc.setText(returnText);
			}
			if(((Button)e.getSource()).getLabel().equals("Output Directory")){
				Dialog selectPath = new Dialog(this,"Select an Output Directory");
				selectPath.pack();
				selectPath.add(finder);
				selectPath.setVisible(true);
				outputLoc.setText(returnText);
			}
	    }

	}
}
