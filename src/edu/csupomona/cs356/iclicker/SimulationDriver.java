package edu.csupomona.cs356.iclicker;

public class SimulationDriver {
  public static void main(String[] args) {
	String q;
	String[] a;
	String qType;
	Question question;
    // create question
	qType = "SingleChoice";
	q = "Is OOP fun?";
    // create answers
	a = new String[]{"True", "False"};
	
	switch(qType) {
	case "MultipleChoice":
	  question = new MultipleChoiceQuestion(q, a);
	}

    // configure IClickerService

    // create students

    // for each student submit an answer

    // for some students submit a 2nd answer

    // for each student check answers and notify the student

    // show statistics
    System.out.println("You haven't done anything yet...");
  }
};
