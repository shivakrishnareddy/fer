<%@page import="com.rs.fer.serviceimpl.FERServiceImpl"%>
<%@page import="com.rs.fer.bean.User"%>
<%@page import="com.rs.fer.service.FERService"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%
	FERService ferService = new FERServiceImpl();
	User personalInfo = (User) session.getAttribute("personalInfo");
	personalInfo.setMail(request.getParameter("email"));
	personalInfo.setMobile(request.getParameter("mobile"));
	session.setAttribute("personalInfo", personalInfo);
%>
<html:form action="updatePersonal?method=updateReview">
	<table align='center' border='1'>
		<tr>
			<td colspan='2' align='center'>Address Info</td>
		</tr>
		<tr id="errorTRId" style="display: none;">
			<td colspan='2' id="errorTdId"></td>
		</tr>
		<tr>
			<td>LineOne<font color="red">*</font></td>
			<td><input type="text" name="lineOne"
				value='<%=personalInfo.getAddress().getLineOne()%>'></td>
		</tr>
		<tr>
			<td>LineTwo <font color="red">*</font></td>
			<td><input type="text" name="lineTwo"
				value=' <%=personalInfo.getAddress().getLineTwo()%> '></td>
		</tr>
		<tr>
			<td>Street <font color="red">*</font></td>
			<td><input type="text" name="street"
				value=' <%=personalInfo.getAddress().getStreet()%>'></td>
		</tr>
		<tr>
			<td>City <font color="red">*</font></td>
			<td><input type="text" name="city"
				value=' <%=personalInfo.getAddress().getCity()%>'></td>
		</tr>
		<tr>
			<td>State <font color="red">*</font></td>
			<td><input type="text" name="state"
				value=' <%=personalInfo.getAddress().getState()%> '></td>
		</tr>
		<tr>
			<td>Zip <font color="red">*</font></td>
			<td><input type="text" name="zip"
				value=' <%=personalInfo.getAddress().getZip()%>'></td>
		</tr>
		<tr>
			<td colspan='2' align='center'><html:submit value="next" />
		</tr>
	</table>
</html:form>