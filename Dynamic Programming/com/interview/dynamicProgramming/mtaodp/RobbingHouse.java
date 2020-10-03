package com.interview.dynamicProgramming.mtaodp;

public class RobbingHouse implements DynamicProgramming {

	public static void main(String[] args) {
		int arr[] = { 20, 25, 20, 15, 10 };
		System.out.println(RobbingHouse.getMaxProfit(arr, approach.RECURSION));
		System.out.println(RobbingHouse.getMaxProfit(arr, approach.RECURSION_MEMOIZATION));
		System.out.println(RobbingHouse.getMaxProfit(arr, approach.BOTTOM_UP));
	}

	private static int getMaxProfit(int[] arr, approach recursion) {
		switch (recursion) {
		case RECURSION: {
			return robbingHouseUsingRecurssion(arr, arr.length - 1);
		}
		case RECURSION_MEMOIZATION: {
			int dp[] = new int[arr.length + 1];
			return robbingHouseUsingRecurssionAndMemoization(arr, arr.length - 1, dp);
		}
		case BOTTOM_UP: {
			int dp[] = new int[arr.length + 1];
			return robbingHouseUsingBottomUp(arr, dp);
		}

		default:
			throw new IllegalArgumentException("Unexpected value: " + recursion);
		}

	}

	private static int robbingHouseUsingBottomUp(int[] arr, int[] dp) {

		int n = arr.length;
		dp[0] = 0;
		dp[1] = arr[0];

		boolean robbed[] = new boolean[n];
		for (int i = 2; i <= n; i++) {
			if (dp[i - 2] + arr[i - 1] > dp[i - 1]) {
				robbed[i - 1] = true;
				dp[i] = dp[i - 2] + arr[i - 1];
			} else {
				dp[i] = dp[i - 1];
			}
		}

		reconstructSolution(arr, dp, robbed);
		return dp[n];
	}

	private static void reconstructSolution(int[] arr, int[] dp, boolean[] robbed) {
		int i = arr.length - 1;

		while (i >= 0) {
			if (robbed[i]) {
				System.out.println(i + " " + arr[i]);
				i = i - 2;
			} else {
				i = i - 1;
			}
		}
	}

	private static int robbingHouseUsingRecurssionAndMemoization(int[] arr, int index, int[] dp) {
		if (index < 0)
			return 0;

		if (index == 0)
			return arr[0];

		if (dp[index] != 0)
			return dp[index];

		dp[index] = Math.max(robbingHouseUsingRecurssion(arr, index - 2) + arr[index],
				robbingHouseUsingRecurssion(arr, index - 1));

		return dp[index];
	}

	private static int robbingHouseUsingRecurssion(int[] arr, int index) {
		// TODO Auto-generated method stub
		if (index < 0)
			return 0;

		if (index == 0)
			return arr[0];

		return Math.max(robbingHouseUsingRecurssion(arr, index - 2) + arr[index],
				robbingHouseUsingRecurssion(arr, index - 1));
	}
}
