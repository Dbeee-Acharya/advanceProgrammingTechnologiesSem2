package Week4Lab;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserRegister
 */
@WebServlet("/Register")
public class UserRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRegister() {
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
		// TODO Auto-generated method stub
		
		String firstname=request.getParameter("first_name");
		String lastname=request.getParameter("last_name");
		String email=request.getParameter("email");
		
		Connection con=DatabaseConnectivity.getDbConnection();
		String query = "insert into student_register(firstname,lastname,email) values(?,?,?)";
		try {
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, firstname);
			st.setString(2, lastname);
			st.setString(3, email);
			int row = st.executeUpdate();
			if (row>1) 
			{
				response.sendRedirect(request.getContextPath()+"/pages/home.jsp");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
