
<table id="productTable">
<tr>
    <td><spring:message code="label.tr.sellerproduct.code" /><td>${f:h(sellerProductListForm.productCode)}</td></td>
</tr>
  <tr>
    <td><spring:message code="label.tr.common.productModel" /></td>
    <td>
	    <c:choose>
	      <c:when test="${f:h(sellerProductListForm.productModel)=='0'}">
	      	<spring:message code="label.tr.sellerproduct.model.0" />
	      </c:when>
	      <c:when test="${f:h(sellerProductListForm.productModel)=='1'}">
	      	<spring:message code="label.tr.sellerproduct.model.1" />
	      </c:when>
	      <c:when test="${f:h(sellerProductListForm.productModel)=='2'}">
	      	<spring:message code="label.tr.sellerproduct.model.2" />
	      </c:when>
	      <c:when test="${f:h(sellerProductListForm.productModel)=='3'}">
	      	<spring:message code="label.tr.sellerproduct.model.3" />
	      </c:when>
	      <c:when test="${f:h(sellerProductListForm.productModel)=='4'}">
	      	<spring:message code="label.tr.sellerproduct.model.4" />
	      </c:when>
	      <c:when test="${f:h(sellerProductListForm.productModel)=='5'}">
	      	<spring:message code="label.tr.sellerproduct.model.5" />
	      </c:when>
	      <c:when test="${f:h(sellerProductListForm.productModel)=='6'}">
	      	<spring:message code="label.tr.sellerproduct.model.6" />
	      </c:when>
	      <c:otherwise>${f:h(sellerProductListForm.productModel)}</c:otherwise>
	  	</c:choose>
    </td>
  </tr>
  <tr>
    <td><spring:message code="label.tr.common.productBodyStyle" /></td>
    <td>
	    <c:choose>
	      <c:when test="${f:h(sellerProductListForm.productBodyStyle)=='0'}">
	      	<spring:message code="label.tr.sellerproduct.bodystyle.0" />
	      </c:when>
	      <c:when test="${f:h(sellerProductListForm.productBodyStyle)=='1'}">
	      	<spring:message code="label.tr.sellerproduct.bodystyle.1" />
	      </c:when>
	      <c:otherwise>${f:h(sellerProductListForm.productBodyStyle)}</c:otherwise>
	  	</c:choose>
    </td>
  </tr>
  <tr>
    <td><spring:message code="label.tr.common.productYear" /></td>
    <td>${f:h(sellerProductListForm.productYear)}</td>
  </tr>
  <tr>
    <td><spring:message code="label.tr.common.productMonth" /></td>
    <td>${f:h(sellerProductListForm.productMonth)}</td>
  </tr>
  <tr>
    <td><spring:message code="label.tr.common.productPrice" /></td>
    <td>${f:h(sellerProductListForm.productPrice)}</td>
  </tr>
  <tr>
    <td><spring:message code="label.tr.common.productMake" /></td>
    <td>${f:h(sellerProductListForm.productMake)}</td>
  </tr>
  <tr>
    <td><spring:message code="label.tr.common.productMileage" /></td>
    <td>${f:h(sellerProductListForm.productMileage)}</td>
  </tr>
  <tr>
    <td><spring:message code="label.tr.common.productEngine" /></td>
    <td>${f:h(sellerProductListForm.productEngine)}</td>
  </tr>
  <tr>
    <td><spring:message code="label.tr.common.productFuel" /></td>
    <td>${f:h(sellerProductListForm.productFuel)}</td>
  </tr>
  <tr>
    <td><spring:message code="label.tr.common.productTransmission" /></td>
    <td>${f:h(sellerProductListForm.productTransmission)}</td>
  </tr>
  <tr>
    <td><spring:message code="label.tr.common.productColor" /></td>
    <td>
	    <c:choose>
	      <c:when test="${f:h(sellerProductListForm.productColor)=='0'}">
	      	<spring:message code="label.tr.sellerproduct.color.0" />
	      </c:when>
	      <c:when test="${f:h(sellerProductListForm.productColor)=='1'}">
	      	<spring:message code="label.tr.sellerproduct.color.1" />
	      </c:when>
	      <c:when test="${f:h(sellerProductListForm.productColor)=='2'}">
	      	<spring:message code="label.tr.sellerproduct.color.2" />
	      </c:when>
	      <c:when test="${f:h(sellerProductListForm.productColor)=='3'}">
	      	<spring:message code="label.tr.sellerproduct.color.3" />
	      </c:when>
	      <c:otherwise>${f:h(sellerProductListForm.productColor)}</c:otherwise>
	  	</c:choose>
    </td>
  </tr>
  <tr>
    <td>product Image</td>
    <td><img src="${f:h(sellerProductListForm.productImageUrl)}" height=100px width=100px></td>
  </tr>
</table>