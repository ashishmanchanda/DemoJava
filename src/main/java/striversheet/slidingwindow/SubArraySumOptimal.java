package striversheet.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class SubArraySumOptimal     {

    static int numSubarraysWithSum(int nums[],int goal){
     int count=0, sum = 0;;
     Map<Integer,Integer> prefixSum=new HashMap<>();
     prefixSum.put(0,1);


     for(int num:nums){
         sum += num;
         if(prefixSum.containsKey(sum-goal)){
             count+=prefixSum.get(sum-goal);
         }
         prefixSum.put(sum,prefixSum.getOrDefault(sum,0)+1);
     }

     return count;
    }

    public static void main(String[] a){
       int [] nums={1, 0, 1, 0, 1};
        int goal = 2;
        System.out.println(numSubarraysWithSum(nums, goal));

    }
}
