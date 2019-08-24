<%@page import="com.rs.fer.bean.Expense,java.util.*"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>



<%
	List<Expense> expenses = (List<Expense>) session.getAttribute("expenses");

	if (expenses != null && !expenses.isEmpty()) {
%>

<html:form action="editExpense.do?editExpenseMethod=displayEditExpense">
	<select name='id'>


		<option value="Select">Select</option>
		<%
			for (Expense expense : expenses) {
		%>
		<option value='<%=expense.getId()%>'>
			<%=expense.getId()%>,
			<%=expense.getType()%>,
			<%=expense.getDate()%>,
			<%=expense.getPrice()%>,
			<%=expense.getNumberOfIteams()%>,
			<%=expense.getTotal()%>,
			<%=expense.getBywhom()%></option>
		<%
			}
		%>

	</select>
	<html:submit value='Edit Expenses' />
</html:form>

<%
	} else {
%>
No expenses found..
<%
	}
%>

