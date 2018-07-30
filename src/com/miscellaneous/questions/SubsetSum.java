package com.miscellaneous.questions;

import java.util.Arrays;

public class SubsetSum {
	
	public static void main(String args[]) {
		// must be distinct set of positive elements
		int[] set = { 1, 3, 4, 6, 7, 8 };
		int sum = 11;
		findSubsetSum(set, sum);

		sum = 20;
		findSubsetSum(set, sum);

		sum = 22;
		findSubsetSum(set, sum);

		sum = 30;
		findSubsetSum(set, sum);
	}

	private static void findSubsetSum(int[] originalSet, int sum) {
		int rowLen = originalSet.length + 1;
		int colLen = sum + 1;
		// 2D array SETxSUM
		boolean[][] sumTruthTable = new boolean[rowLen][colLen];

		// copy original set, first element must be start with 0
		int[] sortedSet = new int[rowLen];
		sortedSet[0] = 0;
		for (int i = 1; i < sortedSet.length; i++) {
			sortedSet[i] = originalSet[i - 1];
		}
		// sort the set; used sorting algorithm to sort original set
		Arrays.sort(sortedSet);

		// 1. build truth table for 0th row
		for (int i = 0; i < colLen; i++) {
			if (i == 0)
				sumTruthTable[0][i] = true;
			else
				sumTruthTable[0][i] = false;
		}
		// 2. build truth table for remaining rows
		for (int i = 1; i < rowLen; i++) {
			for (int j = 0; j < colLen; j++) {
				if (sortedSet[i] > j) {
					sumTruthTable[i][j] = sumTruthTable[i - 1][j];
				} else if (sortedSet[i] <= j) {
					sumTruthTable[i][j] = sumTruthTable[i - 1][j - sortedSet[i]];
				}
			}
		}

		// finally check subset of sum using sumTruthTable
		int sumRow = isSumExist(sumTruthTable, rowLen, sum);
		if (sumRow > 0) {
			System.out.println("sum " + sum + " exist at [row,col]:" + sumRow + ":" + sum);
		} else {
			System.out.println("sum " + sum + " not exist !!");
			return;
		}

		String subset = printSubSet(sumTruthTable, sumRow, sum, sortedSet);
		System.out.println("subset:" + subset);

	}

	private static String printSubSet(boolean[][] sumTruthTable, int sumRow, int sumCol, int[] sortedSet) {
		String subset = "";
		while (sumRow >= 0 && sumCol > 0) {
			if (sumTruthTable[sumRow][sumCol]) {
				sumRow--;
			} else {
				subset += sortedSet[sumRow + 1] + ",";
				sumCol -= sortedSet[sumRow + 1];
			}
		}
		return subset;
	}

	private static int isSumExist(boolean[][] sumTruthTable, int rowLen, int sum) {
		boolean found = false;
		int row = 0;
		while (row < rowLen) {
			if (sumTruthTable[row][sum]) {
				found = true;
				break;
			}
			row++;
		}
		return found ? row : -1;
	}

}
