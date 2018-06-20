package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MysqlDao {
	Connection connection = null;

	
	public MysqlDao() {
		System.out.println("-------- MySQL JDBC Connection Testing ------------");

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Where is your MySQL JDBC Driver?");
			e.printStackTrace();
			return;
		}

		System.out.println("MySQL JDBC Driver Registered!");

		try {
			connection = DriverManager
			.getConnection("jdbc:mysql://10.87.164.50:3306/accelerate","root", "");

		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;
		}

		if (connection != null) {
			System.out.println("You made it, take control your database now!");
		} else {
			System.out.println("Failed to make connection!");
		}
	}
	
	public void select() throws SQLException {
		String query = "SELECT * FROM users";

	      // create the java statement
	      Statement st = connection.createStatement();
	      
	      // execute the query, and get a java resultset
	      ResultSet rs = st.executeQuery(query);
	      
	      // iterate through the java resultset
	      while (rs.next())
	      {
	        String firstName = rs.getString("firstname");
	        String lastName = rs.getString("lastname");
	        
	        // print the results
	        System.out.println(String.format("firstName %s , lastName %s ", firstName,lastName));
	      }
	      rs.close();
	      st.close();
	}

}
