
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<body>
<a align="left" href="postQuestion">Add Question</a>
<div align="right">
 <form:form action="logout" method="get">
    
           <input type="submit" value="logout">
           
            </form:form>
            </div>
<c:forEach var="question" items="${allQuestions}">   
   
   <h2>${question.questionDescription}</h2>
   
   <p>Posted by: ${question.employee.employeeName}    on: ${question.date}</p>
   
   	<c:if test="${question.employee.employeeId eq employeeId }">   
   		<a href="editQuestion?qid=${question.questionId}">Edit Question</a>
   		<a href="deleteQuestion?qid=${question.questionId}">Delete Question</a>
   </c:if>
   
   <c:forEach var="answer" items="${allAnswers}">
   		<c:if test="${answer.question.questionId eq question.questionId}">   
   			  <h4>${answer.answerDescription}</h4>
   			  <p>Posted by: ${answer.employee.employeeName}    on:${answer.date}</p>
		   	  <c:if test="${answer.employee.employeeId eq employeeId }">
		   	  
		   	  	<a href="editAnswer?aid=${answer.answerId}">Edit Answer</a>
		   	  	<a href="deleteAnswer?aid=${answer.answerId}">Delete Answer</a>
		   	  </c:if> 
   		</c:if>
   	</c:forEach>
   	<br/> 
   	<br/>
   		<c:if test="${question.employee.employeeId ne employeeId }">   
   			<a href="postAnswer?id=${question.questionId}">Add Answer</a>
    	</c:if>
    </c:forEach> 
  
</body>
</html>