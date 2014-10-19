package edu.csupomona.cs356.iclicker;

import java.util.Hashtable;

public class IClickerService {
  private Hashtable<String, String[]> submissions;
  
  public IClickerService() {
    this(new SingleChoiceQuestion());
  }
  
  public IClickerService(Question q) {
    
  }
  
  public boolean submit(String uuid, String[] answers) {
	submissions.put(uuid, answers);
	return false;
  }
}
