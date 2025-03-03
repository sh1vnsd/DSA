class Solution {
    public TreeNode buildTreeAgain(int[] inorder, int inStart, int inEnd,
                                    int[] postorder, int postStart, int postEnd,
                                    Map<Integer, Integer> map){
        if(postStart > postEnd || inStart > inEnd) return null;

        TreeNode root = new TreeNode(postorder[postEnd]);
        int inRoot = map .get(root.val);
        int numsLeft = inRoot - inStart;

        root.left = buildTreeAgain(inorder, inStart, inRoot - 1,
                                    postorder, postStart, postStart + numsLeft - 1, map);
        root.right = buildTreeAgain(inorder, inRoot + 1, inEnd,
                                    postorder, postStart + numsLeft, postEnd - 1, map);
        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }

        TreeNode root = buildTreeAgain(inorder, 0, inorder.length - 1,
                                        postorder, 0, postorder.length - 1, map);
        return root;
    }
}