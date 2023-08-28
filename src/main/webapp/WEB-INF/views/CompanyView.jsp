<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"   %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Company View</title>
</head>

<body>
	<h1>View Company Details</h1>
	<h4>Company Id : ${cid}</h4>
	<h4>Name : ${name}</h4>
	<h4>Email : ${email}</h4>
	<br>
	<!-- Assuming itemList is a List<MyItem> in your model -->
	<table>
	<tr>
	<th>Company Id</th>
	<th>Name</th>
	<th>Email</th>
	</tr>
	
    <c:forEach  var="list" items="${newdata}">
    <!-- Access properties of the item using ${item.propertyName} -->
    <tr>
    <td>${list.cid}</td>
    <td>${list.name}</td>
    <td>${list.email}</td>
    </tr>
    </c:forEach>
	</table>
	<h4>
		<a href="companysessionview"> Click here to get data into session
			page </a>
	</h4>
</body>
</html>


