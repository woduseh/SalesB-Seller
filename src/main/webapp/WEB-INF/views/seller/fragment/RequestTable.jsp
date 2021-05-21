
<table id="requestTable">
	<thead>
		<tr>
			<th scope="col"><spring:message
					code="lable_tr_admin_request_form_table_header_seq" /></th>
			<th scope="col"><spring:message
					code="lable_tr_admin_request_form_table_header_client" /></th>
			<th scope="col"><spring:message
					code="lable_tr_admin_request_form_table_header_request_name" /></th>
			<th scope="col"><spring:message
					code="lable_tr_admin_request_form_table_header_request_content" /></th>
			<th scope="col"><spring:message
					code="lable_tr_admin_request_form_table_header_update_time" /></th>
		</tr>
	</thead>
	<c:forEach var="Request" items="${SellerRequestToAdminForm.content}">
		<tr>
			<td>${f:h(Request.seq)}</td>
			<td>${f:h(Request.client)}</td>
			<td>${f:h(Request.requestName)}</td>
			<td>${f:h(Request.requestContents)}</td>
			<td>${f:h(Request.updateTime)}</td>
		</tr>
	</c:forEach>
</table>