package com.miniproject.quiz;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class QuestionClass {
	private ArrayList<Question> questionSet;
	public QuestionClass() {
		questionSet=new ArrayList<Question>();
		String q = "Number of Primitive data types in java are?";
		String []a = {"5","6","7","8"};
		questionSet.add(new Question(q,a,"8"));
		
		q="Automatic type conversion is possible in which of the possible cases?";
		a=new String[] {"Byte to int","int to Long","Long to int","Short to int"};
		questionSet.add(new Question(q,a,"int to Long"));
		
		q="Arrays in java are-";
		a=new String[] {"Object references","Objects","Primitive data type","None"};
		questionSet.add(new Question(q,a,"Objects"));
		
		q="When is the object created with new keyword?";
		a=new String[] {"At run time","At compile time","Dependes on code","None"};
		questionSet.add(new Question(q,a,"At run time"));
		
		q="Identify the keyword among the following that makes a variable belong to a class,rather than being defined for each instance of the class.";
		a=new String[] {"final","static","volitile","abstract"};
		questionSet.add(new Question(q,a,"static"));
		
		q="In which of the following is toString() method defined?";
		a=new String[] {"java.lang.Object","java.lang.String","java.lang.util","None"};
		questionSet.add(new Question(q,a,"java.lang.Object"));
		
		q="Identify the return type of a method that does not return any value.";
		a=new String[] {"int","void","double","None"};
		questionSet.add(new Question(q,a,"void"));
		
		q="Where does the system stores parameters and local variables whenever a method is invoked?";
		a=new String[] {"Heap","Stack","Array","Tree"};
		questionSet.add(new Question(q,a,"Stack"));
		
		q="Identify the modifier which cannot be used for constructor.";
		a=new String[] {"public","protected","private","static"};
		questionSet.add(new Question(q,a,"static"));
		
		q="What is the variables declared in a class for the use of all methods of the class called?";
		a=new String[] {"Object","Instance variable","Reference variable","None"};
		questionSet.add(new Question(q,a,"Instance variable"));
			
		Collections.shuffle(questionSet,new Random());	
	}
	static int count=0;
	public void startQuiz() {
		Scanner sc =new Scanner(System.in);
		
//		"It shows question from questionSet"
		for (int question=0;question<questionSet.size();question++) {
			System.out.println((question +1)+") "+questionSet.get(question).getQuestion());

//      "show choices of question from questionSet"		
			int choicesNum=questionSet.get(question).getChoices().size();
			for(int choice=0;choice<choicesNum;choice++) {
				System.out.println((choice+1) +": " +questionSet.get(question).getChoices().get(choice));		
			}
			int playAnswer=sc.nextInt();
			ArrayList <String> choiceSet =questionSet.get(question).getChoices();
			
			String correctanswer =questionSet.get(question).getAnswer();
			int correctAnswerIndex =choiceSet.indexOf(correctanswer);
			if(playAnswer ==correctAnswerIndex +1) {
				count++;
			}
			
		}
//		sc.close();
		System.out.println("Your score is "+count);
		if(count>=8) {
			System.out.println("You got Class A grade");
		}else if(count<8 && count>=6) {
			System.out.println("You got Class B grade");
		}else if(count==5) {
			System.out.println("You got Class C grade");
		}else {
			System.out.println("You failed the test,Better luck for Next Time");
		}
	}

}
