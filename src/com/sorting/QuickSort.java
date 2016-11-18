package com.sorting;

public class QuickSort {

	public static void main(String str[]) {
		int arr[] = { 10, 12, 5, 1, 7 };
		quicksort(arr, 0, arr.length - 1);
		show(arr);
	}

	private static void show(int[] arr) {
		for (int x : arr) {
			System.out.print(x + " ");
		}
		System.out.println();
	}

	private static void quicksort(int[] arr, int start, int end) {
		if (start < end) {
			int pIndex = partition(arr, start, end);
			quicksort(arr, start, pIndex - 1);
			quicksort(arr, pIndex + 1, end);
		}
	}

	private static int partition(int[] arr, int start, int end) {
		int pivot = arr[end];
		int pIndex = start;

		// scan start to end
		for (int i = start; i < end; i++) {
			if (arr[i] <= pivot) {
				int temp = arr[i];
				arr[i] = arr[pIndex];
				arr[pIndex] = temp;
				pIndex = pIndex + 1;
			}
		}

		// last swap with pivot
		arr[end] = arr[pIndex];
		arr[pIndex] = pivot;

		return pIndex;
	}

}
