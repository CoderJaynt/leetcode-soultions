class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();

        int r = 0;
        int l = 0;

        int maxLen = 0;
        int maxF = 0;

        int[] hash = new int[26];

        while(r < n){
            hash[s.charAt(r) - 'A']++;

            maxF = Math.max(maxF, hash[s.charAt(r) - 'A']);

            while(((r-l+1) - maxF) > k){
                hash[s.charAt(l) - 'A']--;
                for(int i = 0 ; i<26 ; i++){
                    maxF = Math.max(maxF, hash[i]);
                }

                l = l+1;
            }

            if(((r-l+1) - maxF) <= k){
                maxLen = Math.max(maxLen, r-l+1);
            }

            r++;
        }

        return maxLen;
    }
}