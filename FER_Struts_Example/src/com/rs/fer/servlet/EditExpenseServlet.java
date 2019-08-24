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

@WebServlet("/editExpense")
public class EditExpenseServlet extends HttpServlet {
	FERService ferservice = null;

	@Override
	public void init(ServletConfig config) throws ServletException {
		ferservice = new FERServiceimpl();
		super.init(config);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session= request.getSession();
		PrintWriter out = response.getWriter();
		session.getAttribute("expense");
		Expense expense=new Expense();
		
		expense.setType(request.getParameter("type"));
		expense.setDate(request.getParameter("date")); 
		expense .setPrice(Float.parseFloat(request.getParameter("price")));
		expense.setNumberOfIteams(Integer.parseInt(request.getParameter("numberofiteams"))); 
		expense.setTotal(Float.parseFloat(request.getParameter("total")));
		expense.setBywhom(request.getParameter("bywhom"));
		expense.setId(Integer.parseInt(session.getAttribute("id").toString()));


		boolean isEdited = ferservice.editExpense(expense);
		
		
		HTMLUtil.displayHeaderAndLeftFrame(request, response, out, session.getAttribute("username").toString());
		out.println(isEdited ? "Expense edited succesfully.." : "Expense edited failed...");

		HTMLUtil.displayFooter(request, response);

	}

	@Override
	public void destroy() {
		ferservice = null;
	}

}
