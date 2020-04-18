package com.interview.dynamicProgramming.Knapsack;

public class ZeroOneKnapsackUsingTopDownApproachWithMemoizataion extends ZeroOneKnapsackStrategy {

	public ZeroOneKnapsackUsingTopDownApproachWithMemoizataion(int[] val, int[] wt, int w) {
		super(val, wt, w);
	}

	@Override
	public int getMaximumProfit() {
		System.out.print(" #### Top Down Approach with Memoization ####");
		return getMaximumProfitUsingUsingTopDownApproachWithMemoizataion(capacity, value.length - 1);
	}

	private int getMaximumProfitUsingUsingTopDownApproachWithMemoizataion(int w, int n) {
		if (n <= 0 || w <= 0)
			return 0;

		if (dp[w][n] != -1)
			return dp[w][n];

		if (weight[n] <= w)
			dp[w][n] = Math.max(
					value[n] + getMaximumProfitUsingUsingTopDownApproachWithMemoizataion(w - weight[n], n - 1),
					getMaximumProfitUsingUsingTopDownApproachWithMemoizataion(w, n - 1));
		else
			dp[w][n] = getMaximumProfitUsingUsingTopDownApproachWithMemoizataion(w, n - 1);

		return dp[w][n];
	}

}

