package com.example.demo.Practicejava;

import static java.util.stream.Collectors.joining;

class Result {


    public static String newPassword(String a, String b) {
        String result="";
        int alen=a.length();
        int blen=a.length();
        boolean ag=alen>blen;
        boolean bg=blen>alen;
        int min=alen<blen?alen:blen;
        boolean equal=alen==blen?true:false;
        char []achar =a.toCharArray();
        System.out.println(achar);
        char []bchar = b.toCharArray();
        System.out.println(bchar);

        for (int i=0;i<min;i++){
            result+=achar[i];
            result+=bchar[i];
        }
        if(ag && !equal){
            for (int i=min;i<alen;i++){
                result+=achar[i];
            }
        }else if (bg && !equal){
            for (int i=min;i<blen;i++){
                result+=bchar[i];
            }
        }

        return result;


    }


    public static void main(String[] args) {
        String a="abcjiji";
        String b="def";
        System.out.println(newPassword(a,b));
    }
}