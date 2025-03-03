//Leetcode
class Pair {
    TreeNode node;
    int index;
    Pair (TreeNode node, int index){
        this.node = node;
        this.index = index;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
       if(root == null) return 0;
       int ans = 0;
       Queue<Pair> q = new ArrayDeque<Pair>(); 
       q.add(new Pair(root, 0));

       while(!q.isEmpty()){
        int size = q.size();
        int minInd = q.peek().index;
        int first = 0, last = 0;
        for(int i=0; i<size; i++){
            int curr_ind = q.peek().index - minInd;
            TreeNode node = q.peek().node;
            q.poll();
            if(i == 0) first = curr_ind;
            if(i == size - 1) last = curr_ind;
            if(node.left != null){
                q.add(new Pair(node.left, curr_ind*2+1));
            }
            if(node.right != null){
                q.add(new Pair(node.right, curr_ind*2+2));
            }
        }
        ans = Math.max(ans, last - first + 1);
       }
       return ans;
    }
}