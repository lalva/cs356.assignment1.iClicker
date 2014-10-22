package edu.csupomona.cs356.iclicker;
import java.util.ArrayList;

public class SingleChoiceQuestion extends Question {
  public SingleChoiceQuestion(String q, ArrayList<String> a, ArrayList<String> correct) {
    super(q, a, correct);
  }
  
  // Check the answer of the submission, only allow one answer since this is single choice.
  public String checkA(ArrayList<String> submittedAnswers) {
	if (submittedAnswers.size() != 1) {
	  return "This is a single choice answer, please submit one answer.";
	} else {
	  if (this.correct.get(0).compareTo(submittedAnswers.get(0)) == 0) {
		return "Your answer is correct!";
	  } else {
		return "Your answer is incorrect. The correct answer is: "+this.correct.get(0);
	  }
	}
  }
}