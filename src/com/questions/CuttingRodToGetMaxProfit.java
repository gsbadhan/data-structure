package com.questions;

import java.util.ArrayList;
import java.util.List;

public class CuttingRodToGetMaxProfit {

	public static void main(String args[]) {
		// given maximum length of rod
		int maxRodLength = 8;
		
		// given lengths of each rod piece. Note: added extra 0
		int[] rodPieces = { 0, 1, 2, 3, 4, 5, 6 };
		
		// given profits of each rod piece. Note: added extra 0
		int[] costOfRodPieces = { 0, 2, 5, 4, 9, 6, 5 };
		
		maximumProfit(maxRodLength, rodPieces, costOfRodPieces);
	}

	private static void maximumProfit(int maxRodLength, int[] rodPieces, int[] costOfRodPieces) {
		int maxRow = rodPieces.length;
		int maxCol = maxRodLength + 1;
		int[][] costTable = new int[maxRow][maxCol];
		for (int i = 1; i < maxRow; i++) {
			for (int j = 1; j < maxCol; j++) {
				int excludeRod = excludeRodPiece(costTable, i, j);
				if (rodPieces[i] > j) {
					costTable[i][j] = costTable[i - 1][j];
				} else {
					int includeRod = includeRodPiece(costTable, rodPieces, j, costOfRodPieces, i);
					costTable[i][j] = Math.max(excludeRod, includeRod);
				}
			}
		}

		System.out.println("maximum profit:" + costTable[maxRow - 1][maxCol - 1]);

		String rods = findWhatAreRodPieces(costTable, maxRow, maxCol, rodPieces);
		System.out.println("rods pieces:" + rods);
	}

	private static String findWhatAreRodPieces(int[][] costTable, int maxRow, int maxCol, int[] rodPieces) {
		List<Integer> rods = new ArrayList<>();
		maxCol = maxCol - 1;
		maxRow = maxRow - 1;
		while (maxRow > 0 || maxCol > 0) {
			if (costTable[maxRow][maxCol] == costTable[maxRow - 1][maxCol]) {
				maxRow = maxRow - 1;
			} else {
				rods.add(rodPieces[maxRow]);
				maxCol = maxCol - rodPieces[maxRow];
			}
		}
		return rods.toString();
	}

	private static int includeRodPiece(int[][] costTable, int[] rodPieces, int currentRodLengthIndex, int[] costOfRodPieces,
			int fixedRodLengthIndex) {
		int currentRodLength = rodPieces[fixedRodLengthIndex];
		int cost = costOfRodPieces[fixedRodLengthIndex];
		currentRodLengthIndex = currentRodLengthIndex - currentRodLength;
		while (currentRodLengthIndex > 0) {
			cost = cost + costTable[fixedRodLengthIndex][currentRodLengthIndex];
			currentRodLengthIndex -= currentRodLengthIndex;
		}
		return cost;
	}

	// exclude current profit and take from above row,column
	private static int excludeRodPiece(int[][] costTable, int row, int col) {
		return costTable[row - 1][col];
	}

}
