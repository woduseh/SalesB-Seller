<div class="container">
  <div class="success"><br><br><br>
    <p>
      <spring:message code="lable_tr_request_complete" />
    </p>
  </div>
  <form:form method="get" action="${pageContext.request.contextPath}/">
    <button id="goToMenuBtn">
      <spring:message code="label.tr.common.gotoMenuMessage" />
    </button>
  </form:form>
</div>
