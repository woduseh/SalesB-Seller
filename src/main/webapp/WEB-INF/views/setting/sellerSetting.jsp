<div class="container"><br><br><br>
  <!-- 메뉴 메시지 -->
  <p id="messagesArea" class="box">  </p>
    <sec:authorize access="!hasRole('SELLER')">
      <spring:message code="label.tr.common.notLoginMessage" />
    </sec:authorize>
    <h3>Seller Setting Page</h3>
    <table>
		<thead>
			<tr>
				<th scope="col">
				<%-- <spring:message
						code="lable_tr_admin_request_form_table_header_seq" /> --%>
						seller Code
				</th>
				<th scope="col">
			<%-- 	<spring:message
						code="lable_tr_admin_request_form_table_header_client" /> --%>
						seller Name
				</th>
				<th scope="col">
				<%-- <spring:message
						code="lable_tr_admin_request_form_table_header_request_name" /> --%>
						seller Mail
				</th>
				<th scope="col">
				<%-- <spring:message
						code="lable_tr_admin_request_form_table_header_request_content" /> --%>
						seller Tel
				</th>
				<th scope="col">
			<%-- 	<spring:message
						code="lable_tr_admin_request_form_table_header_update_time" /> --%>
						seller info
				</th>
				<th scope="col">
			<%-- 	<spring:message
						code="lable_tr_admin_request_form_table_header_update_time" /> --%>
						seller image
				</th>
				<th scope="col">
			<%-- 	<spring:message
						code="lable_tr_admin_request_form_table_header_update_time" /> --%>
						modify
				</th>
			</tr>
		</thead>
			<tr>  
				<td>${f:h(output.sellerCode)}</td>
				<td>${f:h(output.sellerName)}</td>
				<td>${f:h(output.sellerMail)}</td>
				<td>${f:h(output.sellerTel)}</td>
				<td>${f:h(output.sellerInformation)}</td>
				<td><img src="${f:h(output.sellerImageURL)}" height=50px width=50px></td>
				<td><form:form method="get"
                    action="${pageContext.request.contextPath}/Setting/${f:h(output.sellerCode)}/update" style="margin:0 !important">
                    <button id="changeBtn${rowStatus.index}" name="form">
                      <spring:message code="label.tr.manageseller.change" />
                    </button>
                  </form:form>
                 </td>
			</tr>
		</table>
</div>
