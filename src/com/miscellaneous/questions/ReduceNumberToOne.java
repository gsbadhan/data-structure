package com.miscellaneous.questions;

public class ReduceNumberToOne {

	/**
	 * 
	 * min{f(n-1),f(n/2),f(n/3)} + 1
	 * 
	 * @param number
	 * @param memo
	 * @return
	 */
	public int getMinimumStep(int number, int memo[]) {

		// base check
		if (number == 1)
			return 0;

		// check already computed minimum value
		if (memo[number] != 0)
			return memo[number];

		int result = getMinimumStep(number - 1, memo);
		if (number % 2 == 0)
			result = Math.min(result, getMinimumStep(number / 2, memo));
		if (number % 3 == 0)
			result = Math.min(result, getMinimumStep(number / 3, memo));

		memo[number] = result + 1;
		return memo[number];
	}

	public static void main(String args[]) {
		ReduceNumberToOne reduceNumberToOne = new ReduceNumberToOne();
		int number = 6;
		int memo[] = new int[number + 1];
		int minimumStep = reduceNumberToOne.getMinimumStep(number, memo);
		System.out.println("min step:" + minimumStep);
	}
}
