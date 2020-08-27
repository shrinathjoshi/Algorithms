import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/*
Subset 2
https://leetcode.com/problems/subsets-ii/

Input: [1,2,2]
Output:
[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
[1,2,3]

0th ite :- [1]              ... [2]       ... [3]
1th ite :- [1,2]  [1,3]         [2,3]
2th ite :- [1,2,3]
 
[1,2,2]

0th ite :- [1]          ... [2]        [2]
1th ite :- [1,2]            [2,2]
2th ite :- [1,2,2]

 */

public class SubsetTwo {

	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> subsets = new ArrayList<>();
		generateSubsets(0, new ArrayList<>(), nums, subsets);
		return subsets;
	}

	public void generateSubsets(int index, List<Integer> partialSolution, int nums[], List<List<Integer>> subsets) {
		subsets.add(new ArrayList<Integer>(partialSolution));
		HashSet<Integer> hashSet = new HashSet<Integer>();
		for (int i = index; i < nums.length; i++) {
			if (hashSet.add(nums[i])) {
				partialSolution.add(nums[i]);
				generateSubsets(i + 1, partialSolution, nums, subsets);
				partialSolution.remove(partialSolution.size() - 1);
			}
		}
	}

	public static void main(String[] args) {
		int input[] = { 1, 2, 2 };
		List<List<Integer>> result = new SubsetTwo().subsets(input);

		for (List<Integer> res1 : result) {
			for (Integer res : res1)
				System.out.print(res + " ");
			System.out.println();
		}
	}

}
