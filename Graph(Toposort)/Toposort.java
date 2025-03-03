class Solution {
    public static void dfs(int start, int[] vis, Stack<Integer> st, ArrayList<ArrayList<Integer>> adj){
        vis[start] = 1;
        for(int i : adj.get(start)){
            if(vis[i] == 0)
                dfs(i, vis, st, adj);
        }
        st.push(start);
    }
    static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> adj) {
        int V = adj.size();
        Stack<Integer> st = new Stack<Integer>();

        int[] vis = new int[V];
        for(int i=0; i<V; i++){
            if(vis[i] == 0){
                dfs(i, vis, st, adj);
            }
        }

        int[] ans = new int[V];
        int i = 0;
        while(!st.isEmpty()){
            ans[i++] = st.peek();
            st.pop();
        }
        if(i!=V) return new int[]{};
        return ans;
    }
}