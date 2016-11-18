package com.sorting;

public class InsertionSort {

	public static void main(String[] args) {
		int arr[] = { 2, 7, 4, 1, 5, 3 };
		show(arr);

		for (int i = 1; i < arr.length; i++) {

			// find out insertion index i.e. partitionIndex
			int partitionIndex = -1;
			for (int j = 0; j < i; j++) {
				if (arr[i] < arr[j]) {
					partitionIndex = j;
					break;
				}
			}

			// replace and swap forward
			if (partitionIndex > -1) {
				int value = arr[i];
				for (int k = partitionIndex; k <= i; k++) {
					int x = arr[k];
					arr[k] = value;
					value = x;
					show(arr);
				}
			}
		}
	}

	private static void show(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}
