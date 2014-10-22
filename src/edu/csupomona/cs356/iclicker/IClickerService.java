package edu.csupomona.cs356.iclicker;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

// IClickerService stores submissions and uses the question to
// validate submissions and show statistics for question choices.
// submissions_end tells the instance when we have stopped colelcting
// submissions and num_correct keeps track of how many submissions
// were correct, used for statistics.
public class IClickerService {
  private Hashtable<String, ArrayList<String>> submissions;
  private Question q;
  private boolean submissions_end;
  private Integer num_correct;
  
  public IClickerService(Question q) {
    this.q = q;
    this.submissions = new Hashtable<String, ArrayList<String>>();
    this.submissions_end = false;
    this.num_correct = 0;
    
  }
  
  // Accept a submission from a student. Validate the submission by
  // making sure the answers submitted are in the domain of the choices
  // and there are no repeat answers.
  public boolean submit(String uuid, ArrayList<String> submission) {
	if (this.submissions_end) {
	  return false;
	}
	ArrayList<String> uniqueSubmission = makeUnique(submission);
	ArrayList<String> validSubmission = new ArrayList<String>();
	for (String sub : uniqueSubmission) {
	  if (this.q.inChoices(sub)) {
		validSubmission.add(sub);
	  }
	}
	this.submissions.put(uuid, validSubmission);
	return true;
  }

  // Only allow one of the same answer. no I, I, I, I, I submissions.
  private ArrayList<String> makeUnique(ArrayList<String> submission) {
	Set<String> temp = new HashSet<String>(submission);
	ArrayList<String> uq = new ArrayList<String>();
	uq.addAll(temp);
	return uq;
  }

  // Print out statistics for this iClicker instance.
  public String showStats() {
	String stats = "Question:\n";
	stats += q.getQuestion();
	stats += "\n-----------------";
	stats += "\nAnswer Statistics\n";
	stats += "-----------------\n";
	ArrayList<String> choices = this.q.getChoices();
	for (String choice : choices) {
	  Integer numChoice = 0;
	  for (String uuid : submissions.keySet()) {
		if (submissions.get(uuid).contains(choice)) {
		  numChoice++;
		}
	  }
	  stats += choice + "\t\t\t" + numChoice.toString() + "\n";
	}
	stats += "-----------------\n";
	stats += "Total Submissions: " + this.totalSubmissions().toString();
	stats += "\nTotal Correct: " + this.num_correct;
	stats += "\n\n";
	return stats;
  }

  // Return the total number of submissions
  public Integer totalSubmissions() {
	return this.submissions.size();
  }
  
  // Stop accepting submissions
  public void endSubmissions() {
	this.submissions_end = true;
  }

  // Allow answers to be checked only if submissions have ended
  public String checkA(ArrayList<String> answers) {
	if (!submissions_end) {
	  return "Please wait until submission collection has ended.";
	}
	String check = q.checkA(answers);
	if (check.compareTo("Your answer is correct!") == 0) {
	  this.num_correct++;
	}
	return check;
  }
}
