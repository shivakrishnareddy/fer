package com.rs.fer.main;

import com.rs.fer.bean.Expense;
import com.rs.fer.service.FERService;
import com.rs.fer.serviceimpl.FERServiceimpl;

public class AddExpenses {

	public static void main(String[] args) {
		Expense addexpense = new Expense();

		addexpense.setType("Medicin");
		addexpense.setDate("2019-07-30");
		addexpense.setPrice(1000);
		addexpense.setNumberOfIteams(6);
		addexpense.setTotal(10000);
		addexpense.setBywhom("skr");
		addexpense.setUserid(5);

		FERService ferService1 = new FERServiceimpl();

		boolean isAdded = ferService1.addExpense(addexpense);

		if (isAdded) {
			System.out.println(" expense Added successfully...");
		} else {
			System.out.println("expense Adding failed...");
		}

	}

}
