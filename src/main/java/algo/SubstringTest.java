package algo;

import java.util.HashSet;

public class SubstringTest {

    static int findMaxSub(char[] s,HashSet<Character> characters){
        int maxlength=0;
        int length=0;
        for(int i=0;i<s.length;i++){

            if(!characters.contains(s[i])){
                characters.add(s[i]);
                length++;

            }else{
              if(length>maxlength){

                 maxlength=length;
                  length--;
                  if(length<1){
                      length=1;
                  }

              }
            }
        }
        return  maxlength;
    }

    public static void main(String[] args) {
        String s="abcdefb";
        HashSet<Character> charset=new HashSet<>();

        char[] chars=s.toCharArray();
        System.out.println(findMaxSub(chars,charset));



    }
}
