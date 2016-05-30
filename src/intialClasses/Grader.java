package intialClasses;

import java.awt.Button;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.TextArea;
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
	/**
	 * The system path containing the .txt files with the students' responses.
	 */
	private String inDirectory;
	/**
	 * Outputs the .csv files containing the students' results to the desired output directory.
	 */
	private PrintWriter scores,breakdown;
	/**
	 * The list of ids written in the students' .txts
	 */
	private ArrayList<Integer> ids;
	/**
	 * Contains the line by line read of the given .test file
	 */
	ArrayList<String> answerKey;
	private int points,myMCWeight;
	private JComboBox<Integer> scoreChooser;
	
	/**
	 * @param testLoc
	 * The system path location of the .test file that corresponds with the test.
	 * @param inputDirectory The directory containing the student submitted .txt files.
	 * @param outputDirectory The desired location of the .csv output files.
	 * @param mcWeight The weight of the multiple choice answers. For example a 10 question test with 1 5-point written response and a weight of 1 would be worth a total of 14 points. A 10 question test with 1 5-point written response and a weight of 2 would be worth a total of 23 points. 
	 * @throws FileNotFoundException
	 * @throws UnsupportedEncodingException
	 * Constructs a Grader that outputs two .csv files to the given output directory. The .cvs contain the results when the given input directory of .txt student answers is checked against the .test answer key located at testLoc with the given multiple choice the weight .
	 * Throws a FileNotFoundError in the event that the given input, output or .test locations are invalid
	 */
	public Grader(String testLoc, String inputDirectory,String outputDirectory,int mcWeight) throws FileNotFoundException, UnsupportedEncodingException{
		this.answerKey=new ArrayList<String>();
		this.ids=new ArrayList<Integer>();
		this.inDirectory=inputDirectory;
		Scanner dotTestReader=new Scanner(new FileReader(testLoc));
		String title =dotTestReader.nextLine();
		this.myMCWeight=mcWeight;
		while(dotTestReader.hasNextLine()){
			answerKey.add(dotTestReader.nextLine());
		}
		for(String s : answerKey){
			ids.add(Integer.parseInt(s.split("</t>")[1]));
		}
		this.breakdown=new PrintWriter(outputDirectory+title+"_Breakdown.csv","UTF-8");
		breakdown.println("Name Block, Question Number, Answer, Correct Answer");
		this.scores=new PrintWriter(outputDirectory+title+"_Scores.csv","UTF-8");
		scores.println("Name Block, Number Correct, Total Points, Percent");
		
	}
	
	
	/**
	 * Grades the .txt files in the given input directory based on the given .test file path. For all written response questions this method will display a dialog containing the prompt of the question and what the student wrote for said question.
	 * The output of this method is two .csv files located in the path of the outputDirectory. One of the .csv files is called the breakdown, it contains the information on what multiple choice questions students incorrectly answered. 
	 * The second is the scores file, it contains the percent and ratio scores each student received.
	 * @throws FileNotFoundException
	 * 
	 */
	public void grade() throws FileNotFoundException{
		Scanner kb = new Scanner(System.in);
		File folder = new File(inDirectory);
		for (File f : folder.listFiles()){
			Scanner quiz = new Scanner(f);
			String name = quiz.nextLine().substring(5).trim();
			String block = quiz.nextLine().substring(6).trim();
			quiz.nextLine();
			String temp = quiz.nextLine().substring(4).trim();
			int key = Integer.parseInt(temp);
			quiz.nextLine();
			quiz.nextLine();
			String thisKey = answerKey.get(ids.indexOf(key));
			int c = 1;
			String[] questions = thisKey.split("</t>")[0].split(" < : > ");
			int total=0;
			double score =0;
			while(quiz.hasNextLine()&&c-1<questions.length){
				if(!(questions[c-1].substring(0,1).equals("W"))){
					String answer = quiz.nextLine().substring((c+"").length()+1).trim().toUpperCase();
					String correct = swap(questions[c-1].charAt(questions[c-1].length()-1));
					char correctT = questions[c-1].charAt(questions[c-1].length()-1);
					if(!(correct.equals(answer))){
						breakdown.println(name+" "+block+", "+questions[c-1].charAt(0)+", "+answer+", "+correct);
					}else{
						score+=this.myMCWeight;
					}
					total+=myMCWeight;
				}else{
					Dialog jf = new Dialog(new JFrame(),"Written Response Scoring");
					jf.setLayout(new FlowLayout());
					jf.setLocationRelativeTo(jf.getParent());
					TextArea prompt = new TextArea();
					Label promptLabel = new Label("Prompt: ");
					Label responseLabel = new Label("Response: ");
					prompt.setSize(200, 100);
					prompt.setText(questions[c-1].split("</q>")[2]);
					jf.add(promptLabel);
					jf.add(prompt);
					TextArea response = new TextArea();
					response.setSize(200, 100);
					response.setText(quiz.nextLine().substring((c+".").length()).trim());
					jf.add(responseLabel);
					jf.add(response);
					scoreChooser = new JComboBox<Integer>();
					for(int i = 0;i<=Integer.parseInt(questions[c-1].split("</q>")[3]);i++){
						scoreChooser.addItem(i);
					}
					jf.add(scoreChooser);
					Button submit = new Button("Submit Score");
					jf.add(submit);
					jf.pack();
					submit.addActionListener(this);
					jf.setModal(true);
					jf.setVisible(true);
					score+=points;
					total+=Integer.parseInt(questions[c-1].split("</q>")[3]);
				}
				c++;
			}
			scores.println(name+" "+block+", "+score+", "+total+", "+(score/total)*100);
		}
		scores.close();
		breakdown.close();
	}
	
	/**
	 * @param c A character that is either a number 0-4 or a letter A-E
	 * @return The corresponding letter if the input is a number, i.e 0 returns A. And vice-versa.
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
