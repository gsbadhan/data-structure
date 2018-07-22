package com.strings;


public class LongestCommonSubsequence {

	public static void main(String[] args) {
		String a = "ABAZDC";
		String b = "BACBAD";
		LCS(a.toCharArray(), b.toCharArray());
	}

	private static void LCS(char[] a, char[] b) {
		int lcs[][] = new int[a.length + 1][b.length + 1];

		for (int i = 0; i <= a.length; i++) {
			for (int j = 0; j <= b.length; j++) {
				if (i == 0 || j == 0) {
					lcs[i][j] = 0;
				} else if (a[i - 1] == b[j - 1]) {
					lcs[i][j] = 1 + lcs[i - 1][j - 1];
				} else {
					lcs[i][j] = Math.max(lcs[i][j - 1], lcs[i - 1][j]);
				}
			}
		}
		System.out.println("longest sequence:" + lcs[a.length][b.length]);
	}


}
