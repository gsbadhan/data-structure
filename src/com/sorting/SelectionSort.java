package com.sorting;

public class SelectionSort {

	public static void main(String[] args) {
		int arr[] = { 2, 7, 4, 1, 5, 3 };
		show(arr);

		for (int i = 0; i < arr.length; i++) {

			// assume i is minimum
			int minIndex = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[minIndex]) {
					minIndex = j;
				}
			}
			int min = arr[minIndex];
			arr[minIndex] = arr[i];
			arr[i] = min;
			show(arr);
		}

	}

	private static void show(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

}
