package com.interview.dynamicProgramming.mtaodp.TwoDimensionalDynamicProgramming;

import java.util.Arrays;

/**
 * @author Shrinath Joshi
 * 
 *         You are given a grid. You start at (0,0), top-left corner and you
 *         have to reach bottom left corner. You can only move down or right.
 *         Find out the minimum cost to reach the destination
 *
 *
 *
 */

public class MinCost {

	public static int minCostPath(int currentRow, int currentColumn, int[][] grid) {

		/*
		 * We draw recursion tree. Its a binary tree. Height of the tree is 2N. Number
		 * of nodes in the tree = 2^2N = 4N ,Time complexity is :- O(4N) Exponential
		 * Space complexity O(1)
		 */

		if (currentRow == 0 && currentColumn == 0)
			return grid[0][0];

		if (currentRow == 0)
			return grid[0][currentColumn];

		if (currentColumn == 0)
			return grid[currentRow][0];

		int maxCostPathLenght = Integer.MAX_VALUE;
		if (currentRow > 0)
			maxCostPathLenght = Math.min(
					minCostPath(currentRow - 1, currentColumn, grid) + grid[currentRow][currentColumn],
					maxCostPathLenght);

		if (currentColumn > 0)
			maxCostPathLenght = Math.min(
					minCostPath(currentRow, currentColumn - 1, grid) + grid[currentRow][currentColumn],
					maxCostPathLenght);

		return maxCostPathLenght;

	}

	public static int minCostPathMemoization(int currentRow, int currentColumn, int[][] grid) {

		int cache[][] = new int[currentRow + 1][currentColumn + 1];
		for (int[] i : cache) {
			Arrays.fill(i, -1);
		}

		return minCostPathMemoization(currentRow, currentColumn, grid, cache);
	}

	public static int minCostPathMemoization(int currentRow, int currentColumn, int[][] grid, int cache[][]) {

		if (currentRow == 0 && currentColumn == 0)
			return grid[0][0];

		if (currentRow == 0)
			return grid[0][currentColumn];

		if (currentColumn == 0)
			return grid[currentRow][0];

		int maxCostPathLenght = Integer.MAX_VALUE;
		if (currentRow > 0)
			maxCostPathLenght = Math.min(
					minCostPath(currentRow - 1, currentColumn, grid) + grid[currentRow][currentColumn],
					maxCostPathLenght);

		if (currentColumn > 0)
			maxCostPathLenght = Math.min(
					minCostPath(currentRow, currentColumn - 1, grid) + grid[currentRow][currentColumn],
					maxCostPathLenght);

		return maxCostPathLenght;

	}

	public static int minCostPathBottomUp(int currentRow, int currentColumn, int[][] grid) {

		int cache[][] = new int[currentRow + 1][currentColumn + 1];
		for (int[] i : cache) {
			Arrays.fill(i, -1);
		}

		return minCostPathBottomUp(grid, cache);
	}

	public static int minCostPathBottomUp(int[][] grid, int cache[][]) {

		// Time complexity :- O(n2)
		// Space complexity :- O(n2)

		int rows = grid.length;
		int column = grid[0].length;

		cache[0][0] = grid[0][0];

		for (int i = 0; i < rows; i++)
			cache[i][0] = grid[i][0];

		for (int i = 0; i < column; i++)
			cache[0][i] = grid[0][i];

		for (int i = 1; i < rows; i++) {
			for (int j = 1; j < column; j++) {
				cache[i][j] = Math.min(cache[i - 1][j], cache[i][j - 1]);
			}
		}

		return cache[rows][column];
	}

	public static void main(String[] args) {
		int grid[][] = { { 0, 47, 8, 18, 1 }, { 43, 25, 39, 36, 13 }, { 22, 8, 13, 38, 46 }, { 41, 41, 40, 25, 44 },
				{ 29, 43, 22, 50, 10 } };

		System.out.println(MinCost.minCostPath(grid.length - 1, grid[0].length - 1, grid));
		System.out.println(MinCost.minCostPathMemoization(grid.length - 1, grid[0].length - 1, grid));
		System.out.println(MinCost.minCostPathBottomUp(grid.length - 1, grid[0].length - 1, grid));

	}

}
