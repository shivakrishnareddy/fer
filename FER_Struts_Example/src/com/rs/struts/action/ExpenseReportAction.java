package com.rs.struts.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.rs.fer.bean.Expense;
import com.rs.fer.service.FERService;
import com.rs.fer.serviceimpl.FERServiceimpl;
import com.rs.struts.form.ExpenseReportForm;

public class ExpenseReportAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {		

		HttpSession session = request.getSession();
		FERService ferService = new FERServiceimpl();
		int id = Integer.parseInt(session.getAttribute("userId").toString());
		ExpenseReportForm expenseReportForm = (ExpenseReportForm) form;
		String expenseType = request.getParameter("Type");
		String fromDate = request.getParameter("fromDate");
		String toDate = request.getParameter("toDate");
		List<Expense> expenses = ferService.getexpensesReport(id, expenseType, fromDate, toDate);

		session.setAttribute("expenses", expenses);
		if (expenses != null) {
			return mapping.findForward("Success");
		} else {
			return mapping.findForward("failure");

		}
	}
}
