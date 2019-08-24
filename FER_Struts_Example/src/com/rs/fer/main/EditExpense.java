package com.rs.fer.main;

import com.rs.fer.bean.Expense;
import com.rs.fer.service.FERService;
import com.rs.fer.serviceimpl.FERServiceimpl;

public class EditExpense {

	public static void main(String[] args) {
		Expense expense1 = new Expense();

		expense1.setType("grociers");
		expense1.setDate("2019-07-30");
		expense1.setPrice(1000);
		expense1.setNumberOfIteams(6);
		expense1.setTotal(10000);
		expense1.setBywhom("MSKR");
		expense1.setId(3);

		FERService ferService1 = new FERServiceimpl();

		boolean isEdited = ferService1.editExpense(expense1);

		if (isEdited) {
			System.out.println(" expenses updated successfully...");
		} else {
			System.out.println("expense updation failed...");
		}


	}

}
