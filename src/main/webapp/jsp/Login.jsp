<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>


#login-box {
    width: 300px;
    padding: 20px;
    margin: 100px auto;
    background: #fff;
    -webkit-border-radius: 2px;
    -moz-border-radius: 2px;
    border: 1px solid #000;
}
</style>
</head>
<body>
 <div align="center" id="login-box">
 
     <h3>${message}</h3>
<form:form action="loginProcess" method="post" modelAttribute="login">
		<h1 align="center">Login Form</h1>
<table>
 <tr>
                <td>Employee Id:</td>
                <td><form:input path="employeeId" /></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><form:input type="password" path="password" /></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="Login"></td>
            </tr>
            <tr>
            <td colspan="2" align="center"><a href="newEmployee">Register</a></td>
            </tr>
            </table>
             </form:form>
             </div>

 

 

</body>
</html>