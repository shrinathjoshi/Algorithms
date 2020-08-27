import java.util.ArrayList;
import java.util.List;

/*
Problem Statement :- https://leetcode.com/problems/subsets/

Solution :-


Time Complexity :- O(2^N)
Space Complexity :- O(N)
 */
public class Subsets {

	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> subsets = new ArrayList<>();
		generateSubsets(0, new ArrayList<>(), nums, subsets);
		return subsets;
	}

	public void generateSubsets(int index, List<Integer> partialSolution, int nums[], List<List<Integer>> subsets) {
		subsets.add(new ArrayList<>(partialSolution));

		for (int i = index; i < nums.length; i++) {
			partialSolution.add(nums[i]);
			generateSubsets(i + 1, partialSolution, nums, subsets);
			partialSolution.remove(partialSolution.size() - 1);
		}
	}

	public static void main(String[] args) {
		int input[] = { 1, 2, 3 };
		List<List<Integer>> result = new Subsets().subsets(input);

		for (List<Integer> res1 : result) {
			for (Integer res : res1)
				System.out.print(res + " ");
			System.out.println();
		}
	}

}
