package neetcodequestions.trees.backtracking;
import java.util.*;
class Solution1 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Set<List<Integer>> result = new HashSet();
        Arrays.sort(candidates) ;
        backtrack(candidates, 0, target, new ArrayList(), result);
        return new ArrayList(result);
    }
    private void backtrack(int [] cand, int start, int target, List<Integer> list, Set<List<Integer>> result) {
        if(target < 0)
            return;
        if(target == 0)
            result .add(new ArrayList(list));
        for (int i = start; i < cand.length; i++) {
            list.add(cand[i]);
            backtrack(cand, i + 1, target - cand[i], list, result);
            list.remove(list.size() - 1);
        }
    }
}