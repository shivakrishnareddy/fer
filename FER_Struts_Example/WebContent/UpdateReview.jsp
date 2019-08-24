<%@page import="com.rs.fer.serviceimpl.FERServiceImpl"%>
<%@page import="com.rs.fer.bean.User"%>
<%@page import="com.rs.fer.service.FERService"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%
	FERService ferService =  new FERServiceImpl();

		User personalInfo = (User) session.getAttribute("personalInfo");
		
		personalInfo.getAddress().setLineOne(request.getParameter("lineOne"));
		personalInfo.getAddress().setLineTwo(request.getParameter("lineTwo"));
		personalInfo.getAddress().setStreet(request.getParameter("street"));
		personalInfo.getAddress().setCity(request.getParameter("city"));
		personalInfo.getAddress().setState(request.getParameter("state"));
		personalInfo.getAddress().setZip(request.getParameter("zip"));
		
		session.setAttribute("personalInfo", personalInfo);
		%>
		<html:form action="updatePersonal.do?method=updateStatus">
	<table align='center' border='1'>
		<tr>
			<td colspan='2' align='center'>NameInfo</td>
		</tr>
		<tr id="errorTRId" style="display: none;">
			<td colspan='2' id="errorTdId"></td>
		</tr>
		<tr>
			<td>FirstName <font color="red">*</font></td>
			<td><input type='text' name='firstname'
				value='<%=personalInfo.getFirstName()%>'></td>
		</tr>
		<tr>
			<td>MiddleName <font color="red">*</font></td>
			<td><input type='text' name='middlename'
				value='<%= personalInfo.getMiddleName()%>'></td>
		</tr>
		<tr>
			<td>LastName <font color="red">*</font></td>
			<td><input type='text' name='lastname'
				value='<%= personalInfo.getLastName()%>'></td>
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
			<td colspan='2' align='center'><html:submit value="update" />
		</tr>
	</table>
</html:form>