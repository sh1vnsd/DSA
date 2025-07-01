class Solution {
    public ListNode findNthNode(ListNode head, int k){
        k -= 1;

        while(head != null && k > 0){
            k--;
            head = head.next;
        }
        return head;
    }
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || k == 0) return head;

        int len = 1;
        ListNode tail = head;

        while(tail.next != null){
            len++;
            tail = tail.next;
        }

        if(k % len == 0) return head;

        k = k % len;
        tail.next = head;
        
        ListNode last = findNthNode(head, len - k);

        head = last.next;
        last.next = null;

        return head;
    }
}
