<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<?xml version="1.0" encoding="ISO-8859-1" ?>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>List of Items</title>
</head>
<body>
<h1>List of items</h1>
<p>Here you can see the list of the items, edit them, remove or update.</p>
<table border="1px" cellpadding="0" cellspacing="0" >
<thead>
<tr>
<th width="15%">name</th><th width="10%">description</th><th width="10%">quantity</th><th width="10%">price</th><th width="10%">actions</th>
</tr>
</thead>
<tbody>
<c:forEach var="item" items="${items}">
<tr>
	<td>${item.name}</td>
	<td>${item.description}</td>
	<td>${item.quantity}</td>
	<td>${item.price}</td>
	<td>
	<a href="${pageContext.request.contextPath}/edit/${item.id}.html">Edit</a><br/>
	<a href="${pageContext.request.contextPath}/delete/${item.id}.html">Delete</a><br/>
	<a href="${pageContext.request.contextPath}/purchaseItem/${item.id}.html">Purchase</a><br/>
	</td>
	
</tr>
</c:forEach>
</tbody>
</table>

<a href="${pageContext.request.contextPath}/home.html">Home</a><br/>


</body>
</html>