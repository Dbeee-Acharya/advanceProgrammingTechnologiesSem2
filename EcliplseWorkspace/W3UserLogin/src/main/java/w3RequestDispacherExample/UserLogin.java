package w3RequestDispacherExample;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserLogin
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/Login" })
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLogin() {
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
		String userEmail = request.getParameter("email");
		String userPassword = request.getParameter("password");
		
		String email = "a@a.com";
		String password = "1234";
		
		if((userEmail.equals(email) && userPassword.equals(password))) {
			RequestDispatcher dispacher = request.getRequestDispatcher("home");
			dispacher.forward(request, response);
			
		} else {
			String message = "invalid username or password";
			
			PrintWriter writer = response.getWriter();
			response.setContentType("text/html");
			writer.println("<h2>" + message + "</h2>");
			
			RequestDispatcher dispacher = request.getRequestDispatcher("htmlPages/login.html");
			dispacher.include(request, response);
		}
	}

}
