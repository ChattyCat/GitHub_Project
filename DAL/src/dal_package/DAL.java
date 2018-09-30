package dal_package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class DAL {
	//Credentials
	private static final String url = "jdbc:sqlserver://localhost:1433;database=doOrDie";
	private static final String user = "sapp";
	private static final String password = "sapp";
	
	//Connection to db
	public Connection getConnection() {
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			Connection con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	//Student CRUD
	public Student getStudentFromDB(ResultSet rs) throws SQLException {
		Student student = new Student();
		
		student.setsID(rs.getString("sID"));
		student.setsName(rs.getString("sName"));
		student.setPoints(rs.getInt("points"));
		
		return student;
	}
	public boolean create(Student student) {
		//dbConnection dbCon = new dbConnection();
		//Connector connector = new Connector();
		Connection con = getConnection();
		
		try {
	    PreparedStatement ps = con.prepareStatement("insert into Student values(?, ?, ?)");
	    ps.setString(0, student.getsID());
	    ps.setString(1, student.getsName());
	    ps.setInt(2, student.getPoints());
		
	    if (ps.executeUpdate() == 1) {
	    	return true;
	    }
	    
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		return false;
	}
	public Student retrieve(String sID) {
		//dbConnection dbCon = new dbConnection();
		
		//Connection con = getConnection();
		
		try {
		String query = "select * from Student where sID = " + sID;
		Statement stmt = getConnection().createStatement();
	    ResultSet rs = stmt.executeQuery(query);
	    
	    if (rs.next()) {
	    	return getStudentFromDB(rs);
	    }
	    
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		return null;
	}
	public boolean update(Student student) {
		//dbConnection dbCon = new dbConnection();
		
		Connection con = getConnection();
		
		try {
	    PreparedStatement ps = con.prepareStatement("update Student set sName = ?, points = ? where sID = ?");
	    ps.setString(0, student.getsName());
	    ps.setInt(1, student.getPoints());
	    ps.setString(2, student.getsID());
		
	    if (ps.executeUpdate() == 1) {
	    	return true;
	    }
	    
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean delete(String sID) {
		//dbConnection dbCon = new dbConnection();
		Connection con = getConnection();
		
		try {
		Statement stmt = con.createStatement();
		
	    if (stmt.executeUpdate("delete from Student where sID = " + sID) == 1) {
	    	return true;
	    }
	    
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public List<Student> retrieveAll() {
		//dbConnection dbCon = new dbConnection();
		
		Connection con = getConnection();
		 
		try {
		String query = "select * from Student";
		Statement stmt = con.createStatement();
	    ResultSet rs = stmt.executeQuery(query);
	    
	    List<Student> students = new ArrayList<Student>();
	    
	    while (rs.next()) {
	    	Student student = getStudentFromDB(rs);
	    	students.add(student);
	    }
	    return students;
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		return null;
	}
	//Test Method
	/*
	public Member retrieveTest(String sID) {
		//dbConnection dbCon = new dbConnection();
		
		//Connection con = getConnection();
		
		try {
		String query = "select * from doOrDie where name = " + sID;
		Statement stmt = getConnection().createStatement();
	    ResultSet rs = stmt.executeQuery(query);
	    
	    if (rs.next()) {
	    	return getStudentFromDB(rs);
	    }
	    
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		return null;
	}*/
}


