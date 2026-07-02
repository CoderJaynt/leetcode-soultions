class Solution {
    public boolean dfs(int node, int[] vis, int[] pathVis, List<List<Integer>> adj, int[] check){
        vis[node] = 1;
        pathVis[node] = 1;
        check[node] = 0;

        for(int x : adj.get(node)){
            if(vis[x] == 0){
                if(dfs(x, vis, pathVis, adj, check) == true){
                    return true;
                }
            }else if(pathVis[x] == 1){
                return true;
            }
        }

        pathVis[node] = 0;
        check[node] = 1;
        return false;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V = graph.length;

        int[] vis = new int[V];
        int[] pathVis = new int[V];
        int[] check= new int[V];

        

        List<List<Integer>> adj = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();

        for(int i = 0 ; i<V ; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0 ; i<V ; i++){
            for(int x : graph[i]){
                adj.get(i).add(x);
            }
        }

        for(int i = 0 ; i<V ; i++){
            if(vis[i] == 0){
                dfs(i, vis, pathVis, adj, check);
            }
        }

        for(int i = 0 ; i<V ; i++){
            if(check[i] == 1){
                ans.add(i);
            }
        }

        return ans;
    }
}