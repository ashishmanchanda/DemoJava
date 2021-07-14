package algo;

import java.util.Scanner;

class Palindrome
{

    // A function to check
    // if n is palindrome
    static int isPalindrome(int n)
    {

        // Find reverse of n
        int rev = 0;
        for (int i = n; i > 0; i /= 10)
            rev = rev * 10 + i % 10;

        // If n and rev are same,
        // then n is palindrome
        return(n == rev) ? 1 : 0;
    }

    // prints palindrome between
    // min and max
    static void countPal(int min, int max)
    {
        for (int i = min; i <= max; i++)
            if (isPalindrome(i)==1)
                System.out.print(i + " ");
    }

    // Driver Code
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n1=sc.nextInt();
        int n2=sc.nextInt();

        countPal(n1, n2);
    }
}
