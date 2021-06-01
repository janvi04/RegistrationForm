<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="java.sql.*" %>
<%! String driverName = "com.mysql.jdbc.Driver";%>
<%!String url = "jdbc:mysql://localhost:3306/sample";%>
<%!String user = "root";%>
<%!String psw = "root";%>
<%
String partyId = request.getParameter("partyId");
String firstName=request.getParameter("firstName");
String lastName=request.getParameter("lastName");
String address=request.getParameter("address");
String city=request.getParameter("city");
String state=request.getParameter("state");
String country=request.getParameter("country");
String zip=request.getParameter("zipcode");
String phone=request.getParameter("phone");



Connection con = null;
PreparedStatement ps = null;

try
{
Class.forName(driverName);
con = DriverManager.getConnection(url,user,psw);
String sql="Update party set firstName=?,lastName=?,address=?,city=?,state=?,country=?,zip=?,phone=? where partyId="+partyId;
ps = con.prepareStatement(sql);

ps.setString(1, firstName);
ps.setString(2, lastName);
ps.setString(3, address);
ps.setString(4,city);
ps.setString(5, state);
ps.setString(6,country);
ps.setString(7,zip);
ps.setString(8, phone);

int i = ps.executeUpdate();
if(i > 0)
{
out.print("Record Updated Successfully");
}
else
{
out.print("There is a problem in updating Record.");
}
}
catch(SQLException sql)
{
request.setAttribute("error", sql);
out.println(sql);
}

%>