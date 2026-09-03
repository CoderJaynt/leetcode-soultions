class Solution {
    public void moveZeroes(int[] nums) {
        int i = 0;
        int j = 0;

        int n = nums.length;

        while(j < n){
            while(i < n && nums[i] != 0){
                i++;
            }

            if(j <= i){
                j = i+1;
            }

            while(j < n && nums[j] == 0){
                j++;
            }

            if(j < n && i < n){
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;

                i++;
                j++;
            }


        }

        return;
    }
}