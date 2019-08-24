package com.rs.fer.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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

@WebServlet("/displayPersonalContact")
public class DisplayContactInfoServlet extends HttpServlet {
	FERService ferservice = null;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		ferservice = new FERServiceimpl();
		int id = Integer.parseInt(session.getAttribute("id").toString());

		User personalInfo = (User) session.getAttribute("personalInfo");
		
		 personalInfo.setFirstname(request.getParameter("firstname"));
		 personalInfo.setMiddlename(request.getParameter("middlename"));
		 personalInfo.setLastname(request.getParameter("lastname"));
		 
		 session.setAttribute("personalInfo", personalInfo);
		//User user = new User();

		PrintWriter out = response.getWriter();
		HTMLUtil.displayHeaderAndLeftFrame(request, response, out, session.getAttribute("username").toString());

		out.println("<table align=\"center\" border=\"1\" >");
		out.println("<tr>");
		out.println("<td  colspan='2'  align='center'>UpdateContact</td>");
		out.println("</tr>");

		out.println("<tr>");
		out.println("<td>Mobile</td>");
		out.println("<td><input type='text' name='mobile' value='" + personalInfo.getMobile() + "'></td>");
		out.println("</tr>");

		out.println("<tr>");
		out.println("<td>Email</td>");
		out.println("<td><input type='text' name='email' value='" + personalInfo.getEmail() + "'></td>");
		out.println("</tr>");


		out.println("<tr>");
		out.println("<td colspan='2' align='center'>");
		out.println("<a href=javascript:submitForm('displayAddress')>Next</a>");
		out.println("</td>");
		out.println("</tr>");
		out.println("</table>");

		HTMLUtil.displayFooter(request, response);
	}
}
