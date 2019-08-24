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

@WebServlet("/displayAddress")
public class DisplayAddressInfo extends HttpServlet {
	FERService ferservice = null;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		ferservice = new FERServiceimpl();
		PrintWriter out = response.getWriter();
		//int id = Integer.parseInt(session.getAttribute("id").toString());

		User personalInfo = (User) session.getAttribute("personalInfo");
		
		 personalInfo.setMobile(request.getParameter("mobile"));
		 personalInfo.setEmail(request.getParameter("email"));
		// personalInfo.setLastname(request.getParameter("lastname"));
		 session.setAttribute("personalInfo", personalInfo);

		//User user = new User();
		
		HTMLUtil.displayHeaderAndLeftFrame(request, response, out, session.getAttribute("username").toString());

		out.println("<table align=\"center\" border=\"1\" >");
		out.println("<tr>");
		out.println("<td  colspan='2'  align='center'>AddressInfo</td>");
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
		out.println("<a href=javascript:submitForm('displayReview')>Next</a>");
		out.println("</td>");
		out.println("</tr>");
		out.println("</table>");

		HTMLUtil.displayFooter(request, response);
	}
}