class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int initialOnes = 0;

        for(char c : s.toCharArray()){
            if(c == '1') initialOnes++;
        }

        List<Character> type = new ArrayList<>();
        List<Integer> len = new ArrayList<>();

        String t = '1' + s + '1';
        int j = 0;

        while(j<t.length()){

            char c = t.charAt(j);
            int cnt = 0;

            while(j<t.length() && c == t.charAt(j)){
                cnt++;
                j++;
            }

            len.add(cnt);
            type.add(c);
        }

        int maxProfit = 0;

        for(int i = 1 ; i<type.size()-1 ; i++){
            if(type.get(i) == '1' && type.get(i-1) == '0' && type.get(i+1) == '0'){
                maxProfit = Math.max(maxProfit, len.get(i-1) + len.get(i+1));
            }
        }

        return initialOnes + maxProfit;
    }
}