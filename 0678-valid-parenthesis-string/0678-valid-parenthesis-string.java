class Solution {
    Boolean[][] dp;
    public boolean helper(int idx, int cnt, String s){
        if(cnt<0) return false;
        if(idx == s.length()){
            if(cnt == 0){
                return true;
            }else{
                return false;
            }
        }

        if(dp[idx][cnt] != null) return dp[idx][cnt];

        char c = s.charAt(idx);

        if(c == '('){
            dp[idx][cnt] = helper(idx+1, cnt+1, s);
        }

        else if(c == ')'){
            dp[idx][cnt] = helper(idx+1, cnt-1, s);
        }else{        

            dp[idx][cnt] = helper(idx+1, cnt+1, s) || helper(idx+1, cnt-1, s) || helper(idx+1, cnt, s);
        }

        return dp[idx][cnt];
    }
    public boolean checkValidString(String s) {
        int n = s.length();

        dp = new Boolean[n][n+1];

        return helper(0, 0, s);
    }
}