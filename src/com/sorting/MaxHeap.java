package com.sorting;

public class MaxHeap {

	public static void main(String[] args) {
		int inputArr[] = { 2, 7, 5, 1, 24,100,23,89 };
		int eArr[] = new int[inputArr.length];
		show(inputArr);

		// build Max-Heap from Array
		for (int i = 0; i < inputArr.length; i++) {
			buildHeap(eArr, i, inputArr[i]);
		}
		show(eArr);

		// get largest element from heap
		for (int i = inputArr.length - 1; i >= 0; i--) {
			deleteHeap(eArr, i);
		}

	}

	private static void deleteHeap(int[] eArr, int lastUsedIndex) {
		int max = eArr[0];
		System.out.println("max:" + max);
		eArr[0] = eArr[lastUsedIndex];
		//set -1/lowest number as empty index 
		eArr[lastUsedIndex] = -1;
		maxHeapify(eArr, 0);
	}

	private static void buildHeap(int[] eArr, int lastIndex, int item) {
		eArr[lastIndex] = item;
		maxHeapify(eArr, lastIndex);
	}

	private static void maxHeapify(int[] eArr, int index) {
		int parentIdx = (index - 1) / 2;
		int leftChIdx = (2 * parentIdx) + 1;
		int rightChIdx = (2 * parentIdx) + 2;
		int maxChIdx = -1;

		// max from both child
		if (rightChIdx >= eArr.length) {
			maxChIdx = leftChIdx;
		} else {
			maxChIdx = (eArr[leftChIdx] > eArr[rightChIdx] ? leftChIdx : rightChIdx);
		}

		if (eArr[maxChIdx] > eArr[parentIdx]) {
			int par = eArr[parentIdx];
			eArr[parentIdx] = eArr[maxChIdx];
			eArr[maxChIdx] = par;
			// call again to ensure MAX-HEAP property
			maxHeapify(eArr, parentIdx);
		}

	}

	private static void show(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}

		System.out.println();
	}
}
