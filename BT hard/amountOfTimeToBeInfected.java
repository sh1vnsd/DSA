import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Queue;

import javax.swing.tree.TreeNode;

class Solution {
    private TreeNode markParent(TreeNode root, Map<Integer, Integer> parent, int start){
        Queue<TreeNode> q = new ArrayDeque<>();
        
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
        TreeNode startNode = markParent(root, parent, root);
        Map<TreeNode, Boolean> vis = new HashMap<>();
        vis.put(startNode, true);
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(startNode);
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
