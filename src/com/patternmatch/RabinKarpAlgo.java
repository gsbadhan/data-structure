package com.patternmatch;

public class RabinKarpAlgo {

	public static void main(String args[]) {
		String text = "abxabcabcaby";
		String pattern = "cab";
		boolean isMatched = rabinKarpAlgo(text, pattern);
		System.out.println("pattern found or not ?:" + isMatched);
	}

	private static boolean rabinKarpAlgo(String text, String pattern) {
		if (pattern.length() > text.length()) {
			System.out.println("pattern should be greater than text!!");
			return false;
		}

		// choose good prime number to avoid hash conflict
		final int PRIME_FACTOR = 31;
		long patrnHash = getHash(pattern, PRIME_FACTOR);
		
		int start = 0;
		int end = pattern.length();
		long txtHash = 0;
		while (true) {
			txtHash = getHash(txtHash, text.charAt(start), text, start, end, PRIME_FACTOR);

			if (patrnHash == txtHash) {
				return true;
			}
			start += 1;
			end = start + pattern.length();
			if (end > text.length()) {
				break;
			}
		}
		return false;
	}

	private static long getHash(long oldHash, int previousCharAscii, String text, int start, int end, int primeFactor) {
		if (oldHash > 0) {
			oldHash = (oldHash - previousCharAscii) / primeFactor;
		}
		long hash = text.charAt(start);
		int j = 1;
		for (int i = start + 1; i < end; i++) {
			if (i - 1 == end) {
				hash = (long) (hash + (oldHash + text.charAt(i) * Math.pow(primeFactor, j)));
			} else {
				hash = (long) (hash + (text.charAt(i) * Math.pow(primeFactor, j)));
			}
			j++;
		}
		return hash;
	}

	private static long getHash(String str, int primeFactor) {
		long hash = str.charAt(0);
		for (int i = 1; i < str.length(); i++) {
			hash = (long) (hash + (str.charAt(i) * Math.pow(primeFactor, i)));
		}
		return hash;
	}

}
