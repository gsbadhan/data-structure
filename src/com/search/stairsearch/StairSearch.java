package com.search.stairsearch;

import java.util.Arrays;

/**
 * 
 * search in 2D sorted array. Array is sorted row wise and column wise
 *
 * Searching using Stair Search. complexity will be O(n) time.
 */
public class StairSearch {

	public static void main(String[] args) {
		int[][] sortedArr = { { 10, 20, 30, 40, 50, 60 }, { 15, 22, 34, 43, 56, 65 }, { 17, 25, 35, 45, 57, 66 },
				{ 21, 31, 39, 49, 59, 70 } };

		for (int[] row : sortedArr) {
			System.out.println(Arrays.toString(row));
		}

		int data = 65;
		int[] found = find(sortedArr, data);
		if (found != null) {
			System.out.println("found at index: i[" + found[0] + "]j[" + found[1] + "]");
		} else {
			System.out.println("not found..!!");
		}
	}

	private static int[] find(int[][] arr, int data) {
		int[] foundIndx = null;
		int i = 0;
		int j = arr[0].length - 1;
		while (i < arr.length && j >= 0) {
			if (data == arr[i][j]) {
				foundIndx = new int[] { i, j };
				return foundIndx;
			} else if (data > arr[i][j]) {
				i++;
			} else if (data < arr[i][j]) {
				j--;
			}
		}
		return foundIndx;
	}

}
