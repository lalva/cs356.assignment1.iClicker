package edu.csupomona.cs356.iclicker;
import java.util.ArrayList;

public class MultipleChoiceQuestion extends Question {
  public MultipleChoiceQuestion(String q, ArrayList<String> a, ArrayList<String> correct) {
	super(q, a, correct);
  }
  
  public String checkA(ArrayList<String> submittedAnswers) {
	if (submittedAnswers.size() < 1) {
	  return "Please submit at least one answer.";
	} else {
	  boolean correct = true;
	  for (Integer i = 0; i < this.a.size(); i++) {
		correct = submittedAnswers.remove(a.get(i));
		if (!correct) {
		  break;
		}
	  }
	  if (!correct || submittedAnswers.size() != 0) {
		return "Your answer is incorrect. The correct answer is "+this.a.toString();
	  } else {
		return "Your answer is correct!";
	  }
	}
  }
}