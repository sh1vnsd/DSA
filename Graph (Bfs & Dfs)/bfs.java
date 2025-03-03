import java.io.*; 
import java.util.*;

class Graph 
{ 
  private int V;
  private Map<Integer, List<Integer>> adjVertices;
  public Graph(int V) {
      this.V = V;
    this.adjVertices = new HashMap<Integer, List<Integer>>();
  }
  public void addVertex(int vertex) {
    adjVertices.putIfAbsent(vertex, new ArrayList<>());
  }
  public void addEdge(int src, int dest) {
    adjVertices.get(src).add(dest);
  }


void BFS(int v) 
{ 
    ArrayList<Integer> bfs = new ArrayList<>();
    boolean[] vis = new boolean[adjVertices.size()];
    Queue<Integer> q = new ArrayDeque<>();
    vis[v] = true;
    q.add(v);
    while(!q.isEmpty()){
        Integer Node = q.poll();
        bfs.add(Node);
        
        for(int iter : adjVertices.get(Node)){
            if(vis[iter] == false){
                vis[iter] = true;
                q.add(iter);
            }
        }
    }
    for(int i : bfs){
       System.out.print(i + " "); 
    }
    
} 

}
class bfs {  
  public static void main(String args[]) {
    int V,E,v1,v2,s,i;
    Scanner sc = new Scanner(System.in);
    V = Integer.parseInt(sc.nextLine().trim());
    E = Integer.parseInt(sc.nextLine().trim());
    Graph g = new Graph(V);
    for(i=0;i<V;i++)
      g.addVertex(i);
    for(i=0;i<E;i++)
    {
      v1 = sc.nextInt();
      v2 = Integer.parseInt(sc.nextLine().trim());
      g.addEdge(v1, v2);
    }
    s = Integer.parseInt(sc.nextLine().trim());
    g.BFS(s); 
  } 
}
