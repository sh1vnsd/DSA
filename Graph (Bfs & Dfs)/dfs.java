import java.io.*; 
import java.util.*;

class Graph 
{ 
  private Map<Integer, List<Integer>> adjVertices;
  public Graph() {
    this.adjVertices = new HashMap<Integer, List<Integer>>();
  }
  public void addVertex(int vertex) {
    adjVertices.putIfAbsent(vertex, new ArrayList<>());
  }
  public void addEdge(int src, int dest) {
    adjVertices.get(src).add(dest);
  }

void DFSUtil(int v, boolean vis[], ArrayList<Integer> ans) 
{ 
    vis[v] = true;
    ans.add(v);
    for(int iter : adjVertices.get(v)){
        if(vis[iter] == false){
            vis[iter] = true;
            DFSUtil(iter, vis, ans);
        }
    }

} 

void DFS(int v) 
{ 
    boolean[] vis = new boolean[adjVertices.size()];
    ArrayList<Integer> ans = new ArrayList<>();
    DFSUtil(v, vis, ans);
    for(int i : ans){
        System.out.print(i + " ");
    }
} 

}
class dfs {  
  public static void main(String args[]) {
    int V,E,v1,v2,s,i;
    Scanner sc = new Scanner(System.in);
    V = Integer.parseInt(sc.nextLine().trim());
    E = Integer.parseInt(sc.nextLine().trim());
    Graph g = new Graph();
    for(i=0;i<V;i++)
      g.addVertex(i);
    for(i=0;i<E;i++)
    {
      v1 = sc.nextInt();
      v2 = Integer.parseInt(sc.nextLine().trim());
      g.addEdge(v1, v2);
    }
    s = Integer.parseInt(sc.nextLine().trim());
    g.DFS(s); 
  } 
}

