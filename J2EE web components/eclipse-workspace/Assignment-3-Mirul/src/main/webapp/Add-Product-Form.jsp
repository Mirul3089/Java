<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Assignment 3</title>
</head>
<body>
	<form method="post">
			Product No: <input type="text" name="pn"><br>
			<br> Product Name: <input type="text" name="pname"><br>
			<br> Product Type: <input type="radio" name="pt"
				value="Home Appliance">Home Appliance</input> <input type="radio"
				name="pt" value="Computer Hardware">Computer Hardware</input> 
				<input type="radio" name="pt" value="Game console">Game console</input> 
				<input type="radio" name="pt" value="Clothing">Clothing</input><br><br>
Manufacturer: <select name="man" id="man">
				<option value="LG">LG</option>
				<option value="LogiTech">Logitech</option>
				<option value="Corsair">Corsair</option>
				<option value="Windows">Windows</option>
			</select><br>
			<br> Weight: <input type="text" name="we"><br>
			<br> Price: <input type="text" name="pr"><br>
			<br>
			<button type="submit">Add Product</button>
	</form><br><br>
	The following information is received:
	<br>
<div class="container">
	<p>Product No is: ${param.pn}</p>
	<p>Product Name is: ${param.pname}</p>
	<p>Product type is: ${paramValues.pt[0]}</p>
	<p>Manufacturer is: ${paramValues.man[0]}</p>
	<p>Product type is: ${param.we}</p>
	<p>Product type is: ${param.pr}</p>
</div>

<style type="text/css">
.container{
width:500px;
height:500px;
text-align: center;
}

p{
background-color: lightgrey
}
</style>

</body>
</html>
