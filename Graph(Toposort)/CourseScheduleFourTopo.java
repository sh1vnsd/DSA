import java.util.*;

class CourseScheduleFourTopo {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<numCourses; i++){
            adj.add(new ArrayList<>());
        }

        int[] indegree = new int[numCourses];
        for(int i=0; i<prerequisites.length; i++){
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
            indegree[prerequisites[i][1]]++;
        }

        ArrayList<Integer> topoSort = new ArrayList<>();
        Queue<Integer> q = new ArrayDeque<>();
        Map<Integer, HashSet<Integer>> mpp = new HashMap<>();
        for(int i=0; i<numCourses; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int node = q.poll();
            topoSort.add(node);

            for(int it : adj.get(node)){
                mpp.putIfAbsent(it, new HashSet<>());
                mpp.get(it).add(node);
                
                // Transitive Dependency
                if(mpp.containsKey(node)){
                    for(var prereq : mpp.get(node)){
                        mpp.get(it).add(prereq);
                    }
                }
                indegree[it]--;
                if(indegree[it] == 0){
                    q.add(it);
                }
            }
        }

        List<Boolean> ans = new ArrayList<>();
        for(int i=0; i<queries.length; i++){
            int u = queries[i][0];
            int v = queries[i][1];

            if(mpp.containsKey(v) && mpp.get(v).contains(u)){
                ans.add(true);
            }
            else{
                ans.add(false);
            }
        }
        return ans;
    }



    public static void main(String[] args) {
        CourseScheduleFourTopo solution = new CourseScheduleFourTopo();
        
        // Example input
        int numCourses = 4;
        int[][] prerequisites = {
            {1, 0},
            {2, 1},
            {3, 2}
        };
        int[][] queries = {
            {3, 0},  // Expected: true
            {1, 3},  // Expected: false
            {2, 0},  // Expected: true
            {3, 1}   // Expected: false
        };
        
        // Calling the method
        List<Boolean> result = solution.checkIfPrerequisite(numCourses, prerequisites, queries);
        
        // Printing the result
        System.out.println(result);
    }
}
