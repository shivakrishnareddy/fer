package com.rs.fer.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rs.fer.bean.Expense;
import com.rs.fer.service.FERService;
import com.rs.fer.serviceimpl.FERServiceimpl;
import com.rs.fer.util.HTMLUtil;

@WebServlet("/displayDeleteExpense")
public class DisplayDeleteExpenseServlet extends HttpServlet {
	FERService ferservice = null;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		ferservice = new FERServiceimpl();
		int id = Integer.parseInt(session.getAttribute("id").toString());

		List<Expense> expenses = ferservice.getExpenses(id);

		PrintWriter out = response.getWriter();
		HTMLUtil.displayHeaderAndLeftFrame(request, response, out, session.getAttribute("username").toString());
		if (expenses != null && !expenses.isEmpty()) {
			out.println("<table>");
			out.println("<tr>");
			out.println("<td align='center '>Expense Id</td>");
			out.println("<td><select name='id'>");
			out.println("<option selected ='selected'>select</option>");
			String expenseDesc = null;
			for (Expense expense : expenses) {
				expenseDesc = expense.getType() + "," + expense.getDate() + "," + expense.getPrice() + ","
						+ expense.getNumberOfIteams() + "," + expense.getTotal() + "," + expense.getBywhom();
				out.println("<option value='"+ expense.getId()+"'>"+expenseDesc + "</option");
			}
			out.println("</select><td>");
			out.println("</tr>");
			out.println("<td colspan ='2' align='center'>");
			out.println("<a href=javascript:submitForm('deleteExpense')> Delete</a>");
			out.println("</tr>");
			out.println("</table> ");
		}

		HTMLUtil.displayFooter(request, response);

	}

}
