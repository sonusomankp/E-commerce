<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Basket</title>
</head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<body>

<jsp:include page="header.jsp"/>
  
  <div class="container">
  <h2>Basket</h2>
 <button type="button" class="btn btn-success">Continue Shopping</button>
 </div>

  <div class="container">
    <h3>items</h3>        
  <table class="table">
    
    <tbody>
      <tr>
        <td>Samsung S8+</td>
         <td><button type="button" class="btn btn-danger">Remove</button></td>
        
      </tr>
     </table>
</div>

<jsp:include page="footer.jsp"/>
</body>
</html>