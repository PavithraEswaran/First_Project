<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
#register-box {
    width: 500px;
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
<div align="center" id="register-box">
    
        <h1>Registration Form</h1>
         
        <h3>${message}</h3> 
         
        <form:form action="saveEmployee" method="post" modelAttribute="employee">
        <table>
            
            <tr>
                <td>EmployeeId:</td>
                <td><form:input path="employeeId" /></td>
            </tr>
            <tr>
                <td>EmployeeName:</td>
                <td><form:input path="employeeName" /></td>
            </tr>
            <tr>
                <td>EmployeeDesignation:</td>
                <td><form:input path="employeeDesignation" /></td>
            </tr>
            <tr>
                <td>EmployeeLocation:</td>
                <td><form:input path="employeeLocation" /></td>
            </tr>
            <tr>
                <td>Username:</td>
                <td><form:input path="username" /></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><form:input type="password" path="password" /></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="Submit"></td>
            </tr>
        </table>
        </form:form>
    </div>
</body>
</html>