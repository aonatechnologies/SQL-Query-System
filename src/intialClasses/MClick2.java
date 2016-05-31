package intialClasses;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


/**
 * A MouseListener that performs different operations on a TextField.
 * @author Jonah Tash
 *
 */
public class MClick2 implements MouseListener {
	private TextField t1;
	private TextField t2;
	private int myMode;
	/**
	 * Constructs a MClick2 that will set the text of tf1 with a permutation of the text in tf2.
	 * @param tf1 The TextField this MClick2 will modify.
	 * @param tf2 The TextField that will be permuted.
	 */
	public MClick2(TextField tf1,TextField tf2){
		t1=tf1;
		t2=tf2;
		myMode = 2;
	}
	/**
	 * @param tf1 The TextField this MClick2 will modify.
	 * @param i specifies a mode of operation for this MClick2, 0 will set the text of tf1
	 * to a sudo-random integer. 1 will set the text of tf1 to a sudo-random String of a random length in the range 1-10.
	 */
	public MClick2(TextField tf1, int i) {
		t1=tf1;
		myMode = i;
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

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
	 */
	@Override
	public void mousePressed(MouseEvent arg0) {
		if(myMode==2){
			t1.setText(jarble(t2.getText()));
		}
		if(myMode == 0){
			t1.setText(""+(int)(Math.random()*999));
		}
		if(myMode == 1){
			t1.setText(generateString(new Random(),"QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopAasdfghjklzxcvbnm",((int)(Math.random()*10))+1));
		}

	}
	/**
	 * @param rng A Random object
	 * @param characters The characters that could compose the returned random String.
	 * @param length The desired length of the returned random String.
	 * @return A random String of length length, containing an assortment of letters from characters.
	 */
	public static String generateString(Random rng, String characters, int length){
	    char[] text = new char[length];
	    for (int i = 0; i < length; i++)
	    {
	        text[i] = characters.charAt(rng.nextInt(characters.length()));
	    }
	    return new String(text);
	}
	/**
	 * @param s A string to be mixed.
	 * @return A randomized version of s.
	 */
	public static String jarble(String s){
		ArrayList<Integer> nums = new ArrayList<Integer>();
		for(int i = 0;i<s.length();i++){
			nums.add(i);
		}
		Collections.shuffle(nums);
		String ret = "";
		for (int i = 0;i < s.length();i++){
			ret += s.charAt((int) nums.get(i));
		}
		return ret;
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
