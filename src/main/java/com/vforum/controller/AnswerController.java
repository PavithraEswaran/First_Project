package com.vforum.controller;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.vforum.model.Answers;
import com.vforum.model.Questions;
import com.vforum.service.AnswerService;
import com.vforum.service.EmployeeService;
import com.vforum.service.QuestionService;

@Controller
public class AnswerController {

	
	Logger log = Logger.getLogger(this.getClass());

	 @Autowired
	    private EmployeeService employeeService;
	    @Autowired
	    private AnswerService answerService;
	    @Autowired
	    private QuestionService questionService;
	    
	    
	    
	    @RequestMapping(value ="/postAnswer", method = RequestMethod.GET)    
	    public ModelAndView postAnswer(ModelAndView model,HttpSession session,HttpServletRequest request){    
	    	try {
				String log4jConfigFile = "C:\\projects\\Vforum\\src\\main\\webapp\\WEB-INF\\log4j.properties";
				PropertyConfigurator.configure(log4jConfigFile);
				log.info("This is /postanswer Page Log");
	    	
	    	Answers answer=new Answers();
	    	long milli=System.currentTimeMillis();
			Date currentDate=new Date(milli);
	    	answer.setDate(currentDate);
	    	int employeeId=(Integer) session.getAttribute("employeeId");
	    	int questionId = Integer.parseInt(request.getParameter("id"));
	    	answer.setQuestion(questionService.getQuestion(questionId));
	        answer.setEmployee(employeeService.getEmployee(employeeId));
	    	model.addObject("answer", answer);
	        model.setViewName("Answer");
	        
	        return model;
	    	} catch (Exception e) {
				log.error("Error is in post answer " + e);
			}
	    	return null;
  
	       
	    }
	 
	    @RequestMapping(value = "/addAnswer", method = RequestMethod.POST)
	    public ModelAndView addAnswer(@ModelAttribute Answers answer) {
	    	try {
				String log4jConfigFile = "C:\\projects\\Vforum\\src\\main\\webapp\\WEB-INF\\log4j.properties";
				PropertyConfigurator.configure(log4jConfigFile);
				log.info("This is /addanswer Page Log");
	    	
	    	answerService.addAnswer(answer);
	        ModelAndView m=new ModelAndView();
	        List<Questions> allQuestions=questionService.getAllQuestions();
	        m.addObject("allQuestions",allQuestions);
	        List<Answers> allAnswers=answerService.getAllAnswers();
	        m.addObject("allAnswers",allAnswers);
	        m.setViewName("home");
	        return m;
	    	} catch (Exception e) {
				log.error("Error is in add answer " + e);
			}
	    	return null;
	       
	    }
	    @RequestMapping(value = "/editAnswer", method = RequestMethod.GET)
	    public ModelAndView editAnswer(HttpServletRequest request) {
	    	
	    	try {
				String log4jConfigFile = "C:\\projects\\Vforum\\src\\main\\webapp\\WEB-INF\\log4j.properties";
				PropertyConfigurator.configure(log4jConfigFile);
				log.info("This is /editanswer Page Log");
	    
	        int answerId = Integer.parseInt(request.getParameter("aid"));
	        Answers answer = answerService.getAnswer(answerId);
	        ModelAndView model = new ModelAndView();
	        model.addObject("answer", answer);
	        model.setViewName("editAnswer");
	        return model;
	    	} catch (Exception e) {
				log.error("Error is in edit answer " + e);
			}
	    	return null;
	    }
	   
	    @RequestMapping(value = "/editAnswerProcess", method = RequestMethod.GET)
	    public ModelAndView editAnswerProcess(@ModelAttribute Answers answer) {
	    	
	    	try {
				String log4jConfigFile = "C:\\projects\\Vforum\\src\\main\\webapp\\WEB-INF\\log4j.properties";
				PropertyConfigurator.configure(log4jConfigFile);
				log.info("This is /postanswer Page Log");
	    
	    	answerService.editAnswer(answer);
	        ModelAndView model = new ModelAndView();
	        List<Questions> allQuestions=questionService.getAllQuestions();
	        model.addObject("allQuestions",allQuestions);
	        List<Answers> allAnswers=answerService.getAllAnswers();
	        model.addObject("allAnswers",allAnswers);
	        model.setViewName("home");
	        return model;
	    	} catch (Exception e) {
				log.error("Error is in post answer " + e);
			}
	    	return null;
	    }
	    @RequestMapping(value = "/deleteAnswer", method = RequestMethod.GET)
	    public ModelAndView deleteQuestion(HttpServletRequest request) {
	    	try {
				String log4jConfigFile = "C:\\projects\\Vforum\\src\\main\\webapp\\WEB-INF\\log4j.properties";
				PropertyConfigurator.configure(log4jConfigFile);
				log.info("This is /deleteanswer Page Log");
	    
	        int answerId = Integer.parseInt(request.getParameter("aid"));
	        Answers answer = answerService.getAnswer(answerId);
	        answerService.deleteAnswer(answer);
	        ModelAndView model = new ModelAndView();
	        List<Questions> allQuestions=questionService.getAllQuestions();
	        model.addObject("allQuestions",allQuestions);
	        List<Answers> allAnswers=answerService.getAllAnswers();
	        model.addObject("allAnswers",allAnswers);
	        model.setViewName("home");
	        return model;
	    	} catch (Exception e) {
				log.error("Error is in delete answer " + e);
			}
	    	return null;
	    	}
	    @RequestMapping(value = "/viewAnswer", method = RequestMethod.GET)
	    public ModelAndView viewAnswer() {
	    	
	    	try {
				String log4jConfigFile = "C:\\projects\\Vforum\\src\\main\\webapp\\WEB-INF\\log4j.properties";
				PropertyConfigurator.configure(log4jConfigFile);
				log.info("This is /viewanswer Page Log");
	    
	     	ModelAndView model = new ModelAndView();
	     	List<Answers> allAnswers=answerService.getAllAnswers();
	        model.addObject("allAnswers",allAnswers);
	        model.setViewName("MyAnswers");
	        return model;
	        
	    	} catch (Exception e) {
				log.error("Error is in view answer " + e);
			}
	    	return null;
	    }
	    

}