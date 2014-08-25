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
<th width="15%">name</th><th width="10%">quantity</th><th width="10%">price</th><th width="10%">PurchasedOn</th>
</tr>
</thead>
<tbody>
<c:forEach var="purchaseHistory" items="${purchaseHistories}">
<tr>
	<td>${item.name}</td>
	<td>${purchaseHistory.quantity}</td>
	<td>${purchaseHistory.price}</td>
	<td>${purchaseHistory.purchasedOn}</td>
	
</tr>
</c:forEach>
</tbody>
</table>

<a href="${pageContext.request.contextPath}/home.html">Home</a><br/>


</body>
</html>