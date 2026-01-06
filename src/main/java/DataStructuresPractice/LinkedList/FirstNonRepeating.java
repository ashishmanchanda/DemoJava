package DataStructuresPractice.LinkedList;

// Java implementation for the above approach
import java.io.*;
import java.util.*;

class FirstNonRepeating {

    static String FirstNonRepeating(String A)
    {
        // Arraylist to keep track of current unique characters
        // Hashmap to keep track of character encountered at least once
        ArrayList<Character> list = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        for (char ch : A.toCharArray()) {
            if (!map.containsKey(ch)) { // any new character encountered first time
                list.add(ch);
                map.put(ch, 1);
            }
            else {
                //any repeated character encountered
                int index = list.indexOf(ch);

                // for any repeated character encountered more than twice the
                // index will be -1
                if (index != -1)
                    list.remove(index);
            }
            sb.append(list.isEmpty() ? '#' : list.get(0));
        }
        return sb.toString();
    }

    public static void main(String[] args)
    {
        String A = "geeksforgeeksandgeeksquizfor";
        String ans = FirstNonRepeating(A);
        System.out.print(ans);
    }
}

// This code is contributed by godcoder28.

