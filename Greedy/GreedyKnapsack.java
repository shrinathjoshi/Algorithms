import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;


/**
 * @author Shrinath Joshi
 * 
 * Greedy Knapsack: Given weights and values of n items, we need to put these items in a 
 * knapsack of capacity W to get the maximum total value in the knapsack.
 * 
 * Time complexity:- O(nlogn)
 * Space Complexity:- O(n)
 * 
 */

public class GreedyKnapsack {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the total Knapsack size");
		int totalKnapsackSize=sc.nextInt();

		System.out.println("Enter the no of items");
		int n=sc.nextInt();
		
		System.out.println("For each item , enter profit and weight");
		int profit[]= new int[n];
		int weight[]= new int[n];
		
		for(int i =0;i<n;i++) {
			profit[i]=sc.nextInt();
			weight[i]=sc.nextInt();
		}
		
		double result = GreedyKnapsack(totalKnapsackSize,n,profit,weight);
		
		System.out.println("The total Profit is :" + result);
	}

	private static double GreedyKnapsack(int totalKnapsackSize, int n, int[] profit, int[] weight) {

		
		Item item[] = new Item[n];
		
		for(int i=0;i<n;i++)
			item[i]=new Item(i,profit[i],weight[i],profit[i]/weight[i]);
		
		
		Arrays.sort(item,new Comparator<Item>() {

			@Override
			public int compare(Item o1, Item o2) {
				return (o2.getProfitPerWeight()).compareTo(o1.getProfitPerWeight()) ;
			}
		});
		
		double totalProfit=0;
		
		int i=0;
		for(;i<item.length;i++)
		{
			if(totalKnapsackSize>0 && item[i].getWeight()<=totalKnapsackSize) {
				totalKnapsackSize=(int) (totalKnapsackSize-item[i].getWeight());
				totalProfit=totalProfit+item[i].getProfit();
			}
			else
				break;
		}
		
		if(totalKnapsackSize>0)
			totalProfit=+(totalKnapsackSize*item[i].getProfitPerWeight());
	
		
		return totalProfit;
	}
}

class Item{
	private int index;
	private double profit;
	private double weight;
	private double profitPerWeight;
	
	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public double getProfit() {
		return profit;
	}

	public void setProfit(double value) {
		this.profit = value;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public Double getProfitPerWeight() {
		return profitPerWeight;
	}

	public void setProfitPerWeight(double valuePerWeight) {
		this.profitPerWeight = valuePerWeight;
	}

	public Item(int index, double value, double weight, double valuePerWeight) {
		super();
		this.index = index;
		this.profit = value;
		this.weight = weight;
		this.profitPerWeight = valuePerWeight;
	}
		
}


/*
Enter the total Knapsack size
15
Enter the no of items
5
For each item , enter profit and weight
2 1
28 4
25 5
18 3
9 3
The total Profit is :80.0

 
*/
