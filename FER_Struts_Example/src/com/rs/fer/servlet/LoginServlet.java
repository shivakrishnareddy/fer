package com.rs.fer.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.SingleThreadModel;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rs.fer.service.FERService;
import com.rs.fer.serviceimpl.FERServiceimpl;
import com.rs.fer.util.HTMLUtil;

@WebServlet("/login")
public class LoginServlet extends HttpServlet implements SingleThreadModel{
	FERService ferservice = null;

	@Override
	public void init(ServletConfig config) throws ServletException {
		ferservice = new FERServiceimpl();
		super.init(config);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		int id = ferservice.login(username, password);
		PrintWriter out = response.getWriter();

		if (id > 0) {
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			session.setAttribute("id", id);

			HTMLUtil.displayHeaderAndLeftFrame(request, response, out, username);
			out.println("welcome to  the user:" + username);
			HTMLUtil.displayFooter(request, response);

		} else {
			out.println("Login failed...");

			RequestDispatcher rd = request.getRequestDispatcher("Login.html");
			rd.include(request, response);
		}

	}

	@Override
	public void destroy() {
		ferservice = null;
	}

}
