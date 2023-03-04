<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit an Existing Visitor List</title>
</head>
<body>
<h1>Edit a Visitor List</h1>
<form action = "editVisitorListDetailsServlet" method="post">
<input type = "hidden" name="id" value="${listToEdit.id}">
List Name: <input type="text" name="listName" value="${listToEdit.listName}"><br/>

Trip Date: <input type="text" name="month" placeholder="mm" size="4" value="${month}"> <input type="text" name="day"
placeholder="dd" size="4" value="${date}">, <input type="text" name = "year" placeholder = "yyyy" size="4" value="${year}">

Visitor Name: <input type="text" name="guestName" value="${listToEdit.visitor.guestName}"><br/>

Available Animals:<br/>

<select name="allItemsToAdd" multiple size="6">
<c:forEach items="${requestScope.allAnimals}" var="currentAnimal">
	<option value="${currentAnimal.id}">${currentAnimal.animalType} | ${currentAnimal.habitat} | ${currentAnimal.trackingNum}</option>
</c:forEach>
</select>
<br/>
<input type="submit" value="Edit Visitor List and Add Animals">
</form>
<a href="index.html">Go add new animals instead</a>
</body>
</html>