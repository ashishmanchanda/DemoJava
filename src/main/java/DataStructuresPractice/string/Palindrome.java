package DataStructuresPractice.string;

class Palindrome {

    // Function to check if a string is a palindrome
    public static int isPalindrome(String s){
        int len = s.length();

        // Iterate over the first half of the string
        for (int i = 0; i < len / 2; i++) {

            // If the characters at symmetric positions are
            // not equal
            if (s.charAt(i) != s.charAt(len - i - 1))

                // Return 0 (not a palindrome)
                return 0;
        }

        // If all symmetric characters are equal
        // then it is palindrome
        return 1;
    }

    public static void main(String[] args){
        String s = "abba";
        System.out.println(isPalindrome(s));
    }
}
