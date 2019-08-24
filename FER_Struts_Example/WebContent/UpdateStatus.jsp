<%@page import="com.rs.fer.serviceimpl.FERServiceImpl"%>
<%@page import="com.rs.fer.bean.User"%>
<%@page import="com.rs.fer.service.FERService"%>
<% 
FERService ferService = new FERServiceImpl();		
		User personalInfo = (User) session.getAttribute("personalInfo");
		session.setAttribute("personalInfo", personalInfo);

		boolean updatePersonal = ferService.updatePersonal(personalInfo);


		out.println(updatePersonal ? "updated successfully..." : "update failed....");
%>