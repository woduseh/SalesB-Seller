 <div class="container">

  <div class="info">
    <p>
      <spring:message code="label.tr.manageseller.updateConfirmMessage" />
    </p>
  </div>
  
  
  <div class="container">

  <div class="info">
    <p>
      <spring:message code="label.tr.manageseller.updateConfirmMessage" />
    </p>
  </div>
  <form:form modelAttribute="sellerProductListForm" method="post">
    <jsp:include page="fragment/productDetailTable.jsp" />

    <!-- Include all the hidden items here. 
			These will be mapped to the modelAttribute form -->

    <form:hidden path="productModel" />
    <form:hidden path="productBodyStyle" />
    <form:hidden path="productYear" />
    <form:hidden path="productMonth" />
    <form:hidden path="productPrice" />
    <form:hidden path="productMake" />
    <form:hidden path="productMileage" />
    <form:hidden path="productEngine" />
    <form:hidden path="productFuel" />
    <form:hidden path="productTransmission" />
    <form:hidden path="productColor" />
    
    </form:form>

</div>
  
  
<%--   <form:form modelAttribute="sellerProductListForm">
<table id="productTable">
<tr>
    <td><spring:message code="label.tr.sellerproduct.code" />
    <td>${f:h(output.productCode)}</td>
    </td>
</tr>
  <tr>
    <td><spring:message code="label.tr.common.productModel" /></td>
    <td>
	    <c:choose>
	      <c:when test="${f:h(sellerProduct.productModel)=='0'}">
	      	<spring:message code="label.tr.sellerproduct.model.0" />
	      </c:when>
	      <c:when test="${f:h(sellerProduct.productModel)=='1'}">
	      	<spring:message code="label.tr.sellerproduct.model.1" />
	      </c:when>
	      <c:when test="${f:h(sellerProduct.productModel)=='2'}">
	      	<spring:message code="label.tr.sellerproduct.model.2" />
	      </c:when>
	      <c:when test="${f:h(sellerProduct.productModel)=='3'}">
	      	<spring:message code="label.tr.sellerproduct.model.3" />
	      </c:when>
	      <c:when test="${f:h(sellerProduct.productModel)=='4'}">
	      	<spring:message code="label.tr.sellerproduct.model.4" />
	      </c:when>
	      <c:when test="${f:h(sellerProduct.productModel)=='5'}">
	      	<spring:message code="label.tr.sellerproduct.model.5" />
	      </c:when>
	      <c:when test="${f:h(sellerProduct.productModel)=='6'}">
	      	<spring:message code="label.tr.sellerproduct.model.6" />
	      </c:when>
	      <c:otherwise>${f:h(sellerProduct.productModel)}</c:otherwise>
	  	</c:choose>
    </td>
  </tr>
  <tr>
    <td><spring:message code="label.tr.common.productBodyStyle" /></td>
    <td>
	    <c:choose>
	      <c:when test="${f:h(output.productBodyStyle)=='0'}">
	      	<spring:message code="label.tr.sellerproduct.bodystyle.0" />
	      </c:when>
	      <c:when test="${f:h(output.productBodyStyle)=='1'}">
	      	<spring:message code="label.tr.sellerproduct.bodystyle.1" />
	      </c:when>
	      <c:otherwise>${f:h(output.productBodyStyle)}</c:otherwise>
	  	</c:choose>
    </td>
  </tr>
  <tr>
    <td><spring:message code="label.tr.common.productYear" /></td>
    <td>${f:h(output.productYear)}</td>
  </tr>
  <tr>
    <td><spring:message code="label.tr.common.productMonth" /></td>
    <td>${f:h(output.productMonth)}</td>
  </tr>
  <tr>
    <td><spring:message code="label.tr.common.productPrice" /></td>
    <td>${f:h(sellerProduct.productPrice)}</td>
  </tr>
  <tr>
    <td><spring:message code="label.tr.common.productMake" /></td>
    <td>${f:h(sellerProduct.productMake)}</td>
  </tr>
  <tr>
    <td><spring:message code="label.tr.common.productMileage" /></td>
    <td>${f:h(sellerProduct.productMileage)}</td>
  </tr>
  <tr>
    <td><spring:message code="label.tr.common.productEngine" /></td>
    <td>${f:h(sellerProduct.productEngine)}</td>
  </tr>
  <tr>
    <td><spring:message code="label.tr.common.productFuel" /></td>
    <td>${f:h(sellerProduct.productFuel)}</td>
  </tr>
  <tr>
    <td><spring:message code="label.tr.common.productTransmission" /></td>
    <td>${f:h(output.productTransmission)}</td>
  </tr>
  <tr>
    <td><spring:message code="label.tr.common.productColor" /></td>
    <td>
	    <c:choose>
	      <c:when test="${f:h(sellerProduct.productColor)=='0'}">
	      	<spring:message code="label.tr.sellerproduct.color.0" />
	      </c:when>
	      <c:when test="${f:h(sellerProduct.productColor)=='1'}">
	      	<spring:message code="label.tr.sellerproduct.color.1" />
	      </c:when>
	      <c:when test="${f:h(sellerProduct.productColor)=='2'}">
	      	<spring:message code="label.tr.sellerproduct.color.2" />
	      </c:when>
	      <c:when test="${f:h(sellerProduct.productColor)=='3'}">
	      	<spring:message code="label.tr.sellerproduct.color.3" />
	      </c:when>
	      <c:otherwise>${f:h(sellerProduct.productColor)}</c:otherwise>
	  	</c:choose>
    </td>
  </tr>
</table>
  </form:form> --%>
  
    <form:form modelAttribute="sellerProductListForm" cssClass="inline" method="post">
    <div class="span-6">
      <table>
        <tr>
          <td>
            <button id="backToFormBtn" name="redo">
              <spring:message code="label.tr.managereservation.changeReservationStaBtnMessage" />
            </button>
          </td>
          <td>
            <button id="changeBtn">
              <spring:message code="label.tr.manageseller.confirmEditBtnMessage" />
            </button>
          </td>
        </tr>
      </table>
    </div>
    </form:form>

</div>
 
 
