package com.miscellaneous.questions;

//find prime factor of given number N
public class ShowPrimeFatcorOfNumber {

	public static void main(String[] args) {
		int num = 234;
		computePrimeFactor(num);
	}

	private static void computePrimeFactor(int num) {
		int half = num / 2;
		for (int i = 2; i <= half; i++) {
			while (num % i == 0) {
				System.out.println("factor:" + i);
				num = num / i;
			}
		}
	}

}
