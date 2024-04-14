package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import appConstant.ViewPages;
import model.Student;
import service.StudentDAO;

/**
 * Servlet implementation class adminPanel
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/admin" })
public class adminPanel extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentDAO dao;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		dao = new StudentDAO();
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adminPanel() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			List<Student> listOfStudents = dao.getAllStudent();
			
			request.setAttribute("listOfStudents", listOfStudents);
			request.getRequestDispatcher(ViewPages.VIEW_ALL_STUDENT).forward(request, response);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
