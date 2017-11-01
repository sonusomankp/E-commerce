<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>PRODUCT UPDATE</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
 table, td, th {    
    border: 1px solid #ddd;
    text-align: left;
}
th, td {
    padding: 15px;
}
</style>


</head>
<body>
<jsp:include page="header.jsp"/>

<h4>Product update</h4>

<form action="proupd"  enctype="multipart/form-data" method="post">
<table>
<tr>
  <td>product id: </td> <td>  <span style="cursor:not-allowed"> <input type="text" name="id" value="${sup.id}" readonly> </span></td> </tr> 
 <tr> <td> product name:</td> <td> <input type="text" name="name" value="${sup.name}"></td></tr>
 <tr> <td> product short desc:</td> <td> <input type="text" name="sdes" value="${sup.shortDescrption}"></td></tr>
 
  <tr> <td>category: </td> <td> <select name="ca">
     <option value="${sup.category.c_id}">${sup.category.cname}</option>
     <c:forEach var="designatee" items="${catego}">
                       <option value="${designatee.c_id}">${designatee.cname}</option>    
                    </c:forEach>      
     
   
    </select>
    </td> </tr>   
    
    
    <tr> <td>
    supplier:</td>
    <td>
    <select name="su">
     <option value="${sup.supplier.s_id}">${sup.supplier.sname }</option>
     <c:forEach var="designatee" items="${cat}">
                       <option value="${designatee.s_id}">${designatee.sname}</option>    
                    </c:forEach>         
                    
     
    </select> </td> </tr>
 
 
 
 <tr> <td> product price:</td> <td> <input type="number" name="pric" value="${sup.price}"></td></tr>
 <tr> <td> product stock:</td> <td> <input type="number" name="stoc" value="${sup.stock}"></td></tr>
 <tr> <td> image:</td> <td> <input type="file" name="img" value="${sup.img}"></td></tr>
  <tr> <td><input class="btn btn-success" type="submit" value="Update"></td></tr>
  </table>
</form>
<jsp:include page="footer.jsp"/>
</body>
</html>