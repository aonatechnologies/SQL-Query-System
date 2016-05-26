package intialClasses;

import java.util.ArrayList;

public class WrittenQuestion extends Question{
	
	private int myValue;
	public WrittenQuestion(String prompt, int value, int masterKey){
		super(prompt,masterKey);
		myValue = value;

	}
	@Override
	public void randomize(){
		//Do nothing
	}
	public String toString(){
		return "WRITTEN"+"</q>"+super.getMyMasterKeyNum()+"</q>"+super.getPrompt()+"</q>"+myValue;
	}
	
}
