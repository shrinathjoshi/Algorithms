import java.util.ArrayList;
import java.util.List;

/*
Given an input array and an integer ‘K’ which is atmost the size of the
array, generate all the ways we can choose K integers from the array

Example
Input = [3,2,5,8] , K=3
[3, 2, 5]
[3, 2, 8]
[3, 5, 8]
[2, 5, 8]


 */
public class GenerateWaysToChooseKIntegers {

	public static void main(String[] args) {
		int arr[] = { 3, 2, 5, 8 };
		int k = 3;

		ArrayList<ArrayList<Integer>> result = GenerateWaysToChooseKIntegers.generateWays(arr, k);

		for (List<Integer> res : result) {
			for (Integer r : res)
				System.out.print(r + " ");
			System.out.println();
		}
	}

	private static ArrayList<ArrayList<Integer>> generateWays(int[] arr, int k) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> result1 = new ArrayList<ArrayList<Integer>>();

		ArrayList<Integer> partialSolution = new ArrayList<Integer>();

		// Two Approaches to solve this problem
		// you should use any one Approach
		generateWaysUsingBacktracking(0, arr, partialSolution, k, result);
		generateWaysUsingBacktrackingAlternativeApproach(0, arr, partialSolution, k, result1);

		return result;
	}

	private static void generateWaysUsingBacktrackingAlternativeApproach(int index, int[] arr,
			ArrayList<Integer> partialSolution, int k, ArrayList<ArrayList<Integer>> result) {

		if (partialSolution.size() == k) {
			result.add(new ArrayList<Integer>(partialSolution));
			return;
		}

		if (index >= arr.length)
			return;

		partialSolution.add(arr[index]);
		generateWaysUsingBacktrackingAlternativeApproach(index + 1, arr, partialSolution, k, result);
		partialSolution.remove(partialSolution.size() - 1);
		generateWaysUsingBacktrackingAlternativeApproach(index + 1, arr, partialSolution, k, result);
	}

	private static void generateWaysUsingBacktracking(int index, int[] arr, ArrayList<Integer> partialSolution, int k,
			ArrayList<ArrayList<Integer>> result) {
		if (partialSolution.size() == k) {
			result.add(new ArrayList<Integer>(partialSolution));
			return;
		}

		for (int i = index; i < arr.length; i++) {
			partialSolution.add(arr[i]);
			generateWaysUsingBacktracking(i + 1, arr, partialSolution, k, result);
			partialSolution.remove(partialSolution.size() - 1);
		}
	}

}
