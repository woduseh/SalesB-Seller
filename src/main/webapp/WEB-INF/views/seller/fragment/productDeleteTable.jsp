
<table id="productTable">
<tr>
    <td><spring:message code="label.tr.sellerproduct.code" /><td>${f:h(output.productCode)}</td></td>
</tr>
  <tr>
    <td><spring:message code="label.tr.common.productModel" /></td>
    <td>
	    <c:choose>
	      <c:when test="${f:h(output.productModel)=='0'}">
	      	<spring:message code="label.tr.sellerproduct.model.0" />
	      </c:when>
	      <c:when test="${f:h(output.productModel)=='1'}">
	      	<spring:message code="label.tr.sellerproduct.model.1" />
	      </c:when>
	      <c:when test="${f:h(output.productModel)=='2'}">
	      	<spring:message code="label.tr.sellerproduct.model.2" />
	      </c:when>
	      <c:when test="${f:h(output.productModel)=='3'}">
	      	<spring:message code="label.tr.sellerproduct.model.3" />
	      </c:when>
	      <c:when test="${f:h(output.productModel)=='4'}">
	      	<spring:message code="label.tr.sellerproduct.model.4" />
	      </c:when>
	      <c:when test="${f:h(output.productModel)=='5'}">
	      	<spring:message code="label.tr.sellerproduct.model.5" />
	      </c:when>
	      <c:when test="${f:h(output.productModel)=='6'}">
	      	<spring:message code="label.tr.sellerproduct.model.6" />
	      </c:when>
	      <c:otherwise>${f:h(output.productModel)}</c:otherwise>
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
    <td>${f:h(output.productPrice)}</td>
  </tr>
  <tr>
    <td><spring:message code="label.tr.common.productMake" /></td>
    <td>${f:h(output.productMake)}</td>
  </tr>
  <tr>
    <td><spring:message code="label.tr.common.productMileage" /></td>
    <td>${f:h(output.productMileage)}</td>
  </tr>
  <tr>
    <td><spring:message code="label.tr.common.productEngine" /></td>
    <td>${f:h(output.productEngine)}</td>
  </tr>
  <tr>
    <td><spring:message code="label.tr.common.productFuel" /></td>
    <td>${f:h(output.productFuel)}</td>
  </tr>
  <tr>
    <td><spring:message code="label.tr.common.productTransmission" /></td>
    <td>${f:h(output.productTransmission)}</td>
  </tr>
  <tr>
    <td><spring:message code="label.tr.common.productColor" /></td>
    <td>
	    <c:choose>
	      <c:when test="${f:h(output.productColor)=='0'}">
	      	<spring:message code="label.tr.sellerproduct.color.0" />
	      </c:when>
	      <c:when test="${f:h(output.productColor)=='1'}">
	      	<spring:message code="label.tr.sellerproduct.color.1" />
	      </c:when>
	      <c:when test="${f:h(output.productColor)=='2'}">
	      	<spring:message code="label.tr.sellerproduct.color.2" />
	      </c:when>
	      <c:when test="${f:h(output.productColor)=='3'}">
	      	<spring:message code="label.tr.sellerproduct.color.3" />
	      </c:when>
	      <c:otherwise>${f:h(output.productColor)}</c:otherwise>
	  	</c:choose>
    </td>
  </tr>
   <tr>
    <td>product Image</td>
    <td><img src="${f:h(output.productImageUrl)}" height=100px width=100px></td>
  </tr>
</table>