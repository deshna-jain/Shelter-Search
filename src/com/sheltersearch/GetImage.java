package com.sheltersearch;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sheltersearch.dao.LandlordDao;
import com.sheltersearch.dao.RoomDao;
import com.sheltersearch.dao.StudentDao;

@WebServlet("/image/*")
public class GetImage extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private StudentDao studentDao;
	private RoomDao roomDao;
	private LandlordDao landlordDao;
	public void init() {
    	studentDao = new StudentDao();
    	roomDao = new RoomDao();
    	landlordDao = new LandlordDao();
    }
	
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long id = Long.parseLong(request.getPathInfo().substring(1)); // Returns "foo.png".

        try (Connection connection = DriverManager
                .getConnection("jdbc:mysql://192.168.56.101:3306/shelter_database?useSSL=false", "gaurav", "Gaurav1234"); PreparedStatement statement = connection.prepareStatement("select image from rooms where id = ?")) {
            statement.setLong(1, id);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    byte[] content = resultSet.getBytes("image");
                    response.setContentType(getServletContext().getMimeType(""+id));
                    response.setContentLength(content.length);
                    response.getOutputStream().write(content);
                } else {
                    response.sendError(HttpServletResponse.SC_NOT_FOUND); // 404.
                }
            }
        } catch (SQLException e) {
            throw new ServletException("Something failed at SQL/DB level.", e);
        }
    }
	
}
