import java.util.*;
class Main{
    public boolean exists(int src, int dest, boolean[] vis, List<List<Integer>> adj){
        if(src == dest) return true;

        vis[src] = true;
        for(var it : adj.get(src)){
            if(vis[it] == false){
                if(exists(it, dest, vis, adj)) return true;
            }
        }

        return false;
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();

        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < V; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < E; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            adj.get(x).add(y);
        }

        int src = sc.nextInt();
        int dest = sc.nextInt();

        boolean[] vis = new boolean[V];
        boolean exists = dfs(src, dest, vis, adj);

        if(exists){
            System.out.println("yes");
        }
        else{
            System.out.println("No");
        }
    }
}
