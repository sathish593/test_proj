
<%@page import="com.sathish.am.pojo.AssetPojo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List all</title>
</head>
<body>
<%
List<AssetPojo> list=(List<AssetPojo>) request.getAttribute("list");
AssetPojo pojo1=null;
%>
<table border="2">
	<tr>
	<th>ID</th>
	<th>NAME</th>
	<th>TYPE</th>
	<th>COST</th>
	<th>VEN</th>
	</tr>
	<% 
	for(AssetPojo pojo :list)
	{
		out.println("<tr>");
		out.println("<td>"+pojo.getId()+"</td>");
		out.println("<td><a href='gerRec.action?id="+pojo.getId()+"'>"+pojo.getName()+"</a></td>");
		out.println("<td>"+pojo.getType()+"</td>");
		out.println("<td>"+pojo.getCost()+"</td>");
		out.println("<td>"+pojo.getVender()+"</td>");
		out.println("</tr>");
	}
	
	%>


</table>
<a href="test.action">HOME</a>
</body>
</html>