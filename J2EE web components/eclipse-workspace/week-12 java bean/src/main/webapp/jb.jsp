<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form>
Id: <input type="text" name="id"><br>
Name: <input type="text" name="name"><br>
<button type="submit" value="submit" >Login</button>
</form><br><br>
<%if("get".equalsIgnoreCase(request.getMethod()) == true) { %>
	<jsp:useBean id="emp" class="employeega.employee">

	<jsp:setProperty name="emp" property="*"/> <!-- name is for bean id and property (which property we have to set) -->

My id is:
<jsp:getProperty property="id" name="emp" /><br> <!-- name is for bean id and property (which property we have to read) -->
	My  name is:
	<jsp:getProperty property="name" name="emp" /><br>
	</jsp:useBean>
	
	<%} %>
	
</body>
</html>