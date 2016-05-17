package intialClasses;

import java.util.ArrayList;
import java.util.Collections;

public class Test{
	private ArrayList<Question> myQuestions;
	private int id;
	private static ArrayList<Integer> allIDs;

	
	
	public Test(ArrayList<Question> questions){
		myQuestions = new ArrayList<Question>();
		for(Question q : questions){
			myQuestions.add(new Question(q));
		}
		if(allIDs!=null){
			allIDs = new ArrayList<Integer>();
			for (int i = 0; i<1000; i++){
				allIDs.add(i);
			}
		}
		id = allIDs.remove((int)(Math.random()*allIDs.size()));
	}
	public void randomize(){
		for(int i = 0;i<this.myQuestions.size();i++){
			this.myQuestions.get(i).randomize();
		}
		Collections.shuffle(this.myQuestions);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}