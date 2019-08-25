

<%@page import="com.rs.fer.bean.Expense"%>
<%@page import="java.util.List"%>
<%@page import="com.rs.fer.service.FERServiceImpl"%>
<%@page import="com.rs.fer.service.FERService"%>

<% 

		int userId = Integer.parseInt(session.getAttribute("userId").toString());
		FERService ferService = new FERServiceImpl();

		List<Expense> expenses = ferService.getExpenses(userId);
		session.setAttribute("expenses",expenses);
		%>
ExpenseId:
<select name='expenseId'>
	<%		for (Expense expense : expenses) {
			out.println("<option value=" + expense.getId() + ">" + expense.getType() + "," + expense.getPrice()+ "," 
					+ expense.getNumberofitems() + "," + expense.getTotal() + "," + expense.getBywhom()
					+ "</option>");
		}
%>
</select>
<br></br>


<a href="displayDeleteExpense.do?method=deleteExpense">Delete
	</a>




