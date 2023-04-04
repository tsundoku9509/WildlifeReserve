<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WildLife Reserve</title>
<script type = "text/javascript">
function validate()
{
	let x = document.forms["wildLife"]["name"].value;
	let y = document.forms["wildLife"]["guestNum"].value;
	let z = document.forms["wildLife"]["experience"].value;
	if(x == ""){
		alert("Input your name!");
		form.name.focus();
		return false;
	}
	if (y == ""){
		alert("Input number of guests!")
		form.guestNum.focus();
		return false;
	}
	if (z == ""){
		alert("Input your experience package!")
		form.experience.focus();
		return false;
	}
	
	return true;
}
</script>
</head>
<body>

	<h1>Welcome to the Wildlife Reserve! Please enter your party's information below.</h1>
	<form name = "wildLife" action="WildlifeServ" method="post" onsubmit="return validate()">
	Your Name:
	<input type="text"  name="name" size="14">
	Number In Your Party:
	<input type="text"  name="guestNum" size="14">
	Experience Picked Out:
	<input type="text" name="experience" size="14">
	<input type="submit" value="Submit" />
	</form>

</body>
</html>