package edu.csupomona.cs356.iclicker;

public class SingleChoiceQuestion extends Question {  
  public SingleChoiceQuestion() {
    super();
    this.type = "Boolean";
  }
  
  public SingleChoiceQuestion(String q) {
    this.q = q;
    this.type = "Boolean";
  }
}