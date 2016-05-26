package intialClasses;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Test{
	private ArrayList<Question> myQuestions;
	private int id;
	private static ArrayList<Integer> allIDs;

	
	
	public Test(ArrayList<Question> questions){
		myQuestions = new ArrayList<Question>();
		for(Question q : questions){
			myQuestions.add(new Question(q));
		}
		if(allIDs==null){
			allIDs = new ArrayList<Integer>();
			for (int i = 0; i<1000; i++){
				allIDs.add(i);
			}
		}
		Random r = new Random();
		id = allIDs.remove((int)(r.nextInt(allIDs.size())));

	}
	public void randomize(){
		for(int i = 0;i<this.myQuestions.size();i++){
			this.myQuestions.get(i).randomize();
		}
		Collections.shuffle(this.myQuestions);
	}
	public static String toArrayString(ArrayList<Question> al){
		String output = "";
		for(Question s : al){
			if(s instanceof WrittenQuestion){
				System.out.println("hello sir");
				output+=((WrittenQuestion)s).toString()+" < : > ";
			}
			else{
				output +=s+" < : > ";
			}
		}
		return output.substring(0,output.length()-7);
	}

	public String toString(){
		return toArrayString(this.myQuestions)+"</t>"+id;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}