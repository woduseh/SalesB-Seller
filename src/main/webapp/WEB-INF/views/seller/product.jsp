<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>seller Product</title>

</head>



<body>
  <!-- Page Content -->
  <div class="container">
  <div class="search container">
  <!-- method to post -->

		<form:form method="get" modelAttribute="SellerStoreListForm">
			<div class="form-inline">
			<form:label path="productModel">
	          <spring:message code="label.tr.sellerproduct.model" />
			</form:label>
			<form:select path="productModel" items="${CL_MODEL}"></form:select>

			<form:label path="productBodyStyle">
	          <spring:message code="label.tr.sellerproduct.bodystyle" />
	        </form:label>
	        <form:select path="productBodyStyle" items="${CL_BODY_STYLE}"></form:select>

			<form:label path="productColor">
	          <spring:message code="label.tr.sellerproduct.color" />
			</form:label>
			<form:select path="productColor" items="${CL_COLOR}"></form:select>

          	<form:input path="productPrice" align="left" cssClass="text" />
          	<form:input type="hidden" path="productMake" align="left" cssClass="text" />
          	<form:input type="hidden" path="productMileage" cssClass="text" />
          	<form:input type="hidden" path="productEngine" cssClass="text" />
          	<form:input type="hidden" path="productFuel" cssClass="text" />
          	<form:input type="hidden" path="productTransmission" cssClass="text" />

			<button id="searchBtn" class="btn btn-primary">
				<spring:message code="label.tr.common.search" />
			</button>
			</div>
		</form:form>
	</div>

    <!-- Heading Row -->
    <div class="row align-items-center my-5">
      <div class="row"> <!-- style="max-height:500px; overflow-y:scroll; padding-right:15px; display:flex" -->
		    <p class="notice">
		      <spring:message code="label.tr.sellerproduct.resultCountMessage"
		        arguments="${page.totalElements}" />
		    </p>
		    <table>
<%-- 		      <caption>
		        <spring:message code="label.tr.searchtour.searchTourResultMessage" />
		      </caption> --%>
		      <thead>
		        <tr>
		        <th><spring:message code="label.tr.common.index" /></th>
		        <th>car image</th>
				<th><spring:message code="label.tr.sellerproduct.model" /></th>
				<th><spring:message code="label.tr.sellerproduct.bodystyle" /></th>
				<th><spring:message code="label.tr.sellerproduct.year" /></th>
				<th><spring:message code="label.tr.sellerproduct.month" /></th>
				<th><spring:message code="label.tr.sellerproduct.price" /></th>
				<th><spring:message code="label.tr.sellerproduct.make" /></th>
				<th><spring:message code="label.tr.sellerproduct.mileage" /></th>
				<th><spring:message code="label.tr.sellerproduct.engine" /></th>
				<th><spring:message code="label.tr.sellerproduct.fuel" /></th>
				<th><spring:message code="label.tr.sellerproduct.transmission" /></th>
				<th><spring:message code="label.tr.sellerproduct.color" /></th>
				<th><spring:message code="label.tr.sellerproduct.code" /></th>
				<th><spring:message code="label.tr.sellerproduct.detail" /></th>
		        </tr>
		      </thead>
		      <tbody>
		      <c:forEach var="SellerProduct" items="${page.content}" varStatus="rowStatus">
		        <tr>
				  <%-- <form:form method="get"
                        action="${pageContext.request.contextPath}/sellerProduct/${f:h(SellerProduct.productCode)}/cancel">
                        <button id="deleteBtn">
                          <spring:message
                            code="label.tr.menu.delete" />
                        </button>
                  </form:form> --%>
                  <td>${(page.number * page.size) + rowStatus.index + 1}</td>
                   <!--  <img src="http://133.130.99.248/webdav/1.jpg" height=500px width=500px> -->
                  <td><img src="${f:h(SellerProduct.productImageUrl)}" height=50px width=50px></td>
		          <td>
		          <c:choose>
			          <c:when test="${f:h(SellerProduct.productModel)=='0'}">
			          	<spring:message code="label.tr.sellerproduct.model.0" />
			          </c:when>
			          <c:when test="${f:h(SellerProduct.productModel)=='1'}">
			          	<spring:message code="label.tr.sellerproduct.model.1" />
			          </c:when>
			          <c:when test="${f:h(SellerProduct.productModel)=='2'}">
			          	<spring:message code="label.tr.sellerproduct.model.2" />
			          </c:when>
			          <c:when test="${f:h(SellerProduct.productModel)=='3'}">
			          	<spring:message code="label.tr.sellerproduct.model.3" />
			          </c:when>
			          <c:when test="${f:h(SellerProduct.productModel)=='4'}">
			          	<spring:message code="label.tr.sellerproduct.model.4" />
			          </c:when>
			          <c:when test="${f:h(SellerProduct.productModel)=='5'}">
			          	<spring:message code="label.tr.sellerproduct.model.5" />
			          </c:when>
			          <c:when test="${f:h(SellerProduct.productModel)=='6'}">
			          	<spring:message code="label.tr.sellerproduct.model.6" />
			          </c:when>
			          <c:otherwise>${f:h(SellerProduct.productModel)}</c:otherwise>
		       	  </c:choose>
		          </td>
		          <td>
		           <c:choose>
			          <c:when test="${f:h(SellerProduct.productBodyStyle)=='0'}">
			          	<spring:message code="label.tr.sellerproduct.bodystyle.0" />
			          </c:when>
			          <c:when test="${f:h(SellerProduct.productBodyStyle)=='1'}">
			          	<spring:message code="label.tr.sellerproduct.bodystyle.1" />
			          </c:when>
			          <c:otherwise>${f:h(SellerProduct.productBodyStyle)}</c:otherwise>
		       	  </c:choose>
		          </td>
	           	  <td>${f:h(SellerProduct.productYear)}</td>
       	  		  <td>${f:h(SellerProduct.productMonth)}</td>
	           	  <td>${f:h(SellerProduct.productPrice)}</td>
	           	  <td>${f:h(SellerProduct.productMake)}</td>
	           	  <td>${f:h(SellerProduct.productMileage)}</td>
    	  	      <td>${f:h(SellerProduct.productEngine)}</td>
	           	  <td>${f:h(SellerProduct.productFuel)}</td>
	           	  <td>${f:h(SellerProduct.productTransmission)}</td>
	           	  <td>
		           	  <c:choose>
				          <c:when test="${f:h(SellerProduct.productColor)=='0'}">
				          	<spring:message code="label.tr.sellerproduct.color.0" />
				          </c:when>
				          <c:when test="${f:h(SellerProduct.productColor)=='1'}">
				          	<spring:message code="label.tr.sellerproduct.color.1" />
				          </c:when>
				          <c:when test="${f:h(SellerProduct.productColor)=='2'}">
				          	<spring:message code="label.tr.sellerproduct.color.2" />
				          </c:when>
				          <c:when test="${f:h(SellerProduct.productColor)=='3'}">
				          	<spring:message code="label.tr.sellerproduct.color.3" />
				          </c:when>
				          <c:otherwise>${f:h(SellerProduct.productColor)}</c:otherwise>
			       	  </c:choose>
	           	  </td>
	           	  <td>
	           	  	${f:h(SellerProduct.productCode)}
	           	  </td>
	           	 <%--  <td>${f:h(SellerProduct.productCode)}</td> --%>
	  		      <td>
	  		      <form:form method="get"
                    action="${pageContext.request.contextPath}/sellerProductList/${f:h(SellerProduct.productCode)}"
                    style="margin:0px !important">
                    <%-- <button id="showBtn${rowStatus.index}" > --%>
                    <button id="showBtn" >
                      <spring:message code="label.tr.managereservation.showDetailsBtnMessage" />
                    </button>
                  </form:form>
	              </td>
		        </tr>
		      </c:forEach>
		      </tbody>
		    </table>
		    <div class="pagination">
	           	  	<t:pagination page="${page}" criteriaQuery="${f:query(SellerProduct)}" />
           	 </div>
      </div>
    </div>
    <!-- /.row -->


  </div>
  <!-- /.container -->

  <form:form method="get" action="${pageContext.request.contextPath}/sellerProduct/create">
    <button id="customerRegisterBtn" name="form">
      <spring:message code="label.tr.menu.sellerProductCreateBtnMessage" />
    </button>
  </form:form>
</body>

</html>

