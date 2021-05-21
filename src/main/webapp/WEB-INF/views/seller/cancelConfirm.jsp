
<div class="container">
  <h2 id="screenName">
    <spring:message code="label.tr.managereservation.beforecancelScreenTitleMessage" />
  </h2>

  <div class="info">
    <spring:message code="label.tr.managereservation.beforecancelScreenFlowMessage" />
  </div>
  <p>
    <spring:message code="label.tr.managereservation.beforeCancelScreenMessage" />
  </p>
  <div class="span-24">
    <t:messagesPanel />
    <br>
    <jsp:include page="fragment/productDeleteTable.jsp" />
    <hr />
    <table>
      <caption>
        <spring:message code="label.tr.common.specialNotes" />
      </caption>
      <tr>
        <td><spring:message code="label.tr.common.opinionSuggestion" /></td>
        <td colspan="3">${f:h(sellerProductListForm.productCode)}<br />
      </tr>
    </table>
  </div>
  <div class="span-9">
    <form:form id="sellerProductCanelForm">
      <table>
        <tr>
          <td>
            <button id="backToListBtn" name="backTolist">
              <spring:message code="label.tr.sellerproduct.returnToListScreenBtnMessage" />
            </button>
          </td>
          <td>
            <button id="cancelBtn">
              <spring:message code="label.tr.sellerproduct.cancelReservationBtnMessage" />
            </button>
          </td>
        </tr>
      </table>
    </form:form>
  </div>
</div>

