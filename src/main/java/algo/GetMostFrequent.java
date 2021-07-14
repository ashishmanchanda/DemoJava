package algo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Dinesh.Rajput
 *
 */
 class Node {

    int          value;
    Node         prev;
    Node         next;
    Set<Integer> set;

    public Node(int v){
        value = v;
        set = new HashSet<>();
    }
}

 class GetMostFrequent {

    Map<Integer, Node> map;
    Node tail, head;

    /** Initialize your data structure here. */
    public GetMostFrequent() {
        super();
        map = new HashMap<>();
    }

    /** Adding items to your data structure. */
    public void add(int val) {

        if(map.containsKey(val)) {
            Node node = map.get(val);
            node.set.remove(val);
            if(node.next != null) {
                node.next.set.add(val);
                map.put(val, node.next);
            }else {
                Node newnode = new Node(node.value+1);
                newnode.set.add(val);
                map.put(val, newnode);
                node.next = newnode;
                newnode.prev = node;
                tail = newnode;
            }
        }else {
            if(head != null && tail != null) {
                if(tail.value > 1) {
                    head.set.add(val);
                    map.put(val, head);
                }else {
                    tail.set.add(val);
                    map.put(val, tail);
                }
            }else {
                Node node = new Node(1);
                node.set.add(val);
                map.put(val, node);
                head = node;
                tail = node;
            }
        }
    }

    /** Getting most frequent item from your data structure. */
    public int getMostFrequent() {

        if(tail == null)
            return -1;

        return tail.set.iterator().next();
    }

    /** Removing item from your data structure. */
    public void remove(int val) {

        if(map.containsKey(val)) {
            Node node = map.get(val);
            node.set.remove(val);

            if(node.value == 1){
                map.remove(val);
            }else{
                node.prev.set.add(val);
                map.put(val, node.prev);
            }

            while(tail != null && tail.set.size() == 0){
                tail = tail.prev;
            }

        }else {
            System.out.println("No such item exist!!!");
        }
    }
}

 class GMFTest {

    /**
     * @param args
     */
    public static void main(String[] args) {

        //Creating your data structure object
        GetMostFrequent frequent = new GetMostFrequent();

        //Adding items to your data structure with O(1)
        frequent.add(2);
        frequent.add(3);
        frequent.add(4);
        frequent.add(5);
        frequent.add(2);
        frequent.add(6);
        frequent.add(3);
        frequent.add(3);
        frequent.add(2);
        frequent.add(2);

        //Getting most frequent item from your data structure with O(1)
        System.out.println("Most frequent number in the collection is "+frequent.getMostFrequent()); //Expected 2

        //Removing item from your data structure with O(1)
        frequent.remove(2);
        frequent.remove(2);

        System.out.println("Most frequent number in the collection is "+frequent.getMostFrequent()); //Expected 3

    }

}