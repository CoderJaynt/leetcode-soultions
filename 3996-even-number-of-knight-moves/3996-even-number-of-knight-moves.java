class Solution {
    public boolean canReach(int[] start, int[] target) {
        int start_s = (start[0] + start[1]) % 2;
        int target_t = (target[0] + target[1]) % 2;

        return start_s == target_t;
    }
}