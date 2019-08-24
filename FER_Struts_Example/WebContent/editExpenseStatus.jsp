<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<%@page import="com.rs.fer.bean.Expense"%>
<%
	Object editExpense = session.getAttribute("editExpense");
	if (editExpense != null) {
%>
expense edited successfully
<%
	} else {
%>
unable to edit expense
<%
	}
%>