class Solution {
    public int maxProduct(int[] nums) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        int ans = 0;

        for(int i = 0 ; i<nums.length ; i++){
            pq.add(nums[i]);
        }

        int i = pq.poll();
        int j = pq.poll();

        return (i-1) * (j-1);
    }
}