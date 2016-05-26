package intialClasses;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JComboBox;
import javax.swing.JFrame;

/**
 * @author Jonah Tash
 *
 */
public class Grader implements ActionListener {
	private String inDirectory;
	private PrintWriter scores,breakdown;
	private ArrayList<Integer> ids;
	ArrayList<String> answerKey;
	private int points;
	private JComboBox<Integer> scoreChooser;
	
	/**
	 * @param testLoc
	 * @param inputDirectory
	 * @param outputDirectory
	 * @throws FileNotFoundException
	 * @throws UnsupportedEncodingException
	 */
	public Grader(String testLoc, String inputDirectory,String outputDirectory) throws FileNotFoundException, UnsupportedEncodingException{
		this.answerKey=new ArrayList<String>();
		this.ids=new ArrayList<Integer>();
		this.inDirectory=inputDirectory;
		Scanner dotTestReader=new Scanner(new FileReader(testLoc));
		String title =dotTestReader.nextLine();
		while(dotTestReader.hasNextLine()){
			answerKey.add(dotTestReader.nextLine());
		}
		for(String s : answerKey){
			ids.add(Integer.parseInt(s.split("</t>")[1]));
		}
		this.breakdown=new PrintWriter(title+"_Breakdown.csv","UTF-8");
		breakdown.println("Name Block, Question Number, Answer, Correct Answer");
		this.scores=new PrintWriter(title+"_Scores.csv","UTF-8");
		scores.println("Name Block, Number Correct, Total Points, Percent");
		
	}
	
	
	/**
	 * @throws FileNotFoundException
	 */
	public void grade() throws FileNotFoundException{
		Scanner kb = new Scanner(System.in);
		File folder = new File(inDirectory);
		for (File f : folder.listFiles()){
			Scanner quiz = new Scanner(f);
			String name = quiz.nextLine().substring(5).trim();
			String block = quiz.nextLine().substring(6).trim();
			quiz.nextLine();
			int key = Integer.parseInt(quiz.nextLine().substring(4).trim());
			quiz.nextLine();
			quiz.nextLine();
			String thisKey = answerKey.get(ids.indexOf(key));
			int c = 1;
			String[] questions = thisKey.split("</t>")[0].split(" < : > ");
			int total=questions.length;
			double score =0;
			while(quiz.hasNextLine()&&c-1<questions.length){
				if(!(questions[c-1].substring(0,1).equals("W"))){
					String answer = quiz.nextLine().substring((c+"").length()+1).trim().toUpperCase();
					String correct = swap(questions[c-1].charAt(questions[c-1].length()-1));
					char correctT = questions[c-1].charAt(questions[c-1].length()-1);
					System.out.println(correctT);
					if(!(correct.equals(answer))){
						breakdown.println(name+" "+block+", "+questions[c-1].charAt(0)+", "+answer+", "+correct);
					}else{
						score++;
					}
				}else{
					JFrame jf = new JFrame();
					jf.setVisible(true);
					jf.setLayout(new FlowLayout());
					TextField prompt = new TextField();
					prompt.setText(questions[c-1].split("</q>")[2]);
					jf.add(prompt);
					TextField response = new TextField();
					jf.add(response);
					JComboBox<Integer> scoreChooser = new JComboBox<Integer>();
					for(int i = 1;i<=Integer.parseInt(questions[c-1].split("</q>")[3]);i++){
						scoreChooser.addItem(i);
					}
					jf.add(scoreChooser);
					Button submit = new Button("Submit Score");
					submit.addActionListener(this);
					System.out.println("Written Response \n Prompt - "+questions[c-1].split("</q>")[2]);
					System.out.println("Score out of "+questions[c-1].split("</q>")[3]+" -> ");
					int points = kb.nextInt();
					score+=points;
				}
				c++;
			}
			scores.println(name+" "+block+", "+score+", "+total+", "+(score/total)*100);
		}
		scores.close();
		breakdown.close();
	}
	
	/**
	 * @param c
	 * @return ur mom
	 */
	public static String swap(Character c){
		
		if(c=='A'){
			return "0";
		}
		if(c=='B'){
			return "1";
		}
		if(c=='C'){
			return "2";
		}
		if(c=='D'){
			return "3";
		}
		if(c=='E'){
			return "4";
		}
		if(c=='0'){
			return "A";
		}
		if(c=='1'){
			return "B";
		}
		if(c=='2'){
			return "C";
		}
		if(c=='3'){
			return "D";
		}
		if(c=='4'){
			return "E";
		}else{
			return "";
		}
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		points = scoreChooser.getSelectedIndex();
		((Button)e.getSource()).getParent().setVisible(false);
		
	}
}
