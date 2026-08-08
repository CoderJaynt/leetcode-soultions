class Solution {
    int[][] dp;
    public int uniquePaths(int m, int n) {
        dp = new int[m][n];

        for(int[] x: dp){
            Arrays.fill(x, -1);
        }

        return helper(m-1, n-1);
    }

    public int helper(int row, int col){
        if(row == 0 && col == 0){
            return 1;
        }

        if(row < 0 || col < 0){
            return 0;
        }

        if(dp[row][col] != -1) return dp[row][col];

        int left = helper(row, col-1);
        int up = helper(row-1, col);

        dp[row][col] = left + up;

        return dp[row][col];
    }
}