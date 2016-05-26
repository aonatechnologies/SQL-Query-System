package intialClasses;

import java.util.ArrayList;
import java.util.Collections;

public class Question extends WrittenQuestion{
	private ArrayList<String> myChoices;
	private int indexOfCorrect;
	private String myPrompt;
	private int myMasterKeyNum;
	private boolean isWritten;
	public Question(String prompt, ArrayList<String> choices,int masterKey){
		super(prompt,1,masterKey);
		isWritten=false;
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
	public Question(String prompt, int masterKey) {
		super(prompt,1,masterKey);
		isWritten = true;
		myChoices = new ArrayList<String>();
		myChoices.add("appeasement");
		myChoices.add("appeasement");
		myChoices.add("appeasement");
		myChoices.add("appeasement");
		this.myPrompt=prompt;
		this.myMasterKeyNum=masterKey;
	}
	public void randomize(){
		if(isWritten){
			
		}else{
			if(myChoices.size()==0){
				System.out.println("ERROR");
			}
			String temp = myChoices.get(indexOfCorrect);
			Collections.shuffle(myChoices);
			indexOfCorrect = myChoices.indexOf(temp);
		}
	}
	public static String toArrayString(ArrayList<String> al){
		String output = "";
		for(String s : al){
			output +=s+"</ >";
		}
		return output.substring(0,output.length()-4);
	}
	
	
	public String toString(){
		if(!isWritten){
			return myMasterKeyNum+"</q>"+myPrompt+"</q>"+toArrayString(this.myChoices)+"</q>"+indexOfCorrect;
		}else{
			System.out.println("Hello");
			return "";
		}
	}
	public int getMyMasterKeyNum() {
		return myMasterKeyNum;
	}
	public String getPrompt() {
		return myPrompt;
	}
	
	
	
	
	
	
	
}