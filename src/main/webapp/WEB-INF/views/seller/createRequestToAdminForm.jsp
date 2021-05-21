<style>
p {
	margin-bottom: 70px;
}
</style>
<div class="container">
	<jsp:include page="../common/include.jsp" />
	<form:form modelAttribute="sellerRequestToAdminForm">
		<fieldset>
			<legend>
				<spring:message code="lable_tr_request_notice" />
			</legend>
			<form:errors path="*" cssClass="error" element="div" />
			<table style="cellspacing: 0; width: 300">
				<!-- title -->
				<tr align="center">
					<th><label for="input_subject"> <spring:message
								code="label_tr_request_title" /></label></th>
					<td><form:input path="requestName" id="request_title"
							class="form-control" size="120" /> <form:errors
							path="requestName" cssStyle="color:red;font-size:small"
							size="120" /></td>
				</tr>
				<!-- content -->
				<tr align="center">
					<th><label for="input_text"> <spring:message
								code="label_tr_request_content" />
					</label></th>
					<td><form:textarea path="requestContents" rows="5" cols="50"
							id="input_text" class="form-control" size="120" /> <form:errors
							path="requestContents" cssStyle="color:red;font-size:small"
							size="120" /></td>
				</tr>
			</table>
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
