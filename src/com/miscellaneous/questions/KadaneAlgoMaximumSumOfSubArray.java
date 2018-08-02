package com.miscellaneous.questions;

/**
 * 
 * Kadane's Algo
 */
public class KadaneAlgoMaximumSumOfSubArray {

	public static void main(String[] args) {
		// array can contains +ve and -ve numbers
		int[] arr = { -2, 3, 2, -1, -2, 9 };

		// 1. 1st example will print maximum sum only
		findMaximumSumOfSubArray(arr);

		// 1. 2nd example will print maximum sum and {start,end} of sub array
		findMaximumSumOfSubArrayWithStartAndEnd(arr);

	}

	/**
	 * print maximum sum of sub array
	 */
	public static void findMaximumSumOfSubArray(int[] arr) {
		int currentMaxSum;
		int globalMaxSum;
		currentMaxSum = globalMaxSum = arr[0];
		for (int i = 1; i < arr.length; i++) {
			currentMaxSum = max(arr[i], currentMaxSum + arr[i]);
			if (currentMaxSum > globalMaxSum) {
				globalMaxSum = currentMaxSum;
			}
		}
		System.out.println("max sum of sub-array:" + globalMaxSum);
	}

	/**
	 * print maximum sum and start,end of sub array
	 */
	public static int[] findMaximumSumOfSubArrayWithStartAndEnd(int[] arr) {
		int currentMaxSum;
		int globalMaxSum;
		int startOfSum = 0;
		int endOfSum = 0;
		currentMaxSum = globalMaxSum = arr[0];

		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > (currentMaxSum + arr[i])) {
				startOfSum = endOfSum = i;
				currentMaxSum = arr[i];
			} else {
				currentMaxSum = currentMaxSum + arr[i];
			}

			if (currentMaxSum > globalMaxSum) {
				globalMaxSum = currentMaxSum;
				endOfSum = i;
			}
		}

		System.out.println("max sum of sub-array:" + globalMaxSum + " from:" + startOfSum + "," + endOfSum);

		return new int[] { globalMaxSum, startOfSum, endOfSum };
	}

	private static int max(int a, int b) {
		return a > b ? a : b;
	}

}
