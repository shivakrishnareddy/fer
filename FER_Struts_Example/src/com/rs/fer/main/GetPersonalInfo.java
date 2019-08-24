package com.rs.fer.main;

import com.rs.fer.bean.User;
import com.rs.fer.service.FERService;
import com.rs.fer.serviceimpl.FERServiceimpl;

public class GetPersonalInfo {

	public static void main(String[] args) {

		FERService ferService = new FERServiceimpl();
		int userid = 5 ;
		User getPeronnalInfo = ferService.getPersonalInfo(userid);
		if ( getPeronnalInfo != null) {
			System.out.println("personal info fetched");
		} else {
			System.out.println("personal info not fetched");
		}
	}

}
