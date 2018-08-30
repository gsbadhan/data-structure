package com.miscellaneous.questions;

import java.util.Arrays;

/**
 *  find maximum area of 1s from matrix
 *
 */
public class MaximumAreaOf_1s_InMatrix {

	public static void main(String[] args) {
		int[][] ar = { { 0, 1, 1, 1 }, { 1, 0, 1, 0 }, { 1, 1, 1, 0 }, { 0, 1, 1, 1 } };
		System.out.println(Arrays.deepToString(ar));

		int maxArea = findMaximumAreaOf1s(ar);
		System.out.println("maximum area of 1s:" + maxArea);
	}

	private static int findMaximumAreaOf1s(int[][] ar) {
		int globalMaxArea = 0;
		int[] lastMergeCopy = null;
		for (int i = 0; i < ar.length; i++) {
			int[] currentRowCopy = copyRow(ar, i);
			if (i == 0) {
				lastMergeCopy = currentRowCopy;
			} else {
				mergeRows(currentRowCopy, lastMergeCopy);
			}
			int currentMaxArea = MaximumAreaOfRectangleInHistogram.findMaximumRectangleArea_Solution2(lastMergeCopy);
			if (currentMaxArea > globalMaxArea) {
				globalMaxArea = currentMaxArea;
			}
		}
		return globalMaxArea;
	}

	private static void mergeRows(int[] currentRowCopy, int[] lastMergeCopy) {
		for (int i = 0; i < currentRowCopy.length; i++) {
			lastMergeCopy[i] = (currentRowCopy[i] == 0 ? 0 : (currentRowCopy[i] + lastMergeCopy[i]));
		}
	}

	private static int[] copyRow(int[][] ar, int rowStartIndex) {
		int[] row = new int[ar.length];
		for (int i = 0; i < ar.length; i++) {
			row[i] = ar[rowStartIndex][i];
		}
		return row;
	}

}
