<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.sql.*"%>
<%!ResultSet rs;%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Assignment5</title>
</head>
<body>
<div id="container">
<h2>Mirul's Friends</h2>
	<%
	Class.forName("com.mysql.jdbc.Driver");

	String dbURL = "jdbc:mysql://localhost:3306/w11_mirul";
	String username = "root";
	String dbp = "root";

	Connection con;
	try {
		con = DriverManager.getConnection(dbURL, username, dbp);

		Statement st = con.createStatement();

		rs = st.executeQuery("select * from friend");

	} catch (Exception e) {
		e.printStackTrace();
	}
	%>
	<table border="1">
		<tbody>
			<%
			try {
				while (rs.next()) {
			%>
			<tr id="row">
			    <td><%=rs.getInt("id")%></td>
				<td><%=rs.getString("fname")%></td>
				<td><%=rs.getString("email")%></td>
				<td><%=rs.getString("age")%></td>
				<td><%=rs.getString("color")%></td>
				<td><form action="deleteservlet" method="post"><button type="submit" value="submit">Delete</button></form></td>
				<%
				}
				} catch (Exception e) {
				e.printStackTrace();
				}
				%>
			</tr>
		</tbody>
	</table><br><br>
	<h3><a href="C_47_addform">Add a New Friend</a></h3>
</div>
</body>
<style>
body{
text-align:center;
}
h2{
color:purple;
}
table{
text-align:center;
margin-left:auto;margin-right:auto;
}
tr:hover {background-color: lightblue;}
#container{
width:500px;
height:300px;
padding-left:3%;
padding-top:5%;
border-style: solid;
border-radius: 5px;
margin-left:auto;
margin-right:auto;
}
button {
  background: none!important;
  border: none;
  color: #069;
  text-decoration: underline;
  cursor: pointer;
}
</style>
</html>

