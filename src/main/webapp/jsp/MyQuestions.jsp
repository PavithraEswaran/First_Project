<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script>
function goBack() {
  window.history.back();
}
</script>
</head>
<body>
<c:forEach var="question" items="${allQuestions}">   
   <c:if test="${question.employee.employeeId eq employeeId }"> 
   <h2>${question.questionDescription}</h2>
   
   <p>Posted  on: ${question.date}</p>
     </c:if>
  	</c:forEach>
  	<button onclick="goBack()">Go Back</button>
</body>
</html>