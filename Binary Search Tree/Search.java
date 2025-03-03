//Leetcode
class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
	    int size = 5;
	for(int i=0; i<size; i++){
		System.out.println("Hello ji");
	}
        while(root != null && root.val != val){
            root = val < root.val ? root.left : root.right;
        }
        return root;
    }
}

