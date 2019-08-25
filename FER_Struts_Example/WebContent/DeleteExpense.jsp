<%@page import="com.rs.fer.service.FERServiceImpl"%>
<%@page import="com.rs.fer.service.FERService"%>
<%
	FERService ferService = new FERServiceImpl();

	int expenseId = Integer.parseInt(request.getParameter("expenseId").toString());
	boolean isDeleted = ferService.deleteExpense(expenseId);

	if (isDeleted) {
		out.println("Expense deleted successfully");
	} else {
		out.println("Expense not deleted");
	}
%>
