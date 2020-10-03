package com.interview.dynamicProgramming.mtaodp;

public class Knapsack implements DynamicProgramming {

	public static void main(String[] args) {

		int val[] = new int[] { 60, 100, 120 };
		int wt[] = new int[] { 10, 20, 30 };
		int W = 50;

		int val1[] = new int[] { 4, 14, 10, 5 };
		int wt1[] = new int[] { 3, 7, 10, 6 };
		int W1 = 20;

		System.out.println("Max Profit :- " + Knapsack.getMaxProfit(val, wt, W, approach.RECURSION));

		System.out.println("Max Profit :- " + Knapsack.getMaxProfit(val, wt, W, approach.RECURSION_MEMOIZATION));

		System.out.println("Max Profit :- " + Knapsack.getMaxProfit(val, wt, W, approach.BOTTOM_UP));

		System.out.println("Max Profit :- " + Knapsack.getMaxProfit(val1, wt1, W1, approach.BOTTOM_UP));

	}

	private static int getMaxProfit(int[] val, int[] wt, int w, approach recursion) {
		switch (recursion) {
		case RECURSION: {
			return knapsackUsingRecursion(val, wt, w, wt.length - 1);
		}
		case RECURSION_MEMOIZATION: {

			int dp[][] = new int[wt.length + 1][w + 1];
			return knapsackUsingRecursionAndMemoization(val, wt, w, wt.length - 1, dp);
		}
		case BOTTOM_UP: {

			int dp[][] = new int[wt.length + 1][w + 1];
			boolean decision[][] = new boolean[wt.length + 1][w + 1];
			return knapsackUsingBottomUp(val, wt, w, wt.length, dp, decision);
		}

		default:
			throw new IllegalArgumentException("Unexpected value: " + recursion);
		}

	}

	private static int knapsackUsingBottomUp(int[] val, int[] wt, int w, int length, int[][] dp, boolean[][] decision) {

		int n = wt.length;
		// Base Condition
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j <= w; j++) {
				if (wt[i - 1] <= j) {
					decision[i][j] = true;
					dp[i][j] = Math.max(dp[i - 1][j - wt[i - 1]] + val[i - 1], dp[i - 1][j]);
				} else
					dp[i][j] = dp[i - 1][j];
			}
		}

		showDecission(decision, val, wt, w, n);

		return dp[n][w];
	}

	private static void showDecission(boolean[][] decision, int[] val, int[] wt, int W, int n) {
		int i = n;
		int w = W;

		while (i > 0 && w > 0) {
			boolean picked = decision[n][w];

			if (picked) {
				System.out.println(" Picked " + (i - 1) + " Weight " + wt[i - 1] + " Values " + val[i - 1]);
				w = w - wt[i - 1];
			}
			i--;
		}

	}

	private static int knapsackUsingRecursion(int[] val, int[] wt, int w, int index) {
		// Base Condition
		if (index < 0 || w <= 0)
			return 0;

		int include = knapsackUsingRecursion(val, wt, w - wt[index], index - 1) + val[index];
		int exclude = knapsackUsingRecursion(val, wt, w, index - 1);

		// If weight of current element is less than the actual Weight , return max from
		// including and excluing the current item
		if (wt[index] <= w)
			return Math.max(include, exclude);

		// If weight of current element is greater than the total weight , then we
		// exclude the currrnet
		return exclude;

	}

	private static int knapsackUsingRecursionAndMemoization(int[] val, int[] wt, int w, int index, int[][] dp) {
		// Base Condition
		if (index < 0 || w <= 0)
			return 0;

		if (dp[index][w] != 0)
			return dp[index][w];

		int include = knapsackUsingRecursion(val, wt, w - wt[index], index - 1) + val[index];
		int exclude = knapsackUsingRecursion(val, wt, w, index - 1);
		int result = 0;
		// If weight of current element is less than the actual Weight , return max from
		// including and excluding the current item
		if (wt[index] <= w)
			result = Math.max(include, exclude);
		else
			result = exclude;
		// If weight of current element is greater than the total weight , then we
		// exclude the current
		return result;

	}

}
