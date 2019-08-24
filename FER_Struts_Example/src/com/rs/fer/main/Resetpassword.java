package com.rs.fer.main;

import com.rs.fer.service.FERService;
import com.rs.fer.serviceimpl.FERServiceimpl;

public class Resetpassword {

	public static void main(String[] args) {
		FERService ferService1 = new FERServiceimpl();
		int userId = 5;
		String currentPassword = "shiva";
		String newPassword = "reddy";

		boolean isResetPassword = ferService1.resetPassword(userId, currentPassword, newPassword);

		if (isResetPassword) {
			System.out.println(" RESET PASSWORD SUSSFULLY");
		} else {
			System.out.println("RESET PASSWORD FAILED");
		}

	}

}
