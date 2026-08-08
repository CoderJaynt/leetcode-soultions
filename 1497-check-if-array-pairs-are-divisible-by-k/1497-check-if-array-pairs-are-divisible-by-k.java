class Solution {
    public boolean canArrange(int[] arr, int k) {
        int n = arr.length;

        int[] frq = new int[k];

        for(int x: arr){
            int rem = ((x%k)+k)%k;
            frq[rem]++;
        }

        if(frq[0] % 2 != 0){
            return false;
        }

        for(int i = 1 ; i<k ; i++){
            int other = k - i;

            if(frq[i] != frq[other]){
                return false;
            }
        }

        return true;
    }
}