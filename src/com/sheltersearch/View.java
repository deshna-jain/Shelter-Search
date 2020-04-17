package com.sheltersearch;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.sheltersearch.beans.RoomDetailsBean;
import com.sheltersearch.beans.UserBean;

import java.sql.*;
import java.util.*;

@WebServlet("/view")
public class View extends HttpServlet {

    
     /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
  
            String user = request.getParameter("user");
           
        try{ 
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://192.168.56.101:3306/shelter_database?useSSL=false", "gaurav", "Gaurav1234");
        PreparedStatement st=con.prepareStatement("select * from "+user);
        ResultSet rs= st.executeQuery();
        
        ArrayList<UserBean> users = new ArrayList<UserBean>();
        ArrayList<RoomDetailsBean> rooms = new ArrayList<RoomDetailsBean>();
         request.setAttribute("table", user);
       if(!(user.equals("rooms"))){
        while(rs.next()){
          
             //out.print(rs.getString(2));
            UserBean student = new UserBean();
            
            student.setName(rs.getString("name"));
        	student.setEmail(rs.getString("email"));
        	student.setContact(rs.getLong("contact"));
        	student.setDate(rs.getDate("date")); 
        	student.setGender(rs.getString("gender"));
            users.add(student);
           
            
        }
          rs.close();
          request.setAttribute("data", users);
          RequestDispatcher rd = request.getRequestDispatcher("Data.jsp");
          rd.forward(request, response);
       }
       else{
           while(rs.next()){
               RoomDetailsBean room = new RoomDetailsBean();
               room.setId(rs.getLong(1));
               room.setHouseName(rs.getString(2));
               room.setAddress(rs.getString(3));
               room.setContact(rs.getLong(5));
               room.setRent(rs.getLong(6));
               room.setDescription(rs.getString(7));
               room.setEmail(rs.getString(8));
               
               rooms.add(room);
                 }
            rs.close();
          request.setAttribute("data", rooms);
         
          RequestDispatcher rd = request.getRequestDispatcher("Data.jsp");
          
          rd.forward(request, response);
         
       }
 
   }
        catch(Exception e){
        e.printStackTrace();
        }
    }
}
