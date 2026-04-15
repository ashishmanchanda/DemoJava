package neetcode.slidingwindow;
import java.io.*;
import java.util.*;
 class Main{
public static void main(String[] args) throws Exception {
    /* write your code here*/
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] prices = new int[n];
    for (int i = 0; i < prices.length; i++) {
        prices[i] = sc.nextInt();
    }
        int lsf = Integer.MAX_VALUE;
        int op = 0;
        int pist = 0;
    for (int price : prices) {
        if (price < lsf) {
            lsf = price;
            pist = price - lsf;
            if (pist > op) {
                op = pist;
            }
            System.out.println(op);
        }
    }
    }
    }