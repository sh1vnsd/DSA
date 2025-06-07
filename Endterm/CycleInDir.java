import java.util.*;

class Main{
    public static boolean hasCycle(int node, int parent, boolean[] vis, ArrayList<ArrayList<Integer>> adj){
        vis[node] = true;
        for(var it : adj.get(node)){
            if(vis[it] == false){
                if(hasCycle(it, node, vis, adj)) return true;
            }
            else if(it != parent) return true;
        }

        return false;
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in); 
        int V = sc.nextInt();
        int E = sc.nextInt();

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < V; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < E; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();

            adj.get(x).add(y);
            adj.get(y).add(x);
        }

        boolean[] vis = new boolean[V];
        boolean hasCycle = false;

        for(int i = 0; i < V; i++){
            if(vis[i] == false){
                if(hasCycle(i, -1, vis, adj)) hasCycle = true;
            }
        }

        if(hasCycle){
            System.out.println("Yes");
        }
        else{
            System.out.println("No");
        }
    }
}
