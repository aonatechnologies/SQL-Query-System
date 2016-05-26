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
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.UnsupportedEncodingException;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;


public class TGeMenu extends Frame implements WindowListener,ActionListener{
	private JFileChooser finder,dotTestFinder;
	private TextField dotTestLoc,quizLoc,outputLoc; 
	public TGeMenu(Frame topmenu){

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
		Button grade = new Button("Grade");
		grade.addActionListener(this);
		add(dotTestLoc);
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
	    boolean isOutput = false;
		if(e.getSource() instanceof JFileChooser){
	    	if(((JFileChooser)e.getSource()).getFileSelectionMode()==JFileChooser.DIRECTORIES_ONLY){
	    		File f = ((JFileChooser)e.getSource()).getSelectedFile();
	    		if(isOutput){
	    			outputLoc.setText(f.getPath()+"\\");
	    		}else{
	    			quizLoc.setText(f.getPath()+"\\");
	    		}
	    		((JFileChooser)e.getSource()).getParent().setVisible(false);
	    	}else{
	    		File f = ((JFileChooser)e.getSource()).getSelectedFile();
	    		if (f==null){
	    			System.out.println("ERROR");
	    		}
	    		if(f.getName()==null){
	    			System.out.println("YUNULL");
	    		}
	    		dotTestLoc.setText(f.getName());
	    		((JFileChooser)e.getSource()).getParent().setVisible(false);
	    	}
	    }else{
	    	if(((Button)e.getSource()).getLabel().equals("Grade")){
	    		Grader g;
				try {
					g = new Grader(dotTestLoc.getText(),quizLoc.getText(),outputLoc.getText());
					g.grade();
					ValueGetter vg = new ValueGetter(this,"Graded");
					vg.displayText("Grading Complete!");
					vg.setVisible(true);
				} catch (FileNotFoundException | UnsupportedEncodingException e1) {
					System.out.println("oops!");
					e1.printStackTrace();
				}
	    	}
	    	if(((Button)e.getSource()).getLabel().equals(".test Location")){
				Dialog selectPath = new Dialog(this,"Select .test Location");
				selectPath.add(this.dotTestFinder);
				selectPath.pack();
				selectPath.setVisible(true);
			}
			if(((Button)e.getSource()).getLabel().equals("Folder of Answers")){
				Dialog selectPath = new Dialog(this,"Select the Folder Containing the Students' Answers");
				selectPath.add(finder);
				selectPath.pack();
				selectPath.setVisible(true);
				
			}
			if(((Button)e.getSource()).getLabel().equals("Output Directory")){
				Dialog selectPath = new Dialog(this,"Select an Output Directory");
				isOutput = true;
				selectPath.add(finder);
				selectPath.pack();
				selectPath.setVisible(true);
			}
	    }

	}
}
