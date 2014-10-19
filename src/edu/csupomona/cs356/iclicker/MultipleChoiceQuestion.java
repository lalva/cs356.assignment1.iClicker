package edu.csupomona.cs356.iclicker;
import java.util.Arrays;
import java.util.ArrayList;

public class MultipleChoiceQuestion extends Question {
  public MultipleChoiceQuestion(String q, String[] a) {
	super(q, a);
  }
  
  public String checkA(String[] submittedAnswers) {
	if (submittedAnswers.length < 1) {
	  return "Please submit at least one answer.";
	} else {
	  boolean correct = true;
	  ArrayList<String> check = new ArrayList<String>(Arrays.asList(submittedAnswers));
	  for (Integer i = 0; i < this.a.length; i++) {
		correct = check.remove(a[i]);
		if (!correct) {
		  break;
		}
	  }
	  if (!correct || check.size() != 0) {
		return "Your answer is incorrect. The correct answer is "+this.a.toString();
	  } else {
		return "Your answer is correct!";
	  }
	}
  }
}