//leetcode 
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> q = new ArrayDeque<>();
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;

        q.add(root);
        boolean flag = true;
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> row = new ArrayList<>();
            for(int i=0; i<size; i++){
                TreeNode node = q.poll();
                
                int index = flag ? i : (size - 1 - i);
                if(flag){
                    row.addLast(node.val);
                }
                else{
                    row.addFirst(node.val);
                }

                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }
            flag = !flag;
            ans.add(row);
        }
        return ans; 
    }
}