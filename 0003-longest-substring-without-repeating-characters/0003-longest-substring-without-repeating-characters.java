class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0;
        int r = 0;

        int[] hash = new int[256];

        
        int maxLen = 0;

        while(r < s.length()){
            hash[s.charAt(r)]++;

            while(hash[s.charAt(r)] > 1){
                hash[s.charAt(l)]--;
                l++;
            }

            
            maxLen = Math.max(maxLen, r-l+1);
            r++;
        }

        return maxLen;


    }
}