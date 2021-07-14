package DS.Tree;

import java.util.HashMap;
import java.util.Scanner;

public class KeyValue {
    public static void main(String[] args) {
        HashMap<String,String> keyvalue=new HashMap<>();
        Scanner sc=new Scanner(System.in);
        int t=10;
        //condition is always true to take an input ,for custom test cases we can use while(t-->0)
        while(true){
                String data=sc.nextLine();
                String []input=data.split(" ");
            if(input[0].equals("get")){
                System.out.println(keyvalue.get(input[1]));
            }else if(input[0].equals("watch")){
                keyvalue.forEach((k,v)->{
                    System.out.println(k+" "+v);
                });
            }else if(input[0].equals("set")) {
                keyvalue.put(input[1],input[2]);
            }

        }


    }
}
