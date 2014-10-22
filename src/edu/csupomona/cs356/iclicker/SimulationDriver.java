package edu.csupomona.cs356.iclicker;
import java.util.ArrayList;
import java.util.Random;

/*
I designed this application while keeping in mind that I can switch out the
driver with something more console driven, where you can enter all of these
variables in manually, then each student can submit their answer. I didn't
have the time to make this alternate Driver but if you think about this while
looking over my code you'll have a better understanding of why I did some of
this differently.

There are a few things I could have done differently. Let me know if there is
anywhere I could have used an Interface in this project, I'm sure not sure
how to use them effectively.
 */
public class SimulationDriver {
  public static void main(String[] args) {
	ArrayList<IClickerService> services = new ArrayList<IClickerService>();
	ArrayList<String> singleChoices = new ArrayList<String>();
	ArrayList<String> multiChoices = new ArrayList<String>();
	ArrayList<String> answer = new ArrayList<String>();
	ArrayList<String> answers = new ArrayList<String>();
	
	singleChoices.add("True");
	singleChoices.add("False");
	answer.add(singleChoices.get(0));
	
    multiChoices.add("Yes");
    multiChoices.add("No");
    multiChoices.add("Maybe");
    answers.add(multiChoices.get(0));
    answers.add(multiChoices.get(2));

	services.add(SimulationRun("SingleChoice", "Is OOP fun?", singleChoices, answer, 25));
	//Throws an exception
	//services.add(SimulationRun("SingleChoice", "Is OOP fun?", singleChoices, answers, 25));
	services.add(SimulationRun("MultipleChoice", "Is this an awesome program?", multiChoices, answers, 45));
  }
  
  // Start a simulation, this is a wrapper so you can have multiple runs.
  private static IClickerService SimulationRun(String qType, String q, ArrayList<String> choices, ArrayList<String> answers, Integer num_students) {
	Question question;
	IClickerService iClicker;
	Student[] students = new Student[num_students];
    
	// 1)
	// create a question type and configure the answers
	switch(qType) {
	case "MultipleChoice":
	  question = new MultipleChoiceQuestion(q, choices, answers);
	  break;
	default:
	  question = new SingleChoiceQuestion(q, choices, answers);
	  break;
	}

	// 2)
    // configure IClickerService
	iClicker = new IClickerService(question);

	// 3 and 4)
    // create students, generate an answer, then submit the answer
	for (Integer i = 0; i < students.length; i++) {
	  students[i] = new Student();
	  students[i].enterAnswers(rand_gen_answers(choices, qType));
	  students[i].submitAnswers(iClicker);
	}
	if (iClicker.totalSubmissions() != num_students) {
	  System.err.println("Number of submissions is " + iClicker.totalSubmissions().toString());
	}
	System.out.println("Before submissions are over.");
    System.out.println(iClicker.showStats());

    // for some students submit a 2nd answer
	for (Integer i = 0; i < students.length; i += 5) {
	  students[i].enterAnswers(rand_gen_answers(choices, qType));
	  students[i].submitAnswers(iClicker);
	}
	if (iClicker.totalSubmissions() != num_students) {
	  System.err.println("Number of submissions is " + iClicker.totalSubmissions().toString());
	}
	
	// end submissions
	iClicker.endSubmissions();

    // for each student check answers and notify the student
	for (Student student : students) {
	  student.checkAnswer(iClicker);
	}
	
	// 5)
    // show statistics
	System.out.println("After answers have been checked.");
    System.out.println(iClicker.showStats());
    return iClicker;
  }

  // Randomly generate answers, duplicate answers can be in the returning array.
  // Does not allow answers outside of the available choices.
  private static ArrayList<String> rand_gen_answers(ArrayList<String> choices, String type) {
	Integer numAnswers = 1;
	Random rand = new Random();
	ArrayList<String> answers = new ArrayList<String>();
	if (type == "MultipleChoice") {
	  numAnswers = rand.nextInt(choices.size() - 1) + 1;
	}
	for (Integer i = 0; i < numAnswers; i++) {
	  answers.add(choices.get(rand.nextInt(choices.size())));
	}
	return answers;
  }
};
