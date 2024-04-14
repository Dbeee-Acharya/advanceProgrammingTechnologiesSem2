package service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Student;
import util.DatabaseConnection;

// DAO = Data Access Object
// Database sanga ko sabbai yo class ma

public class StudentDAO {
	private Connection conn;
	private PreparedStatement statement;
	private Boolean isSuccess;
	ResultSet resultSet;
	
	private static final String insertQuery = 
			"INSERT INTO student_register"
			+ "(firstName, lastName, userName, dob, "
			+ "gender, email, phoneNumber, subject,password) "
			+ "VALUES (?,?,?,?,?,?,?,?,?)";	
	
	public StudentDAO() {
		conn = DatabaseConnection.getDbConnection();
			
	}
	
	public boolean saveStudent(Student student) {
		String selectQuery = "SELECT COUNT(*) FROM student_register";
		
		try {
			statement = conn.prepareStatement(selectQuery);
			resultSet = statement.executeQuery();
			
			if(resultSet.next()) {
				boolean userExists = check(student);
				
				if(userExists) {
					isSuccess = false;
				} else {
					int rows = insertStudentData(student);
					
					if(rows>0) {
						isSuccess = true;
					} else {
						isSuccess = false;
					}
				}
				
			} else {
				int rows = insertStudentData(student);
				
				if(rows>0) {
					isSuccess = true;
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return isSuccess;
	}
	
	
	public int insertStudentData(Student student) throws SQLException {
		statement = conn.prepareStatement(insertQuery);
		statement.setString(1, student.getFirstName());
		statement.setString(2, student.getLastName());
		statement.setString(3, student.getUserName());
		statement.setDate(4, student.getDob());
		statement.setString(5, student.getGender());
		statement.setString(6, student.getEmail());
		statement.setLong(7, student.getPhoneNumber());
		statement.setString(8, student.getSubject());
		statement.setString(9, student.getPassword());
		
		int rows = statement.executeUpdate();
		return rows;
		
	}
	
	
	public boolean check(Student student) throws SQLException {
		boolean userExists = false;
		String checkQuery = "SELECT username, email, phoneNumber FROM student_register";
		statement = conn.prepareStatement(checkQuery);
		resultSet = statement.executeQuery();
		
		while(resultSet.next()){
			String userNameDb = resultSet.getString("username");
			String emailDb = resultSet.getString("email");
			Long phoneNumberDb = resultSet.getLong("phoneNumber");
			
			if(student.getUserName().equals(userNameDb)) {
				userExists = true;
				break;
				
			} else if(student.getEmail().equals(emailDb)) {
				userExists = true;
				break;
				
			} else if(student.getPhoneNumber() == phoneNumberDb) {
				userExists = true;
				break;
			}
		}
		
		return userExists;
	}

	public List<Student> getAllStudent() throws SQLException {
		// TODO Auto-generated method stub
		statement = conn.prepareStatement("select * from student_register");
		resultSet = statement.executeQuery();
		
		List<Student> listOfStudent = new ArrayList<Student>();
		
		while(resultSet.next()) {
			int id = resultSet.getInt("id");
			String firstName = resultSet.getString("firstName");
			String lastName = resultSet.getString("lastName");
			String userName = resultSet.getString("userName");
			Date dob = resultSet.getDate("dob");
			String gender = resultSet.getString("gender");
			String email = resultSet.getString("email");
			Long phoneNumber = resultSet.getLong("phoneNumber");
			String subject = resultSet.getString("subject");
			
			Student student = new Student();
			
			student.setFirstName(firstName);
			student.setLastName(lastName);
			student.setUserName(userName);
			student.setDob(dob);
			student.setGender(gender);
			student.setEmail(email);
			student.setPhoneNumber(phoneNumber);
			student.setSubject(subject);
			
			listOfStudent.add(student);
		}
		
		return listOfStudent;
		
	}
	

}
