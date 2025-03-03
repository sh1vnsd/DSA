//leetcode
class Pair {
    TreeNode node;
    int level;
    Pair(TreeNode node, int level){
        this.node = node;
        this.level = level;
    }
}
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) return new ArrayList<>();
        Queue<Pair> q = new ArrayDeque<Pair>();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        q.add(new Pair(root, 0));

        while(!q.isEmpty()){
            Pair pr = q.poll();
            TreeNode node = pr.node;
            int level = pr.level;
            if(node == null) continue;
            if(map.containsKey(level) == false){
                map.put(level, node.val);
            }

            if(node.right != null) q.add(new Pair(node.right, level + 1));

            if(node.left != null) q.add(new Pair(node.left, level + 1));
        }

        List<Integer> ans = new ArrayList<>();
        for(var it : map.values()){
            ans.add(it);
        }
        return ans;
    }
}