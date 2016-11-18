package com.sorting;

import java.util.Arrays;

public class MergeSortArray {

	public static void main(String[] args) {
		int[] arr = { 11, 10, 1, 3, 4 };
		show(arr);
		mergeSort(arr, 0, arr.length);
		show(arr);
	}

	private static void show(int[] arr) {
		for (int x : arr) {
			System.out.print(x + " ");
		}
		System.out.println();
	}

	private static void mergeSort(int[] arr, int start, int end) {
		if (arr.length >= 2) {
			int mid = arr.length / 2;

			int[] lAr = Arrays.copyOfRange(arr, start, mid);
			int[] rAr = Arrays.copyOfRange(arr, mid, end);

			mergeSort(lAr, 0, lAr.length);
			mergeSort(rAr, 0, rAr.length);
			merge(arr, lAr, rAr);
		}
	}

	private static void merge(int[] arr, int[] lAr, int[] rAr) {
		int lIndex = 0;
		int rIndex = 0;
		int index = 0;

		while (lIndex < lAr.length && rIndex < rAr.length) {
			if (lAr[lIndex] < rAr[rIndex]) {
				arr[index] = lAr[lIndex];
				lIndex++;
			} else {
				arr[index] = rAr[rIndex];
				rIndex++;
			}
			index++;
		}

		while (lIndex < lAr.length) {
			arr[index] = lAr[lIndex];
			lIndex++;
			index++;
		}

		while (rIndex < rAr.length) {
			arr[index] = rAr[rIndex];
			rIndex++;
			index++;
		}

	}

}
