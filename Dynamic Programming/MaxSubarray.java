/**
 * @author Shrinath Joshi
 * 
 * LeetCode problem:- https://leetcode.com/problems/maximum-subarray/
 * 53. Max Subarray
 *
 * 3 Approaches to solve this question
 * 		1. Using Dynamic Programming 
 * 			Time complexity:- O(n)
 * 			Space complexity :- O(n)
 * 
 * 		2. Using Divide and Conquer 
 * 			Time complexity:- O(n)
 * 			Space complexity :- O(1)
 * 
 * 		3. Using Scaning Algorithm ( optimization of 1st Approach) 
 * 			Time complexity:- O(n)
 * 			Space complexity :- O(1)
 *
 */

public class MaxSubarray {

	 public int maxSubArray(int[] nums) {
	     
		 /*
		  * Time complexity:- O(n)
		  * Space complexity:- O(n)
		  */
		 
	        int n= nums.length;
	        int dp[]=new int[n];
	        dp[0]=nums[0];
	        
	        for(int i =1;i<n;i++){
	            dp[i]=Math.max(dp[i-1]+nums[i],nums[i]);
	        }
	        
	        int max=Integer.MIN_VALUE;
	        for(int i =0;i<n;i++)
	            if(max<dp[i])
	                max=dp[i];
	        
	        return max;
	        
	    }
	
	 public int maxSubArrayUsingDivideAndConquer(int [] nums) {
		 
		/*
		 * This problem can be solved using Divide and Conquer technique
		 * 
		 * Recurrence Relation :-
		 * 	T(n) = 2T(n/2)+O(n)
		 * 
		 * Time complexity :- O(nlogn)
		 * Space complexity :- O(1)
		 *  
		 */
		 
		 
		return  maximumSubArray(nums,0,nums.length-1);
	 }

	private int maximumSubArray(int[] nums, int left, int right) {
		if(right<left) return 0;
		
		if(left == right) return Math.max(nums[left], 0);
		
		int mid= (left+right)/2;
		
		int maxToLeft =0;
		int sum=0;
		for(int i=mid;i>=left;i--)
		{
			sum=sum+nums[i];
			maxToLeft=Math.max(maxToLeft, sum);
		}
		
		int maxToRight =0;
		sum=0;
		for(int i=mid+1;i<=right;i++)
		{
			sum=sum+nums[i];
			maxToRight=Math.max(maxToRight, sum);
		}

		int leftResult= maximumSubArray(nums, left, mid);
		int rightResult= maximumSubArray(nums, mid+1, right);
		int intermediateResult= Math.max(leftResult, rightResult);
		return Math.max(maxToLeft+maxToRight, intermediateResult);
	}

	public int maxSubArrayUsingScaningAlgorithm(int[] nums) {
		
		/*
		 * Time complexity:- O(n)
		 * Space complexity :- O(1)
		 */
		
		int maxSoFar=nums[0];
		int maxEndingHere=nums[0];
		
		for(int i=1;i<nums.length;i++) {
			maxEndingHere=Math.max(maxEndingHere+nums[i],nums[i]);
			maxSoFar=Math.max(maxSoFar, maxEndingHere);
		}
		return maxSoFar;
	}
	
	
	public static void main(String[] args) {

		int arr[]= {-2,1,-3,4,-1,2,1,-5,4};
		MaxSubarray maxSub= new MaxSubarray();
		System.out.println("The Max Subarray is "+maxSub.maxSubArray(arr));
		System.out.println("The Max Subarray is  using Divide and Conquer Technique is "+maxSub.maxSubArrayUsingDivideAndConquer(arr));
		System.out.println("The Max Subarray is  using Scaning Algorithm is "+maxSub.maxSubArrayUsingScaningAlgorithm(arr));
		
	}

}

/*
OUTPUT:-
The Max Subarray is 6
The Max Subarray is  using Divide and Conquer Technique is 6
The Max Subarray is  using Scaning Algorithm is 6 
 */

