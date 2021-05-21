<%-- <div class="container">
  <h4>sender</h4>
  <form action="${pageContext.request.contextPath}/mail/mailSending" method="post">
    <div align="center"><!-- receiver -->
      <input type="text" name="tomail" size="120" style="width:100%" placeholder="상대의 이메일" class="form-control" >
    </div>     
    <div align="center"><!-- title -->
      <input type="text" name="title" size="120" style="width:100%" placeholder="제목을 입력해주세요" class="form-control" >
    </div>
    <p>
    <div align="center"><!-- contents --> 
      <textarea name="content" cols="120" rows="12" style="width:100%; resize:none" placeholder="내용#" class="form-control"></textarea>
    </div>
    <p>
    <div align="center">
      <input type="submit" value="send" class="btn btn-warning">
    </div>
  </form>
</div>
 --%>
 
 <div  class="container">
   <form:form method="POST" modelAttribute="mailObject" >
       <fieldset>
           <div style="float:left;">
               <table style="cellspacing:0; width:300">
                   <tr align="center">
                       <th><label for="input_to">To</label></th>
                       <td><form:input path="to" id="input_to" type="email" class="form-control" size="120"/>
                           <form:errors path="to" cssStyle="color:red;font-size:small" size="120"/>
                       </td>
                   </tr>
                   <tr align="center">
                       <th><label for="input_subject">Title</label></th>
                       <td><form:input path="subject" id="input_subject" class="form-control" size="120"/>
                           <form:errors path="subject" cssStyle="color:red;font-size:small" size="120"/>
                       </td>
                   </tr>
                   <tr align="center">
                       <th><label for="input_text"><%-- ${messageLabel}: --%></label></th>
                       <td><form:textarea path="text" rows="5" cols="50" id="input_text" class="form-control" size="120"/>
                           <form:errors path="text" cssStyle="color:red;font-size:small" size="120"/>
                       </td>
                   </tr>
                   <tr align="center">
                       <th></th>
                       <td>
                           <input type="submit" value="send" class="btn btn-warning">
                       </td>
                   </tr>
               </table>
           </div>
       </fieldset>
   </form:form>
   
   <form:form method="get" action="${pageContext.request.contextPath}/requestToSellerList" style="margin:0 !important">
      <button class="btn btn-warning">
        <spring:message code="label.tr.manageseller.returnToListScreenBtnMessage" />
      </button>
    </form:form>
</div>