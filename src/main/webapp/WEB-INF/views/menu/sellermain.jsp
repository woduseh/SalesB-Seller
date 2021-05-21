<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<div class="container"><br><br><br>
	<p id="messagesArea" class="box">
	    <sec:authorize access="!hasRole('SELLER')">
	      <spring:message code="label.tr.common.notLoginMessage" />
	    </sec:authorize>
	    <sec:authorize access="hasRole('SELLER')">hello, 
				<sec:authentication property="principal.username" />
		</sec:authorize>
	</p>
	 <sec:authorize access="hasRole('SELLER')">
		<div class="col-md-4 mb-5">
			<div class="card h-100">
				<div class="card-body">
					<h2 class="card-title">Seller Main Page</h2>
				</div>
				<form:form method="get"
					action="${pageContext.request.contextPath}/${sellerCode}">
					 <button class="btn btn-primary btn-sm" name="initForm" style="width: 150px;">
		              Go
		            </button>
				</form:form>
			</div>
		</div>
	</sec:authorize>
   <sec:authorize access="hasRole('SELLER')">
	  <form:form action="${pageContext.request.contextPath}/logout" cssClass="inline">
	    <button class="btn btn-primary btn-sm" name="logout">
	      <spring:message code="label.tr.common.logout" />
	    </button>
	  </form:form>
   </sec:authorize>
</div>
