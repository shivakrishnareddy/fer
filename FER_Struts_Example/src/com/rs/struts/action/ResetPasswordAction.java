package com.rs.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.rs.fer.service.FERService;
import com.rs.fer.serviceimpl.FERServiceImpl;

public class ResetPasswordAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		FERService ferService = new FERServiceImpl();
		HttpSession session = request.getSession();
		int id=Integer.parseInt(session.getAttribute("id").toString());
		
		String currentPassword = request.getParameter("currentPassword");
		String newPassword = request.getParameter("newPassword");
		String confirmPassword = request.getParameter("confirmPassword");
		
		boolean isResetPassword = ferService.resetPassword(id, currentPassword, newPassword);
			
		return mapping.findForward(isResetPassword ? "success" : "failure");

	}

	}
	

