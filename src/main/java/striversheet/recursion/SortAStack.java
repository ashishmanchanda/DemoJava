package striversheet.recursion;

import java.util.Stack;

public class SortAStack {

    static void sortedInsert(int x,Stack<Integer> stack) {
        if (stack.isEmpty() || x > stack.peek()) {
            stack.push(x);
            return;
        }
        int value=stack.pop();
        sortedInsert(x,stack);
        stack.push(value);
    }

    static void sortStack(Stack<Integer> stack) {
        if (stack.isEmpty()) return;
        int value=stack.pop();
        sortStack(stack);
        sortedInsert(value,stack);
    }


    public static void main(String[] a){
        Stack<Integer> st=new Stack<>();
        st.push(1);
        st.push(4);
        st.push(3);
        st.push(15);
        st.push(6);

        sortStack(st);

        System.out.print("Sorted stack (descending order): ");
        while (!st.isEmpty()) {
            System.out.print(st.pop() + " ");
        }
    }
}
