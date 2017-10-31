package com.questions;

public class NQueenProblem {

	public static void main(String args[]) {
		// queen's count
		int totalQueen = 4;
		// box's size 4x4
		int totalBoxSize = 4;
		int[][] box = new int[totalBoxSize][totalBoxSize];

		boolean allPlaced = placeQueen(box, totalQueen, 0, 0);

	}

	private static boolean placeQueen(int[][] box, int totalQueen, int row, int col) {
		if (col >= totalQueen) {
			return true;
		}

		for (int i = col; i < totalQueen; i++) {
			if (isQueenSafe(box, totalQueen, row, col)) {
				box[row][i] = 1;
				if (placeQueen(box, totalQueen, i + 1, 0)) {
					return true;
				}
			}
		}
		return false;
	}

	private static boolean isQueenSafe(int[][] box, int totalQueen, int row, int col) {
		// row wise safe check
		for (int j = 0; j < totalQueen; j++) {
			if (box[row][j] == 1)
				return false;
		}


		return false;
	}
}
