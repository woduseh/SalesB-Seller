<div class="container">

  <div class="info">
    <%-- <p>
      <spring:message code="label.tr.managecustomer.createConfirmMessage" />
    </p> --%>
  </div>
  <form:form modelAttribute="sellerProductInputForm">
    <jsp:include page="fragment/productTable.jsp" />

    <!-- Include all the hidden items here.
			These will be mapped to the modelAttribute form -->

    <form:hidden path="productModel" />
    <form:hidden path="productBodyStyle" />
    <form:hidden path="productImageUrl" />
    <form:hidden path="productYear" />
    <form:hidden path="productMonth" />
    <form:hidden path="productPrice" />
    <form:hidden path="productMake" />
    <form:hidden path="productMileage" />
    <form:hidden path="productEngine" />
    <form:hidden path="productFuel" />
    <form:hidden path="productTransmission" />
    <form:hidden path="productColor" />
    <form:hidden path="productImageUrl" />

    <form:button id="backToFormBtn" name="redo">
      <spring:message code="label.tr.common.goBackMessage" />
    </form:button>
            &nbsp;
		<form:button id="registerBtn">
      <spring:message code="label.tr.common.register" />
    </form:button>
  </form:form>

</div>
