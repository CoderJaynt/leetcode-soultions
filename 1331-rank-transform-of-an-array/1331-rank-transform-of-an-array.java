class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;

        int[] dumy = new int[n];

        for(int i = 0; i <n ; i++){
            dumy[i] = arr[i];
        }

        Arrays.sort(dumy);

        Map<Integer,Integer> map= new HashMap<>();

        int r = 0;
        for(int i =0 ; i<n ; i++){
            if(!map.containsKey(dumy[i])){
                r++;
                map.put(dumy[i], r);
            }
        }

        int[] ans = new int[n];

        for(int i = 0 ; i<n ; i++){
            ans[i] = map.get(arr[i]);
        }

        return ans;
    }
}