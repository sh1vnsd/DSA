import java.util.*;

public class cycleU{
  public static boolean checkCycle(int node, int parent, boolean[] vis, List<List<Integer>> adj){
    vis[node] = true;

    for(int it : adj.get(node)){
      if(vis[it] == false){
        if(checkCycle(it, node, vis, adj)) return true;
      }
      else if(it != parent) return true;
    }
    return false;
  }
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);

      int V = sc.nextInt();
      int E = sc.nextInt();

      List<List<Integer>> adj = new ArrayList<>();

      for(int i=0; i<V; i++){
        adj.add(new ArrayList<>());
      }

      for(int i=0; i<E; i++){
        int x = sc.nextInt();
        int y = sc.nextInt();
        adj.get(x).add(y);
        adj.get(y).add(x);
      }

      
      boolean[] vis = new boolean[V];
      boolean hasCycle = false;

      for(int i=0; i<V; i++){
        if(vis[i] == false){
          if(checkCycle(i, -1, vis, adj)) hasCycle = true;
        }
      }
      if(hasCycle){
        System.out.print("Yes");
      }
      else{
        System.out.print("No");
      }
  }
}