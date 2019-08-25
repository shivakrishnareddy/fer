package com.rs.struts.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;

public class DeleteExpenseAction extends DispatchAction {
	
	FERService ferService=new FERServiceImpl();
	
	public ActionForward deleteExpenseDropdown(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		
		return mapping.findForward("deleteExpenseDropdown");

}
	public ActionForward deleteExpense(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		FERService ferService = new FERServiceImpl();
		
		int expenseId = Integer.parseInt(request.getParameter("expenseId").toString());
		boolean isDeleted = ferService.deleteExpense(expenseId);


		return mapping.findForward(isDeleted ? "success":"failure");
}
}