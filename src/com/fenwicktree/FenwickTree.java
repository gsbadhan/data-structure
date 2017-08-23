package com.fenwicktree;

public class FenwickTree {
	private int[] orginalArr = null;
	private int[] indexArr = null;

	public FenwickTree(int[] orginalArray) {
		this.orginalArr = orginalArray;
	}

	/**
	 * build binary index tree from original array.
	 * 
	 * @return
	 */
	public int[] buildIndexTree() {
		indexArr = createIndexTree(orginalArr);
		return indexArr;
	}

	private int[] createIndexTree(int[] ar) {
		int[] indexAr = new int[ar.length + 1];
		for (int i = 0; i < ar.length; i++) {
			int newValue = ar[i];
			int nextIdx = i + 1;
			while (nextIdx < indexAr.length) {
				int oldValue = indexAr[nextIdx];
				indexAr[nextIdx] = oldValue + newValue;
				nextIdx = getNext(nextIdx);
			}
		}
		return indexAr;
	}

	/**
	 * Get sum from 0 to N (user's given index)
	 * 
	 * @param index
	 * @return
	 */
	public int getSumUpto(int index) {
		index = index + 1;
		// decrease range; if it is beyond the array size.
		while (index >= indexArr.length) {
			index = index - 1;
		}

		int sum = 0;
		while (index > 0) {
			sum += indexArr[index];
			index = getParent(index);
		}
		return sum;
	}

	public void updateIndexTree(int index, int newValue) {
		if (index < 0 || index >= (indexArr.length)) {
			throw new IllegalArgumentException("invalid index " + index);
		}
		int oldValue = orginalArr[index];
		orginalArr[index] = newValue;
		int diffValue = findDiff(oldValue, newValue);
		index = index + 1;
		while (index < indexArr.length) {
			indexArr[index] = indexArr[index] + diffValue;
			index = getNext(index);
		}

	}

	/**
	 * get sum between range
	 * 
	 * @param fromIndex
	 * @param toIndex
	 * @return
	 */
	public int rangeSum(int fromIndex, int toIndex) {
		if (fromIndex > toIndex || fromIndex < 0 || toIndex < 0)
			throw new IllegalArgumentException("from must be greater than " + fromIndex + " toIndex " + toIndex);
		if (fromIndex == 0)
			return getSumUpto(toIndex);

		return getSumUpto(toIndex) - getSumUpto(fromIndex - 1);
	}

	private int findDiff(int oldVal, int newVal) {
		return newVal > oldVal ? (newVal - oldVal) : -(oldVal - newVal);
	}

	private int getParent(int index) {
		return (index - (index & (-index)));
	}

	private int getNext(int index) {
		return (index + (index & (-index)));
	}

}
