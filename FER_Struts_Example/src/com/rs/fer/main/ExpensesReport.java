package com.rs.fer.main;

import java.util.List;

import com.rs.fer.bean.Expense;
import com.rs.fer.service.FERService;
import com.rs.fer.serviceimpl.FERServiceimpl;

public class ExpensesReport {

	public static void main(String[] args) {
	FERService ferService1 = new FERServiceimpl();
		
		int userid=5;
		String Type= "phone";
		String fromDate= "2019-07-30";
		String toDate= "2019-08-05";
		List<Expense> expense = ferService1.getexpensesReport(userid, Type, fromDate, toDate);
		if(expense!=null) {
			System.out.println("expenses fetched succesfully");
		}else {
			System.out.println("not found");
		}


	}

}
