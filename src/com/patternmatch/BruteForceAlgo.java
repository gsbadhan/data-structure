package com.patternmatch;

/**
 * pattern matching using brute-force algorithm
 *
 */
public class BruteForceAlgo {

	public static void main(String args[]) {
		String text = "abcdgjkluysgetidoghjklfsyi";
		String pattern = "idoghj";
		boolean isMatched = bruteForceAlgo(text, pattern);
		System.out.println("pattren found or not ?:" + isMatched);
	}

	private static boolean bruteForceAlgo(String text, String pattern) {
		int j = 0;
		for (int i = 0; i < text.length(); i++) {
			if (text.charAt(i) == pattern.charAt(j)) {
				// increment to next position of pattern
				j++;
			} else {
				// go to start of pattern
				j = 0;
			}

			// if full pattern matched then stop
			if (j == pattern.length()) {
				return true;
			}
		}
		return false;
	}
}
