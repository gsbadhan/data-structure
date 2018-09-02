package com.search.binarysearch;

public class BinarySearch {

	public static void main(String[] args) {

		// search ascending order sorted array
		int a[] = { 1, 2, 3, 56, 78, 90 };
		int searchItem = 78;

		int index = binarySearchAsc(a, searchItem);
		if (index > -1) {
			System.out.println("found at index:" + index);
		} else {
			System.out.println("not found..!!");
		}

		
		//search from descending order sorted array
		int b[] = { 90, 78, 56, 3, 2, 1 };

		index = binarySearchDesc(b, searchItem);
		if (index > -1) {
			System.out.println("found at index:" + index);
		} else {
			System.out.println("not found..!!");
		}

	}

	public static int binarySearchAsc(int arr[], int searchItem) {
		int start = 0;
		int end = arr.length;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (searchItem == arr[mid]) {
				return mid;
			}
			if (searchItem < arr[mid]) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return -1;

	}

	public static int binarySearchDesc(int arr[], int searchItem) {
		int start = 0;
		int end = arr.length;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (searchItem == arr[mid]) {
				return mid;
			}
			if (searchItem > arr[mid]) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return -1;

	}

}
