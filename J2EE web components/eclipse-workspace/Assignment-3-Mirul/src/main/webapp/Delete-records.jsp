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
		Enter Product No: <input type="text" name="pn"><br> <br>
	    <button type="submit">Delete Product</button>
	</form><br><br>
	
	<sql:setDataSource var="db" driver="com.mysql.jdbc.Driver" 
	url="jdbc:mysql://localhost:3306/A3" user="root" password="root"/> 
	
	<sql:update dataSource="${db}" var="table">
			DELETE FROM product 
			WHERE ProductNo='${param.pn}'
		</sql:update><br><br>
		
	<c:if test="${table>=1}">
        <font size="5" color='red'> Data deleted successfully. </font>
        
    </c:if>
         </br>	
     <br>
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
</body>
</html>