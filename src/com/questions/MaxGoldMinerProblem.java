package com.questions;

public class MaxGoldMinerProblem {

	/*
	 * its similar to path traversing of maximum value in graph, it will check
	 * adjacent child (right,up right,left right).
	 */
	private static int findMaxGold(int[][] goldField, int MAX_ROW, int MAX_COL) {
		int maxGoldSum = 0;
		for (int path = 0; path <= MAX_ROW; path++) {
			int row = path;
			int col = 0;

			// start position and value of each ROW
			int goldSum = goldField[row][col];

			// run up to last MAX column
			while (col < MAX_COL) {
				col = col + 1;
				int moveRight = (col > MAX_COL) ? 0 : goldField[row][col];
				int moveRightUp = ((row - 1) < 0 || col > MAX_COL) ? 0 : goldField[row - 1][col];
				int moveRightDown = ((row + 1) > MAX_ROW || col > MAX_COL) ? 0 : goldField[row + 1][col];

				if (moveRight >= max(moveRightUp, moveRightDown)) {
					goldSum += moveRight;
				} else if (moveRightUp >= max(moveRight, moveRightDown)) {
					row = row - 1;
					goldSum += moveRightUp;
				} else if (moveRightDown >= max(moveRight, moveRightUp)) {
					row = row - 1;
					goldSum += moveRightDown;
				}
			}

			// set max of each path iteration
			maxGoldSum = max(maxGoldSum, goldSum);
		}
		return maxGoldSum;
	}

	private static int max(int a, int b) {
		return a > b ? a : b;
	}

	public static void main(String args[]) {
		// MxN size array
		int[][] goldField = { { 1, 3, 3 }, { 2, 1, 4 }, { 0, 6, 4 } };
		int MAX_ROW = goldField.length - 1;
		int MAX_COL = goldField[0].length - 1;

		int maxGold = findMaxGold(goldField, MAX_ROW, MAX_COL);

		System.out.println("max gold mine:" + maxGold);
	}
}
