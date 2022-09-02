package com.makarong;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorTest {
	
	Comparator<String> c = new Comparator<String>() {
		
		public int compare(String str1, String str2) {
			
			int answer = Integer.compare(str2.length(), str1.length());
			System.out.println("str1 : " + str1 + ", str2 : " + str2);
			System.out.println("Integer.compare(str2.length(), str1.length() " + answer);
			return Integer.compare(str2.length(), str1.length());
		}
	};
	
	public static void main(String [] args) {
		
		String[] strs = {"na", "n", "a", "banana"};
		ComparatorTest compareTest = new ComparatorTest();
		
		Arrays.sort(strs, compareTest.c);
		
		for(int i=0; i < strs.length; i++) {
			System.out.println("strs " +strs[i]);
		}
	}

}
