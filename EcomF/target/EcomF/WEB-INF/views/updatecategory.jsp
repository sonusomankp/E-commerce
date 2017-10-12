<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>updatedcategory</title>
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
<h4>Category update</h4>
<form action="catupd">
<table>
<tr>
  <td>category id: </td> <td><input type="text" name="id" value="${cat.c_id}"> </td> </tr>
 <tr> <td> category name:</td> <td> <input type="text" name="name" value="${cat.cname}"></td></tr>
  <tr> <td><input  class="btn btn-success" type="submit" value="Update"></td></tr>
  </table>
</form>

<jsp:include page="footer.jsp"/>
</body>
</html>