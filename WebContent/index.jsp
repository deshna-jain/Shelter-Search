<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>ShelterSearch</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">

</head>
<body>
    <header>
        <div class="main">
            <div class="logo">
                <img src="img/logo.png">
            </div>
            <ul>
                <li class="active"><a href="#">Home</a> </li>
                <li><a href="services.jsp">Services</a> </li>
                <li><a href="gallery.jsp">Gallery</a> </li>
                <li><a href="about.jsp">About</a> </li>
                <li><a href="contact.jsp">Contact</a> </li>
            </ul>
        </div>
        <div class="title">
            <h1>SHELTERSEARCH</h1>



         </div>
       
<br> <div id="loginBtn" class="button">
            <a href="<c:url value = "/login.jsp"/>" class="btn">Login</a>            <a href="<c:url value = "/register.jsp"/>" class="btn">Register</a>

        </div>
    </header>

</body>

</html>
