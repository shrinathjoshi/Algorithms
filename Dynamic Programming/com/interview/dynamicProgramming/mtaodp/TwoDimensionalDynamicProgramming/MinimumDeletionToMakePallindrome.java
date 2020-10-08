package com.interview.dynamicProgramming.mtaodp.TwoDimensionalDynamicProgramming;

import java.util.Arrays;

/**
 * 
 * @author Shrinath Joshi
 * 
 * 
 *         Given a string S, find out minimum number of deletions required to
 *         make the string a palindrome. Note : Palindrome is a string which is
 *         same when read backwards and forward. For example : Civic, Kayak,
 *         Level etc KAZAYAKE We can delete Z and E, to make the word = KAYAK
 *
 */
public class MinimumDeletionToMakePallindrome {

	public static int minDeletionPalindrome(int startIndex, int endIndex, String s) {

		if (startIndex >= endIndex)
			return 0;

		if (s.charAt(startIndex) == s.charAt(endIndex))
			return minDeletionPalindrome(startIndex + 1, endIndex - 1, s);

		return Math.min(minDeletionPalindrome(startIndex + 1, endIndex, s),
				minDeletionPalindrome(startIndex, endIndex - 1, s)) + 1;
	}

	public static int minDeletionMemoization(int startIndex, int endIndex, String s) {
		int cache[][] = new int[s.length() + 1][s.length() + 1];
		for (int[] i : cache) {
			Arrays.fill(i, -1);
		}
		return minDeletionMemoization(startIndex, endIndex, s, cache);
	}

	private static int minDeletionMemoization(int startIndex, int endIndex, String s, int cache[][]) {

		if (startIndex >= endIndex)
			return 0;

		if (cache[startIndex][endIndex] != -1)
			return cache[startIndex][endIndex];

		int result = Integer.MAX_VALUE;
		if (s.charAt(startIndex) == s.charAt(endIndex))
			result = Math.min(minDeletionMemoization(startIndex + 1, endIndex - 1, s), result);
		else
			result = Math.min(result, Math.min(minDeletionMemoization(startIndex + 1, endIndex, s),
					minDeletionMemoization(startIndex, endIndex - 1, s)) + 1);

		return result;
	}

	public static void main(String[] args) {
		String s = "KAZAYAKE";

		System.out.println(MinimumDeletionToMakePallindrome.minDeletionPalindrome(0, s.length() - 1, s));
		System.out.println(MinimumDeletionToMakePallindrome.minDeletionMemoization(0, s.length() - 1, s));
		System.out.println(MinimumDeletionToMakePallindrome.minDeletionBottomUp(0, s.length() - 1, s));

	}

	private static int minDeletionBottomUp(int startIndex, int endIndex, String s) {
		int cache[][] = new int[s.length()][s.length()];
		for (int[] i : cache) {
			Arrays.fill(i, -1);
		}
		return minDeletionBottomUp(startIndex, endIndex, s, cache);
	}

	private static int minDeletionBottomUp(int startIndex, int endIndex, String s, int[][] cache) {
		int n = s.length();
		for (int l = 1; l <= n; l++) {
			for (int i = 0; i <= n - l; i++) {
				int j = i + l - 1;

				if (i == j) {
					cache[i][j] = 0;
					continue;
				}

				if (s.charAt(i) == s.charAt(j))
					cache[i][j] = cache[i + 1][j - 1];
				else
					cache[i][j] = Math.min(cache[i + 1][j], cache[i][j - 1]) + 1;
			}

		}

		return cache[0][n - 1];
	}

}
