<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
  <head>
    <title>Registration_page</title>

    <link rel="stylesheet" type="text/css" href="css/register.css" />

    <script type="text/javascript" src="js/register.js"></script>
  </head>

  <body>
    <div class="logo">
      <img src="img/logo.png" />
    </div>

    <div class="login-page">
      <div id="myform" class="form">
        <form name="val_form" class="register-form" method="post" action="<%= request.getContextPath() %>/register">
          <h3><p>REGISTRATION</p></h3>
          <select id="user" name="userType">
            <option value="student">Student</option>
            <option value="landlord">Landlord</option>
          </select>
          <input type="text" id="name" onblur="validatename()" placeholder="Name" name = "name"/>
          <label id="lblname" style="color:blue ;visibility: hidden"
            >Invalid Name</label
          >
          <input type="email" id="email" onblur="validatemail()" placeholder="Email" name = "email"/>
          <label id="lblemail" style="color:blue ;visibility: hidden"
            >Invalid Email</label
          >
          <input type="date" placeholder="Dob" name = "date" required  />

          <input type="tel" id="mob" onblur="validatemobile()"placeholder="Contact no." name = "contact" />
          <label id="lblmob" style="color:blue ;visibility: hidden"
            >Invalid Mobile No</label
          >
          
          <input type="password" id="rpass" onblur="validatepass()" placeholder="Enter password" name = "password"/>
          <label id="lblrpass" style="color:blue ;visibility: hidden"
            >Invalid password</label
          >
          
          <select id="gender" name = "gender">
            <option value="male">Male</option>
            <option value="female">Female</option>
            <option value="other">Other</option>
          </select>
          <button type="submit" onclick="return validate()"value="submit" >Sign up</button>
        </form>
      </div>
    </div>
  </body>
</html>
