class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        Map<Integer,Integer> map = new HashMap<>();

        for(int n : hand){
            map.put(n,map.getOrDefault(n,0)+1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(map.keySet());

        while(!pq.isEmpty()){
            int start = pq.peek();

            for(int i = start ; i<start+groupSize ; i++){
                if(!map.containsKey(i)){
                    return false;
                }

                map.put(i,map.get(i)-1);
                if(map.get(i) == 0){
                    map.remove(i);
                    pq.remove(i);
                }
            }
        }

        return true;
    }
}