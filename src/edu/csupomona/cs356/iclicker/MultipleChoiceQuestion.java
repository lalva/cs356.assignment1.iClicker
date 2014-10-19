package edu.csupomona.cs356.iclicker;

public class MultipleChoiceQuestion extends Question {
  public MultipleChoiceQuestion() {
    super();
    this.type = "MultipleChoice";
  }
  
  public MultipleChoiceQuestion(String q) {
    this.q = q;
    this.type = "MultipleChoice";
  }
}