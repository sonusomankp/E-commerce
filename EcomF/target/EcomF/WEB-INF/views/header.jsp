
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">M4MOBILES</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="">Home</a></li>
      
      <c:if test="${pageContext.request.userPrincipal.name  == 'admin123@gmail.com'}">
      
      <li class="active"><a href="Admin">Admin</a></li>
      
      </c:if> 
             <c:if test="${pageContext.request.userPrincipal.name  != 'admin123@gmail.com'}">
      
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
  
  </c:if>
           <c:if test="${pageContext.request.userPrincipal.name != null && pageContext.request.userPrincipal.name  != 'admin123@gmail.com'}">
   </c:if>
    <ul class="nav navbar-nav navbar-right">
    
    <c:if test="${pageContext.request.userPrincipal.name == null }">
    
      <li><a href="signUp"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      
      </c:if>
      
        <c:if test="${pageContext.request.userPrincipal.name == null }">
        <li><a href="in"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
            </c:if>    
      
      
       <c:if test="${pageContext.request.userPrincipal.name  != null}">
					<li><a>Welcome: ${pageContext.request.userPrincipal.name}</a></li>
		<li><a href='<c:url value="/j_spring_security_logout"/>'> Logout</a></li>
     </c:if>
    </ul>
  </div> 
</nav>
