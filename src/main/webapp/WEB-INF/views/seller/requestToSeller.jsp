<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    
    <title>request to seller</title>
</head>

<body>
    <!-- Page Content -->
    <div class="container">
    
        <!-- Heading Row -->
        <div class="row align-items-center my-5">
            <div class="row">
                <p class="notice">
                    <spring:message code="label.tr.requesttoseller.resultCountMessage"
                    arguments="${page.totalElements}" />
                </p>
                <table>
                    <thead>
                        <tr>
                        <th><spring:message code="label.tr.requesttoseller.name" /></th>
                        <th><spring:message code="label.tr.requesttoseller.content" /></th>
                        <th><spring:message code="label.tr.requesttoseller.mail" /></th>
                        <th>Send Mail</th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="RequestToSeller" items="${page.content}">
                    <tr>
                        <td>${f:h(RequestToSeller.customerCode)}</td>
                        <td>${f:h(RequestToSeller.requestContent)}</td>
                        <td>${f:h(RequestToSeller.customerMail) }</td>
                        <td>
                        
                                               	<%--  <form:form method="get" action="${pageContext.request.contextPath}/mail/send" --%>
                       	 <form:form method="get" action="${pageContext.request.contextPath}/mail/${f:h(RequestToSeller.customerMail)}/${f:h(RequestToSeller.customerCode)}/"
		                    style="margin:0px !important">
		                    <%-- <button id="showBtn${rowStatus.index}" > --%>
		                    <button id="showBtn" >
		                      Go
		                    </button>
		                  </form:form>
                 		</td>
                    </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    
    </div>
</body>
</html>