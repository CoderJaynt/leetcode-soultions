class Solution {
    int m;
    int n;
    Integer[][][][] dp;
    public int helper(int i, int j, int prevDir, int turn, int k, int[][] grid){

        if(turn > k){
            return Integer.MAX_VALUE;
        }

        if(i == m-1 && j == n-1){
            return grid[i][j];
        }

        if(dp[i][j][prevDir][turn] != null) return dp[i][j][prevDir][turn];

        int ans = Integer.MAX_VALUE;

        // UP
        if(i > 0){

            int newTurn = turn;

            if(prevDir != 4 && prevDir != 0){
                newTurn++;
            }

            int cost = helper(i-1, j, 0, newTurn, k, grid);

            if(cost != Integer.MAX_VALUE){
                ans = Math.min(ans, grid[i][j] + cost);
            }
        }

        // DOWN
        if(i < m-1){

            int newTurn = turn;

            if(prevDir != 4 && prevDir != 1){
                newTurn++;
            }

            int cost = helper(i+1, j, 1, newTurn, k, grid);

            if(cost != Integer.MAX_VALUE){
                ans = Math.min(ans, grid[i][j] + cost);
            }
        }

        // LEFT
        if(j > 0){

            int newTurn = turn;

            if(prevDir != 4 && prevDir != 2){
                newTurn++;
            }

            int cost = helper(i, j-1, 2, newTurn, k, grid);

            if(cost != Integer.MAX_VALUE){
                ans = Math.min(ans, grid[i][j] + cost);
            }
        }

        // RIGHT
        if(j < n-1){

            int newTurn = turn;

            if(prevDir != 4 && prevDir != 3){
                newTurn++;
            }

            int cost = helper(i, j+1, 3, newTurn, k, grid);

            if(cost != Integer.MAX_VALUE){
                ans = Math.min(ans, grid[i][j] + cost);
            }
        }

        dp[i][j][prevDir][turn] = ans;

        return dp[i][j][prevDir][turn];
    }

    public int minCost(int[][] grid, int k) {
        m = grid.length;
        n = grid[0].length;

        dp = new Integer[m][n][5][k+1];

        int ans = helper(0, 0, 4, 0, k, grid);

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}