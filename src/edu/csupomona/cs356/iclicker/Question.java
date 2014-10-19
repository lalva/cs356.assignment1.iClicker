package edu.csupomona.cs356.iclicker;

public abstract class Question {
  protected String q;
  protected String[] a;
  
  public Question() {
    this.q = "Pass me a question!";
    this.a = null;
  }
  
  public Question(String question, String[] answers) {
	this.q = question;
	this.a = answers;
  }
  
  public String getQ() {
	return q;
  }
  
  public String[] getA() {
	return a;
  }
  
  public boolean setA(String[] answers) {
	return (a = answers).equals(answers);
  }
  
  public abstract String checkA(String[] submittedAnswers);
}
