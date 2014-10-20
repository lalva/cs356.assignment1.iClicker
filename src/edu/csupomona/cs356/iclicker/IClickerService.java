package edu.csupomona.cs356.iclicker;
import java.util.ArrayList;
import java.util.Hashtable;

public class IClickerService {
	private Hashtable<String, ArrayList<String>> submissions;
  private Question q;
  
  public IClickerService(Question q) {
    this.q = q;
  }
  
  public boolean submit(String uuid, ArrayList<String> submission) {
	ArrayList<String> uniqueSubmission = makeUnique(submission);
	ArrayList<String> validSubmission = new ArrayList<String>();
	for (String sub : uniqueSubmission) {
	  if (this.q.inChoices(sub)) {
		validSubmission.add(sub);
	  }
	}
	this.submissions.put(uuid, validSubmission);
	return false;
  }

  private ArrayList<String> makeUnique(ArrayList<String> submission) {
	return null;
  }
}
