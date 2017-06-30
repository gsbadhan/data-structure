package com.strings;

import java.util.ArrayList;
import java.util.List;

public class StringPermutation {

	public static void main(String[] args) {
		String str = "12345";
		permutation(str);

	}

	private static void permutation(String str) {
		List<String> list = substring(str);
		System.out.println(list.size());
		System.out.println(list);
	}

	public static List<String> substring(String input) {
		List<String> lastList = new ArrayList<>();
		// If input string's length is 1, return {s}. otherwise call substring
		if (input.length() == 1) {
			lastList.add(input);
			return lastList;
		}

		int lastIndex = input.length() - 1;
		// Find out the last character
		String lastChar = input.substring(lastIndex);
		// Rest of the string
		String restString = input.substring(0, lastIndex);
		// Perform permutation on the rest string and
		lastList = substring(restString);
		// merge with the last character
		lastList = merge(lastList, lastChar);
		return lastList;
	}

	public static List<String> merge(List<String> list, String c) {
		List<String> res = new ArrayList<>();
		// Loop through all the string in the list
		for (String s : list) {
			// For each string, insert the last character to all possible
			// positions
			// and add them to the new list
			for (int i = 0; i <= s.length(); ++i) {
				String ps = new StringBuffer(s).insert(i, c).toString();
				res.add(ps);
			}
		}
		return res;
	}

}
