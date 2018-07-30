package com.miscellaneous.questions;

/**
 * find minimum jump to reach end of array
 */
public class FindMinimumJumpToReachEndOfArray {

	public static void main(String[] args) {
		int[] userInput = { 2, 1, 3, 2, 3, 4, 5, 1, 2, 8 };

		findMinimumJumpToReachEndOfArray(userInput);
	}

	private static void findMinimumJumpToReachEndOfArray(int[] userInput) {
		// to track minimum jump
		int[] minJumps = initializeArray(new int[userInput.length]);
		// to track jumps from source index
		int[] fromJumps = new int[userInput.length];

		for (int i = 1; i < minJumps.length; i++) {
			for (int j = 0; j < i; j++) {
				if ((j + userInput[j]) >= i) {
					if ((minJumps[j] + 1) < minJumps[i]) {
						minJumps[i] = minJumps[j] + 1;
						fromJumps[i] = j;
					}
				}
			}
		}

		System.out.println("minimum jump required:" + minJumps[minJumps.length - 1]);
		findIndicesOfJump(fromJumps);
	}

	private static void findIndicesOfJump(int[] fromJumps) {
		int start = fromJumps.length - 1;
		while (start > 0) {
			System.out.print(start + " ");
			start = fromJumps[start];
		}
		System.out.print(start + " ");
	}

	// initialize array with maximum value or infinity from 1 index
	private static int[] initializeArray(int[] arr) {
		arr[0] = 0;
		for (int i = 1; i < arr.length; i++) {
			arr[i] = Integer.MAX_VALUE ;
		}
		return arr;
	}

}
