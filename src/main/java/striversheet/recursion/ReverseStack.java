package striversheet.recursion;

import java.util.Stack;

public class ReverseStack {

    static void reverse(Stack<Integer> st){
         if(st.isEmpty()) return;

         int value = st.pop();
         reverse(st);
         st.push(value);
    }

    public static void main(String[] args){
        Stack<Integer> st=new Stack<>();
        st.push(1);
        st.push(4);
        st.push(3);
        st.push(15);
        st.push(6);
        st.push(8);
        st.push(9);
        st.push(10);

        reverse(st);

        while (!st.empty()){
          System.out.println(st.pop());
        }
    }
}
