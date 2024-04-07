package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
	

}
