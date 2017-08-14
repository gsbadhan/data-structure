package com.strings;

import java.util.Arrays;

public class LongestCommonSubsequence {

	public static void main(String[] args) {
		String a = "ABAZDC";
		String b = "BACBAD";
		LCS2(a.toCharArray(), b.toCharArray(), a.length(), b.length());
	}

	private static void LCS2(char[] a, char[] b, int al, int bl) {
		int lcs[][] = new int[a.length + 1][b.length + 1];

		for (int ai = 0; ai <= a.length; ai++) {
			for (int bi = 0; bi <= b.length; bi++) {
				System.out.println(Arrays.deepToString(lcs));
				if (ai == 0 || bi == 0) {
					lcs[ai][bi] = 0;
				} else if (a[ai - 1] == b[bi - 1]) {
					lcs[ai][bi] = 1 + lcs[ai - 1][bi - 1];
				} else {
					lcs[ai][bi] = Math.max(lcs[ai][bi - 1], lcs[ai - 1][bi]);
				}
			}
		}

	}

	private static int LCS(char[] a, char[] b, int al, int bl) {
		if (a[al - 1] == b[bl - 1]) {
			return 1 + LCS(a, b, al - 1, bl - 1);
		} else {
			int max = Math.max(LCS(a, b, al - 1, bl), LCS(a, b, al, bl - 1));
			return max;
		}

	}

}
