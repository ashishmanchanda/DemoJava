package com.example.demo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;


public class CommonSubstring {

    // Complete the twoStrings function below.
    static String twoStrings(String s1, String s2) {
        String s="abcdefghijklmnopqrstuvwxyz";
        int f=0;
        TreeMap<Integer,Character> h1=new TreeMap<>();
        TreeMap<Integer,Character> h2=new TreeMap<>();
        for(int i=0;i<s1.length();i++)
        {
            h1.put(i,s1.charAt(i));
        }

        for(int i=0;i<s2.length();i++)
        {
            h2.put(i,s2.charAt(i));
        }
        for(int i=0;i<s.length();i++)
        {
            if(h1.containsValue(s.charAt(i))&&h2.containsValue(s.charAt(i))){
                f=1;
                break;
            }
        }
        if(f==1){
      return ("YES");
        }else {
            return ("NO");
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        List<Integer> itemtype=new ArrayList<>();
        System.out.println(itemtype.stream().mapToInt(Integer::intValue).sum());

        /*int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s1 = scanner.nextLine();

            String s2 = scanner.nextLine();

            String result = twoStrings(s1, s2);
            System.out.println(result);


        }



        scanner.close();*/
    }
}

