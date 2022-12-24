<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Assignment4</title>
</head>
<body>
	<div id="container">
		<form action="<%=request.getContextPath()%>/login" method="post">
			Username: <input type="text" name="uname"><br>
			<br> Password: <input type="password" name="pwd"><br>
			<br>
			<button type="submit" value="submit">Login</button>
		</form>
	</div>
	<style>
#container {
	width: 500px;
	height: 300px;
	text-align: center;

}

form {
	padding-top: 15%;
	padding-bottom: 15%;
	padding-left: 2%;
	padding-right: 2%;
	font-family: bold;
	font-size: large;
	border-style: solid;
	border-radius: 5px;
}

body {
	padding-top: 10%;
	padding-bottom: 12%;
	padding-left:18%;
	background-color: lightgrey;
}
</style>
</body>
</html>