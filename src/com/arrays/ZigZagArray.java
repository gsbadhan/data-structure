package com.arrays;

import java.util.Arrays;

/**
 * 
 * convert aray to zig-zag array like /\/\/\/\
 * 
 * @see it should satify a<b>c<d>e<f
 *
 */
public class ZigZagArray {

	public static void main(String[] args) {
		int[] arr = { 4, 3, 7, 5, 6, 8, 1 };
		System.out.println(Arrays.toString(arr));

		int[] out = convertToZigZag(arr);
		System.out.println(Arrays.toString(out));
	}

	private static int[] convertToZigZag(int[] arr) {
		int i = 0;
		boolean flag = true;
		while (i < arr.length - 1) {
			if (flag) {
				// should be a < b else swap
				if (arr[i] > arr[i + 1])
					swap(arr, i, i + 1);
			} else {
				// should be a > b else swap
				if (arr[i] < arr[i + 1])
					swap(arr, i, i + 1);
			}
			flag = !flag;
			i++;
		}
		return arr;
	}

	private static void swap(int[] arr, int i, int j) {
		int t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}

}
