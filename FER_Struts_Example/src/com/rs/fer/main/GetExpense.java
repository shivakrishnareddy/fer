package com.rs.fer.main;

import com.rs.fer.bean.Expense;
import com.rs.fer.service.FERService;
import com.rs.fer.serviceimpl.FERServiceimpl;

public class GetExpense {

	public static void main(String[] args) {
		
	FERService ferService1 = new FERServiceimpl();
	
	int expenseId= 3;
	Expense expense= ferService1.getExpense(expenseId);
	if(expense!=null) {
		System.out.println("expenses fetched succesfully");
	}else {
		System.out.println("not found");
	}

}
	}
