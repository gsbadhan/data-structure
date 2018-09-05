package com.arrays;

import java.util.Arrays;

/**
 * print 2D array digonally
 *
 */
public class PrintArrayDiagonally {

	public static void main(String[] args) {
		// 4x6 2D array
		int[][] arr = { { -1, -2, -3, -4, -5, -6 }, { -7, -8, -9, 10, 11, 12 }, { 13, 14, 15, 16, 17, 18 },
				{ 19, 20, 21, 22, 23, 24 } };
		for (int[] row : arr) {
			System.out.println(Arrays.toString(row));
		}

		printArrayDiagonally(arr);
	}

	private static void printArrayDiagonally(int[][] arr) {
		int rowLen = arr.length;
		int columnLen = arr[0].length;

		int row = 0;
		// print upper diagonal
		while (row < rowLen) {
			int j = 0;
			for (int i = row; i >= 0; i--) {
				System.out.print(arr[i][j] + " ");
				j++;
			}
			row++;
			System.out.println();
		}

		// print lower diagonal
		int col = 1;
		while (col < columnLen) {
			int j = col;
			for (int i = rowLen - 1; i >= 0 && j < columnLen; i--) {
				System.out.print(arr[i][j] + " ");
				j++;
			}
			col++;
			System.out.println();
		}
	}

}
