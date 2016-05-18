package intialClasses;

import java.util.ArrayList;
import java.util.Collections;

public class Test{
	private ArrayList<Question> myQuestions;
	private int id;
	private static ArrayList<Integer> allIDs;
	private String myTitle;
	
	
	public Test(ArrayList<Question> questions,String title){
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
		id = allIDs.remove((int)(Math.random()*allIDs.size()));
		this.myTitle = title;
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
			output +=s+" < : > ";
		}
		return output.substring(0,output.length()-7);
	}
	public String getTitle(){
		return myTitle;
	}
	public String toString(){
		return toArrayString(this.myQuestions)+"</t>"+4785;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}