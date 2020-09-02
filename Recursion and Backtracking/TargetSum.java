import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given a list of numbers , and a target number. Print all the unique
combinations in candidates where the candidate numbers sum to target.
Example:
Input = [10,1,2,7,6,1,5] , target=8
”
Output:
[1, 1, 6]
[1, 2, 5]
[1, 7]
[2, 6]
[1,2,5] = [2,1,5] = [5,1,2] , we should pick only one to avoid duplicates.

 */
public class TargetSum {

	public static void main(String[] args) {
		int nums[] = { 10, 1, 2, 7, 6, 1, 5 };
		int target = 8;

		List<List<Integer>> result = TargetSum.getUniqueCombination(nums, target);

		for (List<Integer> res : result) {
			for (Integer r : res)
				System.out.print(r + " ");
			System.out.println();
		}
	}

	private static List<List<Integer>> getUniqueCombination(int[] nums, int target) {

		List<List<Integer>> result = new ArrayList<List<Integer>>();

		if (nums.length == 0)
			return result;

		Arrays.sort(nums);
		List<Integer> partialSolution = new ArrayList<Integer>();
		generateUniqueCombinationOfSumEqaulToK(0, nums, partialSolution, result, 0, target);
		return result;
	}

	private static void generateUniqueCombinationOfSumEqaulToK(int index, int[] nums, List<Integer> partialSolution,
			List<List<Integer>> result, int currentSum, int target) {

		if (currentSum == target) {
			result.add(new ArrayList<Integer>(partialSolution));
			return;
		}

		if (currentSum > target)
			return;

		for (int i = index; i < nums.length; i++) {
			int c = nums[i];
			if (c + currentSum > target && (i > index && nums[i] == nums[i - 1]))
				continue;

			partialSolution.add(nums[i]);
			generateUniqueCombinationOfSumEqaulToK(i + 1, nums, partialSolution, result, currentSum + c, target);
			partialSolution.remove(partialSolution.size() - 1);
		}
	}

}
