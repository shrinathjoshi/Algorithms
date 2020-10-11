package com.interview.dynamicProgramming.mtaodp.TwoDimensionalDynamicProgramming;

import java.util.Arrays;

public class EditDistance {

	public static void main(String[] args) {
		String A = "GOAT", B = "GET";

		System.out.println(EditDistance.editDistanceRecursive(A.length() - 1, B.length() - 1, A, B));
		System.out.println(EditDistance.editDistanceMemoization(A.length() - 1, B.length() - 1, A, B));
		System.out.println(EditDistance.editDistanceBottomUp(A, B));

	}

	private static int editDistanceBottomUp(String a, String b) {
		int cache[][] = new int[a.length()][b.length()];
		for (int[] c : cache) {
			Arrays.fill(c, -1);
		}
		return editDistanceBottomUp(a, b, cache);
	}

	private static int editDistanceBottomUp(String a, String b, int[][] cache) {

		// Time Complexity :- O(N2)
		// Space Complexity :- O(N2)

		for (int i = 0; i < a.length(); i++) {
			for (int j = 0; j < b.length(); j++) {

				if (i == 0)
					cache[i][j] = j;
				else if (j == 0)
					cache[i][j] = i;
				else if (a.charAt(i) == b.charAt(j))
					cache[i][j] = cache[i - 1][j - 1];
				else
					cache[i][j] = Math.min(cache[i - 1][j], cache[i][j - 1]) + 1;
			}
		}

		return cache[a.length() - 1][b.length() - 1];
	}

	private static int editDistanceMemoization(int i, int j, String a, String b) {
		int cache[][] = new int[a.length() + 1][b.length() + 1];
		for (int[] c : cache) {
			Arrays.fill(c, -1);
		}
		return editDistanceMemoization(i, j, a, b, cache);
	}

	private static int editDistanceMemoization(int i, int j, String a, String b, int[][] cache) {
		if (i == -1)
			return j + 1;

		if (j == -1)
			return i + 1;

		if (cache[i][j] != -1)
			return cache[i][j];

		int length = Integer.MAX_VALUE;
		if (a.charAt(i) == b.charAt(j))
			length = Math.min(editDistanceRecursive(i - 1, j - 1, a, b), length);
		else
			length = Math.min(
					Math.min(editDistanceRecursive(i - 1, j, a, b), editDistanceRecursive(i, j - 1, a, b)) + 1, length);

		cache[i][j] = length;
		return length;
	}

	private static int editDistanceRecursive(int i, int j, String a, String b) {

		// Time Complexity :- O(2^N)
		// Space Complexity :- O(1)

		if (i == -1)
			return j + 1;

		if (j == -1)
			return i + 1;

		if (a.charAt(i) == b.charAt(j))
			return editDistanceRecursive(i - 1, j - 1, a, b);
		else
			return Math.min(editDistanceRecursive(i - 1, j, a, b), editDistanceRecursive(i, j - 1, a, b)) + 1;

	}

}
