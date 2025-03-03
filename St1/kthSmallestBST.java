static int kSmallest(Node root, int k) {
    if(root == null) return 0;
    Node curr = root;
    int count = 0;
    while(curr != null){
        if(curr.left == null){
            count++;
            if(count == k) return curr.data;
            curr = curr.right;
        }
        else{
            Node prev = curr.left;
            while(prev.right != null && prev.right != curr){
                prev = prev.right;
            }
            if(prev.right == null){
                prev.right = curr;
                curr = curr.left;
            }
            else{
                prev.right = null;
                count++;
                if(count == k) return curr.data;
                curr = curr.left;
            }
        }
    }
    return -1;
}
