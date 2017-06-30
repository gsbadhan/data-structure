package com.segmentTree;

public class MinimumRangeQuery {

	public static void main(String[] args) {
		int input[] = { -1, 2, 4, 0 };
		int segmentTree[] = new int[(input.length * 2) - 1];
		constructSegmentTree(input, segmentTree, 0, input.length - 1, 0);

		// min range query search
		int qlow = 1;
		int qhigh = 3;
		minRangeQuery(segmentTree, qlow, qhigh, 0, input.length - 1, 0);
	}

	private static int minRangeQuery(int[] segmentTree, int qlow, int qhigh, int low, int high, int pos) {
		// total overlap
		if (qlow < low && qhigh >= high) {
			return segmentTree[pos];
		}

		// no overlap
		if (qlow > high || qhigh < low) {
			return Integer.MAX_VALUE;
		}
		int mid = (low + high) / 2;
		int min = Math.min(minRangeQuery(segmentTree, qlow, qhigh, low, mid, 2 * pos + 1),
				minRangeQuery(segmentTree, qlow, qhigh, mid + 1, high, 2 * pos + 2));
		return min;

	}

	private static void constructSegmentTree(int[] input, int[] segmentTree, int low, int high, int pos) {
		if (low == high) {
			segmentTree[pos] = input[low];
			return;
		}
		int mid = (low + high) / 2;
		constructSegmentTree(input, segmentTree, low, mid, 2 * pos + 1);
		constructSegmentTree(input, segmentTree, mid + 1, high, 2 * pos + 2);
		segmentTree[pos] = Math.min(segmentTree[2 * pos + 1], segmentTree[2 * pos + 2]);
	}

}
