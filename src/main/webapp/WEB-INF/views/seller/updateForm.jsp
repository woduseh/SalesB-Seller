
<div class="container">
  <h2 id="screenName">
    <spring:message code="label.tr.managereservation.manageReservationEditScreenTitle" />
  </h2>

  <!-- end title -->

  <!-- begin main -->
  <div class="info">
    <spring:message code="label.tr.manageseller.updateFormMessage" />
  </div>
  <!-- begin message -->
<%--   <spring:message code="label.tr.managereservation.manageReservationEditMessage" /> --%>
  <!-- end message -->
  <form:form method="post"
    action="${pageContext.request.contextPath}/sellerProductList/${f:h(sellerProductListForm.productCode)}/update"
    modelAttribute="sellerProductListForm">
<%--     <table>
      <caption>
        <spring:message code="label.tr.searchtour.tourDetailCaptionMessage" />
      </caption>
      <spring:message code="label.tr.common.datePattern" var="datePattern" />
      <tr>
        <th><spring:message code="label.tr.sellerproduct.code" /></th>
        <td>${f:h(output.productCode)}</td>
        <th><spring:message code="label.tr.sellerproduct.model" /></th>
        <td>${f:h(output.productModel)}</td>
      </tr>
      <tr>
        <th><spring:message code="label.tr.sellerproduct.year" /></th>
        <td><form:select path="productYear" items="${CL_YEAR}">${f:h(output.productYear)}</form:select></td>
        <th><spring:message code="label.tr.sellerproduct.month" /></th>
        <td>${f:h(sellerProduct.productMonth)}</td>
      </tr>
      <tr>
        <th><spring:message code="label.tr.sellerproduct.price" /></th>
        <td>${f:h(sellerProduct.productPrice)}</td>
        <th><spring:message code="label.tr.sellerproduct.make" /></th>
        <td>${f:h(sellerProduct.productMake)}</td>
        <form:input path="productMake" cssClass="text" />
      </tr>
      <tr>
        <th><spring:message code="label.tr.sellerproduct.mileage" /></th>
        <td>${f:h(sellerProduct.productMileage)}</td>
        <th><spring:message code="label.tr.sellerproduct.engine" /></th>
        <td>${f:h(sellerProduct.productEngine)}</td>
      </tr>
      <tr>
        <th><spring:message code="label.tr.sellerproduct.fuel" /></th>
        <td>${f:h(sellerProduct.productFuel)}</td>
        <th><spring:message code="label.tr.sellerproduct.transmission" /></th>
        <td>${f:h(sellerProduct.productTransmission)}</td>
      </tr>
      <tr>
        <th><spring:message code="label.tr.sellerproduct.color" /></th>
        <td>${f:h(sellerProduct.productColor)}</td>
        <th><spring:message code="label.tr.sellerproduct.code" /></th>
        <td>${f:h(sellerProduct.productCode)}</td>
      </tr>
    </table> --%>
    <fieldset>
      <legend>
        <spring:message code="label.tr.sellerproduct.productsellerUpdateMessage" />
      </legend>
      <form:errors path="*" cssClass="error" element="div" />
      <p>
        <form:label path="productModel">
          <spring:message code="label.tr.sellerproduct.model" />
		</form:label>
        <br>
        <form:select path="productModel" items="${CL_MODEL}" value="${sellerProductListForm.productModel}"></form:select>
      <p>
        <form:label path="productBodyStyle">
          <spring:message code="label.tr.sellerproduct.bodystyle" />
        </form:label>
        <br>
       	<form:select path="productBodyStyle" items="${CL_BODY_STYLE}" value="${sellerProductListForm.productBodyStyle}"></form:select>
      </p>
      <p>
        <form:label path="productYear">
          <spring:message code="label.tr.sellerproduct.year" />					
		</form:label>
        <br>
        <form:select path="productYear" items="${CL_YEAR}" value="${sellerProductListForm.productYear}"/>
          <spring:message code="label.tr.sellerproduct.month" />
          <form:select path="productMonth" items="${CL_MONTH}" value="${sellerProductListForm.productMonth}" />
      </p>
      <p>
        <form:label path="productPrice">
          <spring:message code="label.tr.sellerproduct.price" />
          (<spring:message code="label.tr.sellerproduct.priceform" />)
		</form:label>
        <br>
        <form:input path="productPrice" value="${sellerProductListForm.productPrice}" />
      </p>
      <p>
        <form:label path="productMake">
          <spring:message code="label.tr.sellerproduct.make"/>
		</form:label>
        <br>
        <form:input path="productMake" cssClass="text" value="${sellerProductListForm.productMake}"/>
      </p>
      <p>
        <form:label path="productMileage">
          <spring:message code="label.tr.sellerproduct.mileage" />
          (<spring:message code="label.tr.sellerproduct.mileageform" />)
		</form:label>
        <br>
        <form:input path="productMileage" cssClass="text" value="${sellerProductListForm.productMileage}" />
      </p>
      <p>
        <form:label path="productEngine">
          <spring:message code="label.tr.sellerproduct.engine" />
           (<spring:message code="label.tr.sellerproduct.engineform" />)
          
		</form:label>
        <br>
        <form:input path="productEngine" cssClass="text" value="${sellerProductListForm.productEngine}" />
      </p>
      <p>
        <form:label path="productFuel">
          <spring:message code="label.tr.sellerproduct.fuel" />
		</form:label>
        <br>
        <form:input path="productFuel" cssClass="text" value="${sellerProductListForm.productFuel}"/>
      </p>
      <p>
        <form:label path="productTransmission">
          <spring:message code="label.tr.sellerproduct.transmission" />
		</form:label>
        <br>
        <form:input path="productTransmission" cssClass="text" value="${sellerProductListForm.productTransmission}" />
      </p>
      <p>
        <form:label path="productColor">
          <spring:message code="label.tr.sellerproduct.color" />
		</form:label>
        <br>
        <form:select path="productColor" items="${CL_COLOR}" value="${sellerProductListForm.productColor}"></form:select>
      </p>
    </fieldset>

    <!-- tour-info end -->
    <br />
    <br />
    <!-- note start -->
<%--     <table>
      <caption>
        <spring:message code="label.tr.common.specialNotes" />
      </caption>
      <tr>
        <td><spring:message code="label.tr.common.opinionSuggestion" /></td>
        <td colspan="3">${f:h(product.productCode)}<br />
      </tr>
    </table> --%>
    <br />
    <!-- note end -->

    <!-- begin buttons -->
    <div class="span-9">
      <table>
        <tr>
          <td>
            <div class="button">
              <button id="backToListBtn" name="backTolist">
                <spring:message code="label.tr.manageseller.returnToListScreenBtnMessage" />
              </button>
            </div>
          </td>
          <td>
            <div class="button">
              <button id="confirmBtn" name="confirm">
                <spring:message code="label.tr.manageseller.confirmEditBtnMessage" />
              </button>
            </div>
          </td>
        </tr>
      </table>
    </div>
    <!-- end buttons -->
  </form:form>
</div>
