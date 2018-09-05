package com.arrays;

import java.util.Arrays;

/**
 * reverse an array in-place
 *
 */
public class ReverseArrayInPlace {

	public static void main(String[] args) {
		int[] ar = { 9, 8, 6, 5, 4, 3, 2, 1, 0 };
		System.out.println(Arrays.toString(ar));
		reverseInPlace(ar);
		System.out.println(Arrays.toString(ar));
	}

	private static void reverseInPlace(int[] ar) {
		int st = 0;
		int end = ar.length - 1;
		while (st < end) {
			swap(ar, st, end);
			st++;
			end--;
		}
	}

	private static void swap(int[] ar, int st, int end) {
		int tmp = ar[st];
		ar[st] = ar[end];
		ar[end] = tmp;
	}

}
