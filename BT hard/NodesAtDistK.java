import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;

import javax.swing.tree.TreeNode;

class Solution {
    private void parent(TreeNode root, Map<TreeNode, TreeNode> parent, TreeNode start){
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(node.left != null){
                parent.put(node.left, node);
                q.add(node.left);
            }
            if(node.right != null){
                parent.put(node.right, node);
                q.add(node.right);
            }
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        parent(root, parent, root);
        Map<TreeNode, Boolean> vis = new HashMap<>();
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(target);
        vis.put(target, true);
        int dist = 0;
        while(!q.isEmpty()){
            int size = q.size();
            if(dist == k) return;
            dist++;
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
        }
        List<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            ans.add(node);
        }
        return ans;
    }
}
