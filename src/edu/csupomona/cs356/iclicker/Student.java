package edu.csupomona.cs356.iclicker;
import java.util.ArrayList;

// A student has a uuid, and an answer. To make things simple my uuid
// is just a number which is derived from count which keeps track
// of the number of instances created. A student also has answers.
// As a student you can enter answers, submit answers, and check
// answers.
public class Student {
  private static int count = 0;
  
  private String uuid;
  private ArrayList<String> answers;
  
  public Student() {
    count += 1;
    this.uuid = "" + count;
  }
  
  // Store generated answers (can be random or manually input)
  public boolean enterAnswers(ArrayList<String> input) {
    this.answers = input;
    return true;
  }
  
  // Submit the stored answers
  public boolean submitAnswers(IClickerService iClick) {
	if (this.answers == null) {
	  return false;
	}
    return iClick.submit(this.uuid, this.answers);
  }

  // check the stored answers comment out the System.out to be more verbose
  public void checkAnswer(IClickerService iClick) {
	@SuppressWarnings("unused")
	String check = iClick.checkA(this.uuid);
	//System.out.println(this.uuid + ": " + check);
  }
}
