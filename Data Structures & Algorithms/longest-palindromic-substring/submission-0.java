class Solution {
    public String longestPalindrome(String s) {
        if(s.length()==1)return s;
        int len = s.length();
        int dp[][] = new int[len][len];
        int st = 0, e = 1;
        int res = 1;

        for(int i=len-1; i>=0; i--){
            for(int j=i; j<len; j++){
                if(i == j) dp[i][j] = 1;
                else if(s.charAt(i) == s.charAt(j) && (j-i+1 < 3 || dp[i+1][j-1] == 1)){
                    dp[i][j] = 1;
                    if(j-i+1 > res){
                        res = j-i+1;
                        st = i;
                        e = j+1;
                    }
                }
            }
        }

        return s.substring(st, e);
    }
}
