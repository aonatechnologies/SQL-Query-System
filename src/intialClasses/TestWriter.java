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
		int c = 0;
		if(dotTestReader.hasNextLine()){
			title = dotTestReader.nextLine();
		}else{
			System.out.println("INVALID .test");
		}
		while(dotTestReader.hasNextLine()){
			PrintWriter pw;
			if(c==0){
				pw = new PrintWriter(outputDirectory+title+" MASTER"+".txt","UTF-8");
			}else{
				pw = new PrintWriter(outputDirectory+title+" "+c+".txt","UTF-8");
			}
			pw.println("     ----"+title+"---");
			String[] testSplit = dotTestReader.nextLine().split("</t>");
			int id = Integer.parseInt(testSplit[1]);
			pw.println();
			pw.println("     Key ID ~ "+id);
			pw.println();
			pw.println();
			String[] questionsSplit = testSplit[0].split(" < : > ");
			for(int i =0;i<questionsSplit.length;i++){
				String[] partsSplit = questionsSplit[i].split("</q>");
				if(partsSplit[0].equals("WRITTEN")){
					pw.println("~Written Response~");
					pw.println(i+". "+partsSplit[2]);
				}else{
					String[] indSplit = partsSplit[2].split("</ >");
					pw.println((i+1)+". "+partsSplit[1]);
					pw.println("   A. "+indSplit[0]);
					pw.println("   B. "+indSplit[1]);
					pw.println("   C. "+indSplit[2]);
					pw.println("   D. "+indSplit[3]);
				}
				pw.println();
			}
			pw.println("Don't forget to write your key ID!");
			pw.close();
			c++;
		}

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
