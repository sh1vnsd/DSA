//GFG
class Pair {
    Node node;
    int vertical;
    Pair(Node node, int vertical){
        this.node = node;
        this.vertical = vertical;
    }
}
class Solution
{
    public ArrayList <Integer> bottomView(Node root)
    {
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
            else{
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
