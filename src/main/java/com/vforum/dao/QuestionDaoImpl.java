package com.vforum.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.vforum.model.Questions;
@Repository
public class QuestionDaoImpl implements QuestionDao {
	 @Autowired
	    private SessionFactory sessionFactory;
	 
	   
	public void addQuestion(Questions question) {
		
		  sessionFactory.getCurrentSession().save(question);
	}

	public Questions getQuestion(int questionId) {
		return (Questions) sessionFactory.getCurrentSession().get(
                Questions.class, questionId);
	}
	@SuppressWarnings({ "unchecked" })
    public List<Questions> getAllQuestions() {
 
        return sessionFactory.getCurrentSession().createQuery("select q from Questions q")
                .list();
    }

	public void editQuestion(Questions question) {
		
		 sessionFactory.getCurrentSession().update(question);
	}

	public void deleteQuestion(Questions question) {
		sessionFactory.getCurrentSession().delete(question);
		
	}
	@SuppressWarnings("unchecked")
	public List<Questions> getAllQuestionByCategory(int categoryId) {
		return sessionFactory.getCurrentSession().createQuery("from Questions q where categoryId="+categoryId) .list();
	}

}