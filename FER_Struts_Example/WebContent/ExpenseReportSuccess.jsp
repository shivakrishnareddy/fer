<%@page import="com.rs.fer.bean.Expense"%>
<%@page import="java.util.List"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
	
	
	<% List<Expense> expenses=(List<Expense>)session.getAttribute("expenses"); %>
		 <table border='1' align='center'>
		<tr>
			<td>expenseType</td>
			<td>price</td>
			<td>noofitems</td>
			<td>total</td>
			<td>byWhom</td>
			<td>Action</td>
		</tr>

		
		<% 
		for(Expense expense: expenses){
		%>
		 
		<tr>
			<td><%=expense.getType()%></td>
			<td><%=expense.getPrice()%></td>
			<td><%=expense.getNumberOfIteams()%></td>
			<td><%=expense.getTotal()%></td>
			<td><%=expense.getBywhom()%></td>

			<td><input type="Submit" value='Edit'> <input
				type="Submit" value='Delete'></td>
			<%
				}
			%>
		</tr>
	</table> 
	
</html>