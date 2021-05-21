
<div class="container">
  <jsp:include page="../common/top.jsp" />
  <div>
    <div>
      <div>
        <div>
          <h1 id="screenName">
            <span><spring:message
                code="label.tr.managereservation.manageReservationShowScreenTitleMessage" /></span>
          </h1>
        </div>
      </div>
    </div>
    <div>
      <%-- <div class="info">
        <spring:message code="label.tr.managereservation.manageReservationShowScreenFlowMessage" />
      </div> --%>
      <br />
      <P>
        <spring:message code="label.tr.managereservation.manageReservationShowMessage" />
      </P>
<%--       <br />
      <spring:message code="label.tr.common.pdfdownloadMessage" />
      <br /> --%>
      <div>
        <%-- <form:form method="get"
          action="${pageContext.request.contextPath}/reservations/${output.reserve.reserveNo}/pdf">
          <button id="downloadBtn">
            <spring:message code="label.tr.common.downloadpdfBtnMessage" />
          </button>
        </form:form> --%>
      </div>
        <jsp:include page="fragment/productDeleteTable.jsp" />
        <br />
        <hr />
      <table>
        <caption>
          <spring:message code="label.tr.common.specialNotes" />
        </caption>
        <tr>
          <td><spring:message code="label.tr.common.opinionSuggestion" /></td>
<%--           <td>${f:h(output.productCode)} </td> --%>
        </tr>
      </table>
      <!-- comment end -->
      <br /> <br />
      <div class="span-12">
        <table>
          <tr>
            <td><form:form method="get"
                action="${pageContext.request.contextPath}/sellerProductList" style="margin:0 !important">
                <button id="backToListBtn" name="backTolist">
                  <spring:message code="label.tr.manageseller.returnToListScreenBtnMessage" />
                </button>
              </form:form></td>
 <%--            <c:if test="${!output.limitExceeding}">
              <c:if test="${output.reserve.transfer == 0}"> --%>
                <td><form:form method="get"
                    action="${pageContext.request.contextPath}/sellerProductList/${f:h(output.productCode)}/update" style="margin:0 !important">
                    <button id="changeBtn${rowStatus.index}" name="form">
                      <spring:message code="label.tr.manageseller.change" />
                    </button>
                  </form:form></td>
                <td>
                
                <form:form method="get"
                        action="${pageContext.request.contextPath}/sellerProductList/${f:h(output.productCode)}/cancel" style="margin:0 !important">
                        <button id="cancelBtn${rowStatus.index}">
                          <spring:message
                            code="label.tr.sellerproduct.delete" />
                        </button>
                	</form:form>
                
          <%--       <form:form method="get"
                    action="${pageContext.request.contextPath}/sellerProductList/${f:h(output.productCode)}/cancel">
                    <button id="cancelBtn">
                      <spring:message code="label.tr.managereservation.cancelReservationBtnMessage" />
                    </button>
                  </form:form> --%>
                  </td>
                  
                  
     <%--          </c:if>
            </c:if> --%>
          </tr>
        </table>
      </div>
      <br /> <br />
    </div>
  </div>
</div>

