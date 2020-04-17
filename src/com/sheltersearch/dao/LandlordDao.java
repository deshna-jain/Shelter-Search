package com.sheltersearch.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sheltersearch.beans.LoginBean;
import com.sheltersearch.beans.UserBean;

public class LandlordDao {
	
	public int registerLandlord(UserBean landlord) throws ClassNotFoundException {
        String INSERT_USERS_SQL = "INSERT INTO landlord" +
            "  (name, email, contact, password, date, gender) VALUES " +
            " (?, ?, ?, ?, ?, ?);";

        int result = 0;

        Class.forName("com.mysql.cj.jdbc.Driver");

        try (Connection connection = DriverManager
            .getConnection("jdbc:mysql://192.168.56.101:3306/shelter_database?useSSL=false", "gaurav", "Gaurav1234");

            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setString(1, landlord.getName());
            preparedStatement.setString(2, landlord.getEmail());
            preparedStatement.setLong(3, landlord.getContact());
            preparedStatement.setString(4, landlord.getPassword());
            preparedStatement.setDate(5, landlord.getDate());
            preparedStatement.setString(6, landlord.getGender());

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

        Class.forName("com.mysql.cj.jdbc.Driver");

        try (Connection connection = DriverManager
        		.getConnection("jdbc:mysql://192.168.56.101:3306/shelter_database?useSSL=false", "gaurav", "Gaurav1234");
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection
            .prepareStatement("select * from landlord where email = ? and password = ? ")) {
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
	
	public UserBean getLandlordBean(LoginBean loginBean) throws ClassNotFoundException{
		UserBean landlord  = new UserBean();
		
		Class.forName("com.mysql.cj.jdbc.Driver");

        try (Connection connection = DriverManager
        		.getConnection("jdbc:mysql://192.168.56.101:3306/shelter_database?useSSL=false", "gaurav", "Gaurav1234");
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection
            .prepareStatement("select * from landlord where email = ? and password = ? ")) {
            preparedStatement.setString(1, loginBean.getEmail());
            preparedStatement.setString(2, loginBean.getPassword());

            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next())
            {
            	landlord.setName(rs.getString("name"));
            	landlord.setEmail(rs.getString("email"));
            	landlord.setContact(rs.getLong("contact"));
            	landlord.setDate(rs.getDate("date"));
            	break;
            }

        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
        return landlord;
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
