<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

       <form:form action="editAnswerProcess" method="get" modelAttribute="answer">
<table>
<form:hidden path="answerId"/>

<h2>${answer.answerDescription}</h2>
			<tr>
                <td>Edit Answer here:</td>
                <td><form:input type="text" path="answerDescription" /></td>
            </tr>
            <tr>
                <td><form:hidden path="date" /></td>
                <td><form:hidden path="question.questionId" /></td>
                <td><form:hidden path="employee.employeeId" /></td>
            </tr>
            
             <tr>
                <td colspan="2" align="center"><input type="submit" value="Edit Answer"></td>
            </tr>
</table>
       </form:form>
</body>
</html>