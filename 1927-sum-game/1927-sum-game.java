class Solution {
    public boolean sumGame(String num) {
        int n = num.length();

        int leftSum = 0;
        int rightSum = 0;

        int leftBlank = 0;
        int rightBlank = 0;

        for(int i = 0 ; i<n/2 ; i++){
            if(num.charAt(i) == '?'){
                leftBlank++;
            }else{
                leftSum += (num.charAt(i) - '0');
            }
        }

        for(int i = n/2 ; i<n ; i++){
            if(num.charAt(i) == '?'){
                rightBlank++;
            }else{
                rightSum += (num.charAt(i) - '0');
            }
        }

        if(leftBlank + rightBlank == 0){
            return leftSum != rightSum;
        }

        if((leftBlank + rightBlank) % 2 != 0){
            return true;
        }

        int mini = Math.min(leftBlank, rightBlank);

        leftBlank -= mini;
        rightBlank -= mini;

        if(leftBlank == 0 && rightBlank == 0){
            return leftSum != rightSum;
        }

        if(leftBlank > 0){
            if(leftSum >= rightSum){
                return true;
            }

            return 9 * (leftBlank/2) != rightSum - leftSum;
        }else{
            if(rightSum >= leftSum){
                return true;
            }

            return 9 * (rightBlank/2) != leftSum - rightSum;
        }
    }
}