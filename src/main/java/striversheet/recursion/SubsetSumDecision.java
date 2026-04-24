package striversheet.recursion;


import com.example.demo.Practicejava.ProducerConsumerSolution;

public class SubsetSumDecision {

    public boolean countSubsequenceWithTargetSum(int index,int[] nums, int sum) {
        if(sum==0){
            return true;
        }
        if(sum<0 ){
            return false;
        }
        if(index==nums.length){
           return sum == 0;
        }
        return countSubsequenceWithTargetSum(index+1,nums,sum-nums[index]) || countSubsequenceWithTargetSum(index+1,nums,sum);
    }

    public static void main(String[] args){
        SubsetSumDecision sol = new SubsetSumDecision();
        int[] nums = {1, 2, 3, 4};
        int target = 5;
        System.out.println("Number of subsequences with target sum " + target + ": "
                + sol.countSubsequenceWithTargetSum(0,nums, target));
    }
}

