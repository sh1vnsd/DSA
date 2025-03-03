import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.TreeMap;

class Pair{
    Node node;
    int vertical;
    Pair(Node node, int vertical){
        this.node = node;
        this.vertical = vertical;
    }
}
class Solution {
    // Function to return list containing elements of left view of binary tree.
    ArrayList<Integer> leftView(Node root) {
        Queue<Pair> q = new ArrayDeque<Pair>();
        q.add(new Pair(root, 0));
        TreeMap<Integer, Integer> map = new TreeMap<>();
        while(!q.isEmpty()){
            Pair pr = q.poll();
            Node curr = pr.node;
            int level = pr.vertical;
            if(curr == null) continue;

            if(map.containsKey(level) == false){
                map.put(level, curr.data);
            }

            if(curr.left != null) q.add(new Pair(curr.left, level + 1));
            if(curr.right != null) q.add(new Pair(curr.right, level + 1));
        }     
        ArraList<Integer> ans = new ArrayList<>();
        for(var it : map.values()){
            ans.add(it);
        }
        return ans;
    }
}
