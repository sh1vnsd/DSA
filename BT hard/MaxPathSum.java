class Solution {
    public int maxPathSum(TreeNode root) {
        int[] maxValue = new int[1];
        maxValue[0] = Integer.MIN_VALUE;
        maxPath(root, maxValue);
        return maxValue[0];
    }
    public int maxPath(TreeNode root, int[] maxValue){
        if(root == null) return 0;
        int left = Math.max(0, maxPath(root.left, maxValue));
        int right = Math.max(0, maxPath(root.right, maxValue));
        maxValue[0] = Math.max(maxValue[0], root.val + left + right);
        return root.val + Math.max(left, right);
    }
}

