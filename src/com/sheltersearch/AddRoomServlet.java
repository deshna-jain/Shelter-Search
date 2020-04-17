package com.sheltersearch;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.sql.Blob;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import javax.sql.rowset.serial.SerialBlob;

import com.sheltersearch.beans.RoomDetailsBean;
import com.sheltersearch.beans.UserBean;
import com.sheltersearch.dao.LandlordDao;
import com.sheltersearch.dao.RoomDao;
import com.sheltersearch.dao.StudentDao;

import org.apache.commons.io.IOUtils;

@WebServlet("/addroom")
@MultipartConfig
public class AddRoomServlet extends HttpServlet {

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
		 			
		 			System.out.println("Inside add roomServlet");
			    	String houseName = request.getParameter("houseName");
			        String address = request.getParameter("address");
			        String description = request.getParameter("description");
			        String contactstr = request.getParameter("contact");
			        String rentstr = request.getParameter("rent");
			        
			        Part filePart = request.getPart("image"); // Retrieves <input type="file" name="file">
			        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
			        InputStream stream =  filePart.getInputStream();
			        byte[] arr = getFileAsByteA(stream);
			        SerialBlob image =null;
					try {
						image = new SerialBlob(arr);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			        
			        long contact = Long.parseLong(contactstr);
			        long rent = Long.parseLong(rentstr);
			        HttpSession session =request.getSession();
					UserBean bean = (UserBean) session.getAttribute("user");
					String email = bean.getEmail();
			        
					RoomDetailsBean room = new RoomDetailsBean();
			        room.setHouseName(houseName);
			        room.setAddress(address);
			        room.setDescription(description);
			        room.setContact(contact);
			        room.setRent(rent);
			        room.setEmail(email);
			        room.setImage(image);
			        
			        try {
			        	 
			        		roomDao.insertRooms(room);
			        		System.out.println("Room Added");
							List<RoomDetailsBean> rooms = roomDao.getRoomsByEamil(bean.getEmail());
							session.setAttribute("rooms", rooms);
							response.sendRedirect("landlorddashboard.jsp");  // TODO Implement landlordDashBoard page
			        	
			        	//else
//			        	{
//			        		System.out.println("Room could not added");
//			        	}
			        } catch (Exception e) {
			            // TODO Auto-generated catch block
			            e.printStackTrace();
			        }
			        
			        // TODO for Landlord
			     //   response.sendRedirect("login.jsp");
			    }
	 public static byte[] getFileAsByteA(InputStream stream) {
		    try {
		        return IOUtils.toByteArray(stream);
		    } catch (IOException ex) {
		        return null;
		    }
		}

}
