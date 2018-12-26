package com.crm.qa.base;

import java.util.HashMap;

public class TestData {
	
	public static HashMap<String, String> getUserLoginDetails() {
	HashMap<String, String> userlogin = new HashMap<String, String>();
	userlogin.put("user1", "Vikas22jan_abc@123");
	userlogin.put("user2", "Vikas22_abc@123");
	return userlogin;
	}

	public static HashMap<Integer, String> getMonth() {
		HashMap<Integer,String> monthmap = new HashMap<Integer, String>();
		monthmap.put(1, "January");
		monthmap.put(2, "February");
		monthmap.put(3, "March");
		monthmap.put(4, "April");
		monthmap.put(5, "May");
		monthmap.put(6, "June");
		monthmap.put(7, "July");
		monthmap.put(8, "August");
		monthmap.put(9, "September");
		monthmap.put(10, "October");
		monthmap.put(11, "November");
		monthmap.put(12, "December");
		
		return monthmap;
	}
	
}
