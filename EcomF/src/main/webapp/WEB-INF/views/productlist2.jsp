<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
      
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>PRODUCTS</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<style>
.btn-product{
	width: 100%;
}
</style>
</head>


<body>
<jsp:include page="header.jsp"/>


<div class="container">
    <div class="row">
     <c:forEach items="${pros}" var="designate"  varStatus="loop">
       <a href="${designate.id}">
    	<div class="col-md-12">
			<div class="col-sm-6 col-md-4">
				<div class="thumbnail" >
					<h4 class="text-center"><span class="label label-info">${designate.name}</span></h4>
					<img src="${pageContext.request.contextPath}/resources/proimages/${designate.img}" style="width:170px;height:180px; alt="" class="img-responsive">
					<div class="caption">
						<div class="row">
							<div class="col-md-6 col-xs-6">
								<h3>${designate.shortDescrption}</h3>
							</div>
							<div class="col-md-6 col-xs-6 price">
								<h3>
								<label>${designate.price}</label></h3>
							</div>
						</div>
			
						<p>${designate.shortDescrption}</p>
						<div class="row">
							<div class="col-md-6">
								<a class="btn btn-primary btn-product"><span class="glyphicon glyphicon-thumbs-up"></span> Like</a> 
							</div>
							<div class="col-md-6">
								<a href="prou1?id=${designate.id}"" class="btn btn-success btn-product"><span class="glyphicon glyphicon-shopping-cart"></span> Quick View</a></div>
						</div>

					
					</div>
				</div>
			</div>
			
				</c:forEach>

</body>
</html>