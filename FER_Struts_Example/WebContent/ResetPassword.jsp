 <%@taglib uri="WEB-INF/struts-html.tld" prefix="html"%>
 
 <!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div style="color: red">
		<html:errors />
	</div>
<html:form action="/reset">
		<table border="1" align="center">
			<tr>
				<td colspan="2" align="center">Reset Password</td>
			</tr>
			<tr>
				<td>New password</td>
				<td><html:password name="ResetPasswordForm" property="newPassword"/></td>
			</tr>
			<tr>
				<td>Current Password</td>
				<td><html:password name="ResetPasswordForm" property="currentPassword"/></td>
			</tr>
			<tr>
				<td>Confirm Password</td>
				<td><html:password name="ResetPasswordForm" property="confirmPassword"/></td>
			</tr>
			
			<tr>
				<td align="center" colspan="2"><input type="submit" value="Reset"></td>
			</tr>
		</table>
	</html:form>

</body>
</html>