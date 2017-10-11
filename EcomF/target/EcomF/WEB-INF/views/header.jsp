
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">M4MOBILES</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="">Home</a></li>
      <li class="active"><a href="Admin">Admin</a></li>
      <li class="active"><a href="bas">Basket</a></li>
    
    <li class="dropdown">
    <a class="dropdown-toggle" data-toggle="dropdown" href="#">Categories
    <span class="caret"></span></a>
    <ul class="dropdown-menu">
        

					<c:forEach var="c" items="${cate}" >

                       <li><a href="categoryid?id=${c.c_id}">${c.cname}</a></li>    
                    </c:forEach>         

    </ul>
  </li>
  </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="signUp"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      <li><a href="in"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
    </ul>
  </div> 
</nav>
