<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link href="https://fonts.googleapis.com/css?family=Josefin+Sans&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <style>
        *{
            margin: 0;padding: 0;font-family: 'Josefin Sans', sans-serif;
        }
    </style>
    <title>ShelterSearch</title>
</head>
<body>
<header>
    <div >
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <a class="navbar-brand" href="#">Shelter Search</a>
            <ul class="navbar-nav ml-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="#">Hello ${user.name}<span class="sr-only">(current)</span></a>
                </li>
            </ul>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="#">Home<span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">About us</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Contact us</a>
                    </li>
                </ul>
                <a href="#" class="btn btn-primary" data-toggle="modal" data-target="#myModal">Add Rooms</a>
            </div>
        </nav>
    </div>
    <div class="modal fade" id="myModal">
        <div class="modal-dialog modal-dialog-centered">
          <div class="modal-content">

            <!-- Modal Header -->
            <div class="modal-header">
              <h4 class="modal-title">Enter Room Details</h4>
              <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>
			<form action="<%=request.getContextPath()%>/addroom" method="post" enctype="multipart/form-data">
            <!-- Modal body -->
            <div class="modal-body">
              	<div class="form-group">
    				<label for="exampleInputEmail1">House Name</label>
    				<input type="text" class="form-control" name = "houseName" placeholder="Enter House Name">
  				</div>
  				<div class="form-group">
    				<label for="exampleInputEmail1">Address</label>
    				<input type="text" class="form-control" name = "address" placeholder="Enter Address">
  				</div>
  			  	<div class="form-group">
    				<label for="exampleFormControlTextarea1">Description</label>
    				<textarea class="form-control" name = "description" placeholder = "Enter Description" rows="3"></textarea>
  			 	</div>
  			 	<div class="form-group">
    				<label for="exampleFormControlFile1">Image</label>
   					<input type="file" class="form-control-file" name = "image">
  				</div>
  				<div class="form-group">
    				<label for="exampleInputEmail1">Contact</label>
    				<input type="tel" class="form-control" name = "contact" placeholder="Enter Contact Number">
  				</div>
  				<div class="form-group">
    				<label for="exampleInputEmail1">Rent</label>
    				<input type="number" class="form-control" name = "rent" placeholder="Enter Rent">
  				</div>
            </div>

            <!-- Modal footer -->
            <div class="modal-footer">
              <button type="submit" class="btn btn-success" value="submit">Submit</button>
            </div>
			</form>
          </div>
        </div>
      </div>
</header>

<section>
  <div class="container">
    <h1 class="text-center text-capitalize my-5">Your Rooms</h1>
    <hr class="w-25 text-center mx-auto">


    <div class="row text-center">
      <c:forEach items="${rooms}" var="room">
      <div class="col-lg-4 col-md-4 col-12">
        <div class="card" >
          <img class="card-img-top" src="<%=request.getContextPath()%>/image/${room.id}" alt="Card image cap">
          <div class="card-body">
            <h5 class="card-title">${room.houseName}</h5>
            <p class="card-text">${room.address}</p>
            <p class ="card-text">Description : ${room.description}<p>
            <p class ="card-text">Contact : ${room.contact}<p>
            <p class ="card-text">Rent : ${room.rent}<p>
            <form action="<%=request.getContextPath()%>/delete" method="post">
            <button  class="btn btn-danger" value="${room.id}" name="id" type ="submit" >DeleteRoom</button>
            </form>
          </div>
        </div>
      </div>

      
      </c:forEach>
    </div>





  </div>
</section>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>