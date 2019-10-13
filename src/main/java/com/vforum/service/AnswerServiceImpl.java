package com.vforum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vforum.dao.AnswerDao;
import com.vforum.dao.QuestionDao;
import com.vforum.model.Answers;
import com.vforum.model.Questions;
@Service
@Transactional
public class AnswerServiceImpl implements AnswerService {
	

	 
	    @Autowired
	    private AnswerDao answerDAO;
	 
	    @Transactional
	    
	public void addAnswer(Answers answer) {
		answerDAO.addAnswer(answer);

	}

 
    @Transactional
	public List<Answers> getAllAnswers() {
		// TODO Auto-generated method stub
		return answerDAO.getAllAnswers();
	}

	public void editAnswer(Answers answer) {
		// TODO Auto-generated method stub
		answerDAO.editAnswer(answer);
	}

	public void deleteAnswer(Answers answer) {
		// TODO Auto-generated method stub
		answerDAO.deleteAnswer(answer);
	}

	public List<Answers> getAnswersByQuestionId(int questionId) {
		// TODO Auto-generated method stub
		return answerDAO.getAnswersByQuestionId(questionId);
	}
	public Answers getAnswer(int answerId) {
		 return answerDAO.getAnswer(answerId);
	}

   public void setAnswerDao(AnswerDao answerDAO) {
       this.answerDAO = answerDAO;
   }

}