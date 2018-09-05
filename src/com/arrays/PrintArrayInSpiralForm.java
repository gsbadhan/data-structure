package com.arrays;

import java.util.Arrays;

/**
 * print 2D array in spiral form
 *
 */
public class PrintArrayInSpiralForm {

	public static void main(String args[]) {
		int[][] arr = { { 1, 2, 3, 4, 5, 6 }, { 7, 8, 9, 10, 11, 12 }, { 13, 14, 15, 16, 17, 18 },{ 19, 20, 21, 22, 23, 24 },{ 25, 26, 27, 28, 29, 30 }};
		for (int[] row : arr) {
			System.out.println(Arrays.toString(row));
		}
		spiralPrint(arr);
		
		int [][] arr2 = { { 1, 2, 3, 4 }, { 7, 8, 9, 10 }, { 13, 14, 15, 16 },{ 19, 20, 21, 22 },{ 25, 26, 27, 28 }};
		for (int[] row : arr2) {
			System.out.println(Arrays.toString(row));
		}
		spiralPrint(arr2);
		
		int [][] arr3 = { { 1, 2, 3 }, { 7, 8, 9 }, { 13, 14, 15}};
		for (int[] row : arr3) {
			System.out.println(Arrays.toString(row));
		}
		spiralPrint(arr3);
	}

	private static void spiralPrint(int[][] arr) {
		//top right column
		int topRightColumn = arr[0].length - 1;
		//bottom left column
		int bottomLeftColumn = 0;
		//start row index
		int upperRow = 0;
		//last row index
		int lastRow = arr.length - 1;
		while (upperRow <= lastRow) {
			for (int i = upperRow; i <= topRightColumn; i++) {
				System.out.print(arr[upperRow][i] + " ");
			}
			for (int i = upperRow + 1; i <= lastRow; i++) {
				System.out.print(arr[i][topRightColumn] + " ");
			}

			if(upperRow==lastRow)
				break;
			
			for (int i = lastRow - 1; i >= bottomLeftColumn; i--) {
				System.out.print(arr[lastRow][i] + " ");
			}
			for (int i = lastRow - 1; i > upperRow; i--) {
				System.out.print(arr[i][bottomLeftColumn] + " ");
			}

			upperRow++;
			lastRow--;
			topRightColumn--;
			bottomLeftColumn++;
		}
		System.out.println();
	}
}
