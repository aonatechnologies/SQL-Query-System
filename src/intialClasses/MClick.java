package intialClasses;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


/**
 * A MouseListener that enables or disables a group of TextArea objects, depending on its mode.
 * @author Jonah Tash
 *
 */
public class MClick implements MouseListener {
	private TextField t1;
	private TextField t3;
	private TextField t2;
	private TextField t4;
	private TGMenu f;
	private int myI;
	
	/**
	 * @param tf1 A TextArea to be enabled/disabled.
	 * @param tf2 A TextArea to be enabled/disabled.
	 * @param tf3 A TextArea to be enabled/disabled.
	 * @param tf4 A TextArea to be enabled/disabled.
	 * @param menu The parent TGMenu of this MClick.
	 * @param i The mode for this MClick, 0 for disabling and 1 for enabling
	 */
	public MClick(TextField tf1,TextField tf2,TextField tf3, TextField tf4,TGMenu menu,int i){
		t1=tf1;
		t2=tf2;
		t3=tf3;
		t4=tf4;
		f=menu;
		this.myI=i;
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		if(myI==0){
			t1.setEditable(false);
			t2.setEditable(false);
			t3.setEditable(false);
			t4.setEditable(false);
			f.Mult=false;
		}else{
			t1.setEditable(true);
			t2.setEditable(true);
			t3.setEditable(true);
			t4.setEditable(true);
			f.Mult=true;
		}

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
