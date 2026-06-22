class Solution {
    public boolean isPalindrome(int x) {
        int reverse = 0;
        int num = x;

        if(x < 0) return false;

        while(num != 0){
            int digit = num % 10;
            reverse = reverse * 10 + digit;
            num /= 10;
        }

        return (reverse == x);
    }
}