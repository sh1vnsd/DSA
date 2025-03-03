//leetcode
class Solution {
    public boolean isSymmetric(TreeNode root) {
         return root == null || isMirror(root.left, root.right);
    }
    private boolean isMirror(TreeNode left, TreeNode right){
    	if(left == null || right == null){
    		return left == right;
    	}
    	if(left.val != right.val) return false;

    	return isMirror(left.left, right.right) && isMirror(left.right, right.left);
    }
}
