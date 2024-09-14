package DS.binarytree;

import DS.Tree.Test;

import java.util.Objects;
import java.util.Optional;

public class TestJava {
    int a;
    String b;
    TestJava(final int a,final String b){
        this.a=a;
        this.b=b;
    }

    public static int minMovesToEnd(final int[] arr) {
        int count = 0;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum < 0) {
                arr[arr.length-1] += arr[i];
                count++;
                sum -= arr[i];
                arr[i] = 0;
            }
        }
        return count;
    }



    public static void main(String[] args) {
        TestJava t=new TestJava(1,null);
        System.out.println(t.b);
        int[] a = new int[]{10,-10,-1,-1,10};
        int aa= (int) Optional.ofNullable(null).filter(Objects::nonNull).orElse(1);
        System.out.println(aa);

//        System.out.println(minMovesToEnd(null));
    }
}
