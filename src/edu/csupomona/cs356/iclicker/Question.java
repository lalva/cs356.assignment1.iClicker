package edu.csupomona.cs356.iclicker;
import java.util.ArrayList;

// Abstract class for Single/Multi choice questions
// Stores the question in `q`, all the available answer choices
// in `choices`, and the correct choices in `correct`
public abstract class Question {
  protected String q;
  protected ArrayList<String> choices;
  protected ArrayList<String> correct;
  
  public Question(String question, ArrayList<String> choices, ArrayList<String> correct) {
	this.q = question;
	this.choices = choices;
	this.correct = correct;
  }
  
  // Getter for the question.
  public String getQuestion() {
	return this.q;
  }

  // Getter for the choices
  public ArrayList<String> getChoices() {
	return choices;
  }

  // Make sure a choice is valid
  public boolean inChoices(String submission) {
	return this.choices.contains(submission);
  }
  
  // A prototype method for checking answer(s)
  public abstract String checkA(ArrayList<String> submittedAnswers);
}
