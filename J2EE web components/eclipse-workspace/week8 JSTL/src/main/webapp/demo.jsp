<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>count to 10 example(using JSTL)</title>
</head>
<body>
	<c:forEach var="i" begin="1" end="10" step="1">
		<c:out value="${i}" />
		<br />
	</c:forEach>
<sql:setDataSource var="db" driver="com.mysql.jdbc.Driver" 
url="jdbc:mysql://localhost:3306/as2_mirul" user="root" password="root" />
<sql:query dataSource="${db}" var="rs">
SELECT * from emp; </sql:query>
<c:forEach var="i" items="${rs.rows}">
		<c:out value="${i.EmpNo}" />
		<c:out value="${i.EmpName}" />
		<c:out value="${i.Department}" />
		<c:out value="${i.Job}" />
	</c:forEach>
</body>

</html>
	