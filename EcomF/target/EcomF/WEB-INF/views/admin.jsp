<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin</title>
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
      <li class="active"><a href="">Home</a></li>
      
    </ul>
  </div> 
</nav>
<div class="container">
  <ul class="nav nav-tabs">
    <li class="active"><a data-toggle="tab" href="#prod">Category</a></li>
    <li><a data-toggle="tab" href="#cat">Product</a></li>  
    <li><a data-toggle="tab" href="#sup">Supplier</a></li>
  </ul>
<div class="tab-content">
 
 <div id="prod" class="tab-pane fade in active">
    <form action="cate">
      <h3>Category</h3>
      
    <label><b>Category Name</b></label>
    <input type="text" class="form-control" name="psw" required ></br>
    <button type="submit" class="btn btn-default" href="Admin">Save</button>
   </form> </div>
    
 <div id="cat" class="tab-pane fade in active">
    <form action="pro">
      <h3>Product</h3>
      <label><b>Type</b></label>
    <input type="text" class="form-control" name="dtype" required></br>
    <label><b>Title</b></label>
    <input type="text" class="form-control" name="tit" required></br>
    <label><b>Short description</b></label>
    <input type="text" class="form-control" name="sdes" required></br>
    <div class="form-group">
        <label for="inputName">Category</label>
        <select name="ca">
     <option value="volvo">Select Category</option>
     <c:forEach var="designatee" items="${catego}">
                       <option value="${designatee.c_id}">${designatee.cname}</option>    
                    </c:forEach>         
     
    </select>
    
     
      <label for="inputName">Supplier</label>
      <select name="su">
     <option value="volvo">Select Supplier</option>
     <c:forEach var="designatee" items="${cat}">
                       <option value="${designatee.s_id}$">${designatee.sname}</option>    
                    </c:forEach>         
     
    </select>
    
    </div>
    
    <label><b>format</b></label>
    <input type="text" class="form-control" name="form" required></br>
    <button type="submit" class="btn btn-default" href="Admin">Save</button>
   </form> </div>
   
  
    
    
    
    <div id="sup" class="tab-pane fade in active">
    <form action="supp">
      <h3>Supplier</h3>
      <label><b>Supplier name</b></label>
    <input type="text" name="dtype" class="form-control" required></br>
    <label><b>Address</b></label>
    <input type="text"  name="psw" class="form-control" required></br>
    <button type="submit" class="btn btn-default" href="admin">Save</button>
   </form> </div>
    </div>
  

    </div>
    



</body>
</html>