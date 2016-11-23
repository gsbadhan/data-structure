package com.sorting;

public class MaxHeap {

	public static void main(String[] args) {
		int inputArr[] = { 2, 7, 5, 1, 24, 3, 78, 90, 34, 65, 89, 24 };
		int eArr[] = new int[inputArr.length];
		show(inputArr);

		// build Max-Heap from Array
		for (int i = 0; i < inputArr.length; i++) {
			buildHeap(eArr, i, inputArr[i]);
		}
		show(eArr);

		//delete heap
		for (int i = 0; i < inputArr.length; i++) {
			deleteHeap(eArr, eArr[i]);
		}

	}

	private static void deleteHeap(int[] eArr, int item) {

	}

	private static void buildHeap(int[] eArr, int index, int item) {
		// insert item at available location
		eArr[index] = item;
		if (index > 0) {
			maxHeapify(eArr, index);
		}
	}

	private static void maxHeapify(int[] eArr, int index) {
		if (index == 0) {
			return;
		}
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
