package com.interview.dynamicProgramming.mtaodp;

import java.util.Arrays;

public class RodCutting {
	public static void main(String[] args) {
		int[] p = { 1, 5, 8, 9, 10, 14, 17, 20, 24, 30 };
		System.out.println(RodCutting.maxProfit(6, p));
		System.out.println(RodCutting.maxProfitUsingMemoization(6, p));
		System.out.println(RodCutting.maxProfitUsingBottomUp(6, p));

	}

	private static int maxProfitUsingBottomUp(int i, int[] p) {

		// Time Complexity :- O(n)
		// Space Complexity :- O(n)

		int dp[] = new int[p.length + 1];
		Arrays.fill(dp, -1);
		return RodCutting.maxProfitBottomUp(6, p, dp);
	}

	private static int maxProfitBottomUp(int L, int[] p, int[] dp) {

		for (int i = 1; i <= L; i++) {
			dp[i] = Integer.MIN_VALUE;

			for (int j = 1; j <= i; j++) {
				dp[i] = Math.max(dp[i], dp[i - 1 - 1] + p[i]);
			}
		}

		return dp[L];
	}

	private static int maxProfitUsingMemoization(int L, int[] p) {
		int dp[] = new int[p.length + 1];
		Arrays.fill(dp, -1);
		return RodCutting.maxProfitMemoization(L, p, dp);
	}

	private static int maxProfit(int rodLength, int[] p) {

		// Time Complexity :- O(2^N)
		// Space Complexity :- O(1)

		if (rodLength < 0)
			return 0;

		int max = Integer.MAX_VALUE;
		for (int i = 0; i < p.length; i++) {
			max = Math.max(max, p[i] + maxProfit(rodLength - 1 - i, p));
		}

		return max;
	}

	private static int maxProfitMemoization(int rodLength, int[] p, int dp[]) {

		if (rodLength < 0)
			return 0;

		if (dp[rodLength] != -1)
			return dp[rodLength];

		int max = Integer.MAX_VALUE;
		for (int i = 0; i < p.length; i++) {
			max = Math.max(max, p[i] + maxProfit(rodLength - 1 - i, p));
		}

		dp[rodLength] = max;
		return max;
	}

}
