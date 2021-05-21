<%-- <div class="header">
  <h1>
    <a id="goToTopLink" href="${pageContext.request.contextPath}/"><spring:message
        code="title.common" /></a>
  </h1>
</div>
<hr> --%>

  <!-- Navigation -->
  <c:forEach items= "${sellerCode}" var="sellerCode"></c:forEach>
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
      <a class="navbar-brand" href="${pageContext.request.contextPath}/${sellerCode}">SalesB</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="true" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
        <span class="navbar-toggler-icon"></span>
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
	        <sec:authorize access="hasRole('SELLER')">
	          <li class="nav-item active">
	            <a class="nav-link" href="${pageContext.request.contextPath}/${sellerCode}">Home
	              <span class="sr-only">(current)</span>
	            </a>
	          </li>
	        </sec:authorize>
	        <sec:authorize access="!hasRole('SELLER')">
	          <li class="nav-item active">
	            <a class="nav-link" href="${pageContext.request.contextPath}/${sellerCode}">Home
	              <span class="sr-only">(current)</span>
	            </a>
	          </li>
            </sec:authorize>
            <sec:authorize access="!hasRole('SELLER')">
	          <li class="nav-item">
	            <a class="nav-link" href="${pageContext.request.contextPath}/login">Login</a>
	          </li>
            </sec:authorize>
        </ul>
      </div>
    </div>
  </nav>