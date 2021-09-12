package algo;

public class LongestPalindromicSubString {
    static int longestPalindromicSubString(char[] input, int start, int end) {
        if(start>end){
            return 0;
        }
        if (start == end) {
            return 1;
        }

        System.out.println("w");

        if (input[start] == input[end]) {
            int remaininglenght=end-start-1;
            System.out.println("w1");
            if(remaininglenght==longestPalindromicSubString(input ,start + 1, end - 1)) {
                return  remaininglenght+2;
            }

        }
        int c2 = longestPalindromicSubString(input,start + 1, end);
        System.out.println("u1");
        int c3 = longestPalindromicSubString(input, start , end-1);
        System.out.println("u2");
        System.out.println("returned value is"+Math.max(c2,c3)+"start"+start+"end"+end);
        return Math.max(c2,c3);
    }




    public static void main(String[] args) {
        String s="abdbca";
        char[] chars=s.toCharArray();
        int start=0;
        int end=chars.length-1;
        int maxlength;
        System.out.println(longestPalindromicSubString(chars,start,end));
    }
}

/**
   a  b  c  d  e  f
 a 1

 b    1

 c

 d

 e

 */

