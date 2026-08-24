class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;

        Map<Character, Integer> map = new HashMap<>();

        int l = 0;

        for(int r = 0 ; r<s.length() ; r++){
            if(map.containsKey(s.charAt(r))){
                
                if(map.get(s.charAt(r)) >= l){
                    l = map.get(s.charAt(r)) +1;

                    map.put(s.charAt(r), r);
                }
            }

            map.put(s.charAt(r), r);
            maxLen = Math.max(maxLen, r-l+1);
        }

        return maxLen;
    }
}