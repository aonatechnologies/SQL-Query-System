import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class DClick implements MouseListener {
	private TextField t1;
	private TextField t3;
	private TextField t2;
	private TextField t4;
	private TGMenu f;
	public DClick(TextField tf1,TextField tf2,TextField tf3, TextField tf4,TGMenu menu){
		t1=tf1;
		t2=tf2;
		t3=tf3;
		t4=tf4;
		f= menu;
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
		t1.setEditable(true);
		t2.setEditable(true);
		t3.setEditable(true);
		t4.setEditable(true);
		f.Mult=true;

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}
}
