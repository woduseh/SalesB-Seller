
<table id="sellerTable">
  <caption>
    <spring:message code="label.tr.common.notLoginMessage" />
  </caption>
  <tr>
    <td><spring:message code="label.tr.common.name" /></td>
    <td>${f:h(sellerForm.sellerName)}</td>
  </tr>
  <tr>
    <td><spring:message code="label.tr.common.email" /></td>
    <td>${f:h(sellerForm.sellerMail)}</td>
  </tr>
  <tr>
    <td><spring:message code="label.tr.common.tel" /></td>
    <td>${f:h(sellerForm.sellerTel)}</td>
  </tr>
  <tr>
    <td><spring:message code="label.tr.common.password" /></td>
    <td>********</td>
  </tr>
</table>