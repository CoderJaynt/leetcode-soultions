class Pair{
    long dist;
    int node;

    Pair(long dist, int node){
        this.dist = dist;
        this.node = node;
    }
}

class Solution {
    public int countPaths(int n, int[][] roads) {

        int MOD =(int) (1e9 +7);
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x,y) -> Long.compare(x.dist , y.dist));
        List<List<long[]>> adj = new ArrayList<>();

        for(int i = 0 ; i<n ; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0 ; i<roads.length ; i++){
            int u = roads[i][0];
            int v = roads[i][1];
            long t = roads[i][2];

            adj.get(u).add(new long[]{v,t});
            adj.get(v).add(new long[]{u,t});
        }

        long[] distance = new long[n];
        Arrays.fill(distance, Long.MAX_VALUE);
        distance[0] = 0;

        int[] ways = new int[n];
        Arrays.fill(ways, 0);
        ways[0] = 1;

        pq.add(new Pair(0, 0));

        while(!pq.isEmpty()){
            Pair p = pq.poll();

            int node = p.node;
            long dist = p.dist;

            if(dist > distance[node]) continue;

            for(long[] x : adj.get(node)){
                int u = (int)x[0];
                long t = x[1];

                if(dist + t < distance[u]){
                    distance[u] = dist + t;
                    pq.add(new Pair(dist+t, u));
                    ways[u] = ways[node];
                }else if(dist+t == distance[u]){
                    ways[u] = (ways[u] + ways[node])%MOD;
                }
            }
        }

        return (ways[n-1]) % MOD;


    }
}