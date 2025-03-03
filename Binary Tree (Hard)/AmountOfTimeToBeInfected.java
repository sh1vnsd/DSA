//leetcode
class Solution {
    private TreeNode markParent(TreeNode root, Map<TreeNode, TreeNode> parent, int start){
        Queue<TreeNode> q = new ArrayDeque<TreeNode>();
        q.add(root);
        TreeNode startNode = null;
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(node.val == start) startNode = node;
            if(node.left != null){
                parent.put(node.left, node);
                q.add(node.left);
            }
            if(node.right != null){
                parent.put(node.right, node);
                q.add(node.right);
            }
        }
        return startNode;
    }
    public int amountOfTime(TreeNode root, int start) {
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        TreeNode startNode = markParent(root, parent, start);
        Map<TreeNode, Boolean> vis = new HashMap<>();
        Queue<TreeNode> q = new ArrayDeque<TreeNode>();
        q.add(startNode);
        vis.put(start, true);
        int time = 0;

        while(!q.isEmpty()){
            int size = q.size();

            for(int i=0; i<size; i++){
                TreeNode node = q.poll();

                if(node.left != null && vis.get(node.left) == null){
                    vis.put(node.left, true);
                    q.add(node.left);
                }
                if(node.right != null && vis.get(node.right) == null){
                    vis.put(node.right, true);
                    q.add(node.right);
                }
                if(parent.get(node) != null && vis.get(parent.get(node)) == null){
                    vis.put(parent.get(node), true);
                    q.add(parent.get(node));
                }
            }
            time++;
        }
        return time - 1;
    }
}