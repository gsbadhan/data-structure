package com.arrays;

public class MedianOfTwoSortedArray {

	public static void main(String[] args) {
		// example 1
		int a[] = { 5, 6, 9, 10, 20 };
		int b[] = { 3, 4, 30, 45, 60 };
		double median = findMedian(a, b);
		System.out.println("median:" + median);

		// example 2
		int x[] = { 23, 69 };
		int y[] = { 3, 4, 30, 45, 60 };
		median = findMedian(x, y);
		System.out.println("median:" + median);
	}

	/**
	 * smallest array should come first
	 */
	private static Double findMedian(int[] a, int[] b) {
		int low = 0;
		int high = a.length;
		while (low <= high) {
			int aPartition = (low + high) / 2;
			int bPartition = ((a.length + b.length + 1) / 2) - aPartition;

			// always minus 1 from both indices
			aPartition -= 1;
			bPartition -= 1;
			int aX1 = checkBoundryAndReturn(aPartition, a);
			int aX2 = checkBoundryAndReturn(aPartition + 1, a);
			int bY1 = checkBoundryAndReturn(bPartition, b);
			int bY2 = checkBoundryAndReturn(bPartition + 1, b);

			if (aX1 <= bY2 && bY1 <= aX2) {
				double med = 0;
				if ((a.length + b.length) % 2 == 0) {
					med = (Math.max(aX1, bY1) + Math.min(aX2, bY2)) / 2D;
				} else {
					med = Math.max(aX1, bY1);
				}
				return med;
			} else if (aX1 > bY2) {
				// move left
				high = aPartition - 1;
			} else {
				// move right
				low = aPartition + 1;
			}
		}
		return null;
	}

	private static int checkBoundryAndReturn(int index, int arr[]) {
		if (index <= 0) {
			return Integer.MIN_VALUE;
		} else {
			return arr[index];
		}
	}

}
