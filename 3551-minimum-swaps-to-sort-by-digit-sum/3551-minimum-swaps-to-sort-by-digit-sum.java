class Solution {
    public int digitSum(int num){
        int sum = 0;

        while(num > 0){
            sum += num%10;
            num /= 10;
        }

        return sum;
    }

    public int minSwaps(int[] nums) {
        int n = nums.length;
        
        Integer[] sort = new Integer[n];
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0 ; i<n ; i++){
            sort[i] = nums[i];

            map.put(nums[i], i);
        }

        Arrays.sort(sort, (a, b) -> {
            int sum1 = digitSum(a);
            int sum2 = digitSum(b);

            if (sum1 != sum2) {
                return sum1 - sum2;
            }

            return a - b;
        });

        boolean[] vis = new boolean[n];
        int cnt = 0;

        for(int i = 0 ; i<n ; i++){
            if(vis[i] || map.get(sort[i]) == i){
                continue;
            }

            int j = i;
            int cycle = 0;


            while(!vis[j]){
                vis[j] = true;
                j = map.get(sort[j]);
                cycle++;
            }

            cnt += cycle - 1;

        }

        return cnt;


    }
}