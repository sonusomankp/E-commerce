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
.table>tbody>tr>td, .table>tfoot>tr>td{
    vertical-align: middle;
}
@media screen and (max-width: 600px) {
    table#cart tbody td .form-control{
		width:20%;
		display: inline !important;
	}
	.actions .btn{
		width:20%;
		margin:1.5em 0;
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

</head>
<body>

<form>
<jsp:include page="header.jsp"/>
<div class="container">
	<table id="cart" class="table table-hover table-condensed">
    				<thead>
						<tr>
							<th style="width:50%">Product</th>
							<th style="width:10%">Price</th>
							<th></th>
							<th style="width:8%">Quantity</th>
							<th style="width:22%" class="text-center"></th>
							<th style="width:10%"></th>
						</tr>
					</thead>
					<tbody>
					
						<tr>
								
							<td data-th="Product">
								<div class="row">
									<div class="col-sm-2 hidden-xs"><img src="${pageContext.request.contextPath}/resources/proimages/${c.product.img}" alt="..." class="img-responsive"/></div>
									<div class="col-sm-10">
										<h4 class="nomargin">${ca.product.name}</h4>
									</div>
								</div>
							</td>
							<td data-th="Price">${ca.price}</td>
							<td></td>
							
							<td data-th="Quantity">
							    <form action = "cartupdate">
							    <input type="hidden"  name="cid" value=${ca.cartid}>
								<input type="number" name="quantity" value=${ca.quantity}>
								<td><input id="submit"  class="btn btn-success" type="submit" value="Update"></td>
								</form>
								
				
								
							</td>
							
								
							
							
						
							
						</tr>
					</tbody>
				
				</table>
</div>
<jsp:include page="footer.jsp"/>

</body>
</html>