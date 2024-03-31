package userLogin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/Login" })
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		
		String correctPassword = "1234";
		String correctEmail = "a@a.com";
		
		if(email.equals(correctEmail) && password.equals(correctPassword)) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("home");
			dispatcher.forward(request, response);
			
		} else {
			String login_failed_message = "username or password incorrect";
			request.setAttribute("error_message", login_failed_message);
			RequestDispatcher dispatcher = request.getRequestDispatcher("pages/login.jsp");
			dispatcher.forward(request, response);
			
		}
	}

}
