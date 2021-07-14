package com.example.demo.Practicejava;

import java.util.LinkedList;

public class PassByValue {
   static void updateArray(LinkedList<Integer> a){
       System.out.println(a.hashCode());
      a=new LinkedList<>();
      a.add(5);
   }
    public static void main(String[] args) {
        LinkedList<Integer> a=new LinkedList<>();
        a.add(3);
        System.out.println(a.hashCode());
        updateArray(a);
        System.out.println(a);
    }
}
