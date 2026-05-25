class Solution {
    public boolean isPalindrome(String s) {
        int len = s.length();
        int left = 0, right = len - 1;

        while(left <= right){
            while(left < len && !checkAlphaNumeric(s.charAt(left))){
                left++;
            }

            while(right > 0 && !checkAlphaNumeric(s.charAt(right))){
                right--;
            }

            if(left > right){
                return true;
            }

            if((s.charAt(left) | 32) != (s.charAt(right) | 32)){
                return false;
            }
            
            left++;
            right--;
        }

        return true;
    }

    private boolean checkAlphaNumeric(char ch){
        return (ch >= 'a' && ch <= 'z') || 
               (ch >= 'A' && ch <= 'Z') ||
               (ch >= '0' && ch <= '9');
    }
}
