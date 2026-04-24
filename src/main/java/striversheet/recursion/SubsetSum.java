package striversheet.recursion;

import com.example.demo.Practicejava.ProducerConsumerSolution;

public class SubsetSum {

    public int countSubsequenceWithTargetSum(int index,int[] nums, int sum) {
        if(sum==0){
            return 1;
        }
        if(sum<0 || index==nums.length){
            return 0;
        }
        return countSubsequenceWithTargetSum(index+1,nums,sum-nums[index])+countSubsequenceWithTargetSum(index+1,nums,sum);
    }

    public static void main(String[] args){
        SubsetSum sol = new SubsetSum();
        int[] nums = {1, 2, 3, 4};
        int target = 5;
        System.out.println("Number of subsequences with target sum " + target + ": "
                + sol.countSubsequenceWithTargetSum(0,nums, target));
    }
}
