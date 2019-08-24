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

@WebServlet("/expenseReport")
public class ExpenseReportServlet extends HttpServlet {
	FERService ferservice = null;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		ferservice = new FERServiceimpl();
		int id = Integer.parseInt(session.getAttribute("id").toString());

		String expenseType = request.getParameter("expenseType");
		String fromDate = request.getParameter("fromDate");
		String toDate = request.getParameter("toDate");
		List<Expense> expenses = ferservice.getexpensesReport(id, expenseType, fromDate, toDate);

		PrintWriter out = response.getWriter();
		HTMLUtil.displayHeaderAndLeftFrame(request, response, out, session.getAttribute("username").toString());
		if (expenses != null && !expenses.isEmpty()) {
			// out.println("<table>");
			out.println("<table align='center' border ='1'>");
			out.println("<tr>");
			out.println("<th>ExpenseType</th>");
			out.println("<th>Date</th>");
			out.println("<th>Price</th>");
			out.println("<th>NumberOfIteams</th>");
			out.println("<th>Total</th>");
			out.println("<th>ByWhom</th>");
			out.println("</tr>");

			for (Expense expense : expenses) {
				out.println("<tr>");
				out.println("<td><input type='text' name='expenseType' value='" + expense.getType() + "'></td>");
				out.println("<td><input type='date' name='date' value='" + expense.getDate() + "'></td> ");
				out.println("<td><input type='text' name='price' value='" + expense.getPrice() + "'></td>");
				out.println(
						"<td><input type='text' name='nuberOfIteams' value='" + expense.getNumberOfIteams() + "'></td>");
				out.println("<td><input type='text' name='total' value='" + expense.getTotal() + "'></td>");
				out.println("<td><input type='text' name='byWhom' value='" + expense.getBywhom() + "'></td>");
				out.println("</tr>");
			}

			out.println("</table>");
		}

		HTMLUtil.displayFooter(request, response);

	}

	@Override
	public void destroy() {

		super.destroy();
	}
}
