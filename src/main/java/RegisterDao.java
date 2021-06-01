import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegisterDao {

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
	
	public String insert(Member member)
	{
		loadDriver(dbDriver);
		Connection con=getConnection();
		String result="Data entered successfully";
		String sql="insert into party(FirstName,LastName,address,city,state,country,zip,phone) values(?,?,?,?,?,?,?,?)";
		String sq1="insert into userlogin(userLoginId,userpassword,partyId) values(?,?,?)";
		
		try {
	PreparedStatement ps=con.prepareStatement(sql);
	ps.setString(1, member.getFirstName());
	ps.setString(2, member.getLastName());
	ps.setString(3, member.getAddress());
	ps.setString(4, member.getCity());
	ps.setString(5, member.getState());
	ps.setString(6, member.getCountry());
	ps.setString(7, member.getZipcode());
	ps.setString(8, member.getPhoneNumber());
	ps.executeUpdate();
	
	
	PreparedStatement ps3=con.prepareStatement("select max(partyId) from party");
     ResultSet rs=ps3.executeQuery();
	
	rs.next();
	
	int id;
	id = rs.getInt(1);
	


	PreparedStatement ps1=con.prepareStatement(sq1);
	
	ps1.setString(1, member.getUserName());
	ps1.setString(2, member.getPassword());
	ps1.setInt(3,id);
	
	
	ps1.executeUpdate();
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result="Data not entered";
		}
		
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
