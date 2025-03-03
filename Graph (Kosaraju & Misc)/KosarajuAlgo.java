//GFG
class Solution {
    // Function to find number of strongly connected components in the graph.
    public void dfs(int start, boolean[] vis, ArrayList<ArrayList<Integer>> adj, Stack<Integer> st ){
        vis[start] = true;
        for(var it : adj.get(start)){
            if(vis[it] == false){
                dfs(it, vis, adj, st);
            }
        }
        st.push(start);
    }

    public void dfs3(int start, boolean[] vis, ArrayList<ArrayList<Integer>> adjT){
        vis[start] = true;
        for(var it : adjT.get(start)){
            if(vis[it] == false){
                dfs3(it, vis, adjT);
            }
        }
    }
    public int kosaraju(ArrayList<ArrayList<Integer>> adj) {
        // code here
        int V = adj.size();
        boolean[] vis = new boolean[V];
        Stack<Integer> st = new Stack<>();

        for(int i=0; i<V; i++){
            if(vis[i] == false){
                dfs(i, vis, adj, st);
            }
        }

        //reverse the graph
        ArrayList<ArrayList<Integer>> adjT = new ArrayList<>();
        for(int i=0; i<V; i++){
            adjT.add(new ArrayList<>());
        }

        for(int i=0; i<V; i++){
            vis[i] = false;
            for(var it : adj.get(i)){
                adjT.get(it).add(i);
            } 
        }
        int scc = 0;
        while(!st.isEmpty()){
            int node = st.peek();
            st.pop();
            if(vis[node] == false){
                scc++;
                dfs3(node, vis, adjT);
            }
        }
        return scc;
    }
}