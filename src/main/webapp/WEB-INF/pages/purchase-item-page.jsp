<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<?xml version="1.0" encoding="ISO-8859-1" ?>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Purchase Items</title>
</head>
<body>
<h1>Purchase Items</h1>
<p>Here you can Purchase Items</p>

<form:form method="POST" commandName="item" action="${pageContext.request.contextPath}/purchaseItem/${item.id}.html">
<table>
<tbody>
	<tr>
		<td>Name:</td>
		<td><form:label path="Name" />${item.name}</td>
	</tr>
	<tr>
		<td>Quantity:</td>
		<td><form:input path="quantity" /></td>
	</tr>
	<tr>
		<td><input type="submit" value="Purchase" /></td>
	
		<td></td>
	</tr>
	
</tbody>

</table>
</form:form>

<a href="${pageContext.request.contextPath}/home.html">Home</a><br/>


</body>
</html>