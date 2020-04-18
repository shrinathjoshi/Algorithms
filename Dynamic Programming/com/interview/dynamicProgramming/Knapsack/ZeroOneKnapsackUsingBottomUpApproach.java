package com.interview.dynamicProgramming.Knapsack;

public class ZeroOneKnapsackUsingBottomUpApproach extends ZeroOneKnapsackStrategy {

	public ZeroOneKnapsackUsingBottomUpApproach(int[] val, int[] wt, int w) {
		super(val, wt, w);
	}

	@Override
	public int getMaximumProfit() {
		System.out.print(" #### Bottom Up Approach ####");
		return getMaximumProfitUsingBottomUpApproach(capacity, value.length - 1);
	}

	private int getMaximumProfitUsingBottomUpApproach(int w, int n) {

		// Initialization
		for (int i = 0; i < w + 1; i++)
			for (int j = 0; j < value.length + 1; j++)
				if (i == 0 || j == 0)
					dp[i][j] = 0;

		for (int i = 1; i < w + 1; i++) {
			for (int j = 1; j < value.length + 1; j++) {

				if (weight[j - 1] <= i)
					dp[i][j] = Math.max(value[j - 1] + dp[i - weight[j - 1]][j - 1], dp[i][j - 1]);
				else
					dp[i][j] = dp[i][j - 1];
			}
		}
		return dp[w][n + 1];
	}

}