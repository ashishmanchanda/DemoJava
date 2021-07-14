package com.example.demo;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.stream.Collectors;


class DemoApplication
{
    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner sc =new Scanner(System.in);
        int n,m,t;
        boolean flag;
        int arr1[],arr2[];
        t=sc.nextInt();
        while(t-->0)
        {
            n=sc.nextInt();
            m=sc.nextInt();
            arr1= new int[n];
            Arrays.setAll(arr1, i -> i + 1);
            arr2= new int[m];
            for(int i=0;i<m;i++)
            {
                arr2[i]=sc.nextInt();
            }
            List<Integer> list1 = Arrays.stream(arr1).boxed().collect(Collectors.toList());
            List<Integer> list2 = Arrays.stream(arr2).boxed().collect(Collectors.toList());
            TreeSet<Integer> set1 = new TreeSet<Integer>(list1);
            TreeSet<Integer> set2 = new TreeSet<Integer>(list2);
            set1.removeAll(set2);
            Integer arr3[]= set1.toArray(new Integer[0]);
            flag=true;
            for(Integer a:arr3)
            {
                if(flag)
                {
                    System.out.print(a+" ");
                    flag=false;
                }else
                {
                    flag=true;
                }
            }
            System.out.println();
            flag=false;
            for(Integer a:arr3)
            {
                if(flag)
                {
                    System.out.print(a+" ");
                    flag=false;
                }else
                {
                    flag=true;
                }
            }
            System.out.println();
        }
    }
}