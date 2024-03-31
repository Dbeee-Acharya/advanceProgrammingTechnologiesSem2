package controller;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Student;

/**
 * Servlet implementation class studentRegister
 */
@WebServlet("/Register")
public class studentRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public studentRegister() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("view/register.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String userName = request.getParameter("userName");
		String birthday = request.getParameter("birthday");
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		Long phoneNumber = Long.parseLong(request.getParameter("phoneNumber"));
		String subject = request.getParameter("subject");
		String password = request.getParameter("password");
		String retypePassword = request.getParameter("retypePassword");
		
		Date dob = null;
		
		try {
			dob = new java.sql.Date(new SimpleDateFormat("yyy-MM-dd").parse(birthday).getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		if (!password.equals(retypePassword)) {
			request.setAttribute("error", "notMatched");
			
			request.setAttribute("firstName", firstName); //pailai deko value set bhairancha
			request.getRequestDispatcher("view/register.jsp").forward(request, response);
			return;
		}
		
		
		Student s = new Student();
		s.setFirstName(firstName);
		s.setLastName(lastName);
		s.setUserName(userName);
		s.setDob(dob);
		s.setGender(gender);
		s.setEmail(email);
		s.setPhoneNumber(phoneNumber);
		s.setSubject(subject);
		s.setPassword(password);
		
	}

}