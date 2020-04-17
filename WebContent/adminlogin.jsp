<%-- 
    Document   : adminlogin
    Created on : 11 Apr, 2020, 11:00:21 PM
    Author     : deshna jain
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Admin-login</title>
	<link rel="stylesheet" type="text/css" href="css/login.css">
</head>
<body>
	<div class="logo">
                <img src="img/logo.png">
    </div>
   
	<div class="login-page">
	
	<div id="myform" class="form">
            <form class="register-form" action="AdminLogin" method="post">
                <input type="text" name="username" placeholder="username"/>
		<input type="password" name="t2" placeholder="password" />
                <button value="submit">Login</button>
		
		</form>
	</div>
	</div>
      
</body>
</html>