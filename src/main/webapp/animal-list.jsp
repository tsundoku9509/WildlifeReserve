<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Current Animals you want to visit:</title>
</head>
<body>
<h1>Animal List</h1>
	<table>
		<c:forEach items = "${requestScope.allAnimals}" var="currentAnimal">
		<tr>
			<td><input type="radio" name="animalType" value="${currentAnimal.animalType}"></td>
			<td>${currentAnimal.animalType}</td>
			<td>${currentAnimal.habitat}</td>
			<td>${currentAnimal.trackingNum}</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>