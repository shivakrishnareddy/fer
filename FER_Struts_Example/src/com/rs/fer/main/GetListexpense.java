package com.rs.fer.main;
import java.util.List;

import com.rs.fer.bean.Expense;
import com.rs.fer.service.FERService;
import com.rs.fer.serviceimpl.FERServiceimpl;

public class GetListexpense {

	public static void main(String[] args) {
		FERService ferService1 = new FERServiceimpl();
		
		int userid=5;
		List<Expense> expense = ferService1.getExpenses(userid);
		if(expense!=null) {
			System.out.println("expenses fetched succesfully");
		}else {
			System.out.println("not found");
		}

	}

}
