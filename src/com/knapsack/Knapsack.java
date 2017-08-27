package com.knapsack;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Knapsack {

	/***************************
	 * <p>
	 * 0. i axis given items and j axis given capacity
	 * </p>
	 * <p>
	 * 1. 0th row and 0th column must be 0
	 * </p>
	 * <p>
	 * 2. if item's weight > bag capacity then new value will be above cell's
	 * value i.e. knp[i][j]=knp[i-1][j]
	 * </p>
	 * <p>
	 * 3. if items's weight <= sum of weight then MAX(knp[i-1][j],new weight
	 * value + knp[i-1][j-i])
	 * </p>
	 ******************************/
	public static void main(String[] args) {
		Map<Integer, Item> itemAndValue = new LinkedHashMap<>();
		// given N items with weight and value. weight and value must be sorted
		itemAndValue.put(1, new Item(3, 4));
		itemAndValue.put(2, new Item(4, 10));
		itemAndValue.put(3, new Item(5, 15));
		itemAndValue.put(4, new Item(6, 20));
		itemAndValue.put(5, new Item(7, 21));
		
		// knapsack with maximum fill up capacity
		int bagCapacity = 10;

		findOutMaxValueEarned(itemAndValue, bagCapacity);
	}

	private static void findOutMaxValueEarned(Map<Integer, Item> itemAndValue, int bagCapacity) {
		int maxItems = itemAndValue.size() + 1;
		int maxBagCapacity = bagCapacity + 1;
		int[][] knapsack = new int[maxItems][maxBagCapacity];

		for (int i = 1; i < maxItems; i++) {
			for (int j = 1; j < maxBagCapacity; j++) {
				// if weight of item > SOW then copy from above cell
				if (itemAndValue.get(i).getWeight() > j) {
					knapsack[i][j] = knapsack[i - 1][j];
					// else if weight of item <= SOW then find MAX value
				} else if (itemAndValue.get(i).getWeight() <= j) {
					int oldValue = knapsack[i - 1][j];
					int sumOfWeight = j;
					int currentWeight = itemAndValue.get(i).getWeight();
					int currentValue = itemAndValue.get(i).getValue();
					int newValue = Math.max(oldValue, currentValue + knapsack[i - 1][(sumOfWeight - currentWeight)]);
					knapsack[i][j] = newValue;
				}
			}
		}
		System.out.println("maximum kanpsack value:" + knapsack[maxItems - 1][maxBagCapacity - 1]);

		// find out weight subset
		int j = maxBagCapacity;
		for (int i = maxItems - 2; i >= 1; i--) {
			int weight = itemAndValue.get(i).getWeight();
			if (j - weight <= 0) {
				continue;
			}
			System.out.println("weight:" + weight);
			j = j - weight;
		}

	}

	private static class Item {
		private int weight;
		private int value;

		public Item(int weight, int value) {
			super();
			this.weight = weight;
			this.value = value;
		}

		public int getWeight() {
			return weight;
		}

		public int getValue() {
			return value;
		}

	}

}
