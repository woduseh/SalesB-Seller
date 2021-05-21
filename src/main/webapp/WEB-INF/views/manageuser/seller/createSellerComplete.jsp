<div class="container">
  <div class="success"><br><br><br>
    <p>
      <spring:message code="label.tr.manageseller.createCompleteMessage"
        arguments="${f:h(seller.sellerCode)}" />
    </p>
  </div>
  <form:form method="get" action="${pageContext.request.contextPath}/">
    <button id="goToMenuBtn">
      <spring:message code="label.tr.common.gotoMenuMessage" />
    </button>
  </form:form>
</div>
