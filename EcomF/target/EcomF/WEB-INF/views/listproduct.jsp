<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>listP</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<jsp:include page="header.jsp"/>
<h3>PRODUCT LIST</h3>
<c:forEach var="p" items="${pr}">
<table>
<tr>

<th><li><a href="categoryid?id=${p.id}">${p.name}</a></li></th>
<th><a href="prou?id=${p.id}"><button type="submit" class="btn btn-info" >Edit</button> </a></th> 
    
    <th><a href="prodel?id=${p.id}">
    <button type="submit" class="btn btn-info" href="listP">Delete</button> </a></th>
</tr>  
                       
      
  </table>
  </c:forEach>

</body>
</html>