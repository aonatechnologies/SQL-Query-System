package intialClasses;

import java.util.ArrayList;
import java.util.Collections;

public class Question{
	private ArrayList<String> myChoices;
	private int indexOfCorrect;
	private String myPrompt;
	private int myMasterKeyNum;
	public Question(String prompt, ArrayList<String> choices,int masterKey){
		myChoices = new ArrayList<String>();
		for(String s : choices){
			myChoices.add(s);
		}
		indexOfCorrect = 0;
		this.myPrompt=prompt;
		this.myMasterKeyNum=masterKey;
	}
	public Question(Question other){
		this(other.myPrompt,other.myChoices,other.myMasterKeyNum);
	}
	public void randomize(){
		String temp = myChoices.get(indexOfCorrect);
		Collections.shuffle(myChoices);
		indexOfCorrect = myChoices.indexOf(temp);
	}
	public static String toArrayString(ArrayList<String> al){
		String output = "";
		for(String s : al){
			output +=s+"</ >";
		}
		return output.substring(0,output.length()-4);
	}
	
	
	public String toString(){
		return myMasterKeyNum+"</q>"+myPrompt+"</q>"+toArrayString(this.myChoices)+"</q>"+indexOfCorrect;
	}
	
	
	
	
	
	
	
}