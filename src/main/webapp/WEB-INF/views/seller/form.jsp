<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>salesB</title>

</head>

<body style="margin-top:100px">
	<!-- Page Content -->
	<div class="container py-10 bg-light" >

	<sec:authorize access="!hasRole('SELLER')">
	<div class="row align-items-center my-5">
		<div class="col-lg-5">
			<a class="btn btn-primary" href="${pageContext.request.contextPath}/login">seller Login Page</a>
		</div>
	</div>
	</sec:authorize>
	<div class="row">
		<sec:authorize access="!hasRole('SELLER')">
			<div class="col-md-4 mb-5">
				<div class="card h-100">
					<div class="card-body">
						<h2 class="card-title">Seller Register</h2>
						<p class="card-text">Seller Register page</p>
					</div>
					<form:form method="get"
						action="${pageContext.request.contextPath}/sellers/create">
						<fieldset class="notice">
							<div class="card-footer">
								<button class="btn btn-primary btn-sm" name="form" style="margin: 40px; padding:6px 12px">
									<spring:message code="label.tr.menu.sellerRegisterBtnMessage" />
								</button>
							</div>
						</fieldset>
					</form:form>
				</div>
			</div>
			</sec:authorize>
			<sec:authorize access="hasRole('SELLER')">
			<div class="col-md-4 mb-5">
				<div class="card h-100">
					<div class="card-body">
						<h2 class="card-title">Seller Product List</h2>
						<p class="card-text">List View</p>
					</div>
					<div class="card-footer">
						<a href="${pageContext.request.contextPath}/sellerProductList"
							class="btn btn-primary btn-sm">View</a>
					</div>
				</div>
			</div>
			</sec:authorize>
			<sec:authorize access="hasRole('SELLER')">
			<div class="col-md-4 mb-5">
				<div class="card h-100">
					<div class="card-body">
						<h2 class="card-title">Seller Product Create</h2>
						<p class="card-text">List Create</p>
					</div>
					<div class="card-footer">
						<form:form method="get"
							action="${pageContext.request.contextPath}/sellerProduct/create">
							<fieldset class="notice">
								<div class="card-footer">
									<button class="btn btn-primary btn-sm" name="form" style="margin: 40px; padding:6px 12px">
										<spring:message
											code="label.tr.menu.sellerProductCreateBtnMessage" />
									</button>
								</div>
							</fieldset>
						</form:form>
					</div>
				</div>
			</div>
			</sec:authorize>
			<sec:authorize access="hasRole('SELLER')">
			<div class="col-md-4 mb-5">
				<div class="card h-100">
					<div class="card-body">
						<h2 class="card-title">Request To Seller</h2>
						<p class="card-text">List view</p>
					</div>
					<div class="card-footer">
						<a href="${pageContext.request.contextPath}/requestToSellerList"
							class="btn btn-primary brn-sm">View</a>
					</div>
				</div>
			</div>
			</sec:authorize>

			<!-- /.col-md-4 -->
			<sec:authorize access="hasRole('SELLER')">
			<div class="col-md-4 mb-5">
				<div class="card h-100">
					<div class="card-body">
						<h2 class="card-title">Send Request to Admin</h2>
					</div>
					<div class="card-footer">
					<form:form method="get"
						action="${pageContext.request.contextPath}/requestToAdmin/create">
						<button class="btn btn-primary btn-sm" name="form" style="margin: 40px; padding:6px 12px">
							<spring:message
								code="lable_tr_request_notice" />
						</button>
					</form:form>
					</div>
				</div>
			</div>
			</sec:authorize>
	
			<!-- /.col-md-4 -->
			<sec:authorize access="hasRole('SELLER')">
			<div class="col-md-4 mb-5">
				<div class="card h-100">
					<div class="card-body">
						<h2 class="card-title">Customer Request</h2>
					</div>
					<div class="card-footer">
					<form:form method="get"
						action="${pageContext.request.contextPath}/customerRequest">
						<button class="btn btn-primary btn-sm" name="form" style="margin: 40px; padding:6px 12px">
							View
						</button>
					</form:form>
					</div>
				</div>
			</div>
			</sec:authorize>
		</div>
		<!-- /.col-md-4 -->
			<sec:authorize access="hasRole('SELLER')">
			<div class="col-md-4 mb-5">
				<div class="card h-100">
					<div class="card-body">
						<h2 class="card-title">Seller Setting</h2>
					</div>
					<div class="card-footer">
					<form:form method="get"
							action="${pageContext.request.contextPath}/Setting/${sellerCode}/">
							<fieldset class="notice">
								<div class="card-footer">
									<button class="btn btn-primary btn-sm" name="form" style="margin: 40px; padding:6px 12px">
										<%-- <spring:message
											code="label.tr.menu.sellerProductCreateBtnMessage" /> --%>Setting
									</button>
								</div>
							</fieldset>
						</form:form>
						<%-- <form:form method="get" action="${pageContext.request.contextPath}/Setting/${sellerCode}/">
						 <button class="btn btn-primary btn-sm" name="initForm" style="width: 150px;">
			              Go
			            </button>
					</form:form> --%>
					</div>
				</div>
			</div>
			</sec:authorize>
	</div>
	<sec:authorize access="hasRole('SELLER')">
		<form:form action="${pageContext.request.contextPath}/logout"
			cssClass="inline">
			<button  class="btn btn-primary btn-sm" name="logout">
				<spring:message code="label.tr.common.logout" />
			</button>
		</form:form>
	</sec:authorize>
</body>

</html>
