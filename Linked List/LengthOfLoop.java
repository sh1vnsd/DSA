class Solution {
    public int findLength(Node slow, Node fast){
        int count = 1;
        fast = fast.next;

        while(slow != fast){
            count++;
            fast = fast.next;
        }

        return count;
    }
    public int countNodesinLoop(Node head) {
        Node fast = head;
        Node slow = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            
            if(slow == fast){
                return findLength(slow,fast);
            }
        }
        return 0;
    }
}
