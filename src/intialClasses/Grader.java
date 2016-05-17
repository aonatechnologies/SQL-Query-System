package intialClasses;

import java.io.File;

public class Grader {
	private String myTestLoc, myDirectory;
	
	public Grader(String testLoc, String directory){
		this.myDirectory=directory;
		this.myTestLoc=testLoc;
	}
	public void grade(){
		File folder = new File(myDirectory);
		for (File f : folder.listFiles()){
			
		}
	}
}
