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
<c:forEach var="answer" items="${allAnswers}">
   		<c:if test="${answer.employee.employeeId eq employeeId }">   
   			  <h2>${answer.answerDescription}</h2>
   			  <p>Posted on: ${answer.date}</p>
   		</c:if>
   	</c:forEach>
   	
</body>
</html>