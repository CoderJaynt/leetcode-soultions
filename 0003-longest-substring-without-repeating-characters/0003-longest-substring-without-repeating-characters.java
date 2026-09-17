class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;

        for(int i = 0 ; i<s.length() ; i++){
            Set<Character> set = new HashSet<>();

            int cnt = 0;

            for(int j = i ; j<s.length() ; j++){
                if(!set.contains(s.charAt(j))){
                    set.add(s.charAt(j));
                    cnt++;
                }else{
                    break;
                }
            }

            maxLen = Math.max(maxLen, cnt);
        }

        return maxLen;
    }
}