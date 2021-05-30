

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String firstName= request.getParameter("firstName");
		String lastName= request.getParameter("lastName");
		String address= request.getParameter("address");
		String city= request.getParameter("city");
		String state= request.getParameter("state");
		String country= request.getParameter("country");
		String zipcode= request.getParameter("zipcode");
		String phoneNumber= request.getParameter("phoneNumber");
		String userName= request.getParameter("userName");
		String password= request.getParameter("password");
		
		
		Member member=new Member(firstName,lastName,address,city,state,country,zipcode,phoneNumber,userName,password);
		RegisterDao rDao = new RegisterDao();
		String result= rDao.insert(member);
		
		response.getWriter().print(result);
		
	
	}

}
