package intialClasses;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Grader {
	private String inDirectory, outDirectory;
	private Scanner dotTestReader;
	public Grader(String testLoc, String inputDirectory,String outputDirectory) throws FileNotFoundException{
		this.inDirectory=inputDirectory;
		this.dotTestReader=new Scanner(new FileReader(testLoc));
		this.outDirectory=outputDirectory;
	}
	public void grade(){
		File folder = new File(inDirectory);
		for (File f : folder.listFiles()){
			
		}
	}
}
