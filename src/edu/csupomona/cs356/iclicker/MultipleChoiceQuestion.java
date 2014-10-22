package edu.csupomona.cs356.iclicker;
import java.util.ArrayList;

public class MultipleChoiceQuestion extends Question {
  public MultipleChoiceQuestion(String q, ArrayList<String> a, ArrayList<String> correct) {
	super(q, a, correct);
  }
  
  // Check the multiple choice answer, make sure at least one answer was submitted.
  public String checkA(ArrayList<String> submittedAnswers) {
	if (submittedAnswers.size() < 1) {
	  return "Please submit at least one answer.";
	} else {
	  boolean correct = true;
	  ArrayList<String> temp = new ArrayList<String>(submittedAnswers);
	  for (Integer i = 0; i < this.correct.size(); i++) {
		correct = temp.remove(this.correct.get(i));
		if (!correct) {
		  break;
		}
	  }
	  if (!correct || temp.size() != 0) {
		return "Your answer is incorrect. The correct answer is "+this.correct.toString();
	  } else {
		return "Your answer is correct!";
	  }
	}
  }
}