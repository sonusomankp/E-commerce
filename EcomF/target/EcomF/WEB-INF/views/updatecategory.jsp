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
</head>
<body>
<%@ include file = "header.jsp" %>

<form action="catupd">
<table>
<tr>
  <td>category id: </td> <td><input type="text" name="id" value="${cat.c_id}"> </td> </tr>
 <tr> <td> category name:</td> <td> <input type="text" name="name" value="${cat.cname}"></td></tr>
  <tr> <td><input type="submit" value="Submit form"></td></tr>
  </table>
</form>

</body>
</html>