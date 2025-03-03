//gfg
class Pair {
    Node node;
    int vertical;
    Pair(Node node, int vertical){
        this.node = node;
        this.vertical = vertical;
    }
}
class Solution {
    // Function to return a list of nodes visible from the top view
    // from left to right in Binary Tree.
    static ArrayList<Integer> topView(Node root) {
        // code here
        Queue<Pair> q = new ArrayDeque<Pair>();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        q.add(new Pair(root, 0));

        while(!q.isEmpty()){
            Pair pr = q.poll();
            Node node = pr.node;
            int vertical = pr.vertical;

            if(map.containsKey(vertical) == false){
                map.put(vertical, node.data);
            }
            if(node.left != null) q.add(new Pair(node.left, vertical - 1));
            if(node.right != null) q.add(new Pair(node.right, vertical + 1));
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for(var it : map.values()){
            ans.add(it);
        }
        return ans;   
    }
}