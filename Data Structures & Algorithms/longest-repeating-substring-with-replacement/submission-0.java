class Solution {
    public int characterReplacement(String s, int k) {
        int maxFq = 0, l=0, maxLen = 0;
        HashMap<Character,Integer> map = new HashMap<>();

        for(int r=0; r<s.length(); r++){
            char c = s.charAt(r);
            map.put(c, map.getOrDefault(c, 0) + 1);
            maxFq = Math.max(maxFq, map.get(c));

            while((r - l + 1) - maxFq > k){
                char lc = s.charAt(l);
                map.put(lc, map.get(lc) - 1);
                l++;
            }

            maxLen = Math.max(maxLen, (r - l + 1));
        }

        return maxLen;
    }
}
