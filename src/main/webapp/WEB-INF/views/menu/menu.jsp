<div class="container"><br><br><br>
  <!-- 메뉴 메시지 -->
  <p id="messagesArea" class="box">
    <sec:authorize access="!hasRole('SELLER')">
      <spring:message code="label.tr.common.notLoginMessage" />
    </sec:authorize>
    
    <!-- 로그아웃 버튼 -->
    <sec:authorize access="hasRole('SELLER')">
	  <form:form action="${pageContext.request.contextPath}/logout" cssClass="inline">
	    <button id="logoutBtn" name="logout">
	      <spring:message code="label.tr.common.logout" />
	    </button>
	  </form:form>
    </sec:authorize>
  </p>
  
  <!-- 판매자 관련 파트 -->
  <div class="span-24 last">
    <sec:authorize access="!hasRole('SELLER')">
      <form:form method="get" action="${pageContext.request.contextPath}/seller">
        <fieldset class="notice">
          <div class="span-5">seller page
            <button id="searchTourBtn" name="initForm" style="width: 150px;">
              <spring:message code="label.tr.seller" />
            </button>
          </div>
          <div class="span-18 last">
            <p>
              <spring:message code="label.tr.seller" />
            </p>
          </div>
        </fieldset>
      </form:form>
    </sec:authorize>

  </div>
</div>
