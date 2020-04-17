<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<title>Login_page</title>
	<link rel="stylesheet" type="text/css" href="css/login.css">
	<link rel="stylesheet" type="text/css" href="css/register.css">
</head>
<body>
	<div class="logo">
                <img src="img/logo.png">
    </div>
	<div class="login-page">
	
	<div id="myform" class="form">
		<form class="register-form" action="<%=request.getContextPath()%>/login" method="post">
		<select id="user" name = "userType">
            <option value="student">Student</option>
            <option value="landlord">Landlord</option>
            <option value="admin">Admin</option>
          </select>
<input type="text" placeholder="email" name = "email"/>
		<input type="password" placeholder="password" name = "password"/>
		<button type="submit" value="Submit">Login</button>
		
		</form>
		
	</div>
	</div>
</body>
</html>