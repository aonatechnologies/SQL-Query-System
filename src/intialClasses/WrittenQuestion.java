package intialClasses;

import java.util.ArrayList;

/**
 * Represents a written response question that is part of a test.
 * @author Jonah Tash
 *
 */
public class WrittenQuestion{
	
	private int myValue;
	private int myMasterKeyNum;
	String prompt;
	
	/**
	 * @param prompt The prompt of the WrittenQuestion.
	 * @param value The worth of the WrittenQuestion.
	 * @param masterKey The position in the master test of this question.
	 */
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
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		return "WRITTEN"+"</q>"+myMasterKeyNum+"</q>"+prompt+"</q>"+myValue;
	}
	
}
