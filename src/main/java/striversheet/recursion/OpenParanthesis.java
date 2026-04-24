package striversheet.recursion;

import java.util.ArrayList;
import java.util.List;

public class OpenParanthesis {

    static void generateParanthesis(int n,String curr,int open,int close,List<String> result){
      if(curr.length()==2*n){
          result.add(curr);
          return;
      }
      if(open<n){
          generateParanthesis(n,curr+"(",open+1,close,result);
      }
      if(close<open){
          generateParanthesis(n,curr+")",open+1,close,result);
      }
    }


    public static void main(String[] args){
        int n=5;
        List<String> result=new ArrayList<>();
        generateParanthesis(n,"",0,0,result);
        System.out.println(result);

    }
}
