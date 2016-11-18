package com.sorting;

public class BubbleSort {

	
	public static void main(String[] args) {
		int arr[] = { 2, 7, 4, 1, 5, 3 };
		show(arr);

		
		for (int i = 0; i < arr.length; i++) {
			boolean noswap = true;

			for (int j = 0; j < arr.length - (1 + i); j++) {
				if (arr[j] > arr[j + 1]) {
					int x = arr[j + 1];
					arr[j + 1] = arr[j];
					arr[j] = x;
					noswap = false;
				}
			}
			show(arr);
			if (noswap) {
				break;
			}
		}

		//
		show(arr);
	}

	private static void show(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

}
