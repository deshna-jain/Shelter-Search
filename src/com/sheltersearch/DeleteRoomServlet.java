package com.sheltersearch;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

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

@WebServlet("/delete")
public class DeleteRoomServlet extends HttpServlet {

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
		    	
		        String idstr = request.getParameter("id");
		        long id = Long.parseLong(idstr);
		        
		        
		            	System.out.println("Here");
		            	try {
							if(roomDao.deleteRoom(id)){
								System.out.println("Room deleted");
								HttpSession session =request.getSession();
								UserBean bean = (UserBean) session.getAttribute("user");
								List<RoomDetailsBean> rooms = roomDao.getRoomsByEamil(bean.getEmail());
								session.setAttribute("rooms", rooms);
								response.sendRedirect("landlorddashboard.jsp");  // TODO Implement landlordDashBoard page
							}
							
							else
							{
								response.sendRedirect("register.jsp");
							}
						} catch (ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		        	
		            }
		        	
		            
		    }

