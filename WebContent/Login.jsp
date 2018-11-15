<%@page import="com.sathish.am.pojo.UserPojo"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@taglib prefix="form"  uri="http://www.springframework.org/tags/form"%> 
<% UserPojo pojo= new UserPojo(); %>
<title>Insert title here</title>
</head>
<body>
Language : <a href="?lang=en">English</a>&nbsp;|&nbsp;<a href="?lang=fr">French</a>&nbsp;|&nbsp;<a href="?lang=de">german</a><br>

<form:form action="Login.action" commandName="pojo">
<h1>LOGIN PAGE</h1>

USERNAME:::<form:input type="text" path="username" /> 		<form:errors path="username"  /><br><br>
PASSWORD:::<form:input type="password" path="password" /> 	<form:errors path="password"  /><br><br>
<input type="submit" value="LOGIN"/>
</form:form>

</body>
</html>