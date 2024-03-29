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

@WebServlet("/resetPassword")
public class ResetPasswordServlet extends HttpServlet {
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
	
		int id = Integer.parseInt(session.getAttribute("id").toString());
		String currentPassword = request.getParameter("currentpassword");
		String newPassword = request.getParameter("newpassword");
		String confirmPassword =request.getParameter("confirmpassword");
		FERService ferService = new FERServiceimpl();

		boolean isResetPassword = ferservice.resetPassword(id, currentPassword, newPassword);

		PrintWriter out = response.getWriter();
		HTMLUtil.displayHeaderAndLeftFrame(request, response, out,session.getAttribute("username").toString());
		out.println(isResetPassword ? "resetpassword succesfully.." : "resetpassword  failed...");

		HTMLUtil.displayFooter(request, response);

	}

	@Override
	public void destroy() {
		ferservice = null;
	}

}
