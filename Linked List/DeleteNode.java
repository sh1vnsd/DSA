class Solution {
    public void deleteNode(ListNode node) {
        if(node == null || node.next == null) return;
        ListNode temp = node.next;
        node.val = temp.val;
        node.next = temp.next;
    }
}
