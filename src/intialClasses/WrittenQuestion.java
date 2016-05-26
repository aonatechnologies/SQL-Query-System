package intialClasses;

import java.util.ArrayList;

public class WrittenQuestion{
	
	private int myValue;
	private int myMasterKeyNum;
	String prompt;
	public WrittenQuestion(String prompt, int value, int masterKey){
		this.myMasterKeyNum=masterKey;
		this.prompt=prompt;
		myValue = value;

	}
	public WrittenQuestion(WrittenQuestion q) {
		this.prompt=q.prompt;
		this.myValue=q.myValue;
		this.myMasterKeyNum=q.myMasterKeyNum;
	}
	public void randomize(){
		//Do nothing
	}
	public String toString(){
		return "WRITTEN"+"</q>"+myMasterKeyNum+"</q>"+prompt+"</q>"+myValue;
	}
	
}
