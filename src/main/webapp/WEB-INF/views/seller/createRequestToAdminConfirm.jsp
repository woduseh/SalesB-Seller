<div class="container">

	<div class="info">
		<%-- <p>
      <spring:message code="label.tr.managecustomer.createConfirmMessage" />
    </p> --%>
	</div>
	<form:form modelAttribute="sellerRequestToAdminForm">

		<table  id="requestTable" style="cellspacing: 0; width: 300">
			<!-- title -->
			<tr align="center">
				<th><label for="input_subject"> <spring:message
							code="label_tr_request_title" /></label></th>
				<td><form:input path="requestName" id="request_title"
						class="form-control" size="120" readonly="true"  /> <form:errors
						path="requestName" cssStyle="color:red;font-size:small" size="120" />${f:h(SellerRequestToAdminForm.requestName)}</td>
			</tr>
			<!-- content -->
			<tr align="center">
				<th><label for="input_text"> <spring:message
							code="label_tr_request_content" />
				</label></th>
				<td><form:textarea path="requestContents" rows="5" cols="50"
						id="input_text" class="form-control" size="120" readonly="true"  /> <form:errors
						path="requestContents" cssStyle="color:red;font-size:small"
						size="120" />${f:h(SellerRequestToAdminForm.requestContents)}</td>
			</tr>
		</table>
		<form:button id="backToFormBtn" name="redo">
			<spring:message code="label.tr.common.goBackMessage" />
		</form:button>
            &nbsp;
		<form:button id="registerBtn">
			<spring:message code="label.tr.common.register" />
		</form:button>
	</form:form>

</div>
