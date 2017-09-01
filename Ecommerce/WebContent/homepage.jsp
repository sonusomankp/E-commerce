<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>M4MOBILES</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">M4MOBILES</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="#">Home</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="#myModal"data-toggle="modal" data-target="#myModal"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      <li><a href="password.jsp"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
    </ul>
  </div> 
</nav>
  
<div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Sign Up</h4>
        </div>
        <div class="modal-body">
<form action="task.jsp" method="post">
<table>
<tr>
<td>
     Name:<td><input type="text" name="name" required></td> </td> </tr>
<tr>
<td>
     Father name:<td><input type="text" name="fname" required></td> </td> </tr>
<tr>
<td>Mail id:<td> <input type="email" name="email"required></td> </td> </tr>
<tr>
<td>   Address:<td><textarea rows="10" cols="10" name="add"required></textarea> </td> </td> </tr>
<tr>
<td>   pin code:<td><input type="number" name="pin"required></td> </td> </tr>
<tr>
<td>  mob no:<td><input type="number" name="mobno"required></td> </td> </tr>
<tr>
<td>   Gender:<td><input type="radio"name="c" value="male">Male<input type="radio" name="c" value="female">Female </td> </td> </tr>
<tr>
<td>   State:<td>
        <select>
        <option>KERALA</option>
        <option>TAMILNADU</option>  
        <option>GOA</option>
        <option>KOLKATA</option>
        </select> </td> </td> </tr>
<tr>
<td> <input type="submit" value="Sign up"></td> </tr>
     </table>
</form>


        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
      
    </div>
  </div>

<div class="container">
  <h3>Welcome to M4MOBILES</h3>
  
</div>

<div class="container">
  <h2>M4MOBILES</h2>  
  <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner">
      <div class="item active">
        <img src="images/android.jpg" alt="Los Angeles" style="width:100%;">
      </div>

      <div class="item">
        <img src="images/iphone8.jpg" alt="Chicago" style="width:100%;">
      </div>
    
      <div class="item">
        <img src="images/lumia.jpg" alt="New york" style="width:100%;">
      </div>
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
</div>
<footer>
  @M4MOBILES 2017
</footer>
</body>
</html>