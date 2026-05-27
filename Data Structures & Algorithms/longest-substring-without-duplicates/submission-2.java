class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> map = new HashMap<>();
        int maxLen = 0;
        int l = 0, r = 0;
        while(r < s.length()){
            char ch = s.charAt(r);
            if(map.containsKey(ch)){
                l = Math.max(map.get(ch) + 1, l);
            }

            map.put(ch, r);
            maxLen = Math.max(r-l+1, maxLen);
            r++;

        }

        return maxLen;
    }
}
