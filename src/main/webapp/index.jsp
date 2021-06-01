<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>

<%

String driverName = "com.mysql.jdbc.Driver";
String connectionUrl = "jdbc:mysql://localhost:3306/";
String dbName = "sample";
String userId = "root";
String password = "root";

try {
Class.forName(driverName);
} catch (ClassNotFoundException e) {
e.printStackTrace();
}

Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
%>
<a href="LoginSuccess.jsp">Back to Home</a>
<h2 align="center"><font><strong>Retrieve data from database in jsp</strong></font></h2>
<table align="center" cellpadding="5" cellspacing="5" border="1">
<tr>

</tr>
<tr bgcolor="#A52A2A">
<td><b>ID</b></td>
<td><b>first Name</b></td>
<td><b>Last Name</b></td>
<td><b>Address</b></td>
<td><b>City</b></td>
<td><b>State</b></td>
<td><b>Country</b></td>
<td><b>zipcode</b></td>
<td><b>phone Number</b></td>
</tr>
<%
try{ 
connection = DriverManager.getConnection(connectionUrl+dbName, userId, password);
statement=connection.createStatement();
String sql ="SELECT * FROM party";

resultSet = statement.executeQuery(sql);
while(resultSet.next()){
%>
<tr bgcolor="#DEB887">
<td><%=resultSet.getInt("partyId")%></td>
<td><%=resultSet.getString("firstName") %></td>
<td><%=resultSet.getString("lastName") %></td>
<td><%=resultSet.getString("address") %></td>
<td><%=resultSet.getString("city") %></td>
<td><%=resultSet.getString("state") %></td>
<td><%=resultSet.getString("country") %></td>
<td><%=resultSet.getString("zip") %></td>
<td><%=resultSet.getString("phone") %></td>
<td><a href="deleteuser.jsp?partyId=<%=resultSet.getString("partyId") %>">Delete</a></td>
<td><a href="updateuser.jsp?partyId=<%=resultSet.getString("partyId")%>">Update</a></td>
</tr>

<% 
}

} catch (Exception e) {
e.printStackTrace();
}
%>
</table>