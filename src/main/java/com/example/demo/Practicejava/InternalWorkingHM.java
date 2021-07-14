package com.example.demo.Practicejava;

import java.util.HashMap;

 class InternalWorkingHM {
}
class A{
    int value;
    A(int value){
        this.value=value;
    }

    @Override public boolean equals(Object obj) {
        return true;
    }

    @Override public int hashCode() {
        return value;
    }


    public static void main(String args[]){
        HashMap<A,String> hashMap= new HashMap<>();
        hashMap.put(new A(1),"1");
        hashMap.put(new A(2),"1");
        hashMap.put(new A(1),"3");
        System.out.println(hashMap.toString());
    }
}