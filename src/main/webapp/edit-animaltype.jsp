<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit the Animal</title>
</head>
<body>
	<h1>Please enter a new Animal Type or Habitat</h1>
	<form action="editAnimalTypeServlet" method="post">
	Animal Type: <input type="text" name="animalType" value="${animalToEdit.animalType}">
	Habitat: <input type="text" name="habitat" value="${animalToEdit.habitat}">
	<input type="hidden" name="id" value="${animalToEdit.id}">
	<input type="submit" value="Save Edited Animal">
	</form>
</body>
</html>