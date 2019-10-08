package Algorithms.Sorting;

import java.util.Scanner;



/**
 * @author Shrinath Joshi
 *	
 *	If the Input is less Quick sort works better than merge sort [As merge sort requires more recursive calls]	
 *
 *	The heart of quicksort Algorithm is PARTITION procedure, which selects a pivot elements and modifies the array
 *	into two half with one set of elements less than pivot element and other set of elements greater than pivot
 *
 *	Then, Quick sort procedure is applied on the above two sets recursively.
 *
 *	Time Complexity:-
 *		Best case :- when the pivot element divides the array into two equal sets
 *		Recurance Releation : T(n) = 2T(n/2) + cn
 *								   = O(nlogn)
 *
 * 		Worst case :- when the pivot element divides the array into two set of 1 element in one set and (n-1) 
 * 		element in other set
 * 		Reccurance Releation : T(n) = T(n-1) + cn
 * 									= O(n2)
 * 
 * 	Space Complexity:-
 *		Best case :- when the pivot element divides the array into two equal sets
 *								   = O(logn)
 *
 * 		Worst case :- when the pivot element divides the array into two set of 1 element in one set and (n-1) 
 * 		element in other set
 * 									=O(n2)
 * 		 		
 *
 */
public class QuickSort {

	public static void sortArray(int[] arr) {
		QUICK_SORT(arr,0,arr.length-1);
	}

	private static void QUICK_SORT(int[] arr, int p, int r) {
		
		if(p<r) {
			int q=PARTITION(arr,p,r);
			QUICK_SORT(arr, p, q-1);
			QUICK_SORT(arr,q+1,r);
		}
	}

	private static int PARTITION(int[] arr, int p, int r) {
	
		//Assuming the last element as pivot
		int pivot=arr[r];
		int i=p-1;
		int temp=0;
		for(int j=p;j<=r-1;j++) {
			if(arr[j]<pivot) {
				i++;
				temp=arr[i];
				arr[i]=arr[j];
				arr[j]=temp;
			}
		}
		temp=arr[i+1];
		arr[i+1]=arr[r];
		arr[r]=temp;
		
		return i+1;
	}

	
}

class QuickSortImplementation{
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

		
		QuickSort.sortArray(arr);
		
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
8
Enter the Elements
8 7 6 5 4 3 2 1
The Array before Sorting :8 7 6 5 4 3 2 1 
The Sorted Array :1 2 3 4 5 6 7 8 

 * 
 */