package intialClasses;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class MClick2 implements MouseListener {
	private TextField t1;
	private TextField t3;
	private TextField t2;
	private TGMenu f;
	
	public MClick2(TextField tf1,TextField tf2,TextField tf3,TGMenu menu){
		t1=tf1;
		t2=tf2;
		t3=tf3;

		f=menu;
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
		t1.setEditable(false);
		t2.setEditable(false);
		t3.setEditable(false);

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
