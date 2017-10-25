package com.patternmatch;

import java.util.LinkedHashMap;
import java.util.Map;

/*
 * pattern matching using boyer-moore algorithm
 */
public class BoyerMooreAlgo {

	public static void main(String args[]) {
		String text = "this pattern search test case1, find if you can !!";
		String pattern = "test";
		boolean isMatched = boyerMooreAlgo(text, pattern);
		System.out.println("pattern found or not ?:" + isMatched);
	}

	private static boolean boyerMooreAlgo(String text, String pattern) {
		Map<Character, Integer> badMatchTable = buildBadMatchTable(pattern);
		System.out.println("bad match table:" + badMatchTable);
		return checkPattrenInText(text, pattern, badMatchTable);
	}

	private static boolean checkPattrenInText(String text, String pattern, Map<Character, Integer> badMatchTable) {
		int textIndex = pattern.length() - 1;
		int patrnIndex = pattern.length() - 1;
		while (textIndex < text.length()) {
			if (text.charAt(textIndex) == pattern.charAt(patrnIndex)) {
				textIndex--;
				patrnIndex--;
			} else {
				if (badMatchTable.containsKey(text.charAt(textIndex))) {
					textIndex += badMatchTable.get(text.charAt(textIndex));
				} else {
					textIndex += badMatchTable.get('*');
				}
				patrnIndex = pattern.length() - 1;
			}
			
			if (patrnIndex == 0) {
				return true;
			}
		}
		return false;
	}

	private static Map<Character, Integer> buildBadMatchTable(String pattern) {
		Map<Character, Integer> uniqueCharTable = new LinkedHashMap<>();
		/*
		 * mandatory: default sentinel i.e. * must be set total length of
		 * pattern
		 */
		uniqueCharTable.put('*', pattern.length());
		for (int i = 0; i < pattern.length(); i++) {
			int badMatchIndex = pattern.length() - i - 1;
			if (i == (pattern.length() - 1)) {
				uniqueCharTable.put(pattern.charAt(i), pattern.length());
			} else {
				uniqueCharTable.put(pattern.charAt(i), badMatchIndex);
			}
		}
		return uniqueCharTable;
	}
}
