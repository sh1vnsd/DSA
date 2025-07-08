import java.util.HashMap;
import java.util.Map;

class Node{
    int key, value;
    Node next, prev;

    Node(int key, int value){
        this.key = key;
        this.value = value;
    }
}
class LRUCache {

    Node head = new Node(0, 0), tail = new Node(0, 0);
    Map<Integer, Node> map = new HashMap<>();
    int capacity;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
       if(map.containsKey(key)){
           Node node = map.get(key);
           deleteNode(node);
           insertAfterHead(node);
           return node.value; 
       }
       return -1; 
    }
    
    public void put(int key, int value) {
       if(map.containsKey(key)){
           deleteNode(map.get(key));
       }
       if(map.size() == capacity){
           deleteNode(tail.prev);
       }

       insertAfterHead(new Node(key, value));
    }

    private void deleteNode(Node node){

        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;

    }

    private void insertAfterHead(Node node){
        map.put(node.key, node);
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
    }
}



