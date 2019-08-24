package com.rs.fer.main;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.rs.fer.bean.User;
import com.rs.fer.service.FERService;
import com.rs.fer.serviceimpl.FERServiceimpl;

public class Registration {

	public static void main(String[] args) {

		FERService ferservice = new FERServiceimpl();
		User user = new User();

		user.setFirstname("Sudi");
		user.setMiddlename("reddy");
		user.setLastname("Dev");
		user.setUsername("devi");
		user.setPassword("dev123");
		user.setEmail("sudi@gmail.com");
		user.setMobile("9864588");

		boolean isRegister = ferservice.registration(user);
		if (isRegister) {
			System.out.println("Succesfully inserted");
		} else {
			System.out.println("try again");

		}

	}
}

		

	
