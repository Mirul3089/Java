<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Assignment 3</title>
</head>
<body>
	<form method="post">
		Product No: <input type="text" name="pn"><br> <br>
		Product Name: <input type="text" name="pname"><br> <br>
		Product Type: <input type="radio" name="pt" value="Home Appliance">Home
		Appliance</input> <input type="radio" name="pt" value="Computer Hardware">Computer
		Hardware</input> <input type="radio" name="pt" value="Game console">Game
		console</input> <input type="radio" name="pt" value="Clothing">Clothing</input><br>
		<br> Manufacturer: <select name="man" id="man">
			<option value="LG">LG</option>
			<option value="LogiTech">Logitech</option>
			<option value="Corsair">Corsair</option>
			<option value="Windows">Windows</option>
		</select><br><br>
		Price: <input type="text" name="pr">
		<br> <br> Weight: <input type="text" name="we"><br>
		<br> <button type="submit">Add Product</button>
	</form><br><br>
	
	<fmt:formatNumber var="x" type="number" minFractionDigits="2" maxFractionDigits="2" value="${param.we}" />
	
     <c:choose>
     
     <c:when test= "${param.pr<100 or param.pr>900}">
			<font size="3" color='blue'>Please Insert valid data</font>
	</c:when>
	
	
	<c:otherwise>
	
        
	<sql:setDataSource var="db" driver="com.mysql.jdbc.Driver"
		url="jdbc:mysql://localhost:3306/A3" user="root" password="root" />

        
			<c:catch var="exception">
	<sql:update dataSource="${db}" var="Table">
			INSERT INTO product (ProductNo,ProductName,ProductType,Manufacturer,Price,Weight) VALUES (?, ?, ?, ?, ?, ?)
			<sql:param value="${param.pn}" />
		<sql:param value="${param.pname}" />
		<sql:param value="${paramValues.pt[0]}" />
		<sql:param value="${paramValues.man[0]}" />
		<sql:param value="${param.pr}" />
		<sql:param value="${x}" />
	</sql:update><br><br>
		</c:catch>
	<c:if test="${exception!=null}">
			 </br>	
			<c:out value="Please enter valid data and Try Again ${exception}" />
			</c:if>
         </br>	
          </br>	
          <sql:query dataSource="${db}" var="rs">  
		SELECT * FROM PRODUCT;
		</sql:query>  
        
        <table cellspacing='1' cellpadding='5' border='1'>
        
        	<tr>
        
        		<th>Product Number</th>
        		<th>Product Name</th>
        		<th>Product Type</th>
        		<th>Manufacturer</th>
        		<th>Price</th>
        		<th>Weight</th>
        	
        	</tr>
        	<c:forEach var="table" items="${rs.rows}">  
        	<tr>
        	
        		<td><c:out value="${table.ProductNo}"/></td>  
				<td><c:out value="${table.ProductName}"/></td>  
				<td><c:out value="${table.ProductType}"/></td>  
				<td><c:out value="${table.Manufacturer}"/></td>  
				<td><c:out value="${table.Price}"/></td>  
				<td><c:out value="${table.Weight}"/></td>  
        	
        	</tr>
        	</c:forEach>  
        
        </table>
    </c:otherwise>
  </c:choose>
        
        
</body>
</html>
