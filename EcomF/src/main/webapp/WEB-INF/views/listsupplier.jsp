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
<h5>${c}</h5>
<h3>SUPPLIER LIST</h3>
<c:forEach var="designatee" items="${su}">
<table>
<tr>

<th width="110px">${designatee.sname}</th>
<th width="110px">
<a href="supu?id=${designatee.s_id}"><button type="submit" class="btn btn-info"><span class="glyphicon glyphicon-pencil"></span>Edit</button> </a></th> <br>
    
    <th width="110px"><a href="supdel?id=${designatee.s_id}">
    <button type="submit" class="btn btn-danger" href="listS"><span class="glyphicon glyphicon-trash"></span>Delete</button> </a></th>
</tr>  
                       
      
  </table>
  </c:forEach>
  <br>
<br>
<br>
<br>
<br>
  
<jsp:include page="footer.jsp"/>
</body>
</html>