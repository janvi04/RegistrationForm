package next.admin.login.databse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import next.admin.login.bean.LoginBean;

public class LoginDao {
	
	private String dburl = "jdbc:mysql://localhost:3306/sample";
	private String dbName= "root";
	private String dbPassword="root";
	private String dbDriver="com.mysql.cj.jdbc.Driver";
	
	
	public void loadDriver(String dbDriver)
	{
		try
		{
			Class.forName(dbDriver);
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace(); 
		}
	}
	
	public Connection getConnection()
	{
		Connection con=null;
		try {
			con=DriverManager.getConnection(dburl,dbName,dbPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	
	public boolean validate(LoginBean loginbean)
	{
		boolean status=false;
		loadDriver(dbDriver);
		Connection con = getConnection();
		
		String sql="select * from userlogin where userLoginId=? and userpassword=?";
		PreparedStatement ps;
		
		try {
			ps= con.prepareStatement(sql);
			
			ps.setString(1,loginbean.getUserName());
			ps.setString(2, loginbean.getPassword());
			
			ResultSet rs= ps.executeQuery();
			status=rs.next();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		
		return status;
	}
	

}
