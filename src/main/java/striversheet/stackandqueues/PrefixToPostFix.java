package striversheet.stackandqueues;

import java.util.*;

class PrefixToPostfix {
    // Function to convert prefix to postfix
    public String prefixToPostfix(String prefix) {
        Stack<String> s = new Stack<>();
        int n = prefix.length();

        // Traverse the prefix expression from right to left
        for (int i = n - 1; i >= 0; i--) {
            char c = prefix.charAt(i);

            // If the character is an operand, push it to the stack
            if (Character.isLetterOrDigit(c)) {
                s.push(String.valueOf(c));
            } else {
                // Pop two operands from the stack
                String op1 = s.pop();
                String op2 = s.pop();

                // Form the new postfix expression and push back to stack
                s.push(op1 + op2 + c);
            }
        }

        // The final element in the stack is the result
        return s.peek();
    }
}

 class PrefixToPostfixMain {
    public static void main(String[] args) {
        PrefixToPostfix converter = new PrefixToPostfix();
        String prefix = "*-A/BC-/AKL";
        System.out.println("Postfix Expression: " + converter.prefixToPostfix(prefix));
    }
}
