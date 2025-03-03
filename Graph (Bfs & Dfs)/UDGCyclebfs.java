import java.util.*;

class Pair {
	int first, second;
	Pair(int first, int second) {
		this.first = first;
		this.second = second;
	}
}

class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean checkForCycle(int src, int V, boolean[] vis, ArrayList<ArrayList<Integer>> adj) {
		vis[src] = true;
		Queue<Pair> q = new ArrayDeque<Pair>();
		q.add(new Pair(src, -1));

		while (!q.isEmpty()) {
			int node = q.peek().first;
			int parent = q.peek().second;
			q.remove();

			for (int adjacentNode : adj.get(node)) {
				if (vis[adjacentNode] == false) {
					vis[adjacentNode] = true;
					q.add(new Pair(adjacentNode, node));
				} else if (parent != adjacentNode) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean isCycle(ArrayList<ArrayList<Integer>> adj) {
		int V = adj.size();
		boolean[] vis = new boolean[V];
		for (int i = 0; i < V; i++) vis[i] = false;
		for (int i = 0; i < V; i++) {
			if (vis[i] == false) {
				if (checkForCycle(i, V, vis, adj)) return true;
			}
		}
		return false;
	}
}

public class UDGCyclebfs {
	public static void main(String[] args) {
		int V = 5; // Number of vertices
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		
		for (int i = 0; i < V; i++) {
			adj.add(new ArrayList<>());
		}
		
		// Adding edges to the graph
		adj.get(0).add(1);
		adj.get(1).add(0);
		adj.get(1).add(2);
		adj.get(2).add(1);
		adj.get(2).add(3);
		adj.get(3).add(2);
		adj.get(3).add(4);
		adj.get(4).add(3);
		adj.get(4).add(1);
		adj.get(1).add(4);

		Solution solution = new Solution();
		boolean hasCycle = solution.isCycle(adj);
		System.out.println("Does the graph contain a cycle? " + hasCycle);
	}
}
