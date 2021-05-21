<table id="sellerTable">
<%-- <tr>
    <td>seller Code</td>
    <td>${f:h(output.sellerCode)}</td>
 
</tr> --%>
  <tr>
    <td>seller Name</td>
    <td>
	   ${f:h(sellerSettingForm.sellerName)}
    </td>
  </tr>
  <tr>
    <td>seller Mail</td>
    <td>${f:h(sellerSettingForm.sellerMail)}</td>
  </tr>
  <tr>
    <td>seller Tel</td>
    <td>${f:h(sellerSettingForm.sellerTel)}</td>
  </tr>
  <tr>
    <td>seller information</td>
    <td>${f:h(sellerSettingForm.sellerInformation)}</td>
  </tr>
  <tr>
    <td>seller image</td>
    <td><img src="${f:h(sellerSettingForm.sellerImageURL)}" height=50px width=50px></td>
  </tr>
</table>