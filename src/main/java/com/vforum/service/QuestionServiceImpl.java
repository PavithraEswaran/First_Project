package com.vforum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vforum.dao.QuestionDao;
import com.vforum.model.Questions;
	 
		@Service
		@Transactional
		public class QuestionServiceImpl implements QuestionService {
		 
		    @Autowired
		    private QuestionDao questionDAO;
		 
		    @Transactional
		    public void addQuestion(Questions question) {
		    	questionDAO.addQuestion(question);
		    }
		 
		    public Questions getQuestion(int questionId) {
		        return questionDAO.getQuestion(questionId);
		    }
		 
		 
		    public void setQuestionDAO(QuestionDao questionDAO) {
		        this.questionDAO = questionDAO;
		    
		 
		}

		    public List<Questions> getAllQuestions() {
		 
		       return questionDAO.getAllQuestions();
		    }

			public void editQuestion(Questions question) {
				questionDAO.editQuestion(question);
				
			}

			public void deleteQuestion(Questions question) {
				questionDAO.deleteQuestion(question);
				
			}

			public List<Questions> getAllQuestionByCategory(int categoryId) {
				return questionDAO.getAllQuestionByCategory(categoryId);
			}


	}
