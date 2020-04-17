<%@page language="java" import="java.util.*" %>
<%@page import="com.sheltersearch.beans.*"  %>
<!DOCTYPE html> 
<html> 
  <head> 
   <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

   <title>Data List</title> 
  </head> 
  <body> 
       <nav class="navbar navbar-dark bg-dark">
             <a class="navbar-brand" href="#">
    <img src="img/logo.png" width="30" height="30" class="d-inline-block align-top" alt="">
    ShelterSearch
  </a>
           <form class="form-inline">
               <button class="btn btn-outline-success" type="button" onclick="window.location.href='login.jsp'">Logout</button>
        </nav>
  <center><div class="shadow-lg p-3 mb-5 bg-white rounded"><h1><%=request.getAttribute("table")%> list</h1> 
            <%if(!(request.getAttribute("table").equals("rooms"))){%>
             <table class="table"> 
          <thead class="thead-dark">
         <tr> 
           
          <th scope="col"><b>Name</b></th> 
          <th scope="col"><b>Email</b></th> 
          <th scope="col"><b>Dob</b></th>
          <th scope="col"><b>Contact</b></th>
          <th scope="col"><b>Gender</b></th>
         </tr> 
          </thead>
          
        <%-- Fetching the attributes of the request object 
             which was previously set by the servlet  
              "StudentServlet.java" 
        --%>  
          <tbody>
        <%ArrayList<UserBean> std =  
            (ArrayList<UserBean>)request.getAttribute("data"); 
        for(UserBean s:std){%> 
        <%-- Arranging data in tabular form 
        --%>
            <tr> 
                <td><%=s.getName()%></td> 
                <td><%=s.getEmail()%></td>
                <td><%=s.getDate()%></td>
                <td><%=s.getContact()%></td>
                <td><%=s.getGender()%></td>
            </tr> 
       
            <%}%> 
             </tbody>
             </table>
           <%}
          else{%>
          <table class="table">
           <thead class="thead-dark">
         <tr> 
        <th scope="col"><b>Id</b></th> 
          <th scope="col"><b>House_name</b></th> 
          <th scope="col"><b>Address</b></th> 
          <th scope="col"><b>Contact</b></th>
          <th scope="col"><b>rent</b></th>
          <th scope="col"><b>Desc</b></th>
          <th scope="col"><b>Email</b></th>
         </tr>
      </thead>
      <tbody>
         <%ArrayList<RoomDetailsBean> std =  
            (ArrayList<RoomDetailsBean>)request.getAttribute("data"); 
        for(RoomDetailsBean s:std){%> 
        <tr> 
            <th scope="row"><%=s.getId()%></th> 
                <td><%=s.getHouseName()%></td>
                 <td><%=s.getAddress()%></td>
                <td><%=s.getContact()%></td>
                <td><%=s.getRent()%></td>
                <td><%=s.getDescription()%></td>
                 <td><%=s.getEmail()%></td>
            </tr> 
            <%}}%>
      </tbody>
        </table>  
      </div>
  </center>
    </body> 
</html> 
