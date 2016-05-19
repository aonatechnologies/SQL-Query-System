package intialClasses;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class TestWriter{
	Scanner dotTestReader;
	String outputDirectory;
	public TestWriter(String dotTestLocation, String outputDirectory) throws FileNotFoundException{
		dotTestReader = new Scanner(new FileReader(dotTestLocation));
		this.outputDirectory=outputDirectory;
	}
	
	
	public void gimmeTehTests() throws FileNotFoundException, UnsupportedEncodingException{
		String title = "";
		int c = 1;
		if(dotTestReader.hasNextLine()){
			title = dotTestReader.nextLine();
		}else{
			System.out.println("INVALID .test");
		}
		while(dotTestReader.hasNextLine()){
			PrintWriter pw = new PrintWriter(outputDirectory+"Test "+c+".txt","UTF-8");
			
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
