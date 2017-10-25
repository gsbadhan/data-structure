package com.patternmatch;

/**
 * 
 * pattern matching using KMP algorithm
 */
public class KMPAlgo {

	public static void main(String args[]) {
		String text = "abxabcabcaby";
		String pattern = "abcaby";
		boolean isMatched = kmpAlgo(text, pattern);
		System.out.println("pattern found or not ?:" + isMatched);
	}

	private static boolean kmpAlgo(String text, String pattern) {
		int[] compilePattern = getCompilePattern(pattern);
		return checkPattrenInText(text, pattern, compilePattern);
	}

	private static boolean checkPattrenInText(String text, String pattern, int[] compilePattern) {
		int j = 0;
		for (int i = 0; i < text.length(); i++) {
			while (true) {
				if (text.charAt(i) == pattern.charAt(j)) {
					j = j + 1;
					break;
				} else {
					j = j - 1;
					if (j < 0) {
						j = 0;
						break;
					}
					j = compilePattern[j];
				}
			}

			if (j == pattern.length()) {
				return true;
			}
		}
		return false;
	}

	private static int[] getCompilePattern(String pattern) {
		int[] compilePattern = new int[pattern.length()];
		int j = 0;
		for (int i = 1; i < pattern.length(); i++) {
			while (true) {
				if (pattern.charAt(j) == pattern.charAt(i)) {
					j = j + 1;
					compilePattern[i] = j;
					break;
				} else {
					j = j - 1;
					if (j < 0) {
						j = 0;
						break;
					}
					j = compilePattern[j];
				}
			}
		}
		return compilePattern;
	}
}
