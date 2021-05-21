<div class="container">
  <jsp:include page="../../common/include.jsp" />
  <form:form modelAttribute="sellerForm">
    <fieldset>
      <legend>
        <spring:message code="label.tr.manageseller.managesellerMessage" />
      </legend>
      <form:errors path="*" cssClass="error" element="div" />
      <p>
        <%-- Name --%>
        <form:label path="sellerName">
          <spring:message code="label.tr.common.sellername" />
					(<spring:message code="label.tr.common.required" />)
				</form:label>
        <br>
        <form:input type="text" cssClass="text" path="sellerName" />
        <%-- &nbsp;(
        <spring:message code="label.tr.managecustomer.englishOnlyMessage" />
        ) --%>
      <p>
        <%-- EMail --%>
        <form:label path="sellerMail">
          <spring:message code="label.tr.common.email" />
        </form:label>
        <br>
        <form:input path="sellerMail" cssClass="text" />
      </p>
      <p>
        <%-- Tel --%>
        <form:label path="sellerTel">
          <spring:message code="label.tr.common.tel" />
					(<spring:message code="label.tr.common.required" />)
				</form:label>
        <br>
        <form:input path="sellerTel" cssClass="text" />
        <%-- &nbsp;(
        <spring:message code="label.tr.managecustomer.halfTelOnlyMessage" />
        )&nbsp;
        <spring:message code="label.tr.managecustomer.telExampleMessage" /> --%>
      </p>
      <p>
        <%-- Password --%>
        <form:label path="sellerPass">
          <spring:message code="label.tr.common.password" />
					(<spring:message code="label.tr.common.required" />)
				</form:label>
        <br>
        <form:password path="sellerPass" cssClass="text" />
       <%--  &nbsp;(
        <spring:message code="label.tr.managecustomer.halfPasswordOnlyMessage" />
        ) --%>
      </p>
      <p>
        <%-- Password Confirm --%>
        <form:label path="sellerPassConfirm">
          <spring:message code="label.tr.common.passwordConfirm" />
					(<spring:message code="label.tr.common.required" />)
				</form:label>
        <br>
        <form:password path="sellerPassConfirm" cssClass="text" />
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
