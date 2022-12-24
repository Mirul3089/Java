<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>welcome</h1>
	<%=new java.util.Date()%><br>
	<br>
	<h3>
		Square root of 5:
		<%=Math.sqrt(5)%></h3>
	<br>
	<%
	out.println("hhw");
	out.println("Ip address:" + request.getRemoteAddr());
	%><br>
	<br>
	<%!int day = 3;%>
<title>IF...ELSE Example</title>
</head>
<body>
	<%
	if (day == 1 | day == 7) {
	%><p>Today is weekend</p>
	<%
	} else {
	%><p> Today is not weekend</p>
	<%
	}
	%>
	
</body>
</html>
</body>
</html>