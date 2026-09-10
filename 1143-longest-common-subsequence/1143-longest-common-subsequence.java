class Solution {
    int[][] dp;
    public int helper(int idx1, int idx2, String t1, String t2){
        if(idx1 < 0 || idx2 < 0){
            return 0;
        }

        if(dp[idx1][idx2] != -1) return dp[idx1][idx2];

        if(t1.charAt(idx1) == t2.charAt(idx2)){
            return 1 + helper(idx1-1, idx2-1, t1, t2);
        }

        dp[idx1][idx2] = Math.max(helper(idx1-1, idx2, t1, t2), helper(idx1,idx2-1, t1, t2));

        return dp[idx1][idx2];
    }
    public int longestCommonSubsequence(String text1, String text2) {
        dp = new int[text1.length()][text2.length()];

        for(int[] x: dp){
            Arrays.fill(x, -1);
        }

        return helper(text1.length()-1, text2.length()-1, text1, text2);
    }
}