<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Wildlife Lists</title>
</head>
<body>
<h1>Current Visitor List's On File</h1>
<form method="post" action="listnavigationServlet">
<table>
<c:forEach items="${requestScope.allLists}" var = "currentAnimal">
<tr>
	<td><input type="radio" name="id" value="${currentAnimal.id}"></td>
	<td><h2>${currentAnimal.listName}</h2></td></tr>
	<tr><td colspan="3">Trip Date: ${currentAnimal.tripDate}</td></tr>
	<tr><td colspan="3">Visitor: ${currentAnimal.visitor.guestName}</td></tr>
		<c:forEach var = "listVal" items = "${currentAnimal.listOfAnimals}">
			<tr><td></td><td colspan = "3">
				${listVal.animalType}, ${listVal.habitat}, ${listVal.trackingNum}
				</td>
				</tr>
		</c:forEach>
</c:forEach>
</table>
<input type="submit" value = "Edit" name="doThisToList">
<input type="submit" value = "Delete" name="doThisToList">
<input type="submit" value = "Add" name="doThisToList">
</form>
<a href = "addAnimalsForListServlet">Create a new List</a><br/>
<a href = "index.html">Insert a new animal</a>
</body>
</html>