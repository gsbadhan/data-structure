package com.patternmatch;

public class ZAlgo {

	public static void main(String args[]) {
		String text = "abxabcabcaby";
		String pattern = "abc";
		boolean isMatched = zAlgo(text, pattern);
		System.out.println("pattern found or not ?:" + isMatched);
	}

	private static boolean zAlgo(String text, String pattern) {
		int[] zArr = buildZArr(text, pattern);

		boolean isMatched = false;
		for (int i = pattern.length() + 1; i < zArr.length; i = i + pattern.length()) {
			if (zArr[i] == pattern.length()) {
				System.out.println("pattern matched at index:" + i);
				isMatched = true;
			}
		}
		return isMatched;
	}

	private static int[] buildZArr(String text, String pattern) {
		String zText = pattern + "$" + text;
		// Z text pre-processing
		int[] zArr = new int[zText.length()];
		for (int z = 1; z < zText.length(); z++) {
			int leftIndx = 0;
			int rightIndx = z;

			int charMatchCount = 0;
			while (zText.charAt(leftIndx) == zText.charAt(rightIndx)) {
				charMatchCount++;
				leftIndx++;
				rightIndx++;
				if(rightIndx>=zText.length()){
					break;
				}
			}
			zArr[z] = charMatchCount;
		}
		return zArr;
	}
}
