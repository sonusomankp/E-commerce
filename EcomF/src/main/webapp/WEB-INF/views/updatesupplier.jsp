<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>updatedsupplier</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<jsp:include page="header.jsp"/>

<form action="supupd">
<table>
<tr>
  <td>supplier id: </td> <td><input type="text" name="id" value="${sup.s_id}"> </td> </tr>
 <tr> <td> supplier name:</td> <td> <input type="text" name="name" value="${sup.sname}"></td></tr>
 <tr> <td> supplier address:</td> <td> <input type="text" name="sad" value="${sup.saddr}"></td></tr>
  <tr> <td><input type="submit" value="Submit form"></td></tr>
  </table>
</form>
</body>
</html>