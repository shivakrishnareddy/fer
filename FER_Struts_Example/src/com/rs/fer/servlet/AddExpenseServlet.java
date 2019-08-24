package com.rs.fer.servlet;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rs.fer.bean.Expense;
import com.rs.fer.bean.User;
import com.rs.fer.service.FERService;
import com.rs.fer.serviceimpl.FERServiceimpl;
import com.rs.fer.util.HTMLUtil;

@WebServlet("/addExpense")
public class AddExpenseServlet extends HttpServlet {
	FERService ferservice = null;

	@Override
	public void init(ServletConfig config) throws ServletException {
		ferservice = new FERServiceimpl();
		super.init(config);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Expense addexpense = new Expense();
		HttpSession session= request.getSession();

		addexpense.setType(request.getParameter("expenseType"));
		addexpense.setDate(request.getParameter("date"));
		addexpense.setPrice(Float.parseFloat(request.getParameter("price")));
		addexpense.setNumberOfIteams(Integer.parseInt(request.getParameter("numberOfIteams")));
		addexpense.setTotal(Float.parseFloat(request.getParameter("total")));
		addexpense.setBywhom(request.getParameter("byWhom"));
		addexpense.setUserid(1);

		FERService ferService = new FERServiceimpl();

		boolean isAddExpense = ferService.addExpense(addexpense);
		PrintWriter out = response.getWriter();
		HTMLUtil.displayHeaderAndLeftFrame(request, response, out, session.getAttribute("username").toString());
		out.println(isAddExpense ? "Expense added succesfully.." : "Expense add failed...");

		HTMLUtil.displayFooter(request, response);

	}

	@Override
	public void destroy() {
		ferservice = null;
	}

}
