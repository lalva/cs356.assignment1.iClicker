package edu.csupomona.cs356.iclicker;

public class Student {
  private static int count = 0;
  
  private String uuid;
  private String[] answers;
  
  public Student() {
    count += 1;
    this.uuid = "" + count;
  }
  
  public boolean enterAnswers(String[] input) {
    this.answers = input;
    return true;
  }
  
  public boolean submitAnswers(IClickerService iClick) {
    return iClick.submit(this.uuid, this.answers);
  }
}
