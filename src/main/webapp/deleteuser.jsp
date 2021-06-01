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
<title>Delete User Page</title>
</head>
<body>
<%
String partyId=request.getParameter("partyId");
Class.forName("com.mysql.jdbc.Driver");
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sample","root","root");
Statement stmt=con.createStatement();
String sql="delete from party where partyId="+partyId;
stmt.executeUpdate(sql);
out.print("Data has been deleted");
%>
</body>
</html>