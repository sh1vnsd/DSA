import java.util.PriorityQueue;

class Pair{
    int val;
    ListNode node;
    Pair(int val, ListNode node){
        this.val = val;
        this.node = node;
    }
}
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        
        for(int i = 0; i < lists.length; i++){
            if(lists[i] != null){
                pq.add(new Pair(lists[i].val, lists[i]));
            }
        }

        ListNode dNode = new ListNode(-1);
        ListNode temp = dNode;

        while(!pq.isEmpty()){
            Pair it = pq.peek();

            temp.next = it.node;
            pq.poll();

            if(it.node.next != null){
                pq.add(new Pair(it.node.next.val, it.node.next));
            }

            temp = temp.next;
        }

        return dNode.next;
    }
}
