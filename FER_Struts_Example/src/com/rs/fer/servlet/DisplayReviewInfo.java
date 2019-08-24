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

@WebServlet("/displayReview")
public class DisplayReviewInfo extends HttpServlet {
	FERService ferservice = null;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		ferservice = new FERServiceimpl();
		int id = Integer.parseInt(session.getAttribute("id").toString());

		User personalInfo = (User) session.getAttribute("personalInfo");
		
		 personalInfo.getAddress().setLineOne(request.getParameter("lineone"));
		 personalInfo.getAddress().setLineTwo(request.getParameter("linetwo"));
		 personalInfo.getAddress().setStreet(request.getParameter("street"));
		 personalInfo.getAddress().setCity(request.getParameter("city"));
		 personalInfo.getAddress().setState(request.getParameter("state"));
		 personalInfo.getAddress().setZip(request.getParameter("zip"));
		 //personalInfo.setEmail(request.getParameter("email"));
		// personalInfo.setLastname(request.getParameter("lastname"));
		 session.setAttribute("personalInfo", personalInfo);

		User user = new User();
		PrintWriter out = response.getWriter();
		HTMLUtil.displayHeaderAndLeftFrame(request, response, out, session.getAttribute("username").toString());

		out.println("<table align=\"center\" border=\"1\" >");
		out.println("<tr>");
		out.println("<td  colspan='2'  align='center'>Review</td>");
		out.println("</tr>");
		
		
		out.println("<tr>");
		out.println("<td>FirstName</td>");
		out.println("<td><input type='text' name='firstname' value='" + personalInfo.getFirstname() + "'></td>");
		out.println("</tr>");

		out.println("<tr>");
		out.println("<td>MiddleName</td>");
		out.println("<td><input type='text' name='middlename' value='" + personalInfo.getMiddlename() + "'></td>");
		out.println("</tr>");

		out.println("<tr>");
		out.println("<td>LasttName</td>");
		out.println("<td><input type='text' name='lastname' value='" + personalInfo.getLastname() + "'></td>");
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
		out.println("<td>LineOne</td>");
		out.println("<td><input type='text' name='lineone' value='" + personalInfo.getAddress().getLineOne() + "'></td>");
		out.println("</tr>");

		out.println("<tr>");
		out.println("<td>LineTwo</td>");
		out.println("<td><input type='text' name='linetwo' value='" + personalInfo.getAddress().getLineTwo() + "'></td>");
		out.println("</tr>");

		out.println("<tr>");
		out.println("<td>Street</td>");
		out.println("<td><input type='text' name='street' value='" + personalInfo.getAddress().getStreet() + "'></td>");
		out.println("</tr>");
		
		
		out.println("<tr>");
		out.println("<td>City</td>");
		out.println("<td><input type='text' name='city' value='" + personalInfo.getAddress().getCity() + "'></td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td>State</td>");
		out.println("<td><input type='text' name='state' value='" + personalInfo.getAddress().getState() + "'></td>");
		out.println("</tr>");

		out.println("<tr>");
		out.println("<td>Zip</td>");
		out.println("<td><input type='text' name='zip' value='" + personalInfo.getAddress().getZip() + "'></td>");
		out.println("</tr>");

		
		out.println("<tr>");
		out.println("<td colspan='2' align='center'>");
		out.println("<a href=javascript:submitForm('displayStatus')>Next</a>");
		out.println("</td>");
		out.println("</tr>");
		out.println("</table>");

		HTMLUtil.displayFooter(request, response);
	}
}