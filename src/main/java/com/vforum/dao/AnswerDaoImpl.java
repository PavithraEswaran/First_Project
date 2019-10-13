package com.vforum.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vforum.model.Answers;

@Repository
public class AnswerDaoImpl implements AnswerDao {
	 @Autowired
	    private SessionFactory sessionFactory;
	 
	   
	
	public void addAnswer(Answers answer) {
		sessionFactory.getCurrentSession().save(answer);

	}

	public Answers getAnswer(int answerId) {
		return (Answers) sessionFactory.getCurrentSession().get(
	             Answers.class, answerId);
	}

	@SuppressWarnings("unchecked")
	public List<Answers> getAllAnswers() {
		String hql="from Answers";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		List<Answers> newList=query.list();
				//sessionFactory.getCurrentSession().createQuery("select a from Answers a").list();
//		 return sessionFactory.getCurrentSession().createQuery("from Answers")
//	                .list();
//		for(int i=0;i<newList.size();i++)
//		System.out.println(newList.get(i).getAnswerDescription());
		return newList;
	}

	public void editAnswer(Answers answer) {
		sessionFactory.getCurrentSession().update(answer);
	}

	public void deleteAnswer(Answers answer) {
		sessionFactory.getCurrentSession().delete(answer);
		
	}

	public List<Answers> getAnswersByQuestionId(int questionId) {
		String hql="from Answers where questionId="+questionId;
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		List<Answers> newList=query.list();
				//sessionFactory.getCurrentSession().createQuery("select a from Answers a").list();
//		 return sessionFactory.getCurrentSession().createQuery("from Answers")
//	                .list();
//		for(int i=0;i<newList.size();i++)
//		System.out.println(newList.get(i).getAnswerDescription());
		return newList;
	}

}