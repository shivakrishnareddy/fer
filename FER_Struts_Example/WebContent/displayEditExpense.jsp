
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@page import="com.rs.fer.service.FERService"%>

<%@page import="java.lang.*"%>
<%@page import="java.util.*"%>
<%@page import="com.rs.fer.bean.Expense"%>
<html:form action="/editExpense.do?editExpenseMethod=editExpenseStatus">

	<%
		Expense expense = (Expense) session.getAttribute("expense");
			if (expense != null) {
	%>
	<table border='1' align='center'>
		<tr height='50px'>
			<td align='center' colspan='2'>Edit Expense</td>
		</tr>

		<tr>
			<td>Expense Type</td>
			<td><input type='text' name='type'
				value=<%=expense.getType()%>></td>
		</tr>
		<tr>
			<td>Date</td>
			<td><input type='text' name='date' value=<%=expense.getDate()%>></td>
		</tr>
		<tr>
			<td>Price</td>
			<td><input type='text' name='price'
				value=<%=expense.getPrice()%>></td>
		</tr>
		<tr>
			<td>No Of Items</td>
			<td><input type='text' name='numberofiteams'
				value=<%=expense.getNumberOfIteams()%>></td>
		</tr>
		<tr>
			<td>Total Account</td>
			<td><input type='text' name='total'
				value=<%=expense.getTotal()%>></td>
		</tr>
		<tr>
			<td>By Whom</td>
			<td><input type='text' name='bywhom'
				value=<%=expense.getBywhom()%>></td>
		</tr>
		<tr>
			<td colspan='2' align='center'><html:submit value='Save Expenses' /></td>
		</tr>

	</table>
	<%
		}
	%>

</html:form>

