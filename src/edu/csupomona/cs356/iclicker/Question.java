package edu.csupomona.cs356.iclicker;

public class Question {
  protected String q;
  protected String type;
  protected String[] correctAnswers;
  
  public Question() {
    this.q = "Default Question?";
    this.type = "Default";
  }
}
