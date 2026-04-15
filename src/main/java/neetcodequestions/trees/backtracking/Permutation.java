package neetcodequestions.trees.backtracking;
import java.util.*;
import java.util.stream.Collectors;

class Solution2 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permute(nums, 0, result);
        return result;
    }

    private void permute(int[] nums, int index, List<List<Integer>> result) {
        if (index == nums.length) {
            List<Integer> copyList =Arrays.stream(nums).boxed().collect(Collectors.toList());
            result.add(copyList);
            return;
        }
        for (int i = index; i < nums.length; i++) {
            swap(nums, i, index);
            permute(nums, index + 1, result);
            swap(nums, i, index);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums [j];
        nums[j] = temp;
    }
}