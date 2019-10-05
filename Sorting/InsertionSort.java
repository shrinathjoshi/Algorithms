import java.util.Scanner;

/**
 * @author Shrinath Joshi
 * 
 * Hackerrank 
 * https://www.hackerrank.com/challenges/insertionsort2/problem
 *
 */

public class InsertionSort {

	 static void insertionSort2(int n, int[] arr) {
	        int key=0;
	        int j=0;
	        for(int i =1;i<n;i++){
	            key=arr[i];
	            j=i-1;
	            while(j>=0){
	                if(arr[j] > key){
	                    arr[j+1] = arr[j];
	                }
	                else break;
	                j--;
	            }
	            arr[j+1]=key;
	            printList(arr);
	        }
	    }

	    static void printList(int arr[]){
	        for(int i =0;i<arr.length;i++)
	            System.out.print(arr[i]+" ");
	        
	        System.out.println();
	    }
	    private static final Scanner scanner = new Scanner(System.in);

	    public static void main(String[] args) {
	        int n = scanner.nextInt();
	        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

	        int[] arr = new int[n];

	        String[] arrItems = scanner.nextLine().split(" ");
	        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

	        for (int i = 0; i < n; i++) {
	            int arrItem = Integer.parseInt(arrItems[i]);
	            arr[i] = arrItem;
	        }

	        insertionSort2(n, arr);

	        scanner.close();
	    }
}

/*
 
INPUT:-
6
1 4 3 5 6 2

OUTPUT:-
1 4 3 5 6 2 
1 3 4 5 6 2 
1 3 4 5 6 2 
1 3 4 5 6 2 
1 2 3 4 5 6 

Time Complexity :-
	Best Case - O(n)
	Worst Case -O(n^2)
	
Space Complexity :- O(1)
	
 */



