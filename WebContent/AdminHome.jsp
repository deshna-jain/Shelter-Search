<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

        <title>Admin-Home</title>
    </head>
    <body>
        <nav class="navbar navbar-dark bg-dark">
             <a class="navbar-brand" href="#">
    <img src="img/logo.png" width="30" height="30" class="d-inline-block align-top" alt="">
    ShelterSearch
  </a>
           
               <button class="btn btn-outline-success" type="button" onclick="window.location.href='adminlogin.jsp'">Logout</button>
        </nav>
         <center><div class="shadow-lg p-3 mb-5 bg-white rounded">
        <h1><span class="badge badge-secondary">Hello Admin</span></h1>
        <h3>Select the user to view details</h3>
        <form action="<%=request.getContextPath()%>/view" method="post">
            <div class="dropdown">
               
         <select id="user" name="user">
            <option class="dropdown-item" value="student">student</option>
            <option class="dropdown-item" value="landlord">landlord</option>
            <option class="dropdown-item" value="rooms">Room</option>
         </select>
            </div>
            
           
       
            <br>
           <button type="submit" class="btn btn-success" value="submit">Submit</button>
        </form>
        </div>
        </center>
    </body>
</html>
