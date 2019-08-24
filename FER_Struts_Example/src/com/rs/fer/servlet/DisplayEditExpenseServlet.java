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

@WebServlet("/displayEditExpense")
public class DisplayEditExpenseServlet extends HttpServlet {
	FERService ferservice = null;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ferservice =new FERServiceimpl();
		PrintWriter out = response.getWriter();
		HttpSession session= request.getSession();
		HTMLUtil.displayHeaderAndLeftFrame(request, response, out, session.getAttribute("username").toString());
		
		int id=Integer.parseInt(request.getParameter("id").toString());
		//boolean isDeleteExpense = ferservice.deleteExpense(id);
		
		
		Expense expense=ferservice.getExpense(id);
		session.setAttribute("id",id);
		
		
		out.println("<table align='center'border='1' >");
		out.println("<tr>");
		out.println("<td  colspan='2' align='center'>Edit Expense</td>");
		out.println("</tr>");
	
		
		out.println("<tr>");
		out.println("<td>ExpenseType</td>");
		out.println("<td> <input type='text' name='type' value='"+expense.getType()+"' ></td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td>Date</td>");
		out.println("<td> <input type='text' name='date' value='"+expense.getDate()+"' ></td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td>Price</td>");
		out.println("<td><input type='text' name='price' value='"+expense.getPrice()+"' ></td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td>Number of iteams</td>");
		out.println("<td><input type='text' name='numberofiteams' value='"+expense.getNumberOfIteams()+"' ></td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td>Total</td>");
		out.println("<td><input type='text' name='total' value='"+expense.getTotal()+"' ></td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td>By whom</td>");
		out.println("<td> <input type='text' name='bywhom' value='"+expense.getBywhom()+"' ></td>");
		out.println("</tr>");

		out.println("<tr>");
		out.println("<td  colspan='2' align='center'>");
		out.println("<a href=javascript:submitForm('editExpense')>Submit</a>");
		out.println("</td>");
		out.println("</tr>");
		out.println("</table>");
		
		
		
		HTMLUtil.displayFooter(request, response);

	}

	@Override
	public void destroy() {
		ferservice = null;
	}

}
