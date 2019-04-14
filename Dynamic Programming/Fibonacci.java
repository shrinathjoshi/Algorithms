/**
@author Shrinath Joshi

*/

// PROBLEM STATEMENT
// Finding the Nth  Term of the Fibonacci Series

// Approach 1
// Using Dynamic Programming using the recurrence Releation
// T(n) = T(n-2)+T(n-1)
// Time Complexity :- O(2^n)


// Approach 2 
// Using Dynamic Programming using the recurrence Releation with MEMORIZATION
// Storing Fibonacci value of every subproblem 
// Time Complexity :- O(n)
// Space complexity :- O(n)

import java.io.*;
import java.util.*;
import java.text.ParseException;
import java.util.concurrent.TimeUnit;

public class Fibonacci{

	private final static int MAX=10000;
	private final static int NIL =-1;
	private static int fibbo[]=new int[MAX];
	
	public static void main(String args[])
	{
			Scanner sc=new Scanner(System.in);

			System.out.println("Enter the nth term of the Fibonacci series");
			int number=sc.nextInt();


			int resultRecursion=fibonacciRecursive(number);
			System.out.println("Result using Recursive Approach : "+resultRecursion);

			int resultMemorization=fibonacciMermorization(number);
			System.out.println("Result using Mermorization Approach : "+resultMemorization);


	}

	public static int fibonacciRecursive(int number)
	{
		long startTime = System.currentTimeMillis();
		int result=fibonacciRecursiveApprach(number);
	    long endTime = System.currentTimeMillis();
 
    	long durationInMillis = (endTime - startTime);  //Total execution time in milli seconds
    	System.out.println("Execution Time using Recursive Approach : "+durationInMillis+" milli sec");

    	return result;
 
	}

	public static int fibonacciMermorization(int number)
	{
		long startTime = System.currentTimeMillis();
 		initialize();
		int result=fibonacciMermorizationApprach(number);
	    long endTime = System.currentTimeMillis();
 
    	long durationInMillis = (endTime - startTime);  //Total execution time in milli seconds
    	System.out.println("Execution Time using Recursive Approach : "+durationInMillis+" milli sec");

    	return result;
 
	}

	public static int fibonacciRecursiveApprach(int number)
	{
		 if(number<=1)
		 	return number;
		 else
		 	return fibonacciRecursiveApprach(number-1)+fibonacciRecursiveApprach(number-2);
	}


	public static int fibonacciMermorizationApprach(int number)
	{
		if(fibbo[number] == NIL)
		{
		if(number<=1)
		 	return fibbo[number]=number;
		 else
		 	return  fibbo[number]=fibonacciMermorizationApprach(number-1)+fibonacciMermorizationApprach(number-2);	
		}
		else
			return fibbo[number];
		 
	}
	public static  void initialize() 
  	{ 
    	for (int i = 0; i < MAX; i++) 
        	fibbo[i] = NIL; 
  	} 


}



/*

E:\Data Structure and algorithm\Dynamic Programming>java Fibonacci
Enter the nth term of the Fibonacci series
40
Execution Time using Recursive Approach : 390 milli sec
Result using Recursive Approach : 102334155
Execution Time using Recursive Approach : 0 milli sec
Result using Mermorization Approach : 102334155

*/