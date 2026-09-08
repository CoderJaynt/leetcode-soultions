class Solution {
    public int countCommas(int n) {
        if(n <= 999){
            return 0;
        }
        
        int ans = 0;

        for(int i = n ; i>=1000 ; i--){
            int cnt = String.valueOf(i).length();

            ans += ((cnt-1)/3);
        }

        return ans;
    }
}