<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.*"%>
    <%!ResultSet rs;%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form class="activity" action="form.jsp" method="get">
			Emp number: &nbsp<input type="text" , name="enumber"><br><br>
			Emp Name: &nbsp<input type="text" , name="ename"><br><br>
			Job: &nbsp<input type="text" , name="job"><br><br>
			Salary: &nbsp<input type="text" , name="salary"><br><br>
			<button value="submit">Submit</button>
</form>
</body>
</html><br><br>
<%
Class.forName("com.mysql.jdbc.Driver");

String dbURL = "jdbc:mysql://localhost:3306/week7";
String username = "root";
String dbp = "root";

Connection con;
try{
con = DriverManager.getConnection(dbURL, username, dbp);

String number = request.getParameter("enumber");
String ename = request.getParameter("ename");
String job =request.getParameter("job");
String salary=request.getParameter("salary");

/*PreparedStatement ps = con.prepareStatement("insert into emp values(?,?,?,?)");
ps.setString(1, number);
ps.setString(2, ename);
ps.setString(3, job);
ps.setString(4, salary);

ps.executeUpdate();*/

Statement st = con.createStatement();


rs = st.executeQuery("select * from emp");

}
catch(Exception e){
	e.printStackTrace();
}

%>
<table border="1">
<thead>
<tr>
<th>empoyeeno</th>
<th>employeename</th>
<th>job</th>
<th>salary</th>
</tr>
</thead>
<tbody>
<%try{
while(rs.next()){
%>
<tr>
<td><%=rs.getString("empno")%></td>
<td><%=rs.getString("ename")%></td>
<td><%=rs.getString("job")%></td>
<td><%=rs.getString("salary")%></td>
<%
}
}
catch(Exception e){
	e.printStackTrace();
}
%>
</tr>
</tbody>
</table>
