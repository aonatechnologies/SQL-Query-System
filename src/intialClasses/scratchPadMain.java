package intialClasses;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class scratchPadMain {

	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		TestWriter tw = new TestWriter("Sample.test","");
		tw.gimmeTehTests();

	}

}
