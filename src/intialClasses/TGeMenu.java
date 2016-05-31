package intialClasses;
import java.awt.Button;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
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


/**
 * The menu for grading tests.
 * @author Jonah Tash
 *
 */
public class TGeMenu extends Frame implements WindowListener,ActionListener{
	private JFileChooser finder,dotTestFinder;
	private TextField dotTestLoc,quizLoc,outputLoc,mCWeight; 
	boolean isOutput;
	/**
	 * Constructs the layout of the Test Grader GUI. It also constructs the components of the menu and adds them onto the menu's frame.
	 * @param topmenu The parent menu of this sub-menu.
	 */
	public TGeMenu(Frame topmenu){
		isOutput = false;
		setLayout(new FlowLayout());
	    finder = new JFileChooser();
		finder.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		finder.addActionListener(this);
		dotTestFinder = new JFileChooser();
		dotTestFinder.addActionListener(this);
		dotTestLoc = new TextField(20);
		Button dotTestButton = new Button(".test Location");
		dotTestButton.addActionListener(this);
		quizLoc = new TextField(20);
		Button quizLocButton = new Button("Folder of Answers");
		quizLocButton.addActionListener(this);
		outputLoc = new TextField(20);
		Button outputButton = new Button("Output Directory");
		mCWeight = new TextField(20);
		mCWeight.setText("1");
		outputButton.addActionListener(this);
		Button grade = new Button("Grade");
		grade.addActionListener(this);
		add(dotTestLoc);
		add(dotTestButton);
		add(new Label("Multiple choice weight"));
		add(mCWeight);
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
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() instanceof JFileChooser){
	    	if(((JFileChooser)e.getSource()).getFileSelectionMode()==JFileChooser.DIRECTORIES_ONLY){
	    		File f = ((JFileChooser)e.getSource()).getSelectedFile();
	    		if(isOutput){
	    			outputLoc.setText(f.getPath()+"\\");
	    		}else{
	    			quizLoc.setText(f.getPath());
	    		}
	    		((JFileChooser)e.getSource()).getParent().setVisible(false);
	    	}else{
	    		File f = ((JFileChooser)e.getSource()).getSelectedFile();
	    		dotTestLoc.setText(f.getPath());
	    		((JFileChooser)e.getSource()).getParent().setVisible(false);
	    	}
	    }else{
	    	if(((Button)e.getSource()).getLabel().equals("Grade")){
	    		Grader g;
				try {
					g = new Grader(dotTestLoc.getText(),quizLoc.getText(),outputLoc.getText(),Integer.parseInt(mCWeight.getText()));
					g.grade();
					ValueGetter vg = new ValueGetter(this,"Graded");
					vg.displayText("Grading Complete!");
					vg.setVisible(true);
				} catch (FileNotFoundException | UnsupportedEncodingException e1) {
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
				isOutput = false;
				
			}
			if(((Button)e.getSource()).getLabel().equals("Output Directory")){
				isOutput = true;
				Dialog selectPath = new Dialog(this,"Select an Output Directory");
				selectPath.setModal(true);
				isOutput = true;
				selectPath.add(finder);
				selectPath.pack();
				selectPath.setVisible(true);
			}
	    }

	}
}
