class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;

        int maxSum = 0;

        for(int i = 0 ; i<k ; i++){
            maxSum += cardPoints[i];
        }

        int leftSum = maxSum;
        int rightIdx = n-1;
        int rightSum = 0;

        for(int i = k-1 ; i>=0 ; i--){
            leftSum -= cardPoints[i];
            rightSum += cardPoints[rightIdx];
            rightIdx--;

            maxSum = Math.max(maxSum, rightSum+leftSum);
        }

        return maxSum;


    }
}