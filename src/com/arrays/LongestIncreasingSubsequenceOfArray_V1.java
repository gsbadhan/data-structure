package com.arrays;

import java.util.Arrays;

/**
 * Longest increasing subsequence of array
 *
 *@see solved using DP 
 */
public class LongestIncreasingSubsequenceOfArray_V1 {

	public static void main(String[] args) {
		int[] arr = { 3, 4, -1, 0, 6, 2, 3 };
		System.out.println(Arrays.toString(arr));
		int longest = findLongestSubsequence(arr);
		System.out.println("longest incraesing subsequence:" + longest);
	}

	private static int findLongestSubsequence(int[] arr) {
		// temporary to track longest subsequence
		int[] countArr = new int[arr.length];
		defaultInitialisation(countArr);
		System.out.println(Arrays.toString(countArr));
		int max = 1;
		for (int i = 1; i < arr.length; i++) {
			//reset j on each iteration
			int j = 0;
			while (j < i) {
				if (arr[j] < arr[i]) {
					countArr[i] = Math.max(countArr[i], countArr[j] + 1);
					if (countArr[i] > max) {
						max = countArr[i];
					}
				}
				j++;
			}
		}
		System.out.println(Arrays.toString(countArr));
		return max;
	}

	private static void defaultInitialisation(int[] countArr) {
		for (int i = 0; i < countArr.length; i++) {
			countArr[i] = 1;
		}
	}

}
