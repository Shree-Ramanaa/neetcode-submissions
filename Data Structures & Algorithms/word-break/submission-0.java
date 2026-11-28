class Solution {
    int maxWordLen = 0;
    HashSet words;
    int memo[];
    public boolean wordBreak(String s, List<String> wordDict) {
        words = new HashSet<String>();
        for(String word: wordDict){
            maxWordLen = Math.max(maxWordLen, word.length());
            words.add(word);
        }
        memo = new int[s.length()+1];
        Arrays.fill(memo,-1);
        return canFormWordSeq(s,0);
    }

    private boolean canFormWordSeq(String s, int start){
        if(start == s.length()){
            return true;
        }
        
        if(memo[start] != -1){
            return memo[start] == 1;
        }

        int end = Math.min(s.length(),start+maxWordLen);
        for(int i=start; i<end; i++){
            if(words.contains(s.substring(start,i+1))){
                if(canFormWordSeq(s,i+1)){
                    memo[start] = 1;
                    return true;
                }
            }
        }

        memo[start] = 0;
        return false;
    }
}