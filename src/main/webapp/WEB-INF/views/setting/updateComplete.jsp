  
<div class="container">
  <div class="success"><br><br><br>
    <p>
      <spring:message code="label.tr.manageseller.updateCompleteMessage"
        arguments="${f:h(sellerSettingForm.sellerCode)}" />
    </p>
  </div>
<div class="span-8">
    <table>
      <tr>
        <td><form:form method="get" action="${pageContext.request.contextPath}/Setting">
            <button id="backToListBtn">
              <spring:message code="label.tr.manageseller.returnToListScreenBtnMessage" />
            </button>
          </form:form></td>
        <td><form:form method="get" action="${pageContext.request.contextPath}/seller">
            <button id="goToMenuBtn">
              <spring:message code="label.tr.common.gotoMenuMessage" />
            </button>
          </form:form>
        </td>
      </tr>
    </table>
</div>
</div>
  