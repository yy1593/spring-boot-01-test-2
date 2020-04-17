package com.gyhl.test.regex;

public class RegexTest {

	public static void main(String[] args) {
		RegexTest test=new RegexTest();
		System.out.println(test.is19xx("19000"));
		System.out.println("\u548c");
	}
	
	public static boolean is19xx(String s) {
		return s.matches("19\\d\\d");
	}
}
