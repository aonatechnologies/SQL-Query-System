package intialClasses;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;


/**
 * The menu used to navigate to the three different portions of AONA Tech's Test Generator and Grader, the Generator UI, the Grader UI,
 *  and the Python Grader UI
 * @author Jonah Tash
 *
 */
public class TopMenu extends Frame implements ActionListener, WindowListener{
	/**
	 * Constructs the TopMenu's three buttons one to navigate to each portion of AONA Tech's Test Generator and Grader.
	 */
	public TopMenu(){
		setLayout(new FlowLayout());
		Button but1  = new Button("Test Generator");
		add(but1);
		Button but2  = new Button("Test Grader");
		add(but2);
		Button but3  = new Button("Python Grader");
		add(but3);
		CM close = new CM(this);
		but1.addActionListener(close);
		TGMenu tg = new TGMenu(this);
		but1.addActionListener(new OpenTG(tg));
		but2.addActionListener(close);
		TGeMenu tge = new TGeMenu(this);
		but2.addActionListener(new OpenTG(tge));
		but3.addActionListener(close);
		PGMenu pg = new PGMenu(this);
		but3.addActionListener(new OpenTG(pg));
		addWindowListener(this);
		setTitle("Top Menu");
		setSize(350,120);
		setVisible(true);
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
	public void actionPerformed(ActionEvent arg0) {
	}
}
