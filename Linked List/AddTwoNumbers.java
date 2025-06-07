class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode t1 = l1;
        ListNode t2 = l2;
        ListNode curr = dummy;
        int carry = 0;

        while(t1 != null || t2 != null){
            int sum = carry;
            if(t1 != null) sum += t1.val;
            if(t2 != null) sum += t2.val;

            ListNode nNode = new ListNode(sum % 10);
            carry = sum / 10;

            curr.next = nNode;
            curr = curr.next;

            if(t1 != null) t1 = t1.next;
            if(t2 != null) t2 = t2.next;
        }

        if(carry != 0){
            ListNode nNode = new Node(carry);
            curr.next = nNode;
        }

        return dummy.next;
    }
}
