package com.interview.dynamicProgramming.Knapsack;

public class ZeroOneKnapsackUsingTopDownApproach extends ZeroOneKnapsackStrategy {

	public ZeroOneKnapsackUsingTopDownApproach(int[] val, int[] wt, int w) {
		super(val, wt, w);
	}

	@Override
	public int getMaximumProfit() {
		System.out.print(" #### Top Down Approach without Memoization ####");
		return getMaximumProfitUsingTopDownApproach(capacity, value.length - 1);
	}

	private int getMaximumProfitUsingTopDownApproach(int w, int n) {
		// Base Conditions
		if (n <= 0 || w <= 0)
			return 0;

		if (weight[n] <= w)
			return Math.max(value[n] + getMaximumProfitUsingTopDownApproach(w - weight[n], n - 1),
					getMaximumProfitUsingTopDownApproach(w, n - 1));
		else
			return getMaximumProfitUsingTopDownApproach(w, n - 1);

	}

}
