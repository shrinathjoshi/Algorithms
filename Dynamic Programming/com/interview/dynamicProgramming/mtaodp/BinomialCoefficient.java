package com.interview.dynamicProgramming.mtaodp;

/**
 * @author Shrinath Joshi
 *
 */
public class BinomialCoefficient implements DynamicProgramming {

	public static void main(String[] args) {
		int n = 5;
		int k = 3;

		System.out.println("Number of ways of choosing " + k + " from " + n + " is : "
				+ BinomialCoefficient.getBinomialCoefficient(n, k, approach.RECURSION));

		System.out.println("Number of ways of choosing " + k + " from " + n + " is : "
				+ BinomialCoefficient.getBinomialCoefficient(n, k, approach.RECURSION_MEMOIZATION));

		System.out.println("Number of ways of choosing " + k + " from " + n + " is : "
				+ BinomialCoefficient.getBinomialCoefficient(n, k, approach.BOTTOM_UP));
	}

	private static int getBinomialCoefficient(int n, int k, approach recursion) {

		switch (recursion) {
		case RECURSION: {
			return binomialCoefficientUsingRecursion(n, k);
		}
		case RECURSION_MEMOIZATION: {
			int dp[][] = new int[n + 1][k + 1];
			return binomialCoefficientUsingRecursionAndMemoization(n, k, dp);
		}
		case BOTTOM_UP: {
			int dp[][] = new int[n + 1][k + 1];
			return binomialCoefficientUsingTopDown(n, k, dp);
		}

		default:
			throw new IllegalArgumentException("Unexpected value: " + recursion);
		}

	}

	private static int binomialCoefficientUsingTopDown(int n, int k, int[][] dp) {

		for (int i = 0; i <= n; i++) {
			dp[i][0] = 1;
			if (i <= k)
				dp[i][i] = 1;
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= k; j++) {
				dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
			}
		}

		return dp[n][k];
	}

	private static int binomialCoefficientUsingRecursion(int n, int k) {
		// Recurrance Relation :- C(n,k) = C(n-1,k-1) + C(n-1,k)
		// C(n,n) = 1 , c(n,0) = 1

		if (k == 0 || n == k)
			return 1;

		return binomialCoefficientUsingRecursion(n - 1, k - 1) + binomialCoefficientUsingRecursion(n - 1, k);
	}

	private static int binomialCoefficientUsingRecursionAndMemoization(int n, int k, int dp[][]) {
		// Recurrance Relation :- C(n,k) = C(n-1,k-1) + C(n-1,k)
		// C(n,n) = 1 , c(n,0) = 1

		if (k == 0 || n == k)
			return 1;

		if (dp[n][k] != 0)
			return dp[n][k];

		int result = binomialCoefficientUsingRecursionAndMemoization(n - 1, k - 1, dp)
				+ binomialCoefficientUsingRecursionAndMemoization(n - 1, k, dp);
		dp[n][k] = result;
		return result;
	}

}
