<style>
p{
	margin-bottom : 70px;
}
</style>
<div class="container">
  <jsp:include page="../common/include.jsp" />



  <form:form method="get" action="${pageContext.request.contextPath}/sellerProduct/upload" path="productImageUrl">
	<button id="resetBtn" class="btn btn-primary btn-sm" name="form" style="margin: 40px; padding:6px 12px">
		<p>이미지등록</p>
	</button>
  </form:form>
  <form:form   method="post"
 action="${pageContext.request.contextPath}/sellerProduct/create"
    modelAttribute="sellerProductInputForm">
    <fieldset>
<!--       <legend>
        <spring:message code="label.tr.sellerproduct.productsellerMessage" />
      </legend>
       -->
      <form:errors path="*" cssClass="error" element="div" />
      <p>
        <%-- productModel --%>
        <form:label path="productModel">
          <spring:message code="label.tr.sellerproduct.model" />
		</form:label>
        <br>
        <form:select path="productModel" items="${CL_MODEL}"></form:select>
      <p>

		<%--productImageUrl --%>


        <%-- productBodyStyle --%>
        <form:label path="productBodyStyle">
          <spring:message code="label.tr.sellerproduct.bodystyle" />
        </form:label>
        <br>
       	<form:select path="productBodyStyle" items="${CL_BODY_STYLE}"></form:select>
      </p>
      <p>
        <%-- productYear --%>
        <form:label path="productYear">
          <spring:message code="label.tr.sellerproduct.year" />
		</form:label>
        <br>
        <form:select path="productYear" items="${CL_YEAR}" />
          <spring:message code="label.tr.sellerproduct.month" />
          <form:select path="productMonth" items="${CL_MONTH}" />
      </p>
      <p>
        <%-- productPrice --%>
        <form:label path="productPrice">
          <spring:message code="label.tr.sellerproduct.price" />
          (<spring:message code="label.tr.sellerproduct.priceform" />)
		</form:label>
        <br>
        <form:input path="productPrice" cssClass="text" />
      </p>
      <p>
        <%-- productMake --%>
        <form:label path="productMake">
          <spring:message code="label.tr.sellerproduct.make" />
		</form:label>
        <br>
        <form:input path="productMake" cssClass="text" />
      </p>
      <p>
        <%-- productMileage --%>
        <form:label path="productMileage">
          <spring:message code="label.tr.sellerproduct.mileage" />
          (<spring:message code="label.tr.sellerproduct.mileageform" />)
		</form:label>
        <br>
        <form:input path="productMileage" cssClass="text" />
      </p>
      <p>
        <%-- productEngine --%>
        <form:label path="productEngine">
          <spring:message code="label.tr.sellerproduct.engine" />
           (<spring:message code="label.tr.sellerproduct.engineform" />)

		</form:label>
        <br>
        <form:input path="productEngine" cssClass="text" />
      </p>
      <p>
        <%-- productFuel --%>
        <form:label path="productFuel">
          <spring:message code="label.tr.sellerproduct.fuel" />
		</form:label>
        <br>
        <form:input path="productFuel" cssClass="text" />
      </p>
      <p>
        <%-- productTransmission --%>
        <form:label path="productTransmission">
          <spring:message code="label.tr.sellerproduct.transmission" />
		</form:label>
        <br>
        <form:input path="productTransmission" cssClass="text" />
      </p>
      <p>
        <%-- productColor --%>
        <form:label path="productColor">
          <spring:message code="label.tr.sellerproduct.color" />
		</form:label>
        <br>
        <form:select path="productColor" items="${CL_COLOR}"></form:select>
      </p>
      <p>
        <button id="confirmBtn" name="confirm">
          <spring:message code="label.tr.common.confirm" />
        </button>
        <button id="resetBtn" type="reset">
          <spring:message code="label.tr.common.reset" />
        </button>
      </p>
    </fieldset>
</form:form>




</div>
