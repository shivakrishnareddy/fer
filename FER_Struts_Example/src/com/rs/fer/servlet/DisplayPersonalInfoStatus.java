package com.rs.fer.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rs.fer.bean.User;
import com.rs.fer.service.FERService;
import com.rs.fer.serviceimpl.FERServiceimpl;
import com.rs.fer.util.HTMLUtil;

@WebServlet("/displayStatus")
public class DisplayPersonalInfoStatus extends HttpServlet {
	FERService ferservice=null;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		ferservice = new FERServiceimpl();
		
	}
 

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session= request.getSession();
		
		PrintWriter out=response.getWriter();
		HTMLUtil.displayHeaderAndLeftFrame(request, response, out, session.getAttribute("username").toString());
		
		User personalInfo = (User) session.getAttribute("personalInfo");
		
		int id=Integer.parseInt(session.getAttribute("id").toString());
		session.setAttribute("personalInfo",personalInfo);
		boolean updatePersonal=ferservice.updatePersonalInfo(personalInfo);
		
		
			
			out.println(updatePersonal ? "updated successfully..":"updated failed..");
			
			HTMLUtil.displayFooter(request, response);
			
		
		
	}
	@Override
	public void destroy() {
		ferservice =null;
	}

	
	}


