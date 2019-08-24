<%@page import="com.rs.fer.serviceimpl.FERServiceImpl"%>
<%@page import="com.rs.fer.bean.User"%>
<%@page import="com.rs.fer.service.FERService"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>

<%
	FERService ferService = new FERServiceImpl();
	User personalInfo = (User) session.getAttribute("personalInfo");
	personalInfo.setFirstName(request.getParameter("firstname"));
	personalInfo.setMiddleName(request.getParameter("middlename"));
	personalInfo.setLastName(request.getParameter("lastname"));
	session.setAttribute("personalInfo", personalInfo);
%>
<html:form action="updatePersonal.do?method=addressInfo">
	<table align='center' border='1'>
		<tr>
			<td colspan='2' align='center'>contactInfo</td>
		</tr>
		<tr id="errorTRId" style="display: none;">
			<td colspan='2' id="errorTdId"></td>
		</tr>

		<tr>
			<td>Email <font color="red">*</font></td>
			<td><input type='text' name='email'
				value='<%=personalInfo.getMail()%>'></td>
		</tr>
		<tr>
			<td>MobileNumber <font color="red">*</font></td>
			<td><input type='text' name='mobile'
				value='<%=personalInfo.getMobile()%>'></td>
		</tr>
		<tr>
			<td colspan='2' align='center'><html:submit value="next" />
		</tr>
	</table>
</html:form>