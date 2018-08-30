package com.miscellaneous.questions;

import java.util.Stack;

public class MaximumAreaOfRectangleInHistogram {

	public static void main(String args[]) {
		int[] histogramArr = { 1, 2, 4 };
		int[] histogramArr2 = { 2, 1, 2, 3, 1 };

		// solution 1
		int globalMaxArea=findMaximumRectangleArea_Solution1(histogramArr);
		System.out.println("maximum area -Solution1:" + globalMaxArea);
		globalMaxArea=findMaximumRectangleArea_Solution1(histogramArr2);
		System.out.println("maximum area -Solution1:" + globalMaxArea);

		// solution 2
		globalMaxArea=findMaximumRectangleArea_Solution2(histogramArr);
		System.out.println("maximum area -Solution2:" + globalMaxArea);
		globalMaxArea=findMaximumRectangleArea_Solution2(histogramArr2);
		System.out.println("maximum area -Solution2:" + globalMaxArea);

	}

	/*
	 * complexity O(n^2)
	 */
	public static int findMaximumRectangleArea_Solution1(int[] histogramArr) {
		int globalMaxArea = 0;
		for (int i = 0; i < histogramArr.length; i++) {
			int maxSumPerBar = 0;
			for (int j = 0; j <= i; j++) {
				if (histogramArr[i] > histogramArr[j]) {
					maxSumPerBar = 0;
					continue;
				}
				maxSumPerBar = maxSumPerBar + histogramArr[i];
				if (maxSumPerBar > globalMaxArea) {
					globalMaxArea = maxSumPerBar;
				}
			}
		}
		return globalMaxArea;
	}

	/*
	 * complexity O(n)
	 */
	public static int findMaximumRectangleArea_Solution2(int[] histogramArr) {
		int globalMaxArea = 0;
		Stack<Integer> indices = new Stack<>();
		for (int i = 0; i <= histogramArr.length; i++) {
			if (indices.isEmpty() && i < histogramArr.length) {
				indices.push(i);
				continue;
			}

			if (i == histogramArr.length) {
				while (!indices.empty()) {
					int currentMaxArea = 0;
					int topBarIndx = indices.pop();
					int topBarValue = histogramArr[topBarIndx];
					if (indices.isEmpty()) {
						currentMaxArea = topBarValue * i;
					} else {
						currentMaxArea = topBarValue * (i - indices.peek() - 1);
					}
					if (currentMaxArea > globalMaxArea) {
						globalMaxArea = currentMaxArea;
					}
				}
			} else if (histogramArr[i] > histogramArr[indices.peek()]) {
				indices.push(i);
				continue;
			} else {
				while (!indices.isEmpty() && histogramArr[indices.peek()] > histogramArr[i]) {
					int currentMaxArea = 0;
					int topBarIndx = indices.pop();
					int topBarValue = histogramArr[topBarIndx];
					if (indices.isEmpty()) {
						currentMaxArea = topBarValue * i;
					} else {
						currentMaxArea = topBarValue * (i - indices.peek() - 1);
					}
					if (currentMaxArea > globalMaxArea) {
						globalMaxArea = currentMaxArea;
					}
				}
				indices.push(i);
			}

		}

		return globalMaxArea;
	}
}
