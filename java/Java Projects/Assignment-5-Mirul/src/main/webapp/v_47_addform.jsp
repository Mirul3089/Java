<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Assignment 5</title>
</head>
<body>
	<div id="container">
		<h2>Add A New Friend</h2>
		<br>
		<form action="addservlet_47" method="post">
			Friend Name: <input type="text" name="fn"><br>
			<br> Email Address: <input type="email" name="em"><br>
			<br> Age: <input type="text" name="ag"><br>
			<br> Friend Color: <input type="text" name="fc"><br>
			<br>
			<button type="reset" value="reset">Clear</button>
			&nbsp;&nbsp;
			<button type="submit" value="submit">Submit</button>
		</form>
	</div>
</body>
<style>
h2 {
	color: purple;
}

#container {
	width: 300px;
	height: 300px;
	padding: 5%;
	border-style: solid;
	border-radius: 5px;
	margin-left: auto;
	margin-right: auto;
}
</style>
</html>