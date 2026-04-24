package striversheet.recursion;

import java.util.ArrayList;
import java.util.List;

public class GenerateBinaryStrings {
    static void generateString(int n, String curr, List<String> result){
        if(curr.length()==n){
            result.add(curr);
            return;
        }
        generateString(n,curr+"0",result);
        if(curr.isEmpty() || curr.charAt(curr.length()-1)!='1'){
            generateString(n,curr+"1",result);
        }
    }

    public static void main(String args[]){
        int n=5;
        List<String> result=new ArrayList<>();
        generateString(n,"",result);
        for(String s:result){
            System.out.println(s);
        }


    }
}
