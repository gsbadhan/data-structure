package com.miscellaneous.questions;

public class MaximumSumOfSubRectangleOf2DArray {

	public static void main(String[] args) {
		int[][] arr = { { 2, 1, -3, -4, 5 }, { 0, 6, 3, 4, 1 }, { 2, -2, -1, 4, -5 }, { -3, 3, 1, 0, 3 } };
		findMaximumSumOfSubRectangle(arr);
	}

	private static void findMaximumSumOfSubRectangle(int[][] arr) {
		int currentSum = 0;
		int globalSum = 0;
		int maxLeft = 0;
		int maxRight = 0;
		int maxUp = 0;
		int maxDown = 0;
		int colLen = arr[0].length;
		int rowLen = arr.length;

		for (int col = 0; col < colLen; col++) {
			//initialize on every iteration
			int[] slice = new int[rowLen];
			for (int row = col; row < rowLen; row++) {
				slice = getVerticalSliceOfColumns(slice, arr, row, rowLen);
				// kadane's algo to find max sum from slice of row
				int[] sumAndStartAndEnd = KadaneAlgoMaximumSumOfSubArray.findMaximumSumOfSubArrayWithStartAndEnd(slice);
				currentSum = sumAndStartAndEnd[0];
				if (currentSum > globalSum) {
					globalSum = currentSum;
					maxUp = sumAndStartAndEnd[1];
					maxDown = sumAndStartAndEnd[2];
					maxLeft = col;
					maxRight = row;
				}
			}
		}

		System.out.println("maximum sum of sub-rectangle:" + globalSum);
		System.out.println(
				"sub rectangle row,col(" + maxUp + "," + maxLeft + ")" + " row,col(" + maxRight + "," + maxDown + ")");

	}

	private static int[] getVerticalSliceOfColumns(int[] slice, int[][] arr, int col, int rowLen) {
		for (int row = 0; row < rowLen; row++) {
			slice[row] = slice[row] + arr[row][col];
		}
		return slice;
	}

}
