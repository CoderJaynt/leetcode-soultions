class Solution {
    public int countRotations(String s, int k) {
        char[] arr = s.toCharArray();
        int n = arr.length;

        int cnt = 0;

        for(int i = 0 ; i<n ; i++){
            int score = 0;

            for(int j = 0 ; j<n-1 ; j++){
                if(arr[(i+j)%n] == arr[(i+j+1)%n]){
                    score++;
                }
            }

            if(score == k){
                cnt++;
            }
        }

        return cnt;
    }
}