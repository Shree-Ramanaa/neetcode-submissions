class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int [][] dp = new int[n][n];
        int cnt = 0;

        for(int i=n-1; i>=0; i--){
            for(int j=i; j<n; j++){
               if(s.charAt(i) == s.charAt(j) && (j-i + 1 < 3 || dp[i+1][j-1] == 1)){
                    dp[i][j] = 1;
                    cnt++;
                }
            }
        }

        return cnt;
    }
}