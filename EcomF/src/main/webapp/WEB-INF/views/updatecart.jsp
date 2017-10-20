<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>



  <style>
<style>
.table>tbody>tr>td, .table>tfoot>tr>td{
    vertical-align: middle;
}
@media screen and (max-width: 600px) {
    table#cart tbody td .form-control{
		width:20%;
		display: inline !important;
	}
	.actions .btn{
		width:36%;
		margin:1.5em 0;
	}
	
	.actions .btn-info{
		float:left;
	}
	.actions .btn-danger{
		float:right;
	}
	
	table#cart thead { display: none; }
	table#cart tbody td { display: block; padding: .6rem; min-width:320px;}
	table#cart tbody tr td:first-child { background: #333; color: #fff; }
	table#cart tbody td:before {
		content: attr(data-th); font-weight: bold;
		display: inline-block; width: 8rem;
	}
	
	
	
	table#cart tfoot td{display:block; }
	table#cart tfoot td .btn{display:block;}
	
}
</style>
  </style>

</head>
<body>

<%@ include file = "header.jsp" %>
<body>

  

<div class="container">
	<table id="cart"  style="color:black;border-collapse: separate;
    border-spacing: 10px ;" >
    				<thead>
						<tr>
							<th style="width:50%">Product</th>
							<th style="width:10%">Price</th>
							<th style="width:22%">Quantity</th>
							
							
							
						</tr>
					</thead>
					<tbody>
						
					
						<tr>
						
							<td data-th="Product">
								<div class="row">
								
									<div class="col-sm-2 "><img src="${pageContext.request.contextPath}/resources/proimages/${ca.product.img}" alt="..." class="img-responsive"width="100%" height="100%"/></div>
									<div class="col-sm-10">
									 
										<h4 class="nomargin">${ca.product.name }</h4>
										<p>
										</p>	</div>
								</div>
							</td>
							<td data-th="Price">&#8377; ${ca.price}</td>
							<td data-th="Quantity">
							<form action="cartupdate">
							 <input id="prodId" name="cid" type="hidden" value="${ca.cartid}">
								<input type="number" class="form-control text-center" value="${ca.quantity }" name="quantity">
							    <input id="submit" class="btn btn-info btn-md" name="submit" type="submit" value="UPDATE" style="width:100%">
							</form>
							</td>
					
							
							
                                 
						</tr>
						
					
					</tbody>
				
				</table>
</div>
<%@ include file = "footer.jsp" %>
</body>
</html>