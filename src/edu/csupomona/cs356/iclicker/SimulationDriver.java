package edu.csupomona.cs356.iclicker;
import java.util.Arrays;
import java.util.ArrayList;

public class SimulationDriver {
  public static void main(ArrayList<String> args) {
	String qType;
	String q;
	ArrayList<String> choices;
	Question question;
	IClickerService iClicker;
	Integer NUM_STUDENTS = 35;
	Student[] students = new Student[NUM_STUDENTS];
    
	// 1)
	// create a question type and configure the answers
	qType = "SingleChoice";
	q = "Is OOP fun?";
	
	switch(qType) {
	case "MultipleChoice":
	  choices = new ArrayList<String>();
	  choices.add("Yes");
	  choices.add("No");
	  choices.add("I don't know");
	  ArrayList<String> answers = new ArrayList<String>();
	  answers.add(choices.get(0));
	  answers.add(choices.get(2));
	  question = new MultipleChoiceQuestion(q, choices, answers);
	  break;
	default:
	  choices = new ArrayList<String>();
	  choices.add("True");
	  choices.add("False");
	  ArrayList<String> answer = new ArrayList<String>();
	  answer.add(choices.get(0));
	  question = new SingleChoiceQuestion(q, choices, answer);
	}

	// 2)
    // configure IClickerService
	iClicker = new IClickerService(question);

	// 3 and 4)
    // create students, generate an answer, then submit the answer
	for (Student student : students) {
	  student = new Student();
	  student.enterAnswers(rand_gen_answers(choices));
	  student.submitAnswers(iClicker);
	}

    // for some students submit a 2nd answer
	for (Integer i = 0; i < students.length; i += 5) {
	  students[i].enterAnswers(rand_gen_answers(choices));
	  students[i].submitAnswers(iClicker);
	}

    // for each student check answers and notify the student
	for (Student student : students) {
	  student.checkAnswer(question);
	}
	
	// 5)
    // show statistics
    System.out.println("You haven't done anything yet...");
  }

  private static ArrayList<String> rand_gen_answers(ArrayList<String> choices) {
	return null;
  }
};
