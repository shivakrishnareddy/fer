package com.rs.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;

public class DynaLoginAction extends Action {
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		System.out.println("DynaLoginAction.execute()");
		
		DynaActionForm loginForm=(DynaActionForm) form;
		
		boolean isValidUser = "admin".equals(loginForm.get("username")) 
								&& "admin".equals(loginForm.get("password"));
		
		return mapping.findForward(isValidUser ? "success" :"failure");
		
	}
	

}
