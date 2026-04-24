package striversheet.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {

    public static void main(String[] args){
        int[] candidates={10,1,2,7,6,1,5};
        int target=8;
        combinationSum2(candidates,target);
     }

     static void combinationSum2(int[] candidates,int target){
         List<List<Integer>> result=new ArrayList<>();
         Arrays.sort(candidates);
         backtrack(candidates,target,result,new ArrayList<>(),0);
         System.out.println(result);
     }

     static void backtrack(int[] candidates, int target, List<List<Integer>> result, List<Integer> current, int index){
         if(target==0){
             result.add(new ArrayList<>(current));
             return;
         }
         for(int i=index;i<candidates.length;i++){
             if(i>index && candidates[i]==candidates[i-1]) continue;
             if(candidates[i]>target) break;
             current.add(candidates[i]);
             backtrack(candidates,target-candidates[i],result,current,i+1);
             current.remove(current.size()-1);
         }
    }
}
