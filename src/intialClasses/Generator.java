package intialClasses;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Scanner;

public class Generator{
	
	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException{
		Scanner kb = new Scanner(System.in);
		System.out.println("What be the title of this here test?");
		String title = kb.nextLine();
		System.out.print("How many of the question is in this here test? -> ");
		int amount = kb.nextInt();
		kb.nextLine();
		ArrayList<Question> questions = new ArrayList<Question>();
		for(int i=1;i<=amount;i++){
			System.out.print("Prompt for question "+i+" -> ");
			String prompt;
			prompt = kb.nextLine();
			ArrayList<String> al = new ArrayList<String>();
			System.out.print("Correct answer for question "+i+" -> ");
			al.add(kb.nextLine());	
			System.out.print("Next answer choice -> ");
			al.add(kb.nextLine());
			System.out.print("Next answer choice -> ");
			al.add(kb.nextLine());
			System.out.print("Next answer choice -> ");
			al.add(kb.nextLine());
			questions.add(new Question(prompt,al,i));
		}
		System.out.println("How many of these here tests do you want? -> ");
		amount = kb.nextInt()-1;
		ArrayList<Test> ts = new ArrayList<Test>();
		ts.add(new Test(questions));
		for(int i=0;i<amount;i++){
			Test temp = new Test(questions);
			temp.randomize();
			ts.add(temp);
		}
		PrintWriter pw = new PrintWriter(title+".test","UTF-8");
		pw.println(title);
		for(Test t : ts){
			pw.println(t);
		}
		pw.close();
	}








}