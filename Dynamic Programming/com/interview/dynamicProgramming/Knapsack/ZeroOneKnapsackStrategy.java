package com.interview.dynamicProgramming.Knapsack;

public abstract class ZeroOneKnapsackStrategy {

	public int weight[];
	public int value[];
	public int capacity;
	public int dp[][];

	public ZeroOneKnapsackStrategy(int[] val, int[] wt, int w) {
		this.weight = wt;
		this.value = val;
		this.capacity = w;
		dp = new int[w + 1][val.length + 1];

		for (int i = 0; i < w + 1; i++)
			for (int j = 0; j < val.length + 1; j++)
				dp[i][j] = -1;

	}

	public abstract int getMaximumProfit();
}