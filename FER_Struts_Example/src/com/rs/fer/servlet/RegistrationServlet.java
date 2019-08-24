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

import com.rs.fer.bean.User;
import com.rs.fer.service.FERService;
import com.rs.fer.serviceimpl.FERServiceimpl;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
	FERService ferservice = null;

	@Override
	public void init(ServletConfig config) throws ServletException {
		ferservice = new FERServiceimpl();
		super.init(config);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = new User();

		user.setFirstname(req.getParameter("First Name"));
		user.setMiddlename(req.getParameter("Middle Name"));
		user.setLastname(req.getParameter("Last Name"));
		user.setUsername(req.getParameter("Email"));
		user.setPassword(req.getParameter("User Name"));
		user.setEmail(req.getParameter("Password"));
		user.setMobile(req.getParameter("Mobile"));

		boolean isRegister = ferservice.registration(user);
		PrintWriter out = resp.getWriter();
		String nextpath = null;

		if (isRegister) {
			out.println("user registered login successfully.please  try using login ..<br> ");
			nextpath = "Login.html";
		} else {
			out.println(" user registration failed. please try again");
			nextpath = "Registration.html";

		}
		RequestDispatcher rd = req.getRequestDispatcher(nextpath);
		rd.include(req, resp);
	}

	@Override
	public void destroy() {
		ferservice = null;
	}

}
