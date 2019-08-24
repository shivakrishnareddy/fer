package com.rs.fer.main;

import com.rs.fer.service.FERService;
import com.rs.fer.serviceimpl.FERServiceimpl;

public class Delete {

	public static void main(String[] args) {
		
		int expenseid= 56;

		FERService ferService1 = new FERServiceimpl();

		boolean isDeleted = ferService1.deleteExpense(expenseid);

		if (isDeleted) {
			System.out.println(" expenses deleted successfully...");
		} else {
			System.out.println("expense deleted  failed...");
		}

	}

}
