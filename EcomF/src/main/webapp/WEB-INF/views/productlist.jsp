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
.glyphicon { margin-right:5px; }
.thumbnail
{
    margin-bottom: 20px;
    padding: 0px;
    -webkit-border-radius: 0px;
    -moz-border-radius: 0px;
    border-radius: 0px;
}

.item.list-group-item
{
    float: none;
    width: 100%;
    background-color: #fff;
    margin-bottom: 10px;
}
.item.list-group-item:nth-of-type(odd):hover,.item.list-group-item:hover
{
    background: #428bca;
}

.item.list-group-item .list-group-image
{
    margin-right: 10px;
}
.item.list-group-item .thumbnail
{
    margin-bottom: 0px;
}
.item.list-group-item .caption
{
    padding: 9px 9px 0px 9px;
}
.item.list-group-item:nth-of-type(odd)
{
    background: #eeeeee;
}

.item.list-group-item:before, .item.list-group-item:after
{
    display: table;
    content: " ";
}

.item.list-group-item img
{
    float: left;
}
.item.list-group-item:after
{
    clear: both;
}
.list-group-item-text
{
    margin: 0 0 11px;
}

</style>
</head>
<body>
<jsp:include page="header.jsp"/>

<div class="container">
    <div id="products" class="row list-group">
    <c:forEach items="${pros}" var="designate"  varStatus="loop">
<a href="${designate.id}">
        <div class="item  col-xs-4 col-lg-4">
            <div class="thumbnail">
              <img class="group list-group-image" src="${pageContext.request.contextPath}/resources/proimages/${designate.img}" style="width:170px;height:180px; alt="" />
                <div class="caption">
                   <h4 class="group inner list-group-item-heading">
                        ${designate.name}</h4>
                   <p class="group inner list-group-item-text">
                       ${designate.shortDescrption}</p>
                    <div class="row">
                        <div class="col-xs-12 col-md-6">
                           <p class="lead">
                                ${designate.price}</p>
                        </div>
                        <div class="col-xs-12 col-md-6">
                            <a class="btn btn-success" href="#">Add to cart</a>
                            <a class="btn btn-success" href="#">Buy now</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
         </a>
    </c:forEach>
    
    </div>
</div>

<jsp:include page="footer.jsp"/>
</body>
</html>