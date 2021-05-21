
<div class="container">
  <h2 id="screenName">
    <spring:message code="label.tr.managereservation.manageReservationEditScreenTitle" />
  </h2>

  <!-- end title -->

  <!-- begin main -->
  <div class="info">
    <spring:message code="label.tr.manageseller.updateFormMessage" />
  </div>
  <form:form method="get" action="${pageContext.request.contextPath}/Setting/${f:h(sellerSettingForm.sellerCode)}/uploadSeller"  path="sellerImageURL">
	<button id="resetBtn" class="btn btn-primary btn-sm" name="form" style="margin: 40px; padding:6px 12px">
		<p>사진</p>
	</button>
  </form:form>
  <form:form method="post"
    action="${pageContext.request.contextPath}/Setting/${f:h(sellerSettingForm.sellerCode)}/update"
    modelAttribute="sellerSettingForm">
    <fieldset>
		 <legend>
			<spring:message code="label.tr.sellerproduct.productsellerUpdateMessage" />
		 </legend>
		<form:errors path="*" cssClass="error" element="div" />
		<!-- SELLER NAME -->
		<p>
			<form:label path="sellerName">
	         	seller Name
			</form:label>
	        <br>
	        <form:input path="sellerName" cssClass="text" value="${sellerSettingForm.sellerName}" />
        </p>
        <!-- SELLER MAIL -->
     	<p>
       		<form:label path="sellerMail">
	         seller mail
			</form:label>
	        <br>
	        <form:input path="sellerMail" cssClass="text" value="${sellerSettingForm.sellerMail}" />
      	</p>
        <!-- SELLER TEL -->
     	<p>
       		<form:label path="sellerTel">
	         seller tel
			</form:label>
	        <br>
	        <form:input path="sellerTel" cssClass="text" value="${sellerSettingForm.sellerTel}" />
      	</p>
        <!-- SELLER INFORMATION -->
     	<p>
       		<form:label path="sellerInformation">
	         seller Information
			</form:label>
	        <br>
	        <form:input path="sellerInformation" cssClass="text" value="${sellerSettingForm.sellerInformation}" />
      	</p>
      	<p>
       		<form:label path="sellerImageURL">
	         seller Image
			</form:label>
	        <br>
	        <img src="${f:h(sellerSettingForm.sellerImageURL)}" height=50px width=50px>
	     <%--    <form:input path="sellerImageURL" cssClass="text" value="${sellerSettingForm.sellerImageURL}" /> --%>
      	</p>

 
     
    </fieldset>

    <!-- tour-info end -->
    <br />
    <br />
    <br />
    <!-- note end -->

    <!-- begin buttons -->
    <div class="span-9">
      <table>
        <tr>
          <td>
            <div class="button">
              <button id="backToListBtn" name="backTolist">
                <spring:message code="label.tr.manageseller.returnToListScreenBtnMessage" />
              </button>
            </div>
          </td>
          <td>
            <div class="button">
              <button id="confirmBtn" name="confirm">
                <spring:message code="label.tr.manageseller.confirmEditBtnMessage" />
              </button>
            </div>
          </td>
        </tr>
      </table>
    </div>
    <!-- end buttons -->
  </form:form>
</div>
