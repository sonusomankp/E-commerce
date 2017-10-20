<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
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
        <br />
        <br />
        <br />
        <br />
    </div>
	    <div class="row color-invoice">
      <div class="col-md-12">
        <div class="row">
          <div class="col-lg-7 col-md-7 col-sm-7">
            <h1>M4MOBILES</h1>
            <br />
            <strong>Email : </strong> M4MOBILES@GMAIL.COM
            <br />
            <strong>Call : </strong> 9846629307
          </div>
          <div class="col-lg-5 col-md-5 col-sm-5">

            

          </div>
        </div>
        <hr />
        <div class="row">
          <div class="col-lg-7 col-md-7 col-sm-7">
            <h3>BILLING ADDRESS : </h3>
            <h5></h5>
            <h5></h5>
            <h5></h5>
            <br /> United States
          </div>
          <div class="col-lg-5 col-md-5 col-sm-5">
            <h3>Client Contact :</h3> Mob: +1-99-88-77-55
            <br> email: info@domainname.com
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
                    <th>S. No.</th>
                    <th>Perticulars</th>
                    <th>Quantity.</th>
                    <th>Unit Price</th>
                    <th>Sub Total</th>
                  </tr>
                </thead>
                <tbody>
                  <tr>
                    <td>1</td>
                    <td>Website Design</td>
                    <td>1</td>
                    <td>5000 USD</td>
                    <td>5000 USD</td>
                  </tr>
                  <tr>
                    <td>2</td>
                    <td>Website Development</td>
                    <td>2</td>
                    <td>5000 USD</td>
                    <td>10000 USD</td>
                  </tr>
                  <tr>
                    <td>3</td>
                    <td>Customization</td>
                    <td>1</td>
                    <td>4000 USD</td>
                    <td>4000 USD</td>
                  </tr>
                  <tr>
                    <td>4</td>
                    <td>Plugin Setup</td>
                    <td>1</td>
                    <td>3000 USD</td>
                    <td>3000 USD</td>
                  </tr>
                </tbody>
              </table>
            </div>
            <hr>
            <div>
              <h4>  Total : 22000 USD </h4>
            </div>
            <hr>
            <div>
              <h4>  Taxes : 4400 USD ( 20 % on Total Bill ) </h4>
            </div>
            <hr>
            <div>
              <h3>  Bill Amount : 26400 USD </h3>
            </div>
            <hr />
          </div>
        </div>
        <div class="row">
          <div class="col-lg-12 col-md-12 col-sm-12">
            <strong> Important: </strong>
            <ol>
              <li>
                Lorem ipsum dolor sit amet, consectetur adipiscing elit.

              </li>
              <li>
                Nulla eros eros, laoreet non pretium sit amet, efficitur eu magna.
              </li>
              <li>
                Curabitur efficitur vitae massa quis molestie. Ut quis porttitor justo, sed euismod tortor.
              </li>
            </ol>
          </div>
        </div>
        <hr />
        <div class="row">
          <div class="col-lg-12 col-md-12 col-sm-12">
            <a href="#" class="btn btn-success btn-sm">Print Invoice</a>    
            <a href="#" class="btn btn-info btn-sm">Download In Pdf</a>
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