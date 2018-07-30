package com.miscellaneous.questions;

import java.util.Arrays;

/**
 * maximum profit of non overlap parallel job
 *
 */
public class WeightedJobScheduling {

	public static void main(String[] args) {
		Job a = new Job("a", 1, 4, 3);
		Job b = new Job("b", 2, 6, 5);
		Job c = new Job("c", 4, 7, 2);
		Job d = new Job("d", 5, 9, 4);
		Job e = new Job("e", 6, 8, 6);
		Job f = new Job("f", 7, 10, 8);

		// user given input
		Job[] jobs = { a, b, c, d, e, f };
		System.out.println("given jobs:" + Arrays.deepToString(jobs));

		// 1. sort the all the job by End time
		Arrays.sort(jobs);
		System.out.println("sorted jobs by end time:" + Arrays.deepToString(jobs));

		// 2. find maximum profitable jobs scheduling without time overlapping
		findMaxProfitJobWithoutOverlap(jobs);

	}

	private static void findMaxProfitJobWithoutOverlap(Job[] jobs) {
		// assign default profit
		int[] jobsMaxProfit = initializeProfitArray(new int[jobs.length], jobs);
		int maxProfit = 0;

		// build maximum profit by comparing job's profit
		for (int i = 1; i < jobs.length; i++) {
			for (int j = 0; j <= i; j++) {
				if (!isOverlap(jobs[j], jobs[i])) {
					int profit = jobs[j].profit + jobs[i].profit;
					if (profit > jobsMaxProfit[i]) {
						jobsMaxProfit[i] = profit;
					}
				}
			}
			if (maxProfit < jobsMaxProfit[i]) {
				maxProfit = jobsMaxProfit[i];
			}
		}

		System.out.println("maximum profit after job scheduling:" + maxProfit);

	}


	private static boolean isOverlap(Job job1, Job job2) {
		return (job2.start < job1.end);
	}

	private static int[] initializeProfitArray(int[] profits, Job[] jobs) {
		for (int i = 0; i < jobs.length; i++) {
			profits[i] = jobs[i].profit;
		}
		return profits;
	}

	// job meta data class
	private static class Job implements Comparable<Job> {
		private String name;
		private int start;
		private int end;
		private int profit;
		private int totalProfit;

		public Job(String name, int start, int end, int profit) {
			super();
			this.name = name;
			this.start = start;
			this.end = end;
			this.profit = profit;
		}

		public int getTotalProfit() {
			return totalProfit;
		}

		public void setTotalProfit(int totalProfit) {
			this.totalProfit = totalProfit;
		}

		@Override
		public String toString() {
			return "[name=" + name + ", start=" + start + ", end=" + end + "]";
		}

		@Override
		public int compareTo(Job job) {
			return Integer.compare(this.end, job.end);
		}

	}

}
