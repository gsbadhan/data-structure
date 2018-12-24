package com.miscellaneous.questions;

import java.util.ArrayList;
import java.util.List;

//find sub-sets of given array of numbers
public class SubsetOfArray {

	public static void main(String[] args) {
		int[] nums = { 1, 2};
		List<List<Integer>> sets = new ArrayList<>();
		List<Integer> subset = new ArrayList<>();
		findSubset(nums, sets, subset, 0);
		System.out.println("total subsets (2^N):" + sets.size() + ", " + sets);

	}

	private static void findSubset(int[] nums, List<List<Integer>> sets, List<Integer> subset, int startIndex) {
		sets.add(new ArrayList<>(subset));
		for (int i = startIndex; i < nums.length; i++) {
			subset.add(nums[i]);
			findSubset(nums, sets, subset, i + 1);
			subset.remove(subset.size() - 1);
		}

	}

}
