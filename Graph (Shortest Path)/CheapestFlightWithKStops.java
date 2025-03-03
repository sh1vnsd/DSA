import java.util.*;

class Pair {
    int first, second;
    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

class Tuple {
    int first, second, third;
    Tuple(int first, int second, int third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }
}

class CheapestFlightWithKStops {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0; i<flights.length; i++){
            adj.get(flights[i][0]).add(new Pair(flights[i][1], flights[i][2]));
        }

        int[] dist = new int[n];
        Arrays.fill(dist, (int)(1e9));

        dist[src] = 0;

        Queue<Tuple> q = new ArrayDeque<Tuple>();
        q.add(new Tuple(0, src, 0));

        while(!q.isEmpty()){
            Tuple it = q.poll();
            int stops = it.first;
            int node = it.second;
            int cost = it.third;

            if(stops > k) continue;
            for(Pair iter : adj.get(node)){
                int adjNode = iter.first;
                int edgeWeight = iter.second;

                if(cost + edgeWeight < dist[adjNode] && stops <= k){
                    dist[adjNode] = cost + edgeWeight;
                    q.add(new Tuple(stops + 1, adjNode, cost + edgeWeight));
                }
            }
        }
        if(dist[dst] == (int)(1e9)) return -1;
        return dist[dst];
    }

    public static void main(String[] args) {
        CheapestFlightWithKStops solution = new CheapestFlightWithKStops();

        // Example input
        int n = 4;
        int[][] flights = {
            {0, 1, 100},
            {1, 2, 100},
            {2, 3, 100},
            {0, 2, 500}
        };
        int src = 0;
        int dst = 3;
        int k = 1;

        // Call the method and print the result
        int result = solution.findCheapestPrice(n, flights, src, dst, k);
        System.out.println("Cheapest Price: " + result);
    }
}
