<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>updatedproduct</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>
<jsp:include page="header.jsp"/>

<form action="proupd">
<table>
<tr>
  <td>product id: </td> <td><input type="text" name="id" value="${prod.id}"> </td> </tr>
 <tr> <td> product name:</td> <td> <input type="text" name="name" value="${prod.name}"></td></tr>
 <tr> <td> product short desc:</td> <td> <input type="text" name="sdes" value="${prod.shortDescrption}"></td></tr>
 
  <tr> <td>category: </td> <td> <select name="ca">
     <option value="volvo">Select Category</option>
     <c:forEach var="designatee" items="${catego}">
                       <option value="${designatee.c_id}">${designatee.cname}</option>    
                    </c:forEach>      
     
   
    </select>
    </td> </tr>   
    
    
    <tr> <td>
    supplier:</td>
    <td>
    <select name="su">
     <option value="volvo">Select Supplier</option>
     <c:forEach var="designatee" items="${cat}">
                       <option value="${designatee.s_id}">${designatee.sname}</option>    
                    </c:forEach>         
                    
     
    </select> </td> </tr>
 
 
 
 <tr> <td> product price:</td> <td> <input type="number" name="pric" value="${prod.price}"></td></tr>
 <tr> <td> product stock:</td> <td> <input type="number" name="stoc" value="${prod.stock}"></td></tr>
  <tr> <td><input type="submit" value="Submit form"></td></tr>
  </table>
</form>
</body>
</html>