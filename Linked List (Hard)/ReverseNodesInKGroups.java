class Solution {
    public ListNode findKth(ListNode temp, int k){
        k -= 1;
        while(temp != null && k > 0){
           k--; 
           temp = temp.next;
        }
        return temp;
    }

    public ListNode reverse(ListNode temp){
        ListNode prev = null;
        ListNode curr = temp;

        while(curr != null){
            ListNode nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }
        return prev;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        ListNode prev = null;

        while(temp != null){
            ListNode kthNode = findKth(temp, k);

            if(kthNode == null){
                if(prev != null) prev.next = temp;
                break;
            }

            ListNode nextNode =  kthNode.next;
            kthNode.next = null;

            reverse(temp);

            if(temp == head){
                head = kthNode;
            }
            else{
                prev.next = kthNode;
            }
                prev = temp;
                temp = nextNode;
        }
        return head;
    }
}
