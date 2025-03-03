import java.util.*;

class CourseScheduleTopo {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        //Create AdjList from Pair
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        int n = prerequisites.length;
        for (int i = 0; i < n; i++) {
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        //Fill Indegree of all the nodes
        int[] indegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            for (int it : adj.get(i)) {
                indegree[it]++;
            }
        }

        //Implement Toposort using BFS
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        List<Integer> topo = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.peek();
            q.remove();
            topo.add(node);

            for (int it : adj.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) q.add(it);
            }
        }
        return topo.size() == numCourses;
    }

    public static void main(String[] args) {
        int numCourses = 5;
        int[][] prerequisites = { { 1, 2 }, { 4, 3 }, { 2, 4 }, {4, 1} }; 

        CourseScheduleTopo sol = new CourseScheduleTopo();
        boolean result = sol.canFinish(numCourses, prerequisites);

        if (result) {
            System.out.println("All courses can be finished.");
        } else {
            System.out.println("Not all courses can be finished due to a cycle.");
        }
    }
}
