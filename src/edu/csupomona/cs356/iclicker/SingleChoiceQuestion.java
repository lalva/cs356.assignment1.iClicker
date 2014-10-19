package edu.csupomona.cs356.iclicker;

public class SingleChoiceQuestion extends Question {
  public String checkA(String[] submittedAnswers) {
	if (submittedAnswers.length != 1) {
	  return "This is a single choice answer, please submit one answer.";
	} else {
	  if (this.a[0].compareTo(submittedAnswers[0]) == 0) {
		return "You have chosen the correct answer";
	  } else {
		return "Your answer is incorrect. The correct answer is: "+this.a[0];
	  }
	}
  }
}