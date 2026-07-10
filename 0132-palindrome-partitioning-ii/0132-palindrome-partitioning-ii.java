class Solution {
    int[] dp;
    public boolean isPalindrome(int start, int end, String s){
        

        while(start < end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }

            start++;
            end--;
        }

        return true;
    }
    public int minCut(String s) {
        int n = s.length();

        dp = new int[n+1];
        dp[n] = 0;

        

        for(int i = n-1 ; i>=0 ; i--){

            int minCost = Integer.MAX_VALUE;

            for(int j = i ; j<s.length() ; j++){                

                if(isPalindrome(i, j, s)){
                    int cost = 1 + dp[j+1];

                    minCost = Math.min(minCost, cost);
                }
            }

            dp[i] = minCost;
        }
        

        return dp[0]-1;
    }
}