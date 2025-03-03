//Leetcode
class Solution {
    public int maxPathSum(TreeNode root) {
        int[] maxValue = new int[1];
        maxValue[0] = Integer.MIN_VALUE;
        maxPath(root, maxValue);
        return maxValue[0];
    }
    private int maxPath(TreeNode node, int[] maxValue){
        if(node == null) return 0;
        int left = Math.max(0, maxPath(node.left, maxValue));
        int right = Math.max(0, maxPath(node.right, maxValue));
        maxValue[0] = Math.max(maxValue[0], node.val + left + right);
        return node.val + Math.max(left, right);
    }
}