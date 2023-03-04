<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create a new Visitor List</title>
</head>
<body>
<h1>Create a new Visitor List</h1>
<form action="createNewAnimalListServlet" method="post">
List Name: <input type="text" name="listName"><br/>
Trip Date: <input type="text" name="month" placeholder='mm' size ="4">
		   <input type="text" name="day" placeholder='dd' size="4">,
		   <input type="text" name="year" placeholder='yyyy' size="4">
Guest Name: <input type="text" name="guestName"><br/>

Available Animals:<br/>
<select name="allAnimalsToAdd" multiple size="6">
<c:forEach items="${requestScope.allAnimals}" var="currentAnimal">
	<option value="${currentAnimal.id}">${currentAnimal.animalType} | ${currentAnimal.habitat} | ${currentAnimal.trackingNum}</option>
</c:forEach>
</select>
<br/>
<input type="submit" value="Create Animal List and Add Animals">
</form>
<a href="index.html">Go add a new Animal instead</a>
</body>
</html>