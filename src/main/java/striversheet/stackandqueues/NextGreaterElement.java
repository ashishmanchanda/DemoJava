package striversheet.stackandqueues;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NextGreaterElement {
    static int[] nextGreaterElement(int[] a){
        Stack<Integer> st = new Stack<>();
        int res[]=new int[a.length];
        for (int i=a.length-1;i>=0;i--)
        {

            while(!st.isEmpty() && st.peek()<a[i]) {
                st.pop();
            }
            if (st.isEmpty()) res[i] = -1;
            else res[i] = st.peek();
            st.push(a[i]);
        }
return res;
        }
    public static void main(String[] args) {
        int a[]= {3,4,5,6,1,2,3,4};
        int[] res=nextGreaterElement(a);
        for(int i=0;i<res.length;i++){
            System.out.println(res[i]);
        }

    }
}
