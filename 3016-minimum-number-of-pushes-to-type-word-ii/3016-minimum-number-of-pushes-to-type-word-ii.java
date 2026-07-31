class Solution {
    public int minimumPushes(String word) {
        Map<Character,Integer> map = new HashMap<>();

        for(char ch : word.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }

        List<Map.Entry<Character,Integer>> list = new ArrayList<>(map.entrySet());

        list.sort((a,b) -> b.getValue().compareTo(a.getValue()));

        Map<Character,Integer> sortMap = new LinkedHashMap<>();

        for(Map.Entry<Character,Integer> entry : list){
            sortMap.put(entry.getKey(),entry.getValue());
        }

        int ans = 0;
        int cnt = 0;

        for(Map.Entry<Character,Integer> map1: sortMap.entrySet()){
            ans = ans + ((cnt/8)+1)*map1.getValue();
            cnt++;
        }

        return ans;
    }
}