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
<jsp:include page="header.jsp"/>
<div class="container">
  <ul class="nav nav-tabs">
    <li class="active"><a data-toggle="tab" href="#prod">Category</a></li>
    <li><a data-toggle="tab" href="#cat">Product</a></li>  
    <li><a data-toggle="tab" href="#sup">Supplier</a></li>
     <li><a data-toggle="tab" href="#lis">List</a></li>
  </ul>
<div class="tab-content">
 
 <div id="prod" class="tab-pane fade in active ">
    <form action="cate">
      <h3>Category</h3>
      
    <label><b>Category Name</b></label>
    <input type="text" class="form-control" name="psw" required ></br>
    <button type="submit" class="btn btn-default" href="Admin">Save</button>
   </form> </div>
    
 <div id="cat" class="tab-pane fade">
    <form action="pro" method="post" enctype="multipart/form-data">
      <h3>Product</h3>
      <label><b>Name</b></label>
    <input type="text" class="form-control" name="name" required></br>
    <label><b>Short Description</b></label>
    <input type="text" class="form-control" name="sdes" required></br>
    <label><b>Price</b></label>
    <input type="number" class="form-control" name="pric" required></br>
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
                       <option value="${designatee.s_id}">${designatee.sname}</option>    
                    </c:forEach>         
     
    </select>
    
    </div>
    
    <label><b>Stock</b></label>
    <input type="number" class="form-control" name="stoc" required></br>
    
    <label><b>image</b></label>
    <input type="file" class="form-control" name="img" required/></br>
    
    <button type="submit" class="btn btn-default" href="Admin">Save</button>
   </form> </div>
   
   
  
    
    
    
    <div id="sup" class="tab-pane fade">
    <form action="supp">
      <h3>Supplier</h3>
      <label><b>Supplier name</b></label>
    <input type="text" name="dtype" class="form-control" required></br>
    <label><b>Address</b></label>
    <input type="text"  name="psw" class="form-control" required></br>
    <button type="submit" class="btn btn-default" href="Admin">Save</button>
   </form> </div>
  
  
  
  
  
  <div id="lis" class="tab-pane fade">
    <h3>List</h3>
    <div>
   <a href="listC?f="><button type="submit" class="btn btn-success" >Category</button></a>
    </div>
    
    
    <br>
    
    
    <div>
   
    <a href="listP?f="><button type="submit" class="btn btn-info">Product</button></a>
      
    </div>
    
    
    <br>
    
    
     <div>
    
    <a href="listS?f="><button type="submit" class="btn btn-warning">Supplier</button>  </a>
     
    </div>
    

  </div>
  <br>
   <br>
   <br>
   <br>
<jsp:include page="footer.jsp"/>
</body>
</html>