import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class OpenTG implements ActionListener{
	private Frame myMenu;
	public OpenTG(Frame menu){
		myMenu = menu;
	}
	public void actionPerformed(ActionEvent arg0) {
		myMenu.setVisible(true);
		
	}

}
