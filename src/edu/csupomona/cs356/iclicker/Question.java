package edu.csupomona.cs356.iclicker;
import java.util.ArrayList;

public abstract class Question {
  protected String q;
  protected ArrayList<String> a;
  protected ArrayList<String> correct;
  
  public Question(String question, ArrayList<String> answers, ArrayList<String> correct) {
	this.q = question;
	this.a = answers;
	this.correct = correct;
  }
  
//  public String getQ() {
//	return q;
//  }
//  
//  public ArrayList<String> getA() {
//	return a;
//  }
//  
//  public boolean setA(ArrayList<String> answers) {
//	return (a = answers).equals(answers);
//  }
  
  public abstract String checkA(ArrayList<String> submittedAnswers);

  public boolean inChoices(String submission) {
	return false;
  }
}
