 <div class="container">

  <div class="info">
    <p>
      <spring:message code="label.tr.manageseller.updateConfirmMessage" />
    </p>
  </div>
  
  
  <div class="container">

  <div class="info">
    <p>
      <spring:message code="label.tr.manageseller.updateConfirmMessage" />
    </p>
  </div>
  <form:form modelAttribute="sellerSettingForm" method="post">
    <jsp:include page="fragment/sellerDetail.jsp" />

    <!-- Include all the hidden items here. 
			These will be mapped to the modelAttribute form -->

    <form:hidden path="sellerName" />
    <form:hidden path="sellerMail" />
    <form:hidden path="sellerTel" />
    <form:hidden path="sellerInformation" />
    <form:hidden path="sellerImageURL" />
    
    </form:form>

</div>

    <form:form modelAttribute="sellerSettingForm" cssClass="inline" method="post">
    <div class="span-6">
      <table>
        <tr>
          <td>
            <button id="backToFormBtn" name="redo">
              <spring:message code="label.tr.managereservation.changeReservationStaBtnMessage" />
            </button>
          </td>
          <td>
            <button id="changeBtn">
              <spring:message code="label.tr.manageseller.confirmEditBtnMessage" />
            </button>
          </td>
        </tr>
      </table>
    </div>
    </form:form>

</div>
 
 
