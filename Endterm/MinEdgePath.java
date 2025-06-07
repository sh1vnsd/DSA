class Result{
    static int dfs(int curr, int n, int steps, boolean[] vis){
        if(curr == n) return steps;
        if(curr > n || vis[curr]){
            return Integer.MAX_VALUE;
        }

        vis[curr] = true;
        int one = dfs(curr + 1, n, steps + 1, vis);
        int two = dfs(curr * 3, n, steps + 1, vis);
        vis[curr] = false;

        return Math.min(one, two);
    }
  static int number_of_edges(int n){
      boolean[] vis = new boolean[n];
      return dfs(1, n, 0, vis);
  }
}
