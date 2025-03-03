//leetcode
class Tuple {
    TreeNode node;
    int vertical, level;

    Tuple(TreeNode node, int vertical, int level){
        this.node = node;
        this.vertical = vertical;
        this.level = level;
    }
}
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Queue<Tuple> q = new ArrayDeque<>();
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        q.add(new Tuple(root, 0, 0));

        while(!q.isEmpty()){
            Tuple tp = q.poll();
            TreeNode node = tp.node;
            int vertical = tp.vertical;
            int level = tp.level;

            if(map.containsKey(vertical) == false){
                map.put(vertical, new TreeMap<>());
            }
            if(map.get(vertical).containsKey(level) == false){
                map.get(vertical).put(level, new PriorityQueue<>());
            }
            map.get(vertical).get(level).add(node.val);

            if(node.left != null){
                q.add(new Tuple(node.left, vertical - 1, level + 1));
            } 
            if(node.right != null){
                q.add(new Tuple(node.right, vertical + 1, level + 1));
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        for(var it : map.values()){
            ans.add(new ArrayList<>());
            for(var node : it.values()){
                while(!node.isEmpty()){
                    ans.get(ans.size() - 1).add(node.poll());
                }
            }
        }
        return ans;
    }
}