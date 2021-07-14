package leetcode.recursion;

import java.util.Objects;
import java.util.Vector;

public class XorOfSubSet {
     static int xorSubs (Vector<Integer> nums,Vector<Vector<Integer>> vectors){
         Integer sum=0;
         int xor=0;
         Vector<Integer> v=new Vector<>();
         sum+=subsutil(nums,0,v,vectors,sum);
        return sum;
    }

    static Integer subsutil(Vector nums,int index, Vector<Integer> v,Vector<Vector<Integer>> vectors,Integer sum){
        if(index==nums.size()){
            Integer i=0;
            for (Integer a:v){
                i^=a;
            }
            sum+=i;
            return sum;
        }
        subsutil(nums,index+1,v,vectors,sum);

        v.add((Integer) nums.get(index));
        subsutil(nums,index+1,v,vectors,sum);
        v.remove((Integer) nums.get(index));
        return sum;
    }
    public static void main(String[] args) {
        Vector<Integer> nums=new Vector<>();
        nums.add(1);
        nums.add(3);
          Vector<Vector<Integer>> vectors=new Vector<>();
        System.out.println(xorSubs(nums,vectors));
    }
}
