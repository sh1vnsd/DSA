class Solution {
    public TreeNode bstFromPreorder(int[] pre) {
        return bstFromPreorder(pre, Integer.MAX_VALUE, new int[]{0});        
    }
    public TreeNode bstFromPreorder(int[] pre, int bound, int[] i){
        if(i[0] == pre.length || pre[i[0]] > bound) return null;
        TreeNode root = new TreeNode(pre[i[0]++]);
        root.left = bstFromPreorder(pre, root.val, i);
        root.right = bstFromPreorder(pre, bound, i);
        return root;
    }
}
