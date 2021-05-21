
<div class="container">

  <div class="info" style="margin-top:50px;">
    <p>
      <spring:message code="label.tr.manageseller.createConfirmMessage" />
    </p>
  </div>
  <form:form modelAttribute="sellerForm">
    <jsp:include page="../fragment/sellerTable.jsp" />

    <!-- Include all the hidden items here. 
			These will be mapped to the modelAttribute form -->

    <form:hidden path="sellerName" />
    <form:hidden path="sellerMail" />
    <form:hidden path="sellerTel" />
    <form:hidden path="sellerPass" />
    <form:hidden path="sellerPassConfirm" />

    <form:button id="backToFormBtn" name="redo">
      <spring:message code="label.tr.common.goBackMessage" />
    </form:button>
            &nbsp;
		<form:button id="registerBtn">
      <spring:message code="label.tr.common.register" />
    </form:button>
  </form:form>

</div>
