package com.sheltersearch;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sheltersearch.beans.UserBean;
import com.sheltersearch.dao.LandlordDao;
import com.sheltersearch.dao.RoomDao;
import com.sheltersearch.dao.StudentDao;

@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {

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

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

    	String userType = request.getParameter("userType");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String contactstr = request.getParameter("contact");
        String password = request.getParameter("password");
        String datestr = request.getParameter("date");
        String gender = request.getParameter("gender");
        
        long contact = Long.parseLong(contactstr);
        
        // date format yyyy-mm-dd

        String[] s = datestr.split("-");
        String datestrr = s[2]+"-"+s[1]+"-"+s[0];
        //System.out.println(ss);
            
       
        Date date = Date.valueOf(datestr);

        UserBean user = new UserBean();
        user.setUserType(userType);
        user.setName(name);
        user.setEmail(email);
        user.setContact(contact);
        user.setPassword(password);
        user.setDate(date);
        user.setGender(gender);

        try {
        	if(userType.equals("student")) {
        	studentDao.registerStudent(user);
        	}
        	else if(userType.equals("landlord")) {
        		landlordDao.registerLandlord(user);
        	}
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
        dispatcher.forward(request, response);
        
        // TODO for Landlord
     //   response.sendRedirect("login.jsp");
    }

	
}
