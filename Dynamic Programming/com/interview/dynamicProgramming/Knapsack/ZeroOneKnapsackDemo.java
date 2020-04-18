package com.interview.dynamicProgramming.Knapsack;

import java.time.Duration;
import java.time.Instant;

import com.interview.dynamicProgramming.Knapsack.ZeroOneKnapsack;
import com.interview.dynamicProgramming.Knapsack.ZeroOneKnapsackStrategy;
import com.interview.dynamicProgramming.Knapsack.ZeroOneKnapsackUsingBottomUpApproach;
import com.interview.dynamicProgramming.Knapsack.ZeroOneKnapsackUsingTopDownApproach;
import com.interview.dynamicProgramming.Knapsack.ZeroOneKnapsackUsingTopDownApproachWithMemoizataion;

public class ZeroOneKnapsackDemo {

	public static void main(String[] args) {

		int val[] = new int[] { 60, 100, 120 };
		int wt[] = new int[] { 10, 20, 30 };
		int W = 50;

		
		ZeroOneKnapsackStrategy bottomUpApproach = new ZeroOneKnapsackUsingBottomUpApproach(val, wt, W);
		ZeroOneKnapsackStrategy topDownApproach = new ZeroOneKnapsackUsingTopDownApproach(val, wt, W);
		ZeroOneKnapsackStrategy topDownApproachUsingMemoization = new ZeroOneKnapsackUsingTopDownApproachWithMemoizataion(val, wt, W);

		getMaxProfit(bottomUpApproach);
		getMaxProfit(topDownApproach);
		getMaxProfit(topDownApproachUsingMemoization);
	
	}

	private static void getMaxProfit(ZeroOneKnapsackStrategy knapsackStrategy) {
		ZeroOneKnapsack knapsack = new ZeroOneKnapsack();
		knapsack.setZeroOneKnapsackStrategy(knapsackStrategy);

		Instant start = Instant.now();
		System.out.println("\nThe Maximumum Profit ïs - "+ knapsack.getProfit());
		Instant end = Instant.now();
		
		long timeElapsed = Duration.between(start, end).toMillis();
		System.out.println("Time Taken to execute "+timeElapsed);
		
		System.out.println();
	}
}

/*
OUTPUT-:-
 #### Bottom Up Approach ####
The Maximumum Profit ïs - 220
Time Taken to execute 1

 #### Top Down Approach without Memoization ####
The Maximumum Profit ïs - 220
Time Taken to execute 1

 #### Top Down Approach with Memoization ####
The Maximumum Profit ïs - 220
Time Taken to execute 0


 */

