<div class="container">
	<div class="search container">
		<form:form method="get" modelAttribute="CustomerRequestForm">
			<div class="form-inline">
				<form:select path="searchOptions" items="${CL_SELECT_OPTION}"></form:select>
				<form:input path="searchKeywords" align="left" cssClass="text" />
				<button id="searchBtn" class="btn btn-primary">
					<spring:message code="label.tr.common.search" />
				</button>
			</div>
		</form:form>
	</div>
	<c:if test="${pageSize > 0}">
		<table id="requestTable">
			<thead>
				<tr>
					<th><spring:message
							code="lable.tr.admin.request.form.table.introduce" /></th>
				</tr>
				<tr>
					<th scope="col"><spring:message
							code="lable.tr.admin.request.form.table.header.seq" /></th>
					<th scope="col"><spring:message
							code="lable.tr.admin.request.form.table.header.client" /></th>
					<th scope="col"><spring:message
							code="lable.tr.admin.request.form.table.header.request.name" /></th>
					<th scope="col"><spring:message
							code="lable.tr.admin.request.form.table.header.request.content" /></th>
					<th scope="col"><spring:message
							code="lable.tr.admin.request.form.table.header.update.time" /></th>
				</tr>
			</thead>
			<c:forEach var="Request" items="${page.content}">
				<tr>
					<td>${f:h(Request.seq)}</td>
					<td>${f:h(Request.client)}</td>
					<td><a
						href="${pageContext.request.contextPath}/customerRequestdetail?requestnum=${Request.seq}">${f:h(Request.requestName)}</a></td>
					<td>${f:h(Request.requestContents)}</td>
					<td>${f:h(Request.updateTime)}</td>
				</tr>
			</c:forEach>
		</table>
		<div class="pagination">
			<t:pagination page="${page}"
				criteriaQuery="${f:query(Request)}" />
		</div>
	</c:if>
	<c:if test="${pageSize <= 0}">
		<spring:message code="lable_tr_no_result" />
	</c:if>
<%-- 	<div class="span-5">
		<form:form method="post"
			action="${pageContext.request.contextPath}/admin">
			<div class="span-5">
				<button id="searchTourBtn" name="initCustomerRequestForm"
					style="width: 150px;">
					<spring:message code="label_tr_menu_return" />
				</button>
			</div>
		</form:form>
	</div> --%>
</div>