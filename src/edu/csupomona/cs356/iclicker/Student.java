package edu.csupomona.cs356.iclicker;
import java.util.ArrayList;

public class Student {
  private static int count = 0;
  
  private String uuid;
  private ArrayList<String> answers;
  
  public Student() {
    count += 1;
    this.uuid = "" + count;
  }
  
  public boolean enterAnswers(ArrayList<String> input) {
    this.answers = input;
    return true;
  }
  
  public boolean submitAnswers(IClickerService iClick) {
    return iClick.submit(this.uuid, this.answers);
  }

  public void checkAnswer(Question question) {
	System.out.println(question.checkA(answers));
  }
}
