<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><%@ taglib
	prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%><html>
<head>
<title>fmt:formatNumber JSTL formatting tag example</title>
</head>
<body>
<p> step 1: </p>
<%!int p=500; %>
<%=p %>
<p> step 2: </p>
<c:set var="q" value="600" />
 <c:out value="${q}"/>
<c:out value="${p}"/>
<p> step 3: </p>
<p><%=p %> ${q}</p>
</body>
</html>