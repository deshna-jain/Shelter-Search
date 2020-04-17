<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Gallery</title>
    <link rel="stylesheet" type="text/css" href="css/style2.css">
    <link rel="stylesheet" href="css/style2.css" type="text/css"/>

</head>

<body>
    <header>
        <div class="main">
            <div class="logo">
                <img src="img/logo.png">
            </div>
            <ul>
                <li><a href="index.jsp">Home</a> </li>
                <li><a href="services.jsp">Services</a> </li>
                <li><a href="gallery.jsp">Gallery</a> </li>
                <li><a href="about.jsp">About</a> </li>
                <li><a href="contact.jsp">Contact</a> </li>
            </ul>
        </div>
        <div class="title">
            <h1>GALLERY</h1>
            
	     

        </div>
    
<div class="slider-holder">
        <span id="slider-image-1"></span>
        <span id="slider-image-2"></span>
        <span id="slider-image-4"></span>
        <span id="slider-image-3"></span>
        <span id="slider-image-5"></span>
        <div class="image-holder">
            <img src="img/1.jpg" class="slider-image" />
            <img src="img/2.jpg" class="slider-image" />
            <img src="img/4.jpg" class="slider-image" />
            <img src="img/3.jpg" class="slider-image" />
            <img src="img/5.jpg" class="slider-image" />
        </div>
        <div class="button-holder">
            <a href="#slider-image-1" class="slider-change"></a>
            <a href="#slider-image-2" class="slider-change"></a>
            <a href="#slider-image-4" class="slider-change"></a>
            <a href="#slider-image-3" class="slider-change"></a>
            <a href="#slider-image-5" class="slider-change"></a>
        </div>
    </div>
        </header>
</body>
</html>
