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
  
  <script>
function myFunction() {
    window.print();
}
</script>
<style>
body {
  font-size: 16px;
  line-height: 25px;
  padding-top: 50px;
  font-family: 'Varela Round', sans-serif;
  background-color: #e7e7e7;
    padding-bottom:50px;
}
.color-invoice{
  background-color: #ffffff;
    border: 1px solid #d7d7d7;
    padding-top:100px;
    padding-bottom:100px;
}
</style>
</head>
<body>
<jsp:include page="header.jsp"/>

<div class="container">
      <div class="col-md-12 text-center">

    </div>
	    <div class="row color-invoice">
      <div class="col-md-12">
        <div class="row">
          <div class="col-lg-7 col-md-7 col-sm-7">
            <h1><span class="glyphicon glyphicon-globe"></span>M4MOBILES</h1>
            <br />
         
            <strong>Email : </strong> m4mobiles@gmail.com
            <br />
            <strong>Call : </strong> +91 9846629307
          
          </div>
          <div class="col-lg-5 col-md-5 col-sm-5">

            

          </div>
        </div>
        <hr />
        <div class="row">
          <div class="col-lg-7 col-md-7 col-sm-7">
          
            <h3>BILLING ADDRESS : </h3>
         <%--  <c:forEach var="s" items="${su}"> --%>
            <h5>Mob no:${su.mobno}</h5>
            <h5>Email:${su.email}</h5>
            <h5>Address:${su.address}</h5>
           <%--  </c:forEach> --%>
            <br /> 
          </div>
         
          <div class="col-lg-5 col-md-5 col-sm-5">
            <h3>SHIPPING ADDRESS:</h3> 
            <%-- <c:forEach var="s" items="${su}"> --%>
            <h5>Mob no:${su.mobno}</h5>
            <h5>Email:${su.email}</h5>
            <h5>Address:${su.address}</h5>
            <%-- </c:forEach> --%>
          </div>
        </div>
        <hr />
        <div class="row">
          <div class="col-lg-6 col-md-6 col-sm-6">
            <strong>ITEM DESCRIPTION & DETAILS :</strong>
          </div>
        </div>
        <hr />
        <div class="row">
          <div class="col-lg-12 col-md-12 col-sm-12">
            <div class="table-responsive">
              <table class="table table-striped table-bordered">
                <thead>
                  <tr>
                    <th>Product</th>
                    <th>Product Name</th>
                    <th>Price</th>
                    <th>Quantity</th>
                    <th>Sub Total</th>
                  </tr>
                </thead>
                <tbody>
                <c:forEach var="c" items="${ca}">
                  <tr>
                    <td><img src="${pageContext.request.contextPath}/resources/proimages/${c.product.img}" alt="..." class="img-responsive" width="80px" height="50px"/></td>
                    <td>${c.product.name}</td>
                    <td>&#8377;${c.price}</td>
                    <td>${c.quantity}</td>
                    <td>&#8377;${c.price * c.quantity}</td>
                  </tr>
                  </c:forEach>
                  
                </tbody>
              </table>
            </div>
            <hr>
            <div>
              <h4>  Total :&#8377;${t} </h4>
            </div>
            <hr>
            <div>
              
            </div>
            <hr>
            <div>
              <h3>  Bill Amount :&#8377;${t}  </h3>
            </div>
            <hr />
          </div>
        </div>
        <div class="row">
          <div class="col-lg-12 col-md-12 col-sm-12">
            <strong> Important: </strong>
            <ol>
              <li>
                After confirmation cash refundable not possible.

              </li>
              <li>
                Check the items before confirm.
              </li>
              <li>
                Select the mode of payment.
              </li>
            </ol>
          </div>
        </div>
        <hr />
        <div class="row">
          <div class="col-lg-12 col-md-12 col-sm-12">
            <a href="pay" class="btn btn-success btn-sm">Confirm Order</a>    
            <button onclick="myFunction()" class="btn btn-info btn-sm">Download Receipt</button>
          </div>
        </div>
        
        <hr>
        <div class="row">

</div>
      </div>
    </div>
</div>


</body>
</html>