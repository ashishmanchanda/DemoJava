package lldquestions;

import java.util.HashMap;
import java.util.Map;
/**
 * @author Dinesh.Rajput
 *
 */
class Node {

    long key;
    long value;
    Node prev;
    Node next;

    public Node(long key, long value){
        this.key   = key;
        this.value = value;
    }
}

public class LRUCache {

    Node head;
    Node tail;
    Map<Long, Node> map = null;
    int capacity = 0;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
    }

    public long get(long key) {

        if(map.get(key) == null){
            return -1;
        }

        Node item = map.get(key);
        //move to tail
        removeNode(item);
        addToTail(item);

        return item.value;
    }

    public void put(Long key, int value) {

        if(map.containsKey(key)){
            Node item = map.get(key);
            item.value = value;

            //move to tail
            removeNode(item);
            addToTail(item);
        }else{
            if(map.size() >= capacity){
                //delete head
                map.remove(head.key);
                removeNode(head);
            }

            //add to tail
            Node node = new Node(key, value);
            addToTail(node);
            map.put(key, node);
        }
    }

    private void removeNode(Node node){

        if(node.prev != null){
            node.prev.next = node.next;
        }else{
            head = node.next;
        }

        if(node.next != null){
            node.next.prev = node.prev;
        }else{
            tail = node.prev;
        }
    }

    private void addToTail(Node node){

        if(tail != null){
            tail.next = node;
        }

        node.prev = tail;
        node.next = null;
        tail = node;

        if(head == null){
            head = tail;
        }
    }
}

 class TestLRUCache {

    /**
     * @param args
     */
    public static void main(String[] args) {

        System.out.println("Going to test the LRU Cache Implementation");

        LRUCache cache = new LRUCache(5);

        //Storing first value 10 with key (1) in the cache.
        cache.put(1l, 10);

        //Storing second value 10 with key (2) in the cache.
        cache.put(2l, 20);

        //Storing third value 10 with key (3) in the cache.
        cache.put(3l, 30);

        //Storing fourth value 10 with key (4) in the cache.
        cache.put(4l, 40);

        //Storing fifth value 10 with key (5) in the cache.
        cache.put(5l, 50);


        System.out.println("Value for the key: 1 is " +
                cache.get(1)); // returns 10

        // evicts key 2 and store a key (6) with value 60 in the cache.
        cache.put(6l, 60);

        System.out.println("Value for the key: 2 is " +
                cache.get(2)); // returns -1 (not found)

        //evicts key 3 and store a key (7) with value 70 in the cache.
        cache.put(7l, 70);

        System.out.println("Value for the key: 3 is " +
                cache.get(3)); // returns -1 (not found)

        System.out.println("Value for the key: 4 is " +
                cache.get(4)); // returns 40

        System.out.println("Value for the key: 5 is " +
                cache.get(5)); // return 50

    }

}