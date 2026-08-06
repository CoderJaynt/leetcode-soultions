class Solution {
    public void dfs(int node, List<List<Integer>> adj, int[] vis){
        vis[node] = 1;

        for(int nxt: adj.get(node)){
            if(vis[nxt] == 0){
                dfs(nxt, adj, vis);
            }
        }
    }
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0 ; i<n ; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge : invocations){
            adj.get(edge[0]).add(edge[1]);
        }

        int[] vis = new int[n];
        dfs(k, adj, vis);

        for(int[] edge: invocations){
            int u = edge[0];
            int v = edge[1];

            if(vis[u] == 0 && vis[v] == 1){
                List<Integer> ans = new ArrayList<>();

                for(int i=0 ; i<n ; i++){
                    ans.add(i);
                }

                return ans;
            }
        }

        List<Integer> ans = new ArrayList<>();

        for(int i = 0; i<n ; i++){
            if(vis[i] == 0){
                ans.add(i);
            }
        }

        return ans;
    }
}