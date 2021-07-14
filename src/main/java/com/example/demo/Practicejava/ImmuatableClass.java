package com.example.demo.Practicejava;

import java.util.HashMap;
import java.util.Scanner;
import java.util.*;

public class ImmuatableClass {

    static void canMake(String ls,String[] smalls,int n){
        Map<Integer,Integer> valtoindex=new HashMap<>();
        int f=0;
         int count[]=new int[256];
         char[] lsc=ls.toCharArray();
         int length[]=new int[ls.length()];
        for (int i = 0; i < lsc.length; i++) {
            count[lsc[i]]++;

        }
        for (int i=0;i<n;i++){
            char[] ss=smalls[i].toCharArray();
            for (int j = 0; j < ss.length; j++) {
                if(count[ss[j]]>0) {
                    count[ss[j]]--;
                }
            }
        }
        for(int i=0;i<256;i++){
            if(count[i]>0){
                f=1;
                System.out.println("NO");
                break;
            }
        }
        if(f==0){
            System.out.println("YES");
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Scanner sc1=new Scanner(System.in);
        String largeString=sc.nextLine();
        int n=sc.nextInt();
        int i;
        String smalls[]=new String[n];
        for(i=0;i<n;i++){
            smalls[i]=sc1.nextLine();
        }
       canMake(largeString,smalls,n);

    }
}
