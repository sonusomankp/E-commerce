<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>listS</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<%@ include file = "header.jsp" %>
<h3>SUPPLIER LIST</h3>
<c:forEach var="designatee" items="${su}">
<table>
<tr>

<th><li><a href="categoryid?id=${designatee.s_id}">${designatee.sname}</a></li></th>
<th><form action="supupd?id=${designatee.s_id}">
    <button type="submit" class="btn btn-info" href="listproduct">Edit</button> </form></th> <br>
    <th><a href="supdel?id=${designatee.s_id}">
    <button type="submit" class="btn btn-info" href="listS">Delete</button> </a></th>
</tr>  
                       
      
  </table>
  </c:forEach>
</body>
</html>