package com.sheltersearch.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sheltersearch.beans.LoginBean;
import com.sheltersearch.beans.UserBean;

public class StudentDao {
	
	public int registerStudent(UserBean student) throws ClassNotFoundException {
        String INSERT_USERS_SQL = "INSERT INTO student" +
            "  (name, email, contact, password, date, gender) VALUES " +
            " (?, ?, ?, ?, ?, ?);";

        int result = 0;

        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = DriverManager
            .getConnection("jdbc:mysql://192.168.56.101:3306/shelter_database?useSSL=false", "gaurav", "Gaurav1234");

            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getEmail());
            preparedStatement.setLong(3, student.getContact());
            preparedStatement.setString(4, student.getPassword());
            preparedStatement.setDate(5, student.getDate());
            preparedStatement.setString(6, student.getGender());

            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            result = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
        return result;
    }
	
	public boolean validate(LoginBean loginBean) throws ClassNotFoundException {
        boolean status = false;

        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = DriverManager
        		.getConnection("jdbc:mysql://192.168.56.101:3306/shelter_database?useSSL=false", "gaurav", "Gaurav1234");
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection
            .prepareStatement("select * from student where email = ? and password = ? ")) {
            preparedStatement.setString(1, loginBean.getEmail());
            preparedStatement.setString(2, loginBean.getPassword());

            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            status = rs.next();

        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
        return status;
    }
	
	public UserBean getStudentBean(LoginBean loginBean) throws ClassNotFoundException{
		UserBean student  = new UserBean();
		
		Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = DriverManager
        		.getConnection("jdbc:mysql://192.168.56.101:3306/shelter_database?useSSL=false", "gaurav", "Gaurav1234");
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection
            .prepareStatement("select * from student where email = ? and password = ? ")) {
            preparedStatement.setString(1, loginBean.getEmail());
            preparedStatement.setString(2, loginBean.getPassword());

            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next())
            {
            	student.setName(rs.getString("name"));
            	student.setEmail(rs.getString("email"));
            	student.setContact(rs.getLong("contact"));
            	student.setDate(rs.getDate("date"));
            	break;
            }

        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
        return student;
	}
	
    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
