class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int maxWordLen = 0;
        int slen = s.length();
        boolean dp[] = new boolean[slen+1];
        Set<String> words = new HashSet<String>();

        for(String word: wordDict){
            maxWordLen = Math.max(maxWordLen, word.length());
            words.add(word);
        }
        
        dp[slen] = true;
        for(int i=slen - 1; i >= 0; i--){
            int end = Math.min(slen, i+maxWordLen);
            for(int j=i; j<end; j++){
                if(dp[j+1] && words.contains(s.substring(i,j+1))){
                    dp[i] = true;
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