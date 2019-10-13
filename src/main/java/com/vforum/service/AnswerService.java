  
package com.vforum.service;

import java.util.List;

import com.vforum.model.Answers;



public interface AnswerService {
	 public void addAnswer(Answers answer);

	    public Answers getAnswer(int answerId);
	    
	    public List<Answers> getAllAnswers();
	    
	    public void editAnswer(Answers answer);
	    
	    public void deleteAnswer(Answers answer);
	    
	    public List<Answers> getAnswersByQuestionId(int questionId);
}