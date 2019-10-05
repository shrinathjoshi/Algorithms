package Algorithms.Sorting;

import java.util.Scanner;

/**
 * @author Shrinath Joshi
 * 
 * Merge sort is an Out of Place Algorithm, here there are two main Procedure 
 * 1. Merge_Sort
 * 2. Merge
 * 
 * Merge_Sort divides the problem into smaller parts and the sorts it
 * Merge combines the two sorted list into a single sorted list.
 * 
 * Time Complexity:-
 *  	Recurrence Relation :- T(n) = 2T(n/2) + n
 *  	Best Case and Worst case :- O(nlogn)
 *  
 * Space Complexity:-
 * 		Merge procedure  :- O(n)
 * 		Merge_Sort stack :- O(logn)
 *   +
 *-------------------------------------------
 *     Total Space Complexity = O(n+logn)
 *     for Merge Sort 
 *							  = O(n)  [as n > logn ]
 *
 */
public class MergeSort {

	public static void sortArray(int[] arr) {
		Merge_Sort(arr,0,arr.length-1);
	}

	private static void Merge_Sort(int[] arr, int p, int r) {
		
		if(p<r) {
			int mid=(p+r)/2;
			Merge_Sort(arr,p, mid);
			Merge_Sort(arr, mid+1, r);
			Merge(arr,p,mid,r);
		}
	}

	private static void Merge(int[] arr, int p, int q, int r) {
		int n1 = q-p+1;
		int n2 = r-q;
		int i=0,j=0,k=0;
		int L[]=new int [n1+1];
		int R[]=new int [n2+1];
		
		for(int i1=0;i1<n1;i1++)
			L[i1]=arr[p+i1];
		
		for(int i1=0;i1<n2;i1++)
			R[i1] = arr[q+i1+1];
		
		L[n1]=Integer.MAX_VALUE;
		R[n2]=Integer.MAX_VALUE;
		
		
		for( k=p;k<=r;k++) {
			if(L[i]>=R[j]) {
				arr[k]=R[j];
				j++;
			}else
			{
				arr[k]=L[i];
				i++;
			}
		}
			
	}

	
}

 class MergeSortImplementation{
	public static void main(String[] args) {

		Scanner s=new Scanner(System.in);
		System.out.println("Enter the number of Elements");
		
		int n=s.nextInt();
		int arr[]=new int[n];
		
		System.out.println("Enter the Elements");
		for(int i=0;i<n;i++)
			arr[i]=s.nextInt();
		
		System.out.print("The Array before Sorting :");
		printArray(arr);

		
		MergeSort.sortArray(arr);
		
		System.out.print("The Sorted Array :");
		printArray(arr);
	}

	private static void printArray(int[] arr) {
		for(int i :arr)
			System.out.print(i+" ");
		System.out.println();
	}
}
 
/*
 * 
Enter the number of Elements
6
Enter the Elements
6 5 4 3 2 1
The Array before Sorting :6 5 4 3 2 1 
The Sorted Array :1 2 3 4 5 6 

 *								
 */
 
 
 