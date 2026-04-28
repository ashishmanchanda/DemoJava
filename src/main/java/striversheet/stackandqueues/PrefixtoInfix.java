package striversheet.stackandqueues;

import java.util.Stack;

public class PrefixtoInfix {

    String prefixToInfix(String prefix) {
        Stack<String> stack = new Stack<>();
        int n = prefix.length();
        for (int i = n - 1; i >= 0; i--) {
            char ch = prefix.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                stack.push(String.valueOf(ch));
            } else {
                String op1 = stack.pop();
                String op2 = stack.pop();
                stack.push("(" + op1 + ch + op2 + ")");
            }
        }
        return stack.peek();
    }

    public static void main(String[] args) {
        PrefixtoInfix p = new PrefixtoInfix();
        String prefix = "*-A/BC-/AKL";
        System.out.println(p.prefixToInfix(prefix));
    }
}
