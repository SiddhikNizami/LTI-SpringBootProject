package com.crs.lt.util;

import java.util.Random;

public class Utils {

	public static void printStatement(String msg) {
		System.out.println(msg);
	}
	
	public static String generateRefNumber() {
		Random rnd = new Random();
	    int number = rnd.nextInt(999999) + 1000000000;
		return String.format("REF%10d", number);
	}
}
