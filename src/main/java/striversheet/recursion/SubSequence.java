package striversheet.recursion;

import java.util.ArrayList;
import java.util.List;

public class SubSequence {

     static void subsequence(String s, int index, StringBuilder current,List<String> result){
        if(index==s.length()){
            result.add(current.toString());
            return;
        }
        subsequence(s,index+1,current,result);
        current=current.append(s.charAt(index));
        subsequence(s,index+1,current,result);
        current=current.deleteCharAt(current.length()-1);
    }
    public static void main(String[] args) {
        String s="abc";
        List<String> result=new ArrayList<>();
        subsequence(s,0,new StringBuilder(""),result);
        System.out.println(result);
    }
}
