class Solution {
    public int kthSmallest(TreeNode root, int k) {
        if(root == null) return -1;
        TreeNode curr = root;
        int count = 0;
        while(curr != null){
            if(curr.left == null){
                count++;
                if(count == k) return curr.val;
                curr = curr.right;
            }
            else{
                TreeNode prev = curr.left;
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
                    if(count == k) return curr.val;
                    curr = curr.right;
                }
            }
        }
        return -1;
    }
}
