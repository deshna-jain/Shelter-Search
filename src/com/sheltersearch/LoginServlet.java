package com.sheltersearch;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sheltersearch.beans.LoginBean;
import com.sheltersearch.beans.RoomDetailsBean;
import com.sheltersearch.beans.UserBean;
import com.sheltersearch.dao.LandlordDao;
import com.sheltersearch.dao.RoomDao;
import com.sheltersearch.dao.StudentDao;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

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
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        PrintWriter out = response.getWriter();
        
        LoginBean loginBean = new LoginBean();
        loginBean.setEmail(email);
        loginBean.setPassword(password);
        loginBean.setType(userType);
        System.out.println(userType);
       
        try {
        	if(userType.equals("student")) {
            if (studentDao.validate(loginBean)) {
            	System.out.println("User Logged in");
            	UserBean student = studentDao.getStudentBean(loginBean);
            	List<RoomDetailsBean> rooms = roomDao.getAllRooms();
        		System.out.println(rooms.size());
                HttpSession session = request.getSession();
                session.setAttribute("user",student);
                session.setAttribute("rooms", rooms);
                response.sendRedirect("userdashboard.jsp");
            }
            else
            {
            	response.sendRedirect("error.jsp");
            }
            }
        	else if(userType.equals("landlord")){
            	System.out.println("Here");
            	if(landlordDao.validate(loginBean)){
            		System.out.println("Landlord Logged in");
            		UserBean landlord = landlordDao.getLandlordBean(loginBean);
            		List<RoomDetailsBean> rooms = roomDao.getRoomsByEamil(loginBean.getEmail());
            		HttpSession session =request.getSession();
            		session.setAttribute("user", landlord);
            		session.setAttribute("rooms", rooms);
            		response.sendRedirect("landlorddashboard.jsp");  // TODO Implement landlordDashBoard page
            	}
            	
            	else
                {
                	response.sendRedirect("error.jsp");
                }
                
        	}
        	else if(userType.equals("admin")) {
                
                
                if((email.equals("admin@gmail.com"))&&(password.equals("admin@123")))
                {
                    RequestDispatcher rs = request.getRequestDispatcher("AdminHome.jsp");
                    rs.forward(request, response);
                }
                else
                {
                	response.sendRedirect("error.jsp");
                }
        	}
            }
        	
            
         catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
	
}
