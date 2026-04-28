package striversheetpractice.recursion;

import java.util.Stack;

public class SortAStack {

    static void sortStack(Stack<Integer> st) {



    }
    public static void main(String[] args){
    Stack<Integer> st = new Stack<>();
    st.push(3);
    st.push(15);
    st.push(3);
    st.push(6);
    st.push(9);
    st.push(7);
    sortStack(st);
    while(!st.isEmpty()){
        System.out.println(st.pop());
    }
    }
}
