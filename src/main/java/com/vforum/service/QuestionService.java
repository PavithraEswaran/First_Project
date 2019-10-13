package com.vforum.service;

import java.util.List;

import com.vforum.model.Questions;

public interface QuestionService {
	  public void addQuestion(Questions question);

	    public Questions getQuestion(int questionId);
	    
	    public List<Questions> getAllQuestions();
	    
	    public void editQuestion(Questions question);
	    
	    public void deleteQuestion(Questions question);
	    
	    public List<Questions> getAllQuestionByCategory(int categoryId);
}