package intialClasses;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * @author Jonah Tash
 *
 */
public class Test{
	private ArrayList<WrittenQuestion> myQuestions;
	private int id;
	private static ArrayList<Integer> allIDs;

	
	
	/**
	 * Constructs a test from a list of question. It also assigns a unique 3 digit integer ID to this Test instance.
	 * @param questions The questions to be contained in this Test.
	 * 
	 */
	public Test(ArrayList<WrittenQuestion> questions){
		myQuestions = new ArrayList<WrittenQuestion>();
		for(WrittenQuestion q : questions){
			if(q instanceof Question){
				myQuestions.add(new Question((Question)q));
			}else{
				myQuestions.add(new WrittenQuestion(q));
			}
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
	/**
	 * Sudo-randomly shuffles the order of a tests questions and the order of the choices in each question.
	 */
	public void randomize(){
		for(int i = 0;i<this.myQuestions.size();i++){
			this.myQuestions.get(i).randomize();
		}
		Collections.shuffle(this.myQuestions);
	}
	/**
	 * @param al
	 * @return A string of the questions contained in al delineated by " < : > ".
	 */
	public static String toArrayString(ArrayList<WrittenQuestion> al){
		String output = "";
		for(WrittenQuestion s : al){
			if(s instanceof WrittenQuestion){
				output+=((WrittenQuestion)s).toString()+" < : > ";
			}
			else{
				output +=s.toString()+" < : > ";
			}
		}
		return output.substring(0,output.length()-7);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		return toArrayString(this.myQuestions)+"</t>"+id;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}