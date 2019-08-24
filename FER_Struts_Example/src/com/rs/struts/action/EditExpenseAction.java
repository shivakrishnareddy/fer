package com.rs.struts.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.rs.fer.bean.Expense;
import com.rs.fer.service.FERService;

import com.rs.fer.serviceimpl.FERServiceimpl;
import com.rs.fer.util.HTMLUtil;

import com.rs.struts.form.EditExpenseForm;

public class EditExpenseAction extends DispatchAction {

	public ActionForward expenseDropdown(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		FERService ferService = new FERServiceimpl();
		HttpSession session = request.getSession();

		int userId = Integer.parseInt(session.getAttribute("userId").toString());
		session.setAttribute("userId", userId);
		List<Expense> expenses = ferService.getExpenses(userId);

		session.setAttribute("expenses", expenses);

		return mapping.findForward("expenseDropdown");

	}

	public ActionForward displayEditExpense(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		FERService ferService = new FERServiceimpl();
		HttpSession session = request.getSession();

		int id = Integer.parseInt(request.getParameter("id").toString());
		// session.setAttribute("id", id);
		Expense expense = ferService.getExpense(id);

		session.setAttribute("expense", expense);
		session.setAttribute("expenseId", id);
		return mapping.findForward("displayEditExpense");

	}

	public ActionForward editExpenseStatus(ActionMapping mapping, ActionForm form, HttpServletRequest request,

			HttpServletResponse response) throws Exception {
		FERService ferService = new FERServiceimpl();
		Expense expense = new Expense();
		HttpSession session = request.getSession();
		EditExpenseForm expenseform = (EditExpenseForm) form;

		expense.setType(expenseform.getType());
		expense.setDate(expenseform.getDate());
		expense.setPrice(expenseform.getPrice());
		expense.setNumberOfIteams(expenseform.getNumberofiteams());
		expense.setTotal(expenseform.getTotal());
		expense.setBywhom(expenseform.getBywhom());
		// expense.setUserId(expenseform.getUserId());
		expense.setId(expenseform.getId());
		boolean expenseStatus = ferService.editExpense(expense);
		session.setAttribute("editExpense", expenseStatus);
		return mapping.findForward("editExpenseStatus");

	}

}
