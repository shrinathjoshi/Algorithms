package com.interview.dynamicProgramming.mtaodp.TwoDimensionalDynamicProgramming;

import java.util.Arrays;

/**
 * @author Shrinath Joshi
 * 
 *         Longest common subsequence. Given two strings A and B, Find the
 *         length of the longest common subsequence.
 * 
 * 
 *         A=“ACHEFMGLP”
 * 
 *         B=“XYCEPQMLG”
 * 
 *         output = 4 , “CEMG” is the longest common subsequence
 * 
 */
public class LongestCommonSubsequence {

	public static void main(String[] args) {
		String A = "ACHEFMGLP";
		String B = "XYCEPQMLG";

		System.out.println(LongestCommonSubsequence.longestCommonSubsequenceRecursion(A, B));
		System.out.println(LongestCommonSubsequence.longestCommonSubsequenceMemoization(A, B));
		System.out.println(LongestCommonSubsequence.longestCommonSubsequenceBottomUp(A, B));

	}

	public static int longestCommonSubsequenceRecursion(String s1, String s2) {

		// Time complexity :- O(2^N)
		// Space Complexity :- O(1)

		return longestCommonSubsequenceRecursion(s1.length() - 1, s2.length() - 1, s1, s2);
	}

	public static int longestCommonSubsequenceRecursion(int i, int j, String s1, String s2) {

		if (i == -1 || j == -1)
			return 0;

		if (s1.charAt(i) == s2.charAt(j))
			return longestCommonSubsequenceRecursion(i - 1, j - 1, s1, s2) + 1;
		else
			return Math.max(longestCommonSubsequenceRecursion(i - 1, j, s1, s2),
					longestCommonSubsequenceRecursion(i, j - 1, s1, s2));

	}

	private static int longestCommonSubsequenceBottomUp(String a, String b) {

		// Time complexity :- O(n2)
		// Space Complexity :- O(n2)

		int cache[][] = new int[a.length() + 1][b.length() + 1];
		for (int[] i : cache) {
			Arrays.fill(i, 0);
		}
		return longestCommonSubsequenceBottomUp(a, b, cache);
	}

	private static int longestCommonSubsequenceBottomUp(String a, String b, int[][] cache) {

		for (int i = 0; i < a.length(); i++)
			cache[i][0] = 0;

		for (int i = 0; i < b.length(); i++)
			cache[0][i] = 0;

		for (int i = 1; i < a.length(); i++) {
			for (int j = 1; j < b.length(); j++) {

				if (a.charAt(i) == b.charAt(j)) {
					cache[i][j] = cache[i - 1][j - 1] + 1;
				} else {
					cache[i][j] = Math.max(cache[i - 1][j], cache[i][j - 1]);
				}
			}
		}

		return cache[a.length() - 1][b.length() - 1];
	}

	private static int longestCommonSubsequenceMemoization(String a, String b) {
		int cache[][] = new int[a.length() + 1][b.length() + 1];
		for (int[] i : cache) {
			Arrays.fill(i, -1);
		}
		return longestCommonSubsequenceMemoization(a.length() - 1, b.length() - 1, a, b, cache);
	}

	public static int longestCommonSubsequenceMemoization(int i, int j, String s1, String s2, int cache[][]) {

		if (i == -1 || j == -1)
			return 0;

		if (cache[i][j] != -1)
			return cache[i][j];

		if (s1.charAt(i) == s2.charAt(j))
			cache[i][j] = longestCommonSubsequenceMemoization(i - 1, j - 1, s1, s2, cache) + 1;
		else
			cache[i][j] = Math.max(longestCommonSubsequenceMemoization(i - 1, j, s1, s2, cache),
					longestCommonSubsequenceMemoization(i, j - 1, s1, s2, cache));

		return cache[i][j];
	}
}
