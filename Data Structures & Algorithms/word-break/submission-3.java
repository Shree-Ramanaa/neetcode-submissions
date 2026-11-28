class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int maxWordLen = 0;
        Set<String> words;
        boolean dp[];
        words = new HashSet<String>();
        for(String word: wordDict){
            maxWordLen = Math.max(maxWordLen, word.length());
            words.add(word);
        }
        int slen = s.length();
        dp = new boolean[slen+1];
        dp[slen] = true;
        for(int i=slen - 1; i >= 0; i--){
            for(int j=i; j<slen; j++){
                if(words.contains(s.substring(i,j+1))){
                    dp[i] = dp[j+1];
                    if(dp[i])break;
                }
            }
        }
        return dp[0];
    }

    //memo sol
    // private boolean canFormWordSeq(String s, int start){
    //     if(start == s.length()){
    //         return true;
    //     }
        
    //     if(memo[start] != -1){
    //         return memo[start] == 1;
    //     }

    //     int end = Math.min(s.length(),start+maxWordLen);
    //     for(int i=start; i<end; i++){
    //         if(words.contains(s.substring(start,i+1))){
    //             if(canFormWordSeq(s,i+1)){
    //                 memo[start] = 1;
    //                 return true;
    //             }
    //         }
    //     }

    //     memo[start] = 0;
    //     return false;
    // }
}