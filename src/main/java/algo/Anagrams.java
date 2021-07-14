package algo;
import java.util.*;

public class Anagrams {

   Long hash(String s){
        long result=0;
        char a[] =s.toCharArray();
        for(int i=0;i<a.length;i++){
            result=result+a[i];
        }
        return  result;
    }
    public static void main(String[] args) {
        Anagrams a=new Anagrams();
       Map<Long,String> hashValue=new HashMap<>();
        List<String> input=new ArrayList<>();
        List<String> resultList=new ArrayList<>();
        input.add("tea");
        input.add("sit");
        input.add("hello");
        input.add("eat");
        input.add("ate");
        input.add("ist");
        input.add("teat");
        for(String s:input){
            Long hash=a.hash(s);
            if(hashValue.containsKey(hash)){
                continue;
            }else{
                hashValue.put(hash,s);
                resultList.add(s);
            }
        }
        for(String s:resultList){
            System.out.println(s);
        }


    }
}
