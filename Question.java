package initialClasses;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Jonah Tash
 *
 */

public class Question extends WrittenQuestion{
	/**
	 * The answer choices of this question.
	 */
	private ArrayList<String> myChoices;
	/**
	 * The index of the correct answer choice in {@link}myChoices
	 */

	private int indexOfCorrect;
	/**
	 * The questions prompt;
	 */
	private String myPrompt;
	private int myMasterKeyNum;
	private boolean isWritten;
	/**
	 * This constructs a multiple choices question. It supplies the question's prompt and a list of answer choices for that prompt. 
	 * @param prompt The desired prompt of the question.
	 * @param choices A list of answer choices for the question. PRECONDITION The correct answer to the question is in the first position (index 0).
	 * @param masterKey The location of the question in the master test.
	 * 
	 */
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
	/**
	 * A deep copy copy constructor.
	 * @param other Another Question object
	 */
	public Question(Question other){
		this(other.myPrompt,other.myChoices,other.myMasterKeyNum);
	}
	/**
	 * Sudo-randomly reorders the the answer choices of a Question object.
	 */
	
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
	
	/**
	 * @param al
	 * @return Returns the contents of al in a single String, delineated by </ >.
	 */
	public static String toArrayString(ArrayList<String> al){
		String output = "";
		for(String s : al){
			output +=s+"</ >";
		}
		return output.substring(0,output.length()-4);
	}
	

	/* (non-Javadoc)
	 * @see intialClasses.WrittenQuestion#toString()
	 */
	public String toString(){
		if(!isWritten){
			return myMasterKeyNum+"</q>"+myPrompt+"</q>"+toArrayString(this.myChoices)+"</q>"+indexOfCorrect;
		}else{
			return "";
		}
	}
	/**
	 * @return The field myMasterKeyNum.
	 */
	public int getMyMasterKeyNum() {
		return myMasterKeyNum;
	}
	/**
	 * @return The field myPrompt.
	 */
	public String getPrompt() {
		return myPrompt;
	}
	
	
	
	
	
	
	
}