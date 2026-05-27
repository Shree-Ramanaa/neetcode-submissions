class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] charFreq = new int[256];
        int maxLen = 0;
        int l = 0, r = 0;
        while(r < s.length()){
            char ch = s.charAt(r);
            if(charFreq[ch] == 1){
                while(charFreq[ch] != 0 && l < r){
                    charFreq[s.charAt(l)]--;
                    l++;
                }
            }

            charFreq[ch]++;
            maxLen = Math.max(r-l+1, maxLen);
            r++;

        }

        return maxLen;
    }
}
