package com.interview.dynamicProgramming.mtaodp.TwoDimensionalDynamicProgramming;

/**
 * @author Shrinath Joshi
 *
 *         Given a string S and a regular expression R, write a function to
 *         check if the S matches the regular expression R. S only contains
 *         letters and numbers. A regular expression consists of 1. Letters A-Z
 *         2. Numbers 0-9 3. ‘*’ - Matches 0 or more characters. 4. ‘.’ -
 *         Matches one character. For example: S=“ABBBAC” R = “.*A*” Return true
 */
public class RegularExpressionMatching {

	public static void main(String[] args) {
		String S = "ABBBAC", R = ".*A*";

		System.out.println(RegularExpressionMatching.matches(S.length() - 1, R.length() - 1, S, R));
		System.out.println(RegularExpressionMatching.matchesMemoization(S.length() - 1, R.length() - 1, S, R));
		System.out.println(RegularExpressionMatching.matchesBottomUp(S, R));

	}

	private static boolean matchesBottomUp(String s, String r) {

		// Time Complexity:- O(N2)
		// Space Complexity :- O(N2)

		boolean cache[][] = new boolean[s.length()][r.length()];

		return matchesBottomUp(s, r, cache);

	}

	private static boolean matchesBottomUp(String S, String R, boolean[][] cache) {
		cache[0][0] = true;

		for (int i = 1; i <= S.length() - 1; i++) {
			for (int j = 1; j <= R.length() - 1; j++) {

				if (S.charAt(i - 1) == R.charAt(j - 1)) {
					cache[i][j] = cache[i - 1][j - 1];
				} else if (R.charAt(j - 1) == '.') {
					cache[i][j] = cache[i - 1][j - 1];
				} else if (R.charAt(j - 1) == '*') {
					cache[i][j] = cache[i - 1][j] || cache[i][j - 1];
				}
			}
		}

		return cache[S.length() - 1][R.length() - 1];
	}

	private static boolean matches(int i, int j, String s, String r) {

		// Time Complexity:- O(2^N)
		// Space Complexity :- O(1)

		if (i == -1 && j == -1 || r.substring(0, j).equals("*"))
			return true;

		if (i == -1 || j == -1)
			return false;

		if (r.charAt(j) == s.charAt(i))
			return matches(i - 1, j - 1, s, r);

		if (r.charAt(j) == '.')
			return matches(i - 1, j - 1, s, r);

		if (r.charAt(j) == '*')
			return matches(i - 1, j, s, r) || matches(i, j - 1, s, r);

		return false;

	}

	private static boolean matchesMemoization(int i, int j, String s, String r) {

		Boolean cache[][] = new Boolean[s.length()][r.length()];

		return matchesMemoization(i, j, s, r, cache);

	}

	private static boolean matchesMemoization(int i, int j, String s, String r, Boolean[][] cache) {

		if ((i == -1 && j == -1) || r.substring(0, j).equals("*"))
			return true;

		if (i == -1 || j == -1)
			return false;

		if (cache[i][j] != null)
			return cache[i][j];

		if (r.charAt(j) == s.charAt(i))
			cache[i][j] = matches(i - 1, j - 1, s, r);
		else if (r.charAt(j) == '.')
			cache[i][j] = matches(i - 1, j - 1, s, r);
		else if (r.charAt(j) == '*')
			cache[i][j] = matches(i - 1, j, s, r) || matches(i, j - 1, s, r);

		return cache[i][j];
	}

}
