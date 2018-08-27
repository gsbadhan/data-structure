package com.miscellaneous.questions;

public class SubsetSumUsingBacktracking {

	public static void main(String args[]) {
		int[] set = { 0, 1, 4, 2, 3, 2 };
		int givenSum = 8;

		findSubsetSum(set, givenSum);
	}

	private static void findSubsetSum(int[] set, int givenSum) {
		int totalSum = totalSum(set);
		subsetSum(givenSum, set, 0, 0, totalSum);
	}

	private static void subsetSum(int givenSum, int[] set, int index, int currentSum, int totalSum) {

		if (currentSum == givenSum) {
			System.out.println("found:" + currentSum + " tail:");
			return;
		}

		if (index >= set.length || currentSum > givenSum ) {
			return;
		}

		subsetSum(givenSum, set, index + 1, (currentSum + set[index]), (totalSum - set[index]));
		subsetSum(givenSum, set, index + 1, currentSum, (totalSum - set[index]));

	}

	private static int totalSum(int[] ar) {
		int sum = 0;
		for (int i = 0; i < ar.length; i++) {
			sum += ar[i];
		}
		return sum;
	}
}
