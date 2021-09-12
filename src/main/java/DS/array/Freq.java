package DS.array;

// Java implementation of the above
// approach

import jdk.nashorn.internal.ir.LiteralNode;
import org.apache.logging.log4j.util.PropertySource;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
class abc implements Comparator<Map.Entry<String,Integer>> {


    @Override public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
        return   e1.getValue() - e2.getValue();
    }
}
 class Frequency_Of_String_Words {

    // Function to count frequency of
    // words in the given string
    static void count_freq(String str)
    {
        Map<String,Integer> mp=new TreeMap<>();

        // Splitting to find the word
        String arr[]=str.split(" ");

        // Loop to iterate over the words
        for(int i=0;i<arr.length;i++)
        {
            // Condition to check if the
            // array element is present
            // the hash-map
            if(mp.containsKey(arr[i]))
            {
                mp.put(arr[i], mp.get(arr[i])+1);
            }
            else
            {
                mp.put(arr[i],1);
            }
        }

        // Loop to iterate over the
        // elements of the map
        for(Map.Entry<String,Integer> entry:
                mp.entrySet())
        {
            System.out.println(entry.getKey()+
                    " - "+entry.getValue());
        }
    }


    // Driver Code
    public static void main(String[] args) {
        abc a=new abc();
        Map<String,Integer> m=new TreeMap<String,Integer>((Map<? extends String, ? extends Integer>) a);
m.put("a",1);
m.put("b",122);
m.forEach((k,v)->{
    System.out.println(v);
});
        String str = "Geeks For Geeks";

        // Function Call
        count_freq(str);
    }
}
