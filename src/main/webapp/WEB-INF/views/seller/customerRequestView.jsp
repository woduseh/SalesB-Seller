<div class="container">
	<div class="span-24 last">

		<c:if test="${pageSize > 0}">
			<table id="requestTable">
				<thead>
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
						<td>${f:h(Request.requestName)}</td>
						<td>${f:h(Request.requestContents)}</td>
						<td>${f:h(Request.updateTime)}</td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</div>
	<div class="span-5">
		<form:form method="get"
			action="${pageContext.request.contextPath}/customerRequest">
			<div class="span-5">
				<button id="searchTourBtn" name="initCustomerRequestForm"
					style="width: 150px;">
					<spring:message code="label.tr.menu.request.manage" />
				</button>
			</div>
		</form:form>
	</div>
</div>