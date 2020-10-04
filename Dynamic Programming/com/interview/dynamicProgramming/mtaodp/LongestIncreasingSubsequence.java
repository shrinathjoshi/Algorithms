package com.interview.dynamicProgramming.mtaodp;

import java.util.Arrays;

/**
 * @author Shrinath Joshi
 *
 *         Longest increasing subsequence Subsequence : A subsequence of a given
 *         array is sequence formed by using subset of items from the original
 *         sequence maintaining their relative ordering.
 * 
 *         [5,2,3,6,8] [5,3,8] is a sub sequence.
 * 
 *         Subarray : A sub segment of a given array.
 * 
 *         [5,2,3] ,[2,3,6], [6,8] Increasing subsequence : A subsequence in
 *         which elements are sorted in ascending order. [2,3,6] [3,6,8] [2,3,8]
 * 
 *         Longest increasing subsequence [2,3,6,8]
 */
public class LongestIncreasingSubsequence {

	public int longestIncreasingSubsequence(int A[], int index) {
		// return lisUsingRecursion(A, index);
		// return lisUsingRecursionApproachTwo(A, A.length - 1);

		// return lisUsingRecursionAndMemoization(A, A.length - 1);

		return lisUsingBottomUp(A, A.length);
	}

	private int lisUsingBottomUp(int[] a, int index) {

		// Time Complexity :- O(n2)
		// Space Complexity : -O(n)

		int dp[] = new int[a.length + 1];
		Arrays.fill(dp, -1);
		return lisUsingBottomUp(a, index, dp);
	}

	private int lisUsingBottomUp(int[] A, int index, int[] dp) {
		dp[0] = 1;

		for (int i = 1; i < A.length; i++) {
			dp[i] = 1;
			for (int j = i - 1; j >= 0; j--) {
				if (A[i] > A[j])
					dp[i] = Math.max(dp[j] + 1, dp[i]);
			}
		}

		return dp[index - 1];
	}

	private int lisUsingRecursionAndMemoization(int[] a, int index) {
		int dp[] = new int[a.length + 1];
		Arrays.fill(dp, -1);
		return lisUsingRecursionAndMemoization(a, index, dp);
	}

	private int lisUsingRecursionAndMemoization(int[] A, int index, int[] dp) {

		if (index == 0)
			return 1;

		if (dp[index] != -1)
			return dp[index];

		int max = Integer.MIN_VALUE;

		for (int i = index - 1; i >= 0; i--) {
			// recursion
			int result = lisUsingRecursionApproachTwo(A, i);

			if (A[i] < A[index])
				result = result + 1;

			max = Integer.max(max, result);
		}
		dp[index] = max;
		return max;

	}

	private int lisUsingRecursionApproachTwo(int[] A, int index) {
		// Base Condition
		if (index == 0)
			return 1;

		int max = Integer.MIN_VALUE;

		for (int i = index - 1; i >= 0; i--) {
			// recursion
			int result = lisUsingRecursionApproachTwo(A, i);

			if (A[i] < A[index])
				result = result + 1;

			max = Integer.max(max, result);
		}
		return max;
	}

	private int lisUsingRecursion(int[] A, int index) {

		// Time Complexity :- O(2^n)
		// Space Complexity :- O(1)

		if (index == A.length - 1)
			return 1;

		if (index > A.length)
			return 0;

		int max = Integer.MIN_VALUE;

		if (index + 1 < A.length && A[index + 1] > A[index])
			max = Math.max(max, lisUsingRecursion(A, index + 1) + 1);
		else
			max = Math.max(max, lisUsingRecursion(A, index + 1));

		return max;
	}

	public static void main(String[] args) {
		int A[] = { 5, 2, 3, 6, 8 };
		System.out.println(new LongestIncreasingSubsequence().longestIncreasingSubsequence(A, 0));
	}

}
