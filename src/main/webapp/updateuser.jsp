<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
String partyId = request.getParameter("partyId");
String driver = "com.mysql.jdbc.Driver";
String connectionUrl = "jdbc:mysql://localhost:3306/";
String database = "sample";
String userid = "root";
String password = "root";
try {
Class.forName(driver);
} catch (ClassNotFoundException e) {
e.printStackTrace();
}
Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
%>
<%
try{
connection = DriverManager.getConnection(connectionUrl+database, userid, password);
statement=connection.createStatement();
String sql ="select * from party where partyId="+partyId;
resultSet = statement.executeQuery(sql);
while(resultSet.next()){
%>

<h1>Update data </h1>
<form method="post" action="update-process.jsp">
<input type="hidden" name="partyId" value="<%=resultSet.getString("partyId") %>">
<br>

First name:<br>
<input type="text" name="firstName" value="<%=resultSet.getString("firstName") %>">
<br>
Last name:<br>
<input type="text" name="lastName" value="<%=resultSet.getString("lastName") %>">
<br>
Address:<br>
<input type="text" name="address" value="<%=resultSet.getString("address") %>">
<br>
City:<br>
<input type="text" name="city" value="<%=resultSet.getString("city") %>">
<br>
State:<br>
<input type="text" name="state" value="<%=resultSet.getString("state") %>">
<br>
Country:<br>
<input type="text" name="country" value="<%=resultSet.getString("country") %>">
<br>
Zip Code:<br>
<input type="text" name="zipcode" value="<%=resultSet.getString("zip") %>">
<br>
Phone:<br>
<input type="text" name="phone" value="<%=resultSet.getString("phone") %>">
<br>
<br>
<input type="submit" value="submit">
</form>
<%
}
connection.close();
} catch (Exception e) {
e.printStackTrace();
}
%>

</body>
</html>