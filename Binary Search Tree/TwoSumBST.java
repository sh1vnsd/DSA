class Solution {
    public void inorder(TreeNode root, List<Integer> in){
        if(root == null) return;
        inorder(root.left, in);
        in.add(root.val);
        inorder(root.right, in);
    }
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> in = new ArrayList<>();
        inorder(root, in);
        int l = 0, r = in.size() - 1;
        while(l < r){
            int sum = in.get(l) + in.get(r);
            if(sum == k) return true;
            if(sum < k) l++;
            else r--;
        }
        return false;
    }
}
