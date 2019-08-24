package com.rs.fer.main;

import com.rs.fer.bean.Address;
import com.rs.fer.bean.User;
import com.rs.fer.service.FERService;
import com.rs.fer.serviceimpl.FERServiceimpl;

public class UpdatePersonalInfo {

	public static void main(String[] args) {
		FERService ferService = new FERServiceimpl();

		User user = new User();
		user.setFirstname("shivak");
		user.setMiddlename("");
		user.setLastname("reddy");
		user.setEmail("ms@gmail.com");
		user.setMobile("851676452");
		user.setId(1);
		
		Address address = new Address();
		address.setLineOne("sri sai krupa");
		address.setLineTwo("jai hind enclave");
		address.setStreet("karvy road");
		address.setCity("hyd");
		address.setState("tg");
		address.setZip("500004");
		address.setUserid(1);

		user.setAddress(address);
		boolean updatePersonal = ferService.updatePersonalInfo(user);
		if (updatePersonal) {
			System.out.println("updated personnalinfo succesfully");
		} else {
			System.out.println("not found");

		}

	}

}
