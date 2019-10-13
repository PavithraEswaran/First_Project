package com.vforum.controller;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.vforum.model.Answers;
import com.vforum.model.Questions;
import com.vforum.service.AnswerService;
import com.vforum.service.CategoryService;
import com.vforum.service.EmployeeService;
import com.vforum.service.QuestionService;
@Controller
public class QuestionController {
	@Autowired
    private EmployeeService employeeService;
    @Autowired
    private QuestionService questionService;
    @Autowired
    private AnswerService answerService;
    @Autowired
    private CategoryService categoryService;
	 @RequestMapping("/postQuestion")    
	    public ModelAndView postQuestion(ModelAndView model,HttpSession session,HttpServletRequest request){   
		    int categoryId=Integer.parseInt(request.getParameter("cId"));
		   // System.out.println(categoryId);
	    	Questions question=new Questions();
	    	long milli=System.currentTimeMillis();
			Date currentDate=new Date(milli);
	    	question.setDate(currentDate);
	    	int employeeId=(Integer) session.getAttribute("employeeId");
	        question.setEmployee(employeeService.getEmployee(employeeId));
	        question.setCategory(categoryService.getCategoryById(categoryId));
	       // System.out.println(question.getCategory().getCategoryId());
	    	model.addObject("question", question);
	        model.setViewName("Question");
	        
	        return model;
	       

	       
	    }
	 
	    @RequestMapping(value = "/addQuestion", method = RequestMethod.POST)
	    public ModelAndView addQuestion(@ModelAttribute Questions question) {
	    	//System.out.println(question.getCategory().getCategoryId());
	    	questionService.addQuestion(question);
	        ModelAndView m=new ModelAndView();
	        List<Questions> allQuestions=questionService.getAllQuestions();
	        m.addObject("allQuestions",allQuestions);
	        List<Answers> allAnswers=answerService.getAllAnswers();
	        m.addObject("allAnswers",allAnswers);
	        m.setViewName("home");
	        return m;
	       
	    }
	 
	    @RequestMapping(value = "/editQuestion", method = RequestMethod.GET)
	    public ModelAndView editQuestion(HttpServletRequest request) {
	        int questionId = Integer.parseInt(request.getParameter("qid"));
	        Questions question = questionService.getQuestion(questionId);
	        ModelAndView model = new ModelAndView();
	        model.addObject("question", question);
	        model.setViewName("editQuestion");
	        return model;
	    }
	   
	    @RequestMapping(value = "/editQuestionProcess", method = RequestMethod.GET)
	    public ModelAndView editQuestionProcess(@ModelAttribute Questions question) {
	        questionService.editQuestion(question);
	        ModelAndView model = new ModelAndView();
	        List<Questions> allQuestions=questionService.getAllQuestions();
	        model.addObject("allQuestions",allQuestions);
	        List<Answers> allAnswers=answerService.getAllAnswers();
	        model.addObject("allAnswers",allAnswers);
	        model.setViewName("home");
	        return model;
	    }
	
	    @RequestMapping(value = "/deleteQuestion", method = RequestMethod.GET)
	    public ModelAndView deleteQuestion(HttpServletRequest request) {
	        int questionId = Integer.parseInt(request.getParameter("qid"));
	        Questions question = questionService.getQuestion(questionId);
	        List<Answers> answerList=answerService.getAnswersByQuestionId(questionId);
	        for(Answers ans:answerList) {
	        	answerService.deleteAnswer(ans);
	        }
	        questionService.deleteQuestion(question);
	        ModelAndView model = new ModelAndView();
	        List<Questions> allQuestions=questionService.getAllQuestions();
	        model.addObject("allQuestions",allQuestions);
	        List<Answers> allAnswers=answerService.getAllAnswers();
	        model.addObject("allAnswers",allAnswers);
	        model.setViewName("home");
	        return model;
	    }
	    @RequestMapping(value = "/viewQuestion", method = RequestMethod.GET)
	    public ModelAndView viewQuestion() {
	     	ModelAndView model = new ModelAndView();
	        List<Questions> allQuestions=questionService.getAllQuestions();
	        model.addObject("allQuestions",allQuestions);
	        model.setViewName("MyQuestions");
	        return model;
	    }
	   
}