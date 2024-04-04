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
	ResultSet resultSet;
	
	public StudentDAO() {
		conn = DatabaseConnection.getDbConnection();
	}
	
	public boolean SaveStudent(Student student) {
		String query = "INSERT INTO student_register"
				+ "(firstName, lastName, userName, dob, "
				+ "gender, email, phoneNumber, subject,password) "
				+ "VALUES (?,?,?,?,?,?,?,?,?)";	
		
		try {
			statement = conn.prepareStatement(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
