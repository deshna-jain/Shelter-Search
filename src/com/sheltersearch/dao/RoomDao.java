package com.sheltersearch.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.Blob;
import com.sheltersearch.beans.RoomDetailsBean;

public class RoomDao {
	
	private String jdbcURL = "jdbc:mysql://192.168.56.101:3306/shelter_database?useSSL=false";
    private String jdbcUsername = "gaurav";
    private String jdbcPassword = "Gaurav1234";

    private static final String INSERT_ROOMS_SQL = "INSERT INTO rooms" + "  (houseName, address, image, contact, rent, description, email) VALUES " +
        " (?, ?, ?, ?, ?, ?, ?);";

    //private static final String SELECT_USER_BY_ID = "select id,name,email,country from users where id =?";
    private static final String SELECT_ALL_ROOMS = "select * from rooms";
    private static final String DELETE_ROOMS_SQL = "delete from rooms where id = ?;";
    //private static final String UPDATE_USERS_SQL = "update users set name = ?,email= ?, country =? where id = ?;";

    public RoomDao() {}

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }
    
    public List<RoomDetailsBean> getRoomsByEamil(String mail) throws ClassNotFoundException{
    	List<RoomDetailsBean> rooms = new ArrayList<RoomDetailsBean>();
        Class.forName("com.mysql.cj.jdbc.Driver");

        try (Connection connection = DriverManager
        		.getConnection("jdbc:mysql://192.168.56.101:3306/shelter_database?useSSL=false", "gaurav", "Gaurav1234");
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection
            .prepareStatement("select * from rooms where email = ?")) {
            preparedStatement.setString(1, mail);

            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while( rs.next())
            {
            	long id = rs.getLong("id");
                String houseName = rs.getString("houseName");
                String email = rs.getString("email");
                String address = rs.getString("address");
                String description = rs.getString("description");
                long rent = rs.getLong("rent");
                long contact = rs.getLong("contact");
                Blob image = (Blob) rs.getBlob("image");
                RoomDetailsBean room = new RoomDetailsBean();
                room.setHouseName(houseName);
                room.setAddress(address);
                room.setImage(image);
                room.setContact(contact);
                room.setId(id);
                room.setEmail(email);
                room.setDescription(description);
                room.setRent(rent);
                rooms.add(room);
            }

        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }	
    	return rooms;
    }

    public void insertRooms(RoomDetailsBean room) throws SQLException {
    	System.out.println("Inside query");
        System.out.println(INSERT_ROOMS_SQL);
        
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ROOMS_SQL)) {
            preparedStatement.setString(1, room.getHouseName());
            preparedStatement.setString(2, room.getAddress());
            preparedStatement.setBlob(3, room.getImage());
            preparedStatement.setLong(4, room.getContact());
            preparedStatement.setLong(5, room.getRent());
            preparedStatement.setString(6, room.getDescription());
            preparedStatement.setString(7, room.getEmail());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
            
            
        } catch (SQLException e) {
            printSQLException(e);
        }
        
    }

//    public User selectUser(int id) {
//        User user = null;
//        // Step 1: Establishing a Connection
//        try (Connection connection = getConnection();
//            // Step 2:Create a statement using connection object
//            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
//            preparedStatement.setInt(1, id);
//            System.out.println(preparedStatement);
//            // Step 3: Execute the query or update query
//            ResultSet rs = preparedStatement.executeQuery();
//
//            // Step 4: Process the ResultSet object.
//            while (rs.next()) {
//                String name = rs.getString("name");
//                String email = rs.getString("email");
//                String country = rs.getString("country");
//                user = new User(id, name, email, country);
//            }
//        } catch (SQLException e) {
//            printSQLException(e);
//        }
//        return user;
//    }

    public List <RoomDetailsBean> getAllRooms() {

        // using try-with-resources to avoid closing resources (boiler plate code)
        List < RoomDetailsBean > rooms = new ArrayList < > ();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ROOMS);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                long id = rs.getLong("id");
                String houseName = rs.getString("houseName");
                String email = rs.getString("email");
                String address = rs.getString("address");
                String description = rs.getString("description");
                long rent = rs.getLong("rent");
                long contact = rs.getLong("contact");
                Blob image = (Blob) rs.getBlob("image");
                RoomDetailsBean room = new RoomDetailsBean();
                room.setHouseName(houseName);
                room.setAddress(address);
                room.setImage(image);
                room.setContact(contact);
                room.setId(id);
                room.setEmail(email);
                room.setDescription(description);
                room.setRent(rent);
                rooms.add(room);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return rooms;
    }

    public boolean deleteRoom(long id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_ROOMS_SQL);) {
            statement.setLong(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

//    public boolean updateUser(User user) throws SQLException {
//        boolean rowUpdated;
//        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
//            statement.setString(1, user.getName());
//            statement.setString(2, user.getEmail());
//            statement.setString(3, user.getCountry());
//            statement.setInt(4, user.getId());
//
//            rowUpdated = statement.executeUpdate() > 0;
//        }
//        return rowUpdated;
//    }

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
