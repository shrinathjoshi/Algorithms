package com.interview.dynamicProgramming.Knapsack;

public class ZeroOneKnapsack{
	
	ZeroOneKnapsackStrategy zeroOneKnapsackStrategy;

	public ZeroOneKnapsackStrategy getZeroOneKnapsackStrategy() {
		return zeroOneKnapsackStrategy;
	}

	public void setZeroOneKnapsackStrategy(ZeroOneKnapsackStrategy zeroOneKnapsackStrategy) {
		this.zeroOneKnapsackStrategy = zeroOneKnapsackStrategy;
	}

	public ZeroOneKnapsack() {
	}
	public int getProfit() {
		return zeroOneKnapsackStrategy.getMaximumProfit();
	}
}