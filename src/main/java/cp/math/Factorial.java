package cp.math;

// Given a number ,find the factorial of a number using iterative method and recursive method and test it for values , 5 ,1 0,-3

import java.util.Scanner;

public class Factorial {

    static int printFactorialRecursive(int number) {
        if(number ==0){
            return 1;
        }
        return number * printFactorialRecursive(number-1);
    }

    static int printFactorialIterative(int number){
        if (number < 0) {
            throw new IllegalArgumentException("number is negative");
        }
        int fact=1;
        for (int i=number; i>0; i--) {
            fact=fact*i;
        }
        return fact;
    }

    public static void main(String [] a){

        Scanner in = new Scanner(System.in);
        int number = in.nextInt();
        try {
            int fact1 = printFactorialRecursive(number);
            System.out.println(fact1);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            int fact2= printFactorialIterative(number);
            System.out.println(fact2);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
