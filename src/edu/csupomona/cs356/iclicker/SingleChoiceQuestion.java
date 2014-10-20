package edu.csupomona.cs356.iclicker;
import java.util.ArrayList;

public class SingleChoiceQuestion extends Question {
  public SingleChoiceQuestion(String q, ArrayList<String> a, ArrayList<String> correct) {
    super(q, a, correct);
  }
  
  public String checkA(ArrayList<String> submittedAnswers) {
	if (submittedAnswers.size() != 1) {
	  return "This is a single choice answer, please submit one answer.";
	} else {
	  if (this.a.get(0).compareTo(submittedAnswers.get(0)) == 0) {
		return "You have chosen the correct answer";
	  } else {
		return "Your answer is incorrect. The correct answer is: "+this.a.get(0);
	  }
	}
  }
}