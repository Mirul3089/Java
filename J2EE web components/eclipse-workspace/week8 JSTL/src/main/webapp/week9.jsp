<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page errorPage="error.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<pre>
<c:set var="age" value ="${param.age}"/>
<c:choose>
<c:when test='${age > 0 or age < 100}' >

<c:out value="your age is ${age}"/>
</c:when>
<c:otherwise>
<c:out value="error"/>
</c:otherwise>

</c:choose>



</pre>

</body>
</html>